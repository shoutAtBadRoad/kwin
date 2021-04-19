package com.kwin.db.entity;

/**
 * @author JYP
 * @date 2020/10/29
 **/

public class SensorRequest {

    //id
    private Integer id;
    //所属区块
    private Integer sector_id;
    //所属大棚
    private Integer house_id;
    //网关信息
    private String logo;
    //传感器信息
    private String sensor_name;
    //通道号
    private Integer channel_name;

    public String getLogo() {
        return logo;
    }

    public SensorRequest() {
    }

    public SensorRequest(Integer id, Integer sector_id, Integer house_id, String logo, String sensor_name, Integer channel_name) {
        this.id = id;
        this.sector_id = sector_id;
        this.house_id = house_id;
        this.logo = logo;
        this.sensor_name = sensor_name;
        this.channel_name = channel_name;
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

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSensor_name() {
        return sensor_name;
    }

    public void setSensor_name(String sensor_name) {
        this.sensor_name = sensor_name;
    }

    public Integer getChannel_name() {
        return channel_name;
    }

    public void setChannel_name(Integer channel_name) {
        this.channel_name = channel_name;
    }

    @Override
    public String toString() {
        return "SensorRequest{" +
                "id=" + id +
                ", sector_id=" + sector_id +
                ", house_id=" + house_id +
                ", logo='" + logo + '\'' +
                ", sensor_name='" + sensor_name + '\'' +
                ", channel_name=" + channel_name +
                '}';
    }
}
