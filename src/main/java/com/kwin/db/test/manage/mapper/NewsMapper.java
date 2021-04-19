package com.kwin.db.test.manage.mapper;

import com.kwin.db.test.manage.entity.News;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Mapper
public interface NewsMapper {

//    @Insert("insert into k_news(title,w_date)values(#{title},#{date})")
    boolean insertNews(String title,Date date);

//    @Select("select * from k_news")
    List<News> getAllNews();

//    @Delete("delete from k_news where id=#{id}")
    boolean deleteNewsById(Integer id);

}
