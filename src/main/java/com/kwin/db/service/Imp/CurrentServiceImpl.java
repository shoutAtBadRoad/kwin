package com.kwin.db.service.Imp;

import com.kwin.db.entity.SensorData;
import com.kwin.db.mapper.SensorMapper;
import com.kwin.db.mapper.CurrentdtMapper;
import com.kwin.db.service.CurrentdtService;
import com.kwin.db.service.CurrentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author JYP
 * @date 2020/10/28
 **/
@Service
//@Transactional
public class CurrentServiceImpl implements CurrentService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    CurrentdtMapper currentdtMapper;
    @Autowired
    CurrentdtService currentdtService;
    @Autowired
    SensorMapper sensorMapper;

    /**
     *
     * @param logo
	 * @param sensor
	 * @param channel
	 * @param sensor_id
     * @return void
     * @author yuxin
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/1 20:49
     * @detail 通过logo查询传感器数据，根据传感器id写入数据库
     */
    @Override
    public void insertDt(String logo, String sensor, Integer channel, Integer sensor_id) {
        List<Double> list = currentdtService.getCurrentdtList(logo);
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if(list!=null){
            currentdtMapper.insertdt(sensor_id,list.get(0),list.get(1),list.get(2),list.get(3),sdf.format(date));
            Jugde(new SensorData(sensor_id,date,list.get(0),list.get(1),list.get(2),list.get(3)));
        }
    }

    /*
    输出Sensor对象
    根据其中的温湿度判断是否异常
    如果异常，则更新警告表warning，返回i{1~3}
 */
    public Integer Jugde(SensorData sensorData){
        logger.info("jugded!");
        if(sensorData ==null){
            return 0;
        }
        Integer i = 0;
        Integer house_id= sensorData.getSensor_id();
        Integer read=0;
        Date date = new Date();
        String context = null;
        if(sensorData.getTemperature()<=25 && sensorData.getTemperature()<=80){
            i=1;
            context = "温湿度均有异常，请即时处理！";
        }else if(sensorData.getTemperature()<=25){
            i=2;
            context = "温度异常，请及时处理！";
        }else if(sensorData.getHumidity()<=85){
            i=3;
            context = "湿度异常，请及时处理！";
        }
        boolean bool = sensorMapper.insertWarn(house_id,context,read,date, 1);
        System.out.println(bool);
        return i;
    }
}
