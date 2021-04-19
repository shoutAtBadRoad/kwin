package com.kwin.db.service;

import com.kwin.db.entity.SensorData;

import java.text.ParseException;
import java.util.List;

public interface HistService {

    public List<SensorData> getShowDataByTime(String begin, String end) throws ParseException;

    List<SensorData> getShowDataByTimeAndHouse(String begin, String end, String id) throws ParseException;

}
