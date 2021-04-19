package com.kwin.db.service.Imp;

import com.kwin.db.mapper.SensorRequsetMapper;
import com.kwin.db.config.schedule.SensorRequestCache;
import com.kwin.db.entity.SensorRequest;
import com.kwin.db.service.SensorReqService;
import com.kwin.db.entity.House;
import com.kwin.db.service.SectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JYP
 * @date 2020/10/30
 **/

@Service
public class SensorReqServiceImpl implements SensorReqService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SensorRequsetMapper sensorRequsetMapper;
    @Autowired
    SectorService sectorService;

    @Override
    public List<SensorRequest> getSensorReq() {
        return sensorRequsetMapper.getSensorReq();
    }

    /*
    根据区块和大棚查询请求
     */
    @Override
    public List<SensorRequest> getSensorReqBy2Id(Integer s_id, Integer h_id) {
        return sensorRequsetMapper.getSensorReqBy2Id(s_id,h_id);
    }

    @Override
    public SensorRequest getSensorReqById(Integer id) {
        return sensorRequsetMapper.getSensorReqById(id);
    }

    /*
    根据区块和大棚查询请求
    但只获取第一个请求，供实时监控页面使用
    如果大棚中无传感器，则调用头号大棚的传感器
    */
    @Override
    public SensorRequest getOneSensorReq(Integer s_id, Integer h_id) {
        SensorRequest sensorRequest = sensorRequsetMapper.getOneSensorReqBy2Id(s_id,h_id);
        if(sensorRequest!=null){
            return sensorRequest;
        }
        return sensorRequsetMapper.getOneSensorReqBy2Id(1,1);
    }


    /*
        将SensorRequest对象保存到数据库中
         */
    @Override
    public boolean insertSensorReq(SensorRequest sr){
        Boolean bool = sensorRequsetMapper.insertSensorReq(sr.getLogo(),sr.getSensor_name(),sr.getChannel_name(),sr.getSector_id(),sr.getHouse_id());
        logger.info(bool.toString());
        refresh();
        logger.info("请求列表更新成功");
        House house = sectorService.getHouseBy2Id(sr.getSector_id(),sr.getHouse_id());
        house.setSensor_number(house.getSensor_number()+1);
        bool = sectorService.updateHouseById(house);
        return bool;
    }

    /*
    更改对应id传感器请求数据
     */
    @Override
    public boolean updateSensorReq(SensorRequest sr){
        Boolean bool = sensorRequsetMapper.updateSensorReqById(sr.getId(),sr.getLogo(),sr.getSensor_name(),sr.getChannel_name());
        logger.info(bool.toString());
        refresh();
        logger.info("请求列表更新成功");
        return bool;
    }
    /*
    删除传感器请求数据
     */
    @Override
    public boolean deleteSensorReq(Integer id){
        SensorRequest sr = sensorRequsetMapper.getSensorReqById(id);
        Integer s = sr.getSector_id();
        Integer h = sr.getHouse_id();
        Boolean bool = sensorRequsetMapper.deleteSensorReqById(id);
        logger.info(bool.toString());
        refresh();
        logger.info("请求列表更新成功");
        House house = sectorService.getHouseBy2Id(s,h);
        house.setSensor_number(house.getSensor_number()-1);
        bool = sectorService.updateHouseById(house);
        return bool;
    }

    /*
        请求信息改变之后，刷新内存中的请求信息列表
        后期可针对不同改变，在内存中实现微调
     */
    public void refresh(){
        SensorRequestCache.list = getSensorReq();
    }

}
