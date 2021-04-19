package com.kwin.db.test.manage.service.Imp;

import com.kwin.db.test.manage.entity.News;
import com.kwin.db.test.manage.mapper.NewsMapper;
import com.kwin.db.test.manage.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class NewsServiceImpl implements NewsService {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    NewsMapper newsMapper;

    @Override
    public boolean putNews(String title){
        return newsMapper.insertNews(title,new Date());
    }

    @Override
    public List<News> getAllNews() {
        return newsMapper.getAllNews();
    }

}
