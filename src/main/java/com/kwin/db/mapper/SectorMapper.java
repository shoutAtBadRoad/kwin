package com.kwin.db.mapper;

import com.kwin.db.entity.House;
import com.kwin.db.entity.Sector;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface SectorMapper {

    //区块方法
    //插入区块信息
    public boolean insertSector(String manager,Integer house_number,String info);
    //更新一个区块的信息
    public boolean updateSectorById(Integer id,String manager,Integer house_number,String info);
    //删除一个区块
    public boolean deleteSectorById(Integer id);
    //根据id查询区块信息
    public Sector getSectorById(Integer id);
    //查询所有区块信息
    public List<Sector> getAllSector();
    //查询区块总数
    public Integer getSectorNum();


    //大棚方法
    //插入大棚信息
    public boolean insertHouse(String employee,Integer sector_id,Integer house_id,Integer sensor_number,Integer cam_number,String info);
    //根据id更新大棚信息
    public boolean updateHouseById(Integer id,String employee,Integer sector_id,Integer house_id,Integer sensor_number,Integer cam_number,String info);
    //根据id删除大棚
    public boolean deleteHouseById(Integer id);
    //根据id查询大棚
    public House getHouseById(Integer id);
    //根据id查询大棚
    public House getHouseBy2Id(Integer sector_id,Integer house_id);
    //根据区块查询大棚
    public List<House> getAllHouseBySector(Integer sector_id);
    //查询所有大棚
    public List<House> getAllHouse();
    //查询大棚总数
    public Integer getHouseNum();
    //区块的大棚总数
    public Integer getHouseNumBySector(Integer sector_id);


}
