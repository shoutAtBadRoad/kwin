package com.kwin.db.service;

import com.kwin.db.entity.SensorData;
import com.kwin.db.entity.Warn;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface SensorService {

    SensorData getShowData(Integer id);

    List<SensorData> getAllShowData();

    List<Integer> getWarnNum();

    List<Warn> getAllWarn(Integer type);

    List<Warn> getAllWarnByHouse(Integer id,Integer type);

    String updateWarnById(Integer id);

    String deleteWarnById(Integer id);

    String deleteAllWarn(Integer type);

    String updateAllWarn(Integer id);
}
