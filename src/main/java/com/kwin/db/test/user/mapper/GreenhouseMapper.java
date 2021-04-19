package com.kwin.db.test.user.mapper;

import com.kwin.db.test.user.entity.Greenhouse;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

//指定操作数据库的mapper
@Mapper
@Component
public interface GreenhouseMapper {

//    @Select("select * from WarnGreenhouse where id=#{id}")
    public Greenhouse getGreById(Integer id);

    public Greenhouse insertGre(Greenhouse greenhouse);

    public List<Greenhouse> getAllGre();

    public boolean deleteGreById(Integer id);

}
