package com.kwin.db.controller;

import com.kwin.db.config.response.ResponseResult;
import com.kwin.db.entity.Warn;
import com.kwin.db.service.Imp.SensorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*

 */

@RestController
@RequestMapping("/warn")
public class WarnController {

    @Autowired
    SensorServiceImpl sensorServiceImpl;
    @GetMapping("/{type}") //根据type读出所有对应类型的未读预警信息
    public List<Warn> findAll(@PathVariable("type")Integer type){
        return sensorServiceImpl.getAllWarn(type);
    }

    //返回h_id大棚下的传感器预警信息
    @GetMapping("/getbyhouse/{h_id}")
    public List<Warn> getByHouse(@PathVariable("h_id")Integer h_id){
        return sensorServiceImpl.getAllWarnByHouse(h_id,1);
    }

    @GetMapping("/getcount")//得到预警信息的条数
    public List<Integer> getWarnNum(){
        return sensorServiceImpl.getWarnNum();
    }

    @GetMapping("/update/{id}")//根据更新为已读
    public String updateWarn(@PathVariable("id")Integer id){
        return sensorServiceImpl.updateWarnById(id);
    }

    @DeleteMapping("/delete/{id}")//根据id删除预警信息
    public String deleteWarn(@PathVariable("id")Integer id){
        return sensorServiceImpl.deleteWarnById(id);
    }

    @DeleteMapping("/deleteall/{type}")//删除所有预警信息
    public String deleteAllWarn(@PathVariable("type")Integer type){
        return sensorServiceImpl.deleteAllWarn(type);
    }

    @GetMapping("/updateall/{house_id}")//根据house_id更新所有该大棚下的预警信息为已读
    public String updateAllWarn(@PathVariable("house_id")Integer id){
        return sensorServiceImpl.updateAllWarn(id);
    }

}
