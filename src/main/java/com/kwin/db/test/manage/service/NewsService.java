package com.kwin.db.test.manage.service;

import com.kwin.db.test.manage.entity.News;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NewsService {

    boolean putNews(String title);

    List<News> getAllNews();

}
