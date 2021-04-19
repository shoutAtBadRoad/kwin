package com.kwin.db.entity;

/**
 * @author JYP
 * @date 2020/11/1
 **/

public class Sector {

    //区块id
    private Integer id;
    //区块负责人
    private String manager;
    //区块大棚数量
    private Integer house_number;
    //其他信息
    private String info;

    public Sector() {
    }

    public Sector(Integer id, String manager, Integer house_number, String info) {
        this.id = id;
        this.manager = manager;
        this.house_number = house_number;
        this.info = info;
    }

    public Sector(String manager, Integer house_number, String info) {
        this.manager = manager;
        this.house_number = house_number;
        this.info = info;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getHouse_number() {
        return house_number;
    }

    public void setHouse_number(Integer house_number) {
        this.house_number = house_number;
    }

    public String getInfo() {
        return info;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "Sector{" +
                "id=" + id +
                ", manager='" + manager + '\'' +
                ", house_number=" + house_number +
                ", info='" + info + '\'' +
                '}';
    }
}
