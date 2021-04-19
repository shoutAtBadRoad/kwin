package com.kwin.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface CurrentdtMapper {

    @Insert("insert into sensordt(sensor_id,temperature,humidity,soil_temperature,soil_humidity,date)values(#{sensor_id},#{t},#{h},#{s_t},#{s_h},#{date})")
    boolean insertdt(Integer sensor_id,double t, double h, double s_t,double s_h,String date);

}
