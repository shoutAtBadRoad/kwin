package com.kwin.db.controller;

import com.kwin.db.service.MonitorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author JYP
 * @date 2020/11/4
 **/

@Controller
@RequestMapping("/monitor")
public class MonitorController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    MonitorService monitorService;

    @ResponseBody
    @GetMapping("/switch/{id}")
    public Map<String, Object> getSwitch(@PathVariable("id")String id){
        return monitorService.getSwitch(id);
    }

}
