package com.jane.dao.impl;
import com.jane.dao.PostDao;
import com.jane.pojo.*;
import com.jane.utils.Constants;
import com.jane.utils.PageBean;
import com.jane.utils.PageCode;
import javafx.geometry.Pos;
import org.apache.lucene.queryparser.flexible.standard.QueryParserUtil;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.get.GetResult;
import org.elasticsearch.index.query.*;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.script.Script;
import org.elasticsearch.script.ScriptType;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.elasticsearch.search.sort.SortOrder;
import org.joda.time.DateTime;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.*;

import static java.util.Collections.singletonMap;

@Repository
public class PostDaoImpl implements PostDao {
    @Value("${elasticsearch.index.post}")
    private String index;
    @Value("${elasticsearch.index.post.type}")
    private String type;
    @Autowired
    private RestHighLevelClient restClient;
    @Override
    public Result compose(Article article) throws Exception {
        Result result=new Result();
        IndexRequest request = new IndexRequest(index, type);
        Map<String, Object> map = new HashMap<>();
        map.put("title",article.getTitle());
        map.put("category",article.getCategory());
        map.put("content",article.getContent());
        map.put("html",article.getHtml());
        map.put("uid", article.getId());
        map.put("pub_date",article.getPubDate());
        map.put("cover", article.getCover());
        map.put("comment_counts", 0);
        map.put("likes", 0);
        map.put("view_counts", 0);
        request.source(map);
        IndexResponse response =restClient.index(request);
        int status=response.status().getStatus();
        if(status==RestStatus.CREATED.getStatus()) {
            result.setStatus(PageCode.ESSAY_CREATE_SUCCESS.getCode());
            result.setMsg(PageCode.ESSAY_CREATE_SUCCESS.getMsg());
            result.setInfo(response.toString());
            return result;
        }
        result.setMsg(PageCode.ESSAY_CREATE_FAILED.getMsg());
        result.setStatus(PageCode.ESSAY_CREATE_FAILED.getCode());
        return result;
    }
    @Override
    public PageBean<SearchResultCart> search(String keyword,int pagenums) throws Exception {
        PageBean<SearchResultCart> pageBean=new PageBean<>();
        pageBean.setSize(Constants.POST_PAGE_SIZE);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags(Constants.PRE_TAGS)
                .postTags(Constants.POST_TAGS)
                .field("title", Constants.FRAGMENT_SIZE,Constants.TITLE_NUMBER_OF_FRAGMENT)
                .field("content", Constants.FRAGMENT_SIZE,Constants.CONTENT_NUMBER_OF_FRAGMENT)
                .noMatchSize(Constants.NO_MATCH_SIZE);
        MultiMatchQueryBuilder multiMatchQueryBuilder=QueryBuilders.multiMatchQuery(keyword,
                "title","content","category").type(MultiMatchQueryBuilder.Type.MOST_FIELDS);
        searchSourceBuilder.from(pageBean.getSize()*(pagenums-1))
                           .size(pageBean.getSize())
                           .query(multiMatchQueryBuilder)
                           .highlighter(highlightBuilder)
                           .fetchSource(
                                   new String[]{"uid","view_counts","likes","cover","category","comment_counts"},
                                   new String[]{"html","content"});
        SearchRequest request = new SearchRequest();
        request.indices(index);
        request.types(type);
        request.source(searchSourceBuilder);
        SearchResponse response=restClient.search(request);
        if(response.status().getStatus()==RestStatus.OK.getStatus()){
            SearchHits hits=response.getHits();
            pageBean.setKeyword(keyword);
            pageBean.setTook(response.getTook().getSecondsFrac());
            pageBean.setResultTotal(hits.getTotalHits());
            pageBean.setType(Constants.PAGEBEAN_POST_TYPE);
            List<SearchResultCart> list= new ArrayList<>();
            for (SearchHit hit:hits) {
                SearchResultCart searchResultCart = new SearchResultCart();
                HighlightField field = hit.getHighlightFields().get("title");
                searchResultCart.setId(hit.getId());
                searchResultCart.setTitle(field.getFragments()[0].toString());
                String preview = "";
                HighlightField highPreview = hit.getHighlightFields().get("content");
                if(highPreview!=null)
                    for (Text text : highPreview.getFragments()) {
                        preview += text;
                    }
                searchResultCart.setPreviews(preview);
                Map<String, Object> doc = hit.getSourceAsMap();
                searchResultCart.setUid(Integer.parseInt(doc.get("uid").toString()));
                searchResultCart.setViewCounts(Integer.parseInt(doc.get("view_counts").toString()));
                searchResultCart.setLikes(Integer.parseInt(doc.get("likes").toString()));
                searchResultCart.setCover(doc.get("cover").toString());
                searchResultCart.setCategory(doc.get("category").toString());
                searchResultCart.setCommentCounts(Integer.parseInt(doc.get("comment_counts").toString()));
                list.add(searchResultCart);
            }
            pageBean.setResults(list);
        }else{
            pageBean.setCode(PageCode.ESSAY_FAILED.getCode());
            pageBean.setMsg(PageCode.ESSAY_FAILED.getMsg());
        }
        return pageBean;
    }

    @Override
    public PageBean<SearchResultCart> essayList(int pagenums) throws Exception {
        PageBean<SearchResultCart> bean=new PageBean<SearchResultCart>();
        bean.setSize(Constants.INDEX_PAGE_SIZE);
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        MatchAllQueryBuilder queryAll=QueryBuilders.matchAllQuery();
        searchSourceBuilder.from((pagenums - 1) * bean.getSize())
                .size(bean.getSize())
                .query(queryAll)
                .sort("pub_date",SortOrder.DESC)
                .fetchSource(
                        new String[]{"content", "title","view_counts", "likes", "cover", "category", "comment_counts"},
                        new String[]{"html","uid"});
        SearchRequest request=new SearchRequest();
        request.indices(index);
        request.types(type);
        request.source(searchSourceBuilder);
        SearchResponse response=restClient.search(request);
        if(response.status().getStatus()==RestStatus.OK.getStatus()){
            bean.setCode(response.status().getStatus());
            bean.setTook(response.getTook().getSecondsFrac());
            SearchHits hits=response.getHits();
            List<SearchResultCart> list = new ArrayList<>();
            bean.setResultTotal(hits.getTotalHits());
            for(SearchHit hit:hits){
                SearchResultCart searchResultCart=new SearchResultCart();
                searchResultCart.setId(hit.getId());
                Map<String,Object> doc=hit.getSourceAsMap();
                searchResultCart.setTitle((String) doc.get("title"));
                searchResultCart.setCategory((String)doc.get("category"));
                searchResultCart.setCover((String)doc.get("cover"));
                searchResultCart.setLikes(Integer.parseInt(doc.get("likes").toString()));
                searchResultCart.setCommentCounts(Integer.parseInt(doc.get("comment_counts").toString()));
                searchResultCart.setViewCounts(Integer.parseInt(doc.get("view_counts").toString()));
                Object content=doc.get("content");
                if(content!=null)
                {
                    String preview=content.toString();
                    if(preview.length()<Constants.NO_MATCH_SIZE) {
                        searchResultCart.setPreviews(preview);
                    }
                    else{
                        searchResultCart.setPreviews(preview.substring(0,100));
                    }
                }
                /**
                 * 防止content内容过少,截取100时会报索引出边界异常
                 */
                list.add(searchResultCart);
            }
            bean.setResults(list);
        }else {
            bean.setCode(PageCode.ESSAY_FAILED.getCode());
            bean.setMsg(PageCode.ESSAY_FAILED.getMsg());
        }
        return bean;
    }
    @Override
    public PageBean<SearchResultCart> category(String category, int pagenums) throws Exception {
        PageBean<SearchResultCart> pageBean = new PageBean<SearchResultCart>();
        SearchSourceBuilder builder = new SearchSourceBuilder();
        TermQueryBuilder queryBuilder = QueryBuilders.termQuery("category", category);
        builder.from(Constants.POST_PAGE_SIZE * (pagenums - 1))
                .size(Constants.POST_PAGE_SIZE)
                .query(queryBuilder)
                .sort("view_counts", SortOrder.DESC)
                .fetchSource(
                        new String[]{"uid","title","content","view_counts","likes","cover","category","comment_counts"},
                        new String[]{"html"});
        SearchRequest request = new SearchRequest();
        request.indices(index);
        request.types(type);
        request.source(builder);
        SearchResponse response=restClient.search(request);
        if (response.status().getStatus() == RestStatus.OK.getStatus()) {
            SearchHits hits = response.getHits();
            pageBean.setResultTotal(hits.getTotalHits());
            pageBean.setSize(Constants.POST_PAGE_SIZE);
            pageBean.setType(Constants.PAGEBEAN_POST_CATEGORY_TYPE);
            pageBean.setTook(response.getTook().getSecondsFrac());
            pageBean.setKeyword(category);
            List<SearchResultCart> list = new ArrayList<>();
            for (SearchHit hit : hits) {
                Map<String, Object> doc = hit.getSourceAsMap();
                SearchResultCart searchResultCart=new SearchResultCart();
                searchResultCart.setTitle(doc.get("title").toString());
                searchResultCart.setId(hit.getId());
                searchResultCart.setUid(Integer.parseInt(doc.get("uid").toString()));
                Object obj=doc.get("content");
                if(obj!=null){
                    String previews=obj.toString();
                    if (previews.length() > 100) {
                        searchResultCart.setPreviews(previews.substring(0,100));
                    }else{
                        searchResultCart.setPreviews(previews);
                    }
                }
                searchResultCart.setCategory(doc.get("category").toString());
                searchResultCart.setCover(doc.get("cover").toString());
                searchResultCart.setCommentCounts(Integer.parseInt(doc.get("comment_counts").toString()));
                searchResultCart.setViewCounts(Integer.parseInt(doc.get("view_counts").toString()));
                searchResultCart.setLikes(Integer.parseInt(doc.get("likes").toString()));
                list.add(searchResultCart);
            }
            pageBean.setMsg(PageCode.ESSAY_SUCCESS.getMsg());
            pageBean.setResults(list);
            return pageBean;
        }
        pageBean.setCode(PageCode.ESSAY_FAILED.getCode());
        pageBean.setMsg(PageCode.ESSAY_FAILED.getMsg());
        return pageBean;
    }

    public Result updateUV(String articleId,Integer types)throws Exception{
        Result res=new Result();
        UpdateRequest request = new UpdateRequest(index, type, articleId);
        Script script=null;
        if(types==1){
            script = new Script(ScriptType.INLINE, "painless", "ctx._source.view_counts++", Collections.<String, Object>emptyMap());
        }else{
            script=new Script(ScriptType.INLINE,"painless","ctx._source.likes++",Collections.<String, Object>emptyMap());
        }
        request.script(script);
        UpdateResponse response=restClient.update(request);
       /* if(response.getResult()==DocWriteResponse.Result.UPDATED)*/
        if(response.status().getStatus()==RestStatus.OK.getStatus()){
            res.setStatus(PageCode.ESSAY_UPDATE_VIEW_SUCCESS.getCode());
            res.setMsg(PageCode.ESSAY_UPDATE_VIEW_SUCCESS.getMsg());
            return  res;
        }
        res.setStatus(PageCode.ESSAY_UPDATE_VIEW_FAILED.getCode());
        res.setMsg(PageCode.ESSAY_UPDATE_VIEW_FAILED.getMsg());
        return  res;
    }

    @Override
    public PageBean<PostRecommend> recommends(Integer pagenums) throws Exception {
        PageBean<PostRecommend> pageBean = new PageBean<PostRecommend>();
        SearchSourceBuilder builder = new SearchSourceBuilder();
        MatchAllQueryBuilder queryBuilder = QueryBuilders.matchAllQuery();
        builder.from(Constants.POST_RECOMMEND_SIZE * (pagenums - 1))
                .size(Constants.POST_RECOMMEND_SIZE)
                .query(queryBuilder)
                .sort("view_counts", SortOrder.DESC)
                .fetchSource(
                        new String[]{"title","cover"},
                        new String[]{"uid","html","content","view_counts","category","likes","comment_counts"});
        SearchRequest request = new SearchRequest();
        request.indices(index);
        request.types(type);
        request.source(builder);
        SearchResponse response=restClient.search(request);
        if (response.status().getStatus() == RestStatus.OK.getStatus()) {
            SearchHits hits = response.getHits();
            pageBean.setResultTotal(hits.getTotalHits());
            pageBean.setSize(Constants.POST_RECOMMEND_SIZE);
            List<PostRecommend> list = new ArrayList<>();
            for (SearchHit hit : hits) {
                Map<String, Object> doc = hit.getSourceAsMap();
                PostRecommend recommend = new PostRecommend();
                recommend.setId(hit.getId());
                recommend.setCover(doc.get("cover").toString());
                recommend.setTitle(doc.get("title").toString());
                list.add(recommend);
            }
            pageBean.setMsg(PageCode.ESSAY_SUCCESS.getMsg());
            pageBean.setResults(list);
            return pageBean;
        }
        pageBean.setCode(PageCode.ESSAY_FAILED.getCode());
        pageBean.setMsg(PageCode.ESSAY_FAILED.getMsg());
        return pageBean;
    }

    @Override
    public Article essayDetail(String id) throws Exception {

        Article article=null;
        GetRequest request = new GetRequest(index,type,id);
        GetResponse response = restClient.get(request);
        if(response.isExists()){
            article=new Article();
            Map<String,Object> map=response.getSourceAsMap();
            article.setArticleId(response.getId());
            article.setId(Integer.parseInt(map.get("uid").toString()));
            article.setCommentCounts(Integer.parseInt(map.get("comment_counts").toString()));
            article.setViewCounts(Integer.parseInt((map.get("view_counts").toString())));
            article.setHtml(map.get("html").toString());
            article.setPubDate(map.get("pub_date").toString());
            article.setTitle(map.get("title").toString());
            article.setLikes(Integer.parseInt(map.get("likes").toString()));
        }
        return article;
    }

    @Override
    public List<Post> posts(Integer uid) throws Exception{
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder=QueryBuilders.boolQuery();
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("uid", uid);
        boolQueryBuilder.must(queryBuilder);
        searchSourceBuilder.query(boolQueryBuilder)
                           .from(0)
        .size(10);
        SearchRequest request=new SearchRequest();
        request.indices(index);
        request.types(type);
        request.source(searchSourceBuilder);
        SearchResponse response=restClient.search(request);
        if(response.status().getStatus()==RestStatus.OK.getStatus()){
            List<Post> posts = new ArrayList<>();
            SearchHits hits=response.getHits();
            for (SearchHit hit : hits) {
                Post post=new Post();
                post.setId(hit.getId());
                Map<String,Object> map=hit.getSourceAsMap();
                post.setCover((String) map.get("cover"));
                post.setTitle((String)map.get("title"));
                posts.add(post);
            }
            return  posts;
        }
        return null;
    }
}
