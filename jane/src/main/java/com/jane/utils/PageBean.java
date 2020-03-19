package com.jane.utils;

import java.util.List;

public class PageBean<T> {

    private  int code=200;

    private String msg;

    private Double took;

    private Integer type;

    public Double getTook() {
        return took;
    }

    public void setTook(Double took) {
        this.took = took;
    }

    public int getCode() {
        return code;
    }

    private String keyword;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    private int size=30;

    private long pageTotal;

    private long resultTotal;

    private List<T> results;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getPageTotal() {
        return (resultTotal%size==0)? (resultTotal/size):(resultTotal/size+1);
    }
    public long getResultTotal() {
        return resultTotal;
    }

    public void setResultTotal(long resultTotal) {
        this.resultTotal = resultTotal;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }
}
