package com.jane.pojo;

public class SearchResultCart {



    private Integer uid;
    private String id;

    private String title;

    private String previews;

    private String cover;

    private String category;

    private int viewCounts;

    private int likes;

    private int commentCounts;

    public int getCommentCounts() {
        return commentCounts;
    }

    public void setCommentCounts(int commentCounts) {
        this.commentCounts = commentCounts;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPreviews() {
        return previews;
    }

    public void setPreviews(String previews) {
        this.previews = previews;
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

    public int getViewCounts() {
        return viewCounts;
    }

    public void setViewCounts(int viewCounts) {
        this.viewCounts = viewCounts;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public String toString() {
        return "SearchResultCart{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", previews='" + previews + '\'' +
                ", cover='" + cover + '\'' +
                ", category='" + category + '\'' +
                ", viewCounts=" + viewCounts +
                ", likes=" + likes +
                '}';
    }
}
