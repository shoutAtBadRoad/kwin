package com.kwin.db.entity;

public class Camera {

    private Integer id;

    private Integer sector_id;

    private Integer house_id;

    private String mac;

    private String url;

    public Camera(Integer sector_id, Integer house_id, String mac, String url) {
        this.sector_id = sector_id;
        this.house_id = house_id;
        this.mac = mac;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSector_id() {
        return sector_id;
    }

    public void setSector_id(Integer sector_id) {
        this.sector_id = sector_id;
    }

    public Integer getHouse_id() {
        return house_id;
    }

    public void setHouse_id(Integer house_id) {
        this.house_id = house_id;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "id=" + id +
                ", house_id=" + house_id +
                ", mac='" + mac + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
