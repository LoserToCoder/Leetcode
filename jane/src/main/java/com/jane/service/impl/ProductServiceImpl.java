package com.jane.service.impl;

import com.jane.dao.ProductDao;
import com.jane.pojo.Product;
import com.jane.pojo.Result;
import com.jane.service.ProductService;
import com.jane.utils.PageBean;
import com.jane.utils.PageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public PageBean<Product> queryAllProduct() throws Exception {
        PageBean<Product> beans = new PageBean<>();
        List<Product> products = productDao.selectAllProduct();
        if (products != null) {
            beans.setResults(products);
            beans.setMsg(PageCode.SCORE_PRODUCTS.getMsg());
            beans.setResultTotal(products.size());
            return beans;
        }
        return null;
    }

    @Override
    public List<Product> getProductList() throws Exception {
        List<Product> products=productDao.selectAllProduct();
        if(products!=null&&products.size()>0)
            return products;
        return null;
    }

    @Override
    public Result delProduct(Integer id) throws Exception {
        Integer nums=productDao.productDel(id);
        if (nums > 0) {
            Result result=new Result();
            result.setStatus(200);
            return result;
        }
        return null;
    }

    @Override
    public Result addProduct(Product product) throws Exception {
        Integer nums=productDao.addProduct(product);
        if(nums>0){
            Result result=new Result();
            result.setStatus(200);
            result.setMsg("商品新增成功");
            return result;
        }

        return null;
    }

}
