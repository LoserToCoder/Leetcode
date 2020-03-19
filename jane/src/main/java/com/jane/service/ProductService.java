package com.jane.service;

import com.jane.pojo.Product;
import com.jane.pojo.Result;
import com.jane.utils.PageBean;

import java.util.List;

public interface ProductService {


    PageBean<Product> queryAllProduct()throws Exception;

    List<Product> getProductList()throws Exception;

    Result delProduct(Integer id)throws Exception;

    Result addProduct(Product product)throws Exception;


}
