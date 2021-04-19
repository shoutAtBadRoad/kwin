package com.kwin.db.entity;

import lombok.Data;

import java.sql.Blob;

/**
 * @author JYP
 * @date 2020/11/8
 **/

@Data
public class Image {

    private Integer id;
    private byte[] img;
    private Integer cam;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public Integer getCam() {
        return cam;
    }

    public void setCam(Integer cam) {
        this.cam = cam;
    }
}
