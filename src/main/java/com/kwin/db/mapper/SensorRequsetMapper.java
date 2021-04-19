package com.kwin.db.mapper;

import com.kwin.db.entity.SensorRequest;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author JYP
 * @date 2020/10/29
 **/

@Component
@Mapper
public interface SensorRequsetMapper {

    //取出所有的请求参数
    @Select("select * from sensorcache")
    public List<SensorRequest> getSensorReq();
    //添加新的请求参数
    @Insert("insert into sensorcache(logo,sensor_name,channel_name,sector_id,house_id)values(#{logo},#{sensor},#{channel},#{sector_id},#{house_id})")
    public boolean insertSensorReq(String logo,String sensor,Integer channel,Integer sector_id,Integer house_id);
    //更新请求参数
    @Update("update sensorcache set logo=#{logo},sensor_name=#{sensor},channel_name=#{channel} where id=#{id}")
    public boolean updateSensorReqById(Integer id,String logo,String sensor,Integer channel);
    //根据id删除请求参数
    @Delete("delete from sensorcache where id=#{id}")
    public boolean deleteSensorReqById(Integer id);
    //根据id得到请求参数
    @Select("select * from sensorcache where id=#{id}")
    public SensorRequest getSensorReqById(Integer id);
    //根据区块和大棚id查询请求参数
    @Select("select * from sensorcache where sector_id=#{s_id} and house_id=#{h_id}")
    public List<SensorRequest> getSensorReqBy2Id(Integer s_id,Integer h_id);
    @Select("select * from sensorcache where sector_id=#{s_id} and house_id=#{h_id} limit 1")
    public SensorRequest getOneSensorReqBy2Id(Integer s_id,Integer h_id);

}
