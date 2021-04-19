package com.kwin.db.mapper;

import com.kwin.db.entity.Camera;
import com.kwin.db.entity.SensorData;
import com.kwin.db.entity.Warn;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Mapper
public interface SensorMapper {

    //得到数据库中的sensor对象数据
    SensorData getShowData(Integer s_id);
    //得到数据库中所有的sensor数据
    List<SensorData> getAllShowData();



    //取出所有传感器预警信息
    List<Warn> getAll(Integer type);
    //根据大棚id取出所有预警信息
    List<Warn> getAllWarnByHouse(Integer id,Integer type);
    //查询预警信息的条数
    Integer getWarnNumByType(Integer type);
    //向warn表中插入预警信息
    boolean insertWarn(Integer house_id, String context, Integer read, Date date, Integer type);
    //根据id删除预警信息
    boolean deleteWarnById(Integer id);
    //删除所有预警信息
    boolean deleteAllWarn(Integer type);
    //根据id设置预警信息为已读（w_read=1）
    boolean updateWarnById(Integer id);
    //根据大棚id将所有消息设置为已读
    boolean updateAllWarn(Integer id);



    //根据大棚id查询摄像头视频流和mac地址
    Camera getCam(Integer id);
    //添加摄像头
    boolean insertCam(Integer sector_id,Integer house_id,String mac,String url);
    //根据id更新摄像头数据
    boolean updateCamById(Integer id,Integer sector_id,Integer house_id,String mac,String url);
    //删除摄像头
    boolean deleteCamById(Integer id);
    //根据sector与house取得其第一号摄像头信息
    Camera getCamBy2Id(Integer s_id,Integer h_id);
    //根据sector与house取得所有摄像头信息
    List<Camera> getAllCamBy2Id(Integer s_id,Integer h_id);
    //查询所有的摄像头
    List<Camera> getAllCam();

}
