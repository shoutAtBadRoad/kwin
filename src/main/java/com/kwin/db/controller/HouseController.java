package com.kwin.db.controller;

import com.kwin.db.entity.House;
import com.kwin.db.service.SectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author JYP
 * @date 2020/11/2
 **/
@Controller
@RequestMapping("/house")
public class HouseController {

    Logger logger = LoggerFactory.getLogger(getClass());
    private Boolean bool;

    @Autowired
    SectorService sectorService;
    @GetMapping("/show")
    public String getShow(Model model){
        List<House> list = sectorService.getAllHouse();
        model.addAttribute("house",list);
        model.addAttribute("sector_id",1);
        return "/house/list";
    }

    @GetMapping("/show/{id}")
    public String getShowBySector(Model model,@PathVariable("id")Integer id){
        List<House> list = sectorService.getAllHouseBySector(id);
        model.addAttribute("house",list);
        model.addAttribute("sector_id",id);
        return "/house/list";
    }

    @GetMapping("/edit/{id}")
    public String editHouse(@PathVariable("id") Integer id,Model model){
        House house = sectorService.getHouseById(id);
        model.addAttribute("h",house);
        return "house/update";
    }

    @GetMapping("/house")
    public String addHouse(Model model){
        House house = new House();
        model.addAttribute("h",house);
        return "/house/add";
    }

    @PostMapping("/insert")
    public String insertHouse(House house){
        logger.info("start insert pro");
        bool = sectorService.insertHouse(house);
        if(bool){
            logger.info("finish insert pro");
        }
        return "redirect:/house/show";
    }

    @PostMapping("/delete/{id}")
    public String deleteHouse(@PathVariable("id") Integer id){
        bool = sectorService.deleteHouseById(id);
        return "redirect:/house/show";
    }

    @PostMapping("/update")
    public String updateSector(House house){
        bool = sectorService.updateHouseById(house);
        if(bool){
            logger.info(house.getId()+"号大棚修改成功");
        }
        return "redirect:/house/show";
    }

    @GetMapping("/get/{id}")
    public House getHouse(@PathVariable("id")Integer id){
        return sectorService.getHouseById(id);
    }

    @GetMapping("/getbysector/{id}")
    public List<House> getAllHouseBySector(@PathVariable("id") Integer sector_id){
        return sectorService.getAllHouseBySector(sector_id);
    }

    @GetMapping("/getAll")
    private List<House> getAllHouse(){
        return sectorService.getAllHouse();
    }



}
