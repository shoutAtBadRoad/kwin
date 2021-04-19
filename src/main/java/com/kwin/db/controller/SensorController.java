package com.kwin.db.controller;

import com.kwin.db.entity.SensorData;
import com.kwin.db.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensor")
public class SensorController {

    @Autowired
    SensorService sensorService;
    /**
     *
     * @param id
     * @return com.kwin.db.config.response.ResponseResult<com.kwin.db.entity.SensorData>
     * @author yuxin
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/1 20:53
     *         根据id查询一条最新的传感器数据
     *         id用来标识传感器
     */
    @GetMapping("/getshowdata/{id}")
    SensorData getData(@PathVariable("id") Integer id){
        return sensorService.getShowData(id);
    }

}
