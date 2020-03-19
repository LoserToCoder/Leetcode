package com.jane.dao;

import com.jane.pojo.Product;

import java.util.List;

public interface ProductDao {

    List<Product> selectAllProduct() throws Exception;

    Integer productDel(Integer id)throws Exception;

    Integer addProduct(Product product)throws Exception;



}
