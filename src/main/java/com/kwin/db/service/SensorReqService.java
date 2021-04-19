package com.kwin.db.service;

import com.kwin.db.entity.SensorRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SensorReqService {

    public List<SensorRequest> getSensorReq();

    public List<SensorRequest> getSensorReqBy2Id(Integer s_id,Integer h_id);

    public SensorRequest getSensorReqById(Integer id);

    public SensorRequest getOneSensorReq(Integer s_id,Integer h_id);

    public boolean insertSensorReq(SensorRequest sr);

    public boolean updateSensorReq(SensorRequest sr);

    public boolean deleteSensorReq(Integer id);

}
