package com.kwin.db.mapper;

import com.kwin.db.entity.Image;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface ImageMapper {

    public boolean insertBlob(Integer cam,byte[] blob);

    public Image getBlobById(Integer id);

}
