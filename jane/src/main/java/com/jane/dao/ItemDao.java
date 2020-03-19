package com.jane.dao;

import com.jane.pojo.*;
import com.jane.utils.PageBean;

import java.util.List;

public interface ItemDao {

    Item itemDetail(String id) throws Exception;

    PageBean<ItemSearchCart> search(String keyword,int pagenums) throws Exception;

    PageBean<ItemSearchCart> categroy(String category,int pagenums) throws Exception;

    PageBean<ItemSearchCart> searchByScene(String scene,int pagenums) throws  Exception;

    PageBean<ItemSearchCart> filterSearch(String keyword, Double minPrice, Double maxPrice, Integer pagenums)throws Exception;

    Result itemAdd(Item item) throws Exception;

    List<Recommend> recommendation(String category)throws Exception;

    Result itemUpdate(String pid, String type)throws Exception;

    List<ItemPost> items(Integer id) throws Exception;
}
