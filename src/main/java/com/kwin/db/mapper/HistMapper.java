package com.kwin.db.mapper;

import com.kwin.db.entity.SensorData;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Mapper
public interface HistMapper {

    //根据时间段查询所有数据
    public List<SensorData> getShowDataByTime(Date begin, Date end);

    //查询大棚下的传感器数据
    List<SensorData> getShowDataByTimeAndHouse(Date begin, Date end, Integer s_id ,Integer h_id);

}
