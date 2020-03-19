package com.jane.dao.impl;
import com.jane.dao.ItemDao;
import com.jane.pojo.*;
import com.jane.utils.Constants;
import com.jane.utils.PageBean;
import com.jane.utils.PageCode;
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
import org.omg.CORBA.OBJ_ADAPTER;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ItemDaoImpl implements ItemDao {
    @Value("${elasticsearch.index.goods}")
    private String index;
    @Value("${elasticsearch.index.goods.type}")
    private String type;
    @Autowired
    private RestHighLevelClient restClient;
    @Override
    public Item itemDetail(String id) throws Exception {
        Item item=null;
        GetRequest request=new GetRequest(index,type,id);
        GetResponse response=restClient.get(request);
        if(response.isExists()){
            item=new Item();
            Map<String,Object> doc=response.getSourceAsMap();
            item.setUid(Long.parseLong(doc.get("uid").toString()));
            item.setId(response.getId());
            item.setPid(Integer.parseInt(doc.get("pid").toString()));
            item.setTitle(doc.get("title").toString());
            item.setDesc(doc.get("desc").toString());
            item.setImgUrl(doc.get("img_url").toString());
            item.setPrice(Double.parseDouble(doc.get("price").toString()));
            item.setCategory(doc.get("category").toString());
            item.setSubCategory( doc.get("sub_category").toString());
            item.setContent( doc.get("content").toString());
            item.setScene(doc.get("scene").toString());
            item.setThumbs((List<String>)doc.get("thumbox_list"));
            item.setViewCounts(Integer.parseInt(doc.get("view_counts").toString()));
            item.setLikes(Integer.parseInt(doc.get("likes").toString()));
            item.setCollections(Integer.parseInt(doc.get("collections").toString()));
            item.setPubDate(doc.get("post_date").toString());
            if(doc.get("prefix")!=null)
               item.setPrefix(doc.get("prefix").toString());
            return item;
        }
        return item;
    }
    @Override
    public Result itemAdd(Item item)throws Exception{
        Result result = new Result();
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("uid",item.getUid());
        map.put("title",item.getTitle());
        map.put("desc", item.getDesc());
        map.put("price", item.getPrice());
        map.put("img_url", item.getImgUrl());
        map.put("pid", item.getPid());
        map.put("prefix", item.getPrefix());
        map.put("category", item.getCategory());
        map.put("sub_category", item.getSubCategory());
        map.put("post_date", item.getPubDate());
        map.put("thumbox_list", item.getThumbs());
        map.put("scene", item.getScene());
        map.put("content", item.getContent());
        map.put("likes", 0);
        map.put("view_counts", 0);
        map.put("collections",0);
        IndexRequest request = new IndexRequest(index,type);
        request.source(map);
        IndexResponse response=restClient.index(request);
        int status=response.status().getStatus();
        if(status==RestStatus.CREATED.getStatus()) {
            result.setStatus(PageCode.ITEM_ADD_SUCCESS.getCode());
            result.setMsg(PageCode.ITEM_ADD_SUCCESS.getMsg());
            result.setInfo(response.toString());
            return result;
        }
        result.setMsg(PageCode.ITEM_ADD_FAILED.getMsg());
        result.setStatus(PageCode.ITEM_ADD_FAILED.getCode());
        return result;
    }

    @Override
    public List<Recommend> recommendation(String category) throws Exception {
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        MultiMatchQueryBuilder multiMatchQueryBuilder=QueryBuilders.multiMatchQuery(category,
                "category","sub_category");
        searchSourceBuilder.from(0)
                .size(5)
                .query(multiMatchQueryBuilder)
                .sort("likes", SortOrder.DESC);
        SearchRequest request = new SearchRequest();
        request.indices(index);
        request.types(type);
        request.source(searchSourceBuilder);
        SearchResponse response=restClient.search(request);
        List<Recommend> list =null;
        if(response.status().getStatus()==RestStatus.OK.getStatus()) {
            SearchHits hits = response.getHits();
            list = new ArrayList<>();
            for (SearchHit hit : hits) {
                Recommend recommend = new Recommend();
                Map<String, Object> doc = hit.getSourceAsMap();
                recommend.setTitle(doc.get("title").toString());
                recommend.setCollections(Integer.parseInt(doc.get("collections").toString()));
                recommend.setViews(Integer.parseInt(doc.get("view_counts").toString()));
                recommend.setPid(Integer.parseInt(doc.get("pid").toString()));
                recommend.setId(hit.getId());
                if (doc.get("prefix") != null)
                    recommend.setPrefix(doc.get("prefix").toString());
                recommend.setImgUrl(doc.get("img_url").toString());
                list.add(recommend);
            }
        }
        return list;
    }
    @Override
    public Result itemUpdate(String pid,String types) throws Exception {
         Result res=new Result();
         UpdateRequest request = new UpdateRequest(index, type, pid);
         Script updateScript=null;
         if(Constants.ITEM_VIEWS.equals(types)){
             updateScript=new Script(ScriptType.INLINE,"painless","ctx._source.view_counts++",Collections.<String, Object>emptyMap());
         }else if(Constants.ITEM_LIKES.equals(types)){
             updateScript=new Script(ScriptType.INLINE,"painless","ctx._source.likes++",Collections.<String, Object>emptyMap());
         }else{
            updateScript=new Script(ScriptType.INLINE,"painless","ctx._source.collections++",Collections.<String, Object>emptyMap());
        }
         request.script(updateScript);
         UpdateResponse response=restClient.update(request);
         if(response.getResult()==DocWriteResponse.Result.UPDATED){
              res.setStatus(PageCode.ITEM_UPDATE_SUCCESS.getCode());
              res.setMsg(PageCode.ITEM_UPDATE_SUCCESS.getMsg());
              return res;
         }
        res.setStatus(PageCode.ITEM_UPDATE_FAILED.getCode());
        res.setMsg(PageCode.ITEM_UPDATE_FAILED.getMsg());
        return  res;
    }

    @Override
    public List<ItemPost> items(Integer id) throws Exception {
        SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder=QueryBuilders.boolQuery();
        QueryBuilder queryBuilder = QueryBuilders.matchQuery("uid", id);
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
            List<ItemPost> items = new ArrayList<>();
            SearchHits hits=response.getHits();
            for (SearchHit hit : hits) {
                ItemPost item=new ItemPost();
                item.setId(hit.getId());
                Map<String,Object> map=hit.getSourceAsMap();
                if(map.get("pid")!=null){
                    item.setPid(Integer.parseInt(map.get("pid").toString()));
                }
                item.setTitle((String)map.get("title"));
                item.setImgUrl((String)map.get("img_url"));
                if(map.get("prefix")!=null){
                    item.setPrefix((String)map.get("prefix"));
                }
                items.add(item);
            }
            return  items;
        }
        return null;
    }
    @Override
    public PageBean<ItemSearchCart> search(String keyword, int pagenums) throws Exception {
        PageBean<ItemSearchCart> pageBean=new PageBean<>();
        pageBean.setSize(Constants.PAGE_SIZE);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        HighlightBuilder highlightBuilder = new HighlightBuilder();
        highlightBuilder.preTags(Constants.PRE_TAGS)
                .postTags(Constants.POST_TAGS)
                .field("title", Constants.FRAGMENT_SIZE,Constants.TITLE_NUMBER_OF_FRAGMENT)
                .noMatchSize(Constants.NO_MATCH_SIZE);
                MultiMatchQueryBuilder multiMatchQueryBuilder=QueryBuilders.multiMatchQuery(keyword,
                "title","category","sub_category");
                 searchSourceBuilder.from(pageBean.getSize()*(pagenums-1))
                                                 .size(pageBean.getSize())
                                                 .query(multiMatchQueryBuilder)
                                                 .highlighter(highlightBuilder);
        SearchRequest request = new SearchRequest();
        request.indices(index);
        request.types(type);
        request.source(searchSourceBuilder);
        SearchResponse response=restClient.search(request);
        if(response.status().getStatus()==200){
            SearchHits hits=response.getHits();
            pageBean.setKeyword(keyword);
            pageBean.setTook(response.getTook().getSecondsFrac());
            pageBean.setResultTotal(hits.getTotalHits());
            pageBean.setType(Constants.PAGEBEAN_ITEM_TYPE);
            List<ItemSearchCart> list = new ArrayList<>();
            for(SearchHit hit:hits ){
                ItemSearchCart searchCart = new ItemSearchCart();
                HighlightField high = hit.getHighlightFields().get("title");
                searchCart.setTitle(high.getFragments()[0].toString());
                Map<String, Object> doc = hit.getSourceAsMap();
                searchCart.setCollections(Integer.parseInt(doc.get("collections").toString()));
                searchCart.setLikes(Integer.parseInt(doc.get("likes").toString()));
                searchCart.setId(hit.getId());
                if(doc.get("prefix")!=null)
                   searchCart.setPrefix(doc.get("prefix").toString());
                searchCart.setPrice(Double.parseDouble(doc.get("price").toString()));
                searchCart.setPid(Integer.parseInt(doc.get("pid").toString()));
                searchCart.setUid(Long.parseLong(doc.get("uid").toString()) );
                searchCart.setImgUrl(doc.get("img_url").toString());
                list.add(searchCart);
            }
            pageBean.setResults(list);
        }else{
            pageBean.setCode(PageCode.SERVER_ERROR.getCode());
        }
        return pageBean;
    }
    @Override
    public PageBean<ItemSearchCart> categroy(String category, int pagenums) throws Exception {
          SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder();
          MultiMatchQueryBuilder multiMatchQueryBuilder=QueryBuilders.multiMatchQuery(category,
                "category","sub_category");
          searchSourceBuilder.from(Constants.PAGE_SIZE*(pagenums-1))
                             .size(Constants.PAGE_SIZE)
                             .query(multiMatchQueryBuilder);
          PageBean<ItemSearchCart> pageBean=templateSearch(searchSourceBuilder);
          pageBean.setType(Constants.PAGEBEAN_ITEM_CATEGORY_TYPE);
          return pageBean;
    }
    @Override
    public PageBean<ItemSearchCart> searchByScene(String scene,int pagenums) throws Exception {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        MultiMatchQueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(scene,"content","scene")
                .type(MultiMatchQueryBuilder.Type.MOST_FIELDS).tieBreaker(0.3f);
        searchSourceBuilder.from(Constants.PAGE_SIZE*(pagenums-1))
                           .size(Constants.PAGE_SIZE)
                           .query(queryBuilder);
        PageBean<ItemSearchCart> pageBean=templateSearch(searchSourceBuilder);
        pageBean.setKeyword(scene);
        return pageBean;
    }

    @Override
    public PageBean<ItemSearchCart> filterSearch(String keyword, Double minPrice, Double maxPrice, Integer pagenums)throws Exception {
        PageBean<ItemSearchCart> pageBean=new PageBean<>();
        pageBean.setSize(Constants.PAGE_SIZE);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        HighlightBuilder highlightBuilder=null;

        if(minPrice!=null||maxPrice!=null){
            RangeQueryBuilder rangeQuery=QueryBuilders.rangeQuery("price");
            if(minPrice<maxPrice){
                rangeQuery.gte(minPrice)
                        .lte(maxPrice);
            }else {
                rangeQuery.gte(maxPrice)
                        .lte(minPrice);
            }
            boolQueryBuilder.filter(rangeQuery);
        }
        if(keyword!=null) {
            highlightBuilder = new HighlightBuilder();
                     highlightBuilder
                    .preTags(Constants.PRE_TAGS)
                    .postTags(Constants.POST_TAGS)
                    .field("title", Constants.FRAGMENT_SIZE, Constants.TITLE_NUMBER_OF_FRAGMENT)
                    .noMatchSize(Constants.NO_MATCH_SIZE);
                     MultiMatchQueryBuilder multiMatchQueryBuilder = QueryBuilders.multiMatchQuery(keyword,
                    "title", "category", "sub_category")
                    .type(MultiMatchQueryBuilder.Type.MOST_FIELDS)
                    .tieBreaker(0.3f);
                    boolQueryBuilder.must(multiMatchQueryBuilder);
                    searchSourceBuilder.highlighter(highlightBuilder);
        }
        searchSourceBuilder.from(pageBean.getSize()*(pagenums-1))
                .size(pageBean.getSize())
                .query(boolQueryBuilder);
        SearchRequest request = new SearchRequest();
        request.indices(index);
        request.types(type);
        request.source(searchSourceBuilder);
        SearchResponse response=restClient.search(request);
        if(response.status().getStatus()==200){
            SearchHits hits=response.getHits();
            pageBean.setKeyword(keyword);
            pageBean.setResultTotal(hits.getTotalHits());
            pageBean.setType(Constants.FILTER_ITEM_TYPE);
            List<ItemSearchCart> list = new ArrayList<>();
            for(SearchHit hit:hits ){
                ItemSearchCart searchCart = new ItemSearchCart();
                Map<String, Object> doc = hit.getSourceAsMap();
                if(highlightBuilder!=null){
                    HighlightField high = hit.getHighlightFields().get("title");
                    searchCart.setTitle(high.getFragments()[0].toString());
                }else{
                    searchCart.setTitle(doc.get("title").toString());
                }
                searchCart.setCollections(Integer.parseInt(doc.get("collections").toString()));
                searchCart.setLikes(Integer.parseInt(doc.get("likes").toString()));
                searchCart.setId(hit.getId());
                if(doc.get("prefix")!=null)
                    searchCart.setPrefix(doc.get("prefix").toString());
                searchCart.setPrice(Double.parseDouble(doc.get("price").toString()));
                searchCart.setPid(Integer.parseInt(doc.get("pid").toString()));
                searchCart.setUid(Long.parseLong(doc.get("uid").toString()) );
                searchCart.setImgUrl(doc.get("img_url").toString());
                list.add(searchCart);
            }
            pageBean.setResults(list);
        }else{
            pageBean.setCode(PageCode.SERVER_ERROR.getCode());
        }
        return pageBean;
    }
    public  PageBean<ItemSearchCart> templateSearch(SearchSourceBuilder searchSourceBuilder)throws Exception{
        PageBean<ItemSearchCart> pageBean=new PageBean<>();
        SearchRequest request = new SearchRequest();
        request.indices(index);
        request.types(type);
        request.source(searchSourceBuilder);
        SearchResponse response=restClient.search(request);
        if(response.status().getStatus()==RestStatus.OK.getStatus()){
            SearchHits hits=response.getHits();
            pageBean.setTook(response.getTook().getSecondsFrac());
            pageBean.setResultTotal(hits.getTotalHits());
            List<ItemSearchCart> list = new ArrayList<>();
            for(SearchHit hit:hits ){
                ItemSearchCart searchCart = new ItemSearchCart();
                Map<String, Object> doc = hit.getSourceAsMap();
                searchCart.setTitle(doc.get("title").toString());
                searchCart.setPrice(Double.parseDouble(doc.get("price").toString()));
                searchCart.setCollections(Integer.parseInt(doc.get("collections").toString()));
                searchCart.setLikes(Integer.parseInt(doc.get("likes").toString()));
                searchCart.setPid(Integer.parseInt(doc.get("pid").toString()));
                searchCart.setId(hit.getId());
                if(doc.get("prefix")!=null)
                   searchCart.setPrefix(doc.get("prefix").toString());
                searchCart.setUid(Long.parseLong(doc.get("uid").toString()) );
                searchCart.setImgUrl(doc.get("img_url").toString());
                list.add(searchCart);
            }
            pageBean.setResults(list);
        }else{
            pageBean.setCode(PageCode.ESSAY_FAILED.getCode());
        }
        return pageBean;
    }
}
