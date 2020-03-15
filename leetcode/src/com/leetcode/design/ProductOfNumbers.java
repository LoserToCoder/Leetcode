package com.leetcode.design;

import java.util.ArrayList;
import java.util.List;


public class ProductOfNumbers {



    private List<Integer> products;

    public ProductOfNumbers() {
        products = new ArrayList<>();
        products.add(1);
    }

    public void add(int num) {
        if(num == 0){
            products = new ArrayList<>();
            products.add(1);
        } else {
            products.add(products.get(products.size() - 1) * num);
        }
    }

    public int getProduct(int k) {
        if(products.size() <= k ){
            return 0;
        }
        return products.get(products.size() - 1) / products.get(products.size() - 1- k);
    }

    public static void main(String[] args) {
        ProductOfNumbers product = new ProductOfNumbers();
        product.add(3);
        product.add(0);
        product.add(2);
        product.add(5);
        product.add(4);

        System.out.println(product.getProduct(2));
        System.out.println(product.getProduct(3));
        System.out.println(product.getProduct(4));

    }
}
