package com.jane.pojo;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.util.List;

public class Article {

    private String articleId;

    private Integer  id;

    private String   title;

    private String   cover;

    private String   category;

    private String   content;

    private String   html;

    private DateTime   pubDate=new DateTime();

    private Integer  viewCounts;

    private Integer  commentCounts;

    private Integer  likes;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public String getPubDate() {
        return pubDate.toString("yyyy-MM-dd HH:mm:ss");
    }

    public void setPubDate(String pubDate) {
        if(pubDate.length()<12)
            this.pubDate=DateTime.parse(pubDate,DateTimeFormat.forPattern("yyyy-MM-dd"));
        else{
            this.pubDate =DateTime.parse(pubDate,DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")) ;
        }

    }

    public Integer getViewCounts() {
        return viewCounts;
    }

    public void setViewCounts(Integer viewCounts) {
        this.viewCounts = viewCounts;
    }

    public Integer getCommentCounts() {
        return commentCounts;
    }

    public void setCommentCounts(Integer commentCounts) {
        this.commentCounts = commentCounts;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

}
