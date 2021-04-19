package com.kwin.db.controller;

import com.kwin.db.entity.Camera;
import com.kwin.db.entity.House;
import com.kwin.db.entity.SensorRequest;
import com.kwin.db.service.CamService;
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
 * @author 邵鹏泽
 * @create 2020-11-22:40
 */
@Controller
@RequestMapping("/camera")
public class CamReqController {
    Logger logger = LoggerFactory.getLogger(getClass());//用于输出日志
    private Boolean bool;
    @Autowired
    CamService camService;
    @Autowired
    SectorService sectorService;

     /*
     * 判断有没有大棚的id，如果有就返回此大棚下的摄像头列表，否则返回所有摄像头列表
     * */
    @GetMapping("/show")
    public String getShow(Model model, HttpServletRequest request){
        String id = request.getParameter("id");
        List<Camera> list = new ArrayList<>();
        if(id==null){
            list=camService.getAllCam();
        }else{
            House house=sectorService.getHouseById(Integer.valueOf(id));
            list = camService.getAllCamBy2Id(house.getSector_id(), house.getHouse_id());
            model.addAttribute("sector_id",house.getSector_id());
            model.addAttribute("house_id", house.getHouse_id());
            model.addAttribute("cam",list);
        }
        model.addAttribute("cs",list);
        return "/camera/list";
    }

    //返回第id号大棚下的摄像头信息，每个大棚默认只有一个摄像头，此处返回的是Camera，不是List
    @GetMapping("/show/{id}")
    public String getShowById(Model model,@PathVariable("id")Integer id){
        House house=sectorService.getHouseById(id);
        List<Camera> cameras=camService.getAllCamBy2Id(house.getSector_id(),house.getHouse_id());
        model.addAttribute("cs",cameras);
        model.addAttribute("sector_id",house.getSector_id());
        model.addAttribute("house_id", house.getHouse_id());
        return "/camera/list";
    }


    //跳转到添加页面、
    @GetMapping("/camera")
    public String addCam(@RequestParam("sector_id")Integer s_id,@RequestParam("house_id")Integer h_id,Model model){
        model.addAttribute("sector_id",s_id);
        model.addAttribute("house_id",h_id);
        return "/camera/add";
    }

    //添加摄像头，跳转显示其大棚下的所有的摄像头
    @PostMapping("/insert")
    public String insertCam(Camera camera, RedirectAttributes attr){
        bool=camService.insertCam(camera.getSector_id(),camera.getHouse_id(),camera.getMac(),camera.getUrl());
        House house = sectorService.getHouseBy2Id(camera.getSector_id(),camera.getHouse_id());
        house.setCam_number(house.getCam_number()+1);
        sectorService.updateHouseById(house);
        attr.addAttribute("id",house.getId());
        return "redirect:/camera/show";
    }

    //删除id号摄像头，跳转显示所有摄像头列表
    @PostMapping("/delete/{id}")
    public String deleteCam(@PathVariable("id")Integer id,RedirectAttributes attr){
        bool =camService.deleteCamById(id);
        return "redirect:/camera/show";
    }

    //编辑id号摄像头
    @GetMapping("/edit/{id}")
    public String editCam(@PathVariable("id")Integer id,Model model){
        Camera camera=camService.getCam(id);
        model.addAttribute("camera",camera);
        return "/camera/update";
    }

    //更新id号摄像头的信息
    @PostMapping("/update")
    public String updateCam(Camera camera){
        bool=camService.updateCamById(camera.getId(),camera.getSector_id(),camera.getHouse_id(),camera.getMac(),camera.getUrl());
        if(bool){
            logger.info(camera.getId()+"号摄像头请求修改成功");
        }
        return "redirect:/camera/show";
    }












}
