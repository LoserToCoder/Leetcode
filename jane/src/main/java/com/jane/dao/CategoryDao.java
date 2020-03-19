package com.jane.dao;

import com.jane.pojo.Category;

import java.util.List;

public interface CategoryDao {


    public List<Category> selectAllCategory() throws  Exception;

    public List<Category> selectAllSubCategory(Integer cid) throws Exception;



}
