package com.colleg.project.news.Models;

public class GsonForDetails {

    /**
     * post_id : 8
     * post_title : حادث مريب
     * post_img : https://cizaro.net/2030/uploads/blog/posts/
     * short_description :
     * long_description :  <p style="text-align: center;">حتى الان لا نعلم شىء عن الحادث</p>
     */

    private int post_id;
    private String post_title;
    private String post_img;
    private String short_description;
    private String long_description;

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    public String getPost_title() {
        return post_title;
    }

    public void setPost_title(String post_title) {
        this.post_title = post_title;
    }

    public String getPost_img() {
        return post_img;
    }

    public void setPost_img(String post_img) {
        this.post_img = post_img;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getLong_description() {
        return long_description;
    }

    public void setLong_description(String long_description) {
        this.long_description = long_description;
    }
}
