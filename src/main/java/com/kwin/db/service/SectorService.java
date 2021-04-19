package com.kwin.db.service;

import com.kwin.db.entity.House;
import com.kwin.db.entity.Index;
import com.kwin.db.entity.Sector;

import java.util.List;

public interface SectorService {
    //区块操作
    public boolean insertSector(Sector sector);

    public boolean updateSectorById(Sector sector);

    public boolean deleteSectorById(Integer id);

    public Sector getSectorById(Integer id);

    public List<Sector> getAllSector();

    public Integer getSectorNum();

    //大棚操作
    //插入大棚信息
    public boolean insertHouse(House house);
    //根据id更新大棚信息
    public boolean updateHouseById(House house);
    //根据id删除大棚
    public boolean deleteHouseById(Integer id);
    //根据id查询大棚
    public House getHouseById(Integer id);
    //根据2id查询大棚
    public House getHouseBy2Id(Integer sector_id,Integer house_id);
    //根据区块查询大棚
    public List<House> getAllHouseBySector(Integer sector_id);
    //查询所有大棚
    public List<House> getAllHouse();
    //查询大棚总数
    public Integer getHouseNum();
    //区块的大棚总数
    public Integer getHouseNumBySector(Integer sector_id);

    //查询区块数与其所属大棚编号
    public List<Index> getIndex();

}
