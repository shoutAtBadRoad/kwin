package com.kwin.db.entity;

import java.util.Date;

public class Warn {
    //信息id
    Integer id;
    //大棚id
    Integer house_id;
    //预警内容
    String context;
    //已读二值数
    Integer w_read;
    //时间
    Date w_date;
    //预警信息类型
    Integer type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHouse_id() {
        return house_id;
    }

    public void setHouse_id(Integer house_id) {
        this.house_id = house_id;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Integer getW_read() {
        return w_read;
    }

    public void setW_read(Integer w_read) {
        this.w_read = w_read;
    }

    public Date getW_date() {
        return w_date;
    }

    public void setW_date(Date w_date) {
        this.w_date = w_date;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Warn{" +
                "id=" + id +
                ", house_id=" + house_id +
                ", context='" + context + '\'' +
                ", w_read=" + w_read +
                ", w_date=" + w_date +
                '}';
    }
}
