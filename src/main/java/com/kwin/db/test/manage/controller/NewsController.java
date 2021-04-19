package com.kwin.db.test.manage.controller;

import com.kwin.db.test.manage.entity.News;
import com.kwin.db.test.manage.mapper.NewsMapper;
import com.kwin.db.test.manage.service.Imp.NewsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/news")
public class NewsController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    NewsServiceImpl newsService;

    @Autowired
    NewsMapper newsMapper;

    @GetMapping("/put")
    public void putNews(){
        boolean bool = newsService.putNews("学哥ssl！");
        System.out.println(bool);;
    }

    @ResponseBody
    @GetMapping("/get")
    public List<News> getAll(){
        return newsService.getAllNews();
    }

    @ResponseBody
    @GetMapping("/delete/{id}")
    public boolean deleteNewsById(@PathVariable("id")Integer id){
        return newsMapper.deleteNewsById(id);
    }



}
