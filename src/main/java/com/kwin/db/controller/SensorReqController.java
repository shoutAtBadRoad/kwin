package com.kwin.db.controller;

import com.kwin.db.entity.SensorRequest;
import com.kwin.db.service.Imp.SensorReqServiceImpl;
import com.kwin.db.entity.House;
import com.kwin.db.service.SectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author JYP
 * @date 2020/10/30
 **/

@Controller
@RequestMapping("/req")
public class SensorReqController {

    Logger logger = LoggerFactory.getLogger(getClass());
    private Boolean bool;

    @Autowired
    SensorReqServiceImpl sensorReqServiceImpl;
    @Autowired
    SectorService sectorService;

    /**
     *
     * @param model
	 * @param request
     * @return java.lang.String
     * @author jyp
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/5 12:05
     * 判断有没有大棚的id，如果有就返回此大棚下的传感器列表，否则返回所有传感器列表
     */
    @GetMapping("/show")
    public String getShow(Model model,HttpServletRequest request){
        String id = request.getParameter("id");
        List<SensorRequest> list = new ArrayList<>();
        if(id==null) {
            list = sensorReqServiceImpl.getSensorReq();
        }else {
            House house = sectorService.getHouseById(Integer.valueOf(id));
            list = sensorReqServiceImpl.getSensorReqBy2Id(house.getSector_id(),house.getHouse_id());
            model.addAttribute("sector_id",house.getSector_id());
            model.addAttribute("house_id", house.getHouse_id());
        }
        model.addAttribute("sr",list);
        return "/sensor/list";
    }

    /**
     *
     * @param model
	 * @param id
     * @return java.lang.String
     * @author jyp
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/5 12:06
     * 返回第id号大棚下的传感器列表
     */
    @GetMapping("/show/{id}")
    public String getShowById(Model model,@PathVariable("id")Integer id){
        House house = sectorService.getHouseById(id);
        List<SensorRequest> list = sensorReqServiceImpl.getSensorReqBy2Id(house.getSector_id(),house.getHouse_id());
        model.addAttribute("sr",list);
        model.addAttribute("sector_id",house.getSector_id());
        model.addAttribute("house_id", house.getHouse_id());
        return "/sensor/list";
    }

    /**
     *
     * @param sensorRequest
     * @return boolean
     * @author yuxin
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/2 16:32
     * 添加传感器后，跳转显示其大棚下所有传感器
     */
    @PostMapping("/insert")
    public String insertSensorReq(SensorRequest sensorRequest, RedirectAttributes attr){
        logger.info("start insert pro");
        bool = sensorReqServiceImpl.insertSensorReq(sensorRequest);
        logger.info("finish insert pro");
        Integer id = sectorService.getHouseBy2Id(sensorRequest.getSector_id(),sensorRequest.getHouse_id()).getId();
        attr.addAttribute("id",id);
        return "redirect:/req/show";
    }

    /*
    跳转到添加页面
     */
    @GetMapping("/req")
    public String addSensorReq(@RequestParam("sector_id")Integer s_id,@RequestParam("house_id")Integer h_id,Model model){
        model.addAttribute("sector_id",s_id);
        model.addAttribute("house_id",h_id);
        return "/sensor/add";
    }

    /**
     *
     * @param id
	 * @param attr
     * @return java.lang.String
     * @author jyp
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/5 12:07
     * 删除id号传感器，跳转显示其大棚下所有传感器
     */
    @PostMapping("/delete/{id}")
    public String deleteSensorReq(@PathVariable("id")Integer id,RedirectAttributes attr){
        SensorRequest sr = sensorReqServiceImpl.getSensorReqById(id);
        bool = sensorReqServiceImpl.deleteSensorReq(id);
        Integer s_id = sectorService.getHouseBy2Id(sr.getSector_id(),sr.getHouse_id()).getId();
        attr.addAttribute("id",s_id);
        return "redirect:/req/show";
    }

    @GetMapping("/edit/{id}")
    public String editSensorReq(@PathVariable("id")Integer id, Model model){
        SensorRequest sensorRequest = sensorReqServiceImpl.getSensorReqById(id);
        model.addAttribute("sr",sensorRequest);
        return "/sensor/update";
    }

    @GetMapping("/update")
    public String updateSensorReq(SensorRequest sensorRequest){
        bool = sensorReqServiceImpl.updateSensorReq(sensorRequest);
        if(bool){
            logger.info(sensorRequest.getId()+"号传感器请求修改成功");
        }
        return "redirect:/req/show";
    }

//    @GetMapping("/inreq")
//    public boolean test(){
//        SensorRequest sr = new SensorRequest("1100201808081001","4",1);
//        Boolean bool = sensorReqService.insertSensorReq(sr);
//        logger.info(bool.toString());
//        return bool;
//    }

}
