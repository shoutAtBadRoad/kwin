package com.kwin.db.test.manage.entity;

import java.util.Date;

public class News {
    //新闻id
    private Integer id;
    //新闻标题
    private String title;
    //新闻发布日期
    private Date w_date;

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

    public Date getDate() {
        return w_date;
    }

    public void setDate(Date date) {
        this.w_date = date;
    }
}
