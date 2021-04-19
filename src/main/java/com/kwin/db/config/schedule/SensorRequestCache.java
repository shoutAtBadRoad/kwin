package com.kwin.db.config.schedule;

import com.kwin.db.mapper.SensorRequsetMapper;
import com.kwin.db.entity.SensorRequest;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JYP
 * @date 2020/10/29
 **/

@Component
@Data
public class SensorRequestCache {

    Logger logger = LoggerFactory.getLogger(getClass());

    public static List<SensorRequest> list = new ArrayList<>();

    @Autowired
    SensorRequsetMapper sensorRequsetMapper;

    /*
    项目启动的时候自动加载请求数据到内存
     */
    @PostConstruct
    public void initCache(){
        list = sensorRequsetMapper.getSensorReq();
        logger.info(list.toString());
    }


}
