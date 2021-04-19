package com.kwin.db.test.user.controller;

import com.kwin.db.test.user.entity.Greenhouse;
import com.kwin.db.test.user.mapper.GreenhouseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController//相当于集合controller与responsebody于一身
//@RequestMapping("/db-0.0.1")
public class GreController {

    @Autowired
    GreenhouseMapper greenhouseMapper;

    @GetMapping("/getAllGre")
    public List<Greenhouse> findAll(){
        System.out.println("findAll");
//        List<Greenhouse> list = greenhouseMapper.getAllGre();
//        Map<Integer,Greenhouse> map = new HashMap<>();
//        Integer i = 1;
//        for(Greenhouse list1 : list){
//            map.put(i,list1);
//            i++;
//        }
//        return map;//和直接return list效果一样
        List<Greenhouse> list = greenhouseMapper.getAllGre();
//        System.out.println(list);
        return list;
    }

    @GetMapping("/Gre/{id}")
    public Greenhouse getGre(@PathVariable("id") Integer id){
        return greenhouseMapper.getGreById(id);
    }

    @GetMapping("/Gre")
    public Greenhouse insertGre(Greenhouse greenhouse){
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Greenhouse g = new Greenhouse(5,df.format(day),"I'm coming!");
        greenhouseMapper.insertGre(g);
        return g;
    }

}
