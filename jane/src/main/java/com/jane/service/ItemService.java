package com.jane.service;
import com.jane.pojo.*;
import com.jane.utils.PageBean;
import org.apache.http.HttpRequest;
import org.omg.PortableInterceptor.INACTIVE;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface ItemService {


    PageBean<ItemSearchCart> search(String keyword, Integer pagenums)throws Exception;

    PageBean<ItemSearchCart> searchByScene(String scene,Integer pagenums)throws Exception;

    PageBean<ItemSearchCart> searchCategory(String category, Integer pagesnum)throws Exception;

    Item itemDetail(String id)throws Exception;

    Result add(HttpServletRequest request)throws Exception;

    Result update(String pid, String type)throws  Exception;

    Result update(Collection collection) throws Exception;

    List<Recommend> recommends(String categorys) throws Exception;

    List<ItemPost> items(Integer id) throws Exception;

    PageBean<ItemSearchCart> filterSearch(String keyword, Double minPrice, Double maxPrice, Integer pagenums)throws Exception;

}
