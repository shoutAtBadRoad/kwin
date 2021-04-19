package com.kwin.db.entity;

import lombok.Data;

/**
 * @author JYP
 * @date 2020/11/1
 **/

@Data
public class House {

    //大棚的id
    private Integer id;
    //大棚管理人员
    private String employee;
    //所属区块的id
    private Integer sector_id;
    //区块中的几号大棚
    private Integer house_id;
    //传感器数量
    private Integer sensor_number;
    //摄像头数量
    private Integer cam_number;
    //其他信息
    private String info;

    public House() {
    }

    public House(Integer id, String employee, Integer sector_id, Integer house_id, Integer sensor_number, Integer cam_number, String info) {
        this.id = id;
        this.employee = employee;
        this.sector_id = sector_id;
        this.house_id = house_id;
        this.sensor_number = sensor_number;
        this.cam_number = cam_number;
        this.info = info;
    }

    public House(String employee, Integer sector_id, Integer house_id, Integer sensor_number, Integer cam_number, String info) {
        this.employee = employee;
        this.sector_id = sector_id;
        this.house_id = house_id;
        this.sensor_number = sensor_number;
        this.cam_number = cam_number;
        this.info = info;
    }

    public Integer getHouse_id() {
        return house_id;
    }

    public void setHouse_id(Integer house_id) {
        this.house_id = house_id;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
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

    public Integer getSensor_number() {
        return sensor_number;
    }

    public void setSensor_number(Integer sensor_number) {
        this.sensor_number = sensor_number;
    }

    public Integer getCam_number() {
        return cam_number;
    }

    public void setCam_number(Integer cam_number) {
        this.cam_number = cam_number;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
