package com.kwin.db.service;

import com.kwin.db.entity.Camera;

import java.util.List;

public interface CamService {

    //根据id查询不同大棚的摄像头地址
    Camera getCam(Integer id);
    //根据区块和大棚号取得主摄像头信息
    Camera getCamBy2Id(Integer s_id,Integer h_id);
    //根据区块和大棚号取得所有摄像头信息
    List<Camera> getAllCamBy2Id(Integer s_id,Integer h_id);
    //添加摄像头
    boolean insertCam(Integer sector_id,Integer house_id,String mac,String url);
    //根据id更新摄像头数据
    boolean updateCamById(Integer id,Integer sector_id,Integer house_id,String mac,String url);
    //删除摄像头
    boolean deleteCamById(Integer id);
    //查询所有的摄像头
    List<Camera> getAllCam();


}
