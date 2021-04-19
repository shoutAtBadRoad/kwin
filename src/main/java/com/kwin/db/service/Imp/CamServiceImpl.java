package com.kwin.db.service.Imp;

import com.kwin.db.entity.Camera;
import com.kwin.db.mapper.SensorMapper;
import com.kwin.db.service.CamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CamServiceImpl implements CamService {

    private Boolean bool;
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    SensorMapper sensorMapper;


    @Override
    public Camera getCam(Integer id) {
        Camera cam = sensorMapper.getCam(id);
        logger.info(cam.toString());
        return cam;
    }

    /*
    根据区块和大棚号获得主摄像头信息
     */
    @Override
    public Camera getCamBy2Id(Integer s_id, Integer h_id) {
        Camera camera = sensorMapper.getCamBy2Id(s_id,h_id);
        if(camera!=null){
            return camera;
        }
        return sensorMapper.getCam(1);
    }

    /*
    根据区块和大棚号获得所有摄像头信息
     */
    @Override
    public List<Camera> getAllCamBy2Id(Integer s_id, Integer h_id) {
        List<Camera> list = sensorMapper.getAllCamBy2Id(s_id,h_id);
        if(list.size()!=0) {
            return list;
        }else {
            return null;
        }
    }

    @Override
    public boolean insertCam(Integer sector_id, Integer house_id, String mac, String url) {
        bool = sensorMapper.insertCam(sector_id,house_id,mac,url);
        return bool;
    }

    @Override
    public boolean updateCamById(Integer id, Integer sector_id, Integer house_id, String mac, String url) {
        bool = sensorMapper.updateCamById(id,sector_id,house_id,mac,url);
        return bool;
    }

    @Override
    public boolean deleteCamById(Integer id) {
        bool = sensorMapper.deleteCamById(id);
        return bool;
    }

    @Override
    public List<Camera> getAllCam() {
        return sensorMapper.getAllCam();
    }
}
