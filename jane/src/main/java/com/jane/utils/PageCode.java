package com.jane.utils;

import com.jane.pojo.Result;

public enum PageCode {

    LOGIN_SUCCESS(200,"登录成功"),
    LOGIN_FAILED(201,"登录失败"),
    REGISTER_SUCCESS(200,"注册成功"),
    REGISTER_FAILED(203,"注册失败"),
    TOKEN_INVALID(204,"token已失效,请重新登录"),
    TOKEN_VALID(200,"token有效"),
    SERVER_ERROR(500,"服务器内部异常,后台小哥正在修复中.."),
    ESSAY_SUCCESS(200,"响应成功"),
    ESSAY_FAILED(505,"请求失败"),
    ESSAY_NO_RESULT(200,"您所输入的关键词暂时没有相关结果匹配,请您重新选择关键词"),
    ESSAY_DETAIL_DELETED(500,"文章已不存在!"),
    ESSAY_DETAIL_SUCCESS(200,"文章详情请求成功"),
    ESSAY_CREATE_SUCCESS(200,"文章新增成功"),
    ESSAY_CREATE_FAILED(500,"文章新增失败"),
    ESSAY_UPDATE_VIEW_SUCCESS(200,"更新成功"),
    ESSAY_UPDATE_VIEW_FAILED(500,"更新失败"),
    ITEM_UPDATE_SUCCESS(200,"更新成功"),
    ITEM_UPDATE_FAILED(500,"更新失败"),
    ITEM_SEARCH_SUCCESS(200,"搜索响应成功"),
    ITEM_SEARCH_NO_RESULT(304,"无响应的结果匹配"),
    ITEM_ADD_SUCCESS(200,"商品新增成功"),
    ITEM_ADD_FAILED(500,"商品新增失败"),
    COMMENT_ADD_SUCCESS(200,"评论添加成功"),
    COMMENT_ADD_FAILED(500,"评论添加失败"),
    COMMENT_LOAD_SUCCESS(200,"评论加载成功"),
    COMMENT_NO_RESULT(201,"无评论结果"),
    REPLY_ADD_FAILED(500,"回复添加失败"),
    REPLY_ADD_SUCCESS(200,"回复添加成功"),
    REPLY_LIST(200,"加载成功"),
    REPLY_NO_RESULT(201,"此评论无回复"),
    CATEGORY_SUCCESS(200,"响应成功"),
    CATEGORY_FAILED(500,"获取失败"),
    ITEM_START_SUCCESS(200,"评分统计成功"),
    ITEM_START_FAILED(500,"评分统计异常"),
    ITEM_START_ADD_SUCCESS(200,"评分成功"),
    ITEM_START_ADD_FAILED(500,"评分失败"),
    ITEM_USER_SCORE(200,"存下用户积分id"),
    ITEM_RECOMMENDS(200,"推荐加载成功"),
    SCORE_PRODUCTS(200,"加载成功"),
    ITEM_COLLECTED(200,"已经收藏过了"),
    ITEM_COLLECTIONS(200,"用户存在收集"),
    ITEM_COLLECTIONS_NO(201,"用户暂无收集"),
    POST_COLLECTIONS(200, "用户收藏成功"),
    POST_COLLECTIONS_EXIST(200, "用户已收藏"),
    USER_POSTS(200,"用户发布过文章"),
    USER_NO_POST(201, "用户暂时未发布文章"),
    USER_ITEMS(200,"用户发布过商品"),
    USER_NO_ITEM(201,"该用户暂未发布商品"),
    UPDATE_USER(200,"用户信息更新成功"),
    UPDATE_USER_FAILED(500,"用户信息更新失败" ),
    USER_PASSWORD_VALIDATED(200,"用户密码校验成功"),
    USER_PASSWORD_VALIDATED_FAILED(404, "用户密码校验失败"),
    RECRUIT_DATA(200, "征文数据加载成功"),
    RECRUIT_NO_RESULTS(201, "暂无征文数据"),
    RECRUIT_ADD_SUCCESS(200, "征文新增成功"),
    RECRUIT_ADD_FAILED(400, "征文新增失败"),
    RECRUIT_UPDATE_SUCCESS(200,"征文新增成功"),
    RECRUIT_UPDATE_FAILED(400, "征文新增失败"),
    USER_FOCUS(200, "用户关注成功"),
    USER_FOCUS_FAILED(500,"用户关注失败"),
    USER_FOCUSED(200, "用户已关注"),
    USER_CANCEL_COLLECTION(200, "用户取消收藏成功"),
    USER_LIST(200, "获取用户列表"),
    USER_CONSUME(200, "用户兑换成功"),
    PRODUCTS_SCORE(200, "用户兑换记录存在"),

    ;

    private Integer code;
    private String msg;
    PageCode(Integer code,String msg){
        this.code=code;
        this.msg=msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
