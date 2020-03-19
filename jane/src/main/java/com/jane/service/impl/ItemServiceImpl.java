package com.jane.service.impl;
import com.jane.dao.CollectionDao;
import com.jane.dao.ItemDao;
import com.jane.pojo.*;
import com.jane.service.ItemService;
import com.jane.utils.PageBean;
import com.jane.utils.PageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDao itemDao;

    @Autowired
    private CollectionDao collectionDao;
    @Override
    public PageBean<ItemSearchCart> search(String keyword, Integer pagenums) throws Exception {
        if(pagenums==null||pagenums<1)
            pagenums=1;
        PageBean<ItemSearchCart> pageBean=itemDao.search(keyword, pagenums);
        if(pageBean.getCode()==PageCode.ITEM_SEARCH_SUCCESS.getCode()){
            if(pageBean.getPageTotal()>=1)
                return pageBean;
            else {
                pageBean.setCode(PageCode.ITEM_SEARCH_NO_RESULT.getCode());
                pageBean.setMsg(PageCode.ITEM_SEARCH_NO_RESULT.getMsg());
            }
        }
        pageBean.setMsg(PageCode.SERVER_ERROR.getMsg());
        return pageBean;
    }

    @Override
    public PageBean<ItemSearchCart> searchByScene(String scene,Integer pagenums) throws Exception {
        if(pagenums==null||pagenums<1)
            pagenums=1;
        PageBean<ItemSearchCart> pageBean=itemDao.searchByScene(scene, pagenums);
        if(pageBean.getCode()==PageCode.ITEM_SEARCH_SUCCESS.getCode()){
            if(pageBean.getPageTotal()>=1){
                pageBean.setMsg(PageCode.ITEM_SEARCH_SUCCESS.getMsg());
                return pageBean;
            }
            pageBean.setCode(PageCode.ITEM_SEARCH_NO_RESULT.getCode());
            pageBean.setMsg(PageCode.ITEM_SEARCH_NO_RESULT.getMsg());
            return pageBean;
        }
        pageBean.setCode(PageCode.SERVER_ERROR.getCode());
        pageBean.setMsg(PageCode.SERVER_ERROR.getMsg());
        return pageBean;
    }

    @Override
    public PageBean<ItemSearchCart> searchCategory(String category, Integer pagesnum) throws Exception {
        if(pagesnum==null||pagesnum<1)
            pagesnum=1;
        PageBean<ItemSearchCart> pageBean=itemDao.categroy(category,pagesnum);
        if(pageBean.getCode()==PageCode.ITEM_SEARCH_SUCCESS.getCode()){
            if(pageBean.getPageTotal()>=1){
                pageBean.setMsg(PageCode.ITEM_SEARCH_SUCCESS.getMsg());
                return pageBean;
            }else{
                pageBean.setCode(PageCode.ITEM_SEARCH_NO_RESULT.getCode());
                pageBean.setMsg(PageCode.ITEM_SEARCH_NO_RESULT.getMsg());
            }
        }
        pageBean.setMsg(PageCode.SERVER_ERROR.getMsg());
        pageBean.setCode(PageCode.SERVER_ERROR.getCode());
        return pageBean;
    }

    @Override
    public Item itemDetail(String id) throws Exception {
        Item item=itemDao.itemDetail(id);
        return item;
    }

    @Override
    public Result add(HttpServletRequest request) throws Exception {
        Item item=new Item();
        List<String> thumb = new ArrayList<>();
        item.setPid(Integer.parseInt(request.getParameter("pid")));
        item.setUid(Long.parseLong(request.getParameter("uid")));
        item.setTitle(request.getParameter("title"));
        item.setPrice(Double.parseDouble(request.getParameter("price")));
        item.setImgUrl(request.getParameter("imgUrl"));
        item.setDesc(request.getParameter("desc"));
        item.setCategory(request.getParameter("category"));
        item.setSubCategory(request.getParameter("subCategory"));
        item.setScene(request.getParameter("scene"));
        item.setContent(request.getParameter("content"));
        String[] thumbs = request.getParameterValues("thumbs[]");
        for(String pic:thumbs)
            thumb.add(pic);
        item.setThumbs(thumb);
        if(item!=null){
            Result result=itemDao.itemAdd(item);
            return result;
        }
        Result result=new Result();
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        return result;
    }

    @Override
    public Result update(String pid, String type) throws Exception {
        return itemDao.itemUpdate(pid,type);
    }
    @Override
    public Result update(Collection collection) throws Exception {
        Result result=itemDao.itemUpdate(collection.getEntityId(),null);
        if(result.getStatus()==PageCode.ITEM_UPDATE_SUCCESS.getCode()){
            result.setInfo(collectionDao.collections(collection));
            return  result;
        }
        result.setMsg(PageCode.SERVER_ERROR.getMsg());
        result.setStatus(PageCode.SERVER_ERROR.getCode());
        return result;
    }

    @Override
    public List<Recommend> recommends(String category) throws Exception {
        return itemDao.recommendation(category);
    }

    @Override
    public List<ItemPost> items(Integer id) throws Exception {
        return itemDao.items(id);
    }

    @Override
    public PageBean<ItemSearchCart> filterSearch(String keyword, Double minPrice, Double maxPrice, Integer pagenums) throws Exception {
        if (pagenums == null || pagenums < 1) {
            pagenums=1;
        }
        if(minPrice==null||minPrice<0){
            minPrice = Double.valueOf("0");
        }
        if(maxPrice==null||maxPrice<0){
            maxPrice= Double.valueOf("500");
        }
        return itemDao.filterSearch(keyword,minPrice,maxPrice,pagenums);
    }


}
