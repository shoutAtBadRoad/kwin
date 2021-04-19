package com.kwin.db.test.user.entity;

public class Greenhouse {

    private Integer id;
    private String date;
    private String context;

    public Greenhouse(Integer id, String data, String context) {
        this.id = id;
        this.date = data;
        this.context = context;
    }

    public Greenhouse(String data, String context) {
        this.date = data;
        this.context = context;
    }

    //空构造器一定要写出来！！！
    public Greenhouse() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return date;
    }

    public void setData(String data) {
        this.date = data;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
