package com.kwin.db.service.Imp;

import com.kwin.db.entity.SensorData;
import com.kwin.db.entity.Warn;
import com.kwin.db.service.SensorService;
import com.kwin.db.mapper.SensorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class SensorServiceImpl implements SensorService {

    @Autowired
    SensorMapper sensorMapper;

    Logger logger = LoggerFactory.getLogger(getClass());

    //得到数据库中最新的一条传感器数据
    @Override
    public SensorData getShowData(Integer id) {
        SensorData sensorData = sensorMapper.getShowData(id);
        logger.info(sensorData.toString());
        return sensorData;
    }

    //得到传感器表中所有数据
    @Override
    public List<SensorData> getAllShowData() {
        List<SensorData> list = sensorMapper.getAllShowData();
        return list;
    }

    @Override
    public List<Integer> getWarnNum() {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<5;i++) {
            list.add(sensorMapper.getWarnNumByType(i));
        }
        return list;
    }

    /*
        如果操作不成功，或者不存在数据，统一返回null
        在返回数据封装过程中检测是否null
     */
    @Override
    //返回对应类型的所有warn信息
    public List<Warn> getAllWarn(Integer type) {
        List<Warn> list = sensorMapper.getAll(type);
        if(list.size() != 0) {
            return list;
        }else {
            return null;
        }
    }

    //返回id号大棚下的所有传感器预警信息
    @Override
    public List<Warn> getAllWarnByHouse(Integer id,Integer type) {
        List<Warn> list = sensorMapper.getAllWarnByHouse(id,type);
        if(list.size() != 0){
            return list;
        }else {
            return null;
        }
    }

    @Override
    public String updateWarnById(Integer id) {
         if(sensorMapper.updateWarnById(id)){
            return "true";
        }else{
             return null;
         }
    }

    @Override
    public String deleteWarnById(Integer id) {
        if(sensorMapper.deleteWarnById(id)){
            return "true";
        }else{
            return null;
        }
    }

    @Override
    public String deleteAllWarn(Integer type) {
        if(sensorMapper.deleteAllWarn(type)){
            return "true";
        }
        return null;
    }

    @Override
    public String updateAllWarn(Integer id) {
        if(sensorMapper.updateAllWarn(id)){
            return "true";
        }else {
            return null;
        }
    }

}
