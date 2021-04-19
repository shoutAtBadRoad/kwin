package com.kwin.db.controller;

import com.kwin.db.entity.Index;
import com.kwin.db.entity.Sector;
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
@RequestMapping("/sector")
public class SectorController {

    Logger logger = LoggerFactory.getLogger(getClass());
    private Boolean bool;
    
    @Autowired
    SectorService sectorService;

    /**
     * 
     * @param s
     * @return boolean
     * @author jyp
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/2 16:52
     * 区块添加操作，然后返回信息展示页面
     */
    @PostMapping("/insert")
    public String insertSector(Sector s){
        logger.info("start insert pro");
        bool = sectorService.insertSector(s);
        if(bool){
            logger.info("finish insert pro");
        }
        return "redirect:/sector/show";
    }
    
    @PostMapping("/delete/{id}")
    public String deleteSector(@PathVariable("id") Integer id){
        bool = sectorService.deleteSectorById(id);
        if(bool){
            logger.info(id+"号区块删除成功");
        }
        return "redirect:/sector/show";
    }

    @PostMapping("/update")
    public String updateSector(Sector s){
        System.out.println(s.toString());
        bool = sectorService.updateSectorById(s);
        if(bool){
            logger.info(s.getId()+"号区块修改成功");
        }
        return "redirect:/sector/show";
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Sector getSector(@PathVariable("id")Integer id){
        return sectorService.getSectorById(id);
    }

    @GetMapping("/getAll")
    @ResponseBody
    private List<Sector> getAllSector(){
        return sectorService.getAllSector();
    }

    /*
    跳转到添加页面
     */
    @GetMapping("/sector")
    public String enterAdd(){
        return "sector/add";
    }
    /*
    跳转修改页面
     */
    @GetMapping("/edit/{id}")
    public String editSector(@PathVariable("id") Integer id,Model model){
        Sector s = sectorService.getSectorById(id);
        model.addAttribute("s",s);
        return "sector/update";
    }

    /*
    区块信息展示页面
     */
    @GetMapping("/show")
    public String showSector(Model model){
        List<Sector> sector = sectorService.getAllSector();
        model.addAttribute("sector",sector);
        return "sector/list";
    }

    /**
     *
     * @param
     * @return java.util.List<com.kwin.db.entity.Index>
     * @author jyp
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/4 11:24
     * 返回所有区块大棚索引信息
     */
    @GetMapping("/getindex")
    @ResponseBody
    public List<Index> getIndex(){
        return sectorService.getIndex();
    }

}
