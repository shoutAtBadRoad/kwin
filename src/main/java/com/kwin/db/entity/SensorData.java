package com.kwin.db.entity;

import java.util.Date;

public class SensorData {

    //设备号
    private Integer sensor_id;
    //日期
    private Date date;
    //温度
    private double temperature;
    //湿度
    private double humidity;
    //土壤温度
    private double soil_temperature;
    //土壤湿度
    private double soil_humidity;

    public SensorData(Integer sensor_id, Date date, double temperature, double humidity, double soil_temperature, double soil_humidity) {
        this.sensor_id = sensor_id;
        this.date = date;
        this.temperature = temperature;
        this.humidity = humidity;
        this.soil_temperature = soil_temperature;
        this.soil_humidity = soil_humidity;
    }

    public Integer getSensor_id() {
        return sensor_id;
    }

    public void setSensor_id(Integer sensor_id) {
        this.sensor_id = sensor_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getSoil_temperature() {
        return soil_temperature;
    }

    public void setSoil_temperature(double soil_temperature) {
        this.soil_temperature = soil_temperature;
    }

    public double getSoil_humidity() {
        return soil_humidity;
    }

    public void setSoil_humidity(double soil_humidiyt) {
        this.soil_humidity = soil_humidiyt;
    }

    @Override
    public String toString() {
        return "Sensor{" +
                "s_id=" + sensor_id +
                ", date=" + date +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", soil_temperature=" + soil_temperature +
                ", soil_humidity=" + soil_humidity +
                '}';
    }
}
