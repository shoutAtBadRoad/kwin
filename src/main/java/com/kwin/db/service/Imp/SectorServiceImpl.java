package com.kwin.db.service.Imp;

import com.kwin.db.entity.House;
import com.kwin.db.entity.Index;
import com.kwin.db.entity.Sector;
import com.kwin.db.mapper.SectorMapper;
import com.kwin.db.service.SectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author JYP
 * @date 2020/11/1
 **/

@Service
public class SectorServiceImpl implements SectorService {

    private Boolean bool;
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SectorMapper sm;

    /**
     * 
     * @param sector 
     * @return boolean
     * @author yuxin
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/1 18:54
     */
    @Override
    public boolean insertSector(Sector sector) {
        bool = sm.insertSector(sector.getManager(),sector.getHouse_number(),sector.getInfo());
        logger.info(bool.toString());
        return bool;
    }

    @Override
    public boolean updateSectorById(Sector sector) {
        bool = sm.updateSectorById(sector.getId(),sector.getManager(),sector.getHouse_number(),sector.getInfo());
        logger.info(bool.toString());
        return bool;
    }

    @Override
    public boolean deleteSectorById(Integer id) {
        bool = sm.deleteSectorById(id);
        logger.info(bool.toString());
        return bool;
    }

    @Override
    public Sector getSectorById(Integer id) {
        Sector sector = sm.getSectorById(id);
        logger.info(sector.toString());
        return sector;
    }

    /**
     * 
     * @param  
     * @return java.util.List<com.kwin.db.entity.Sector>
     * @author yuxin
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/1 18:49
     */
    @Override
    public List<Sector> getAllSector() {
        List<Sector> list = sm.getAllSector();
        logger.info("list.size = " + list.size());
        return list;
    }

    @Override
    public Integer getSectorNum() {
        Integer num = sm.getSectorNum();
        logger.info(num.toString());
        return num;
    }

    /**
     *
     * @param h
     * @return boolean
     * @author yuxin
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/1 19:03
     */
    @Override
    public boolean insertHouse(House h) {
        Sector sector = sm.getSectorById(h.getSector_id());
        h.setHouse_id(sector.getHouse_number()+1);
        System.out.println(h.getHouse_id());
        bool =  sm.insertHouse(h.getEmployee(),h.getSector_id(),h.getHouse_id(),h.getSensor_number(),h.getCam_number(),h.getInfo());
        logger.info(bool.toString());
        sector.setHouse_number(h.getHouse_id());
        bool = updateSectorById(sector);
        return bool;
    }

    @Override
    public boolean updateHouseById(House h) {
        bool = sm.updateHouseById(h.getId(),h.getEmployee(),h.getSector_id(),h.getHouse_id(),h.getSensor_number(),h.getCam_number(),h.getInfo());
        logger.info(bool.toString());
        return bool;
    }

    /**
     *
     * @param id
     * @return boolean
     * @author yuxin
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/1 19:05
     */
    @Override
    public boolean deleteHouseById(Integer id) {
        House h = sm.getHouseById(id);
        Sector sector = sm.getSectorById(h.getSector_id());
        bool = sm.deleteHouseById(id);
        logger.info(bool.toString());
        sector.setHouse_number(sector.getHouse_number()-1);
        bool = updateSectorById(sector);
        return bool;
    }

    @Override
    public House getHouseById(Integer id) {
        return sm.getHouseById(id);
    }

    @Override
    public House getHouseBy2Id(Integer sector_id,Integer house_id) {
        House house = sm.getHouseBy2Id(sector_id,house_id);
        logger.info(house.toString());
        return house;
    }

    /**
     *
     * @param sector_id
     * @return java.util.List<com.kwin.db.entity.House>
     * @author yuxin
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/1 19:07
     */
    @Override
    public List<House> getAllHouseBySector(Integer sector_id) {
        List<House> list = sm.getAllHouseBySector(sector_id);
        logger.info(list.toString());
        return list;
    }

    @Override
    public List<House> getAllHouse() {
        List<House> list = sm.getAllHouse();
        logger.info(list.toString());
        return list;
    }

    @Override
    public Integer getHouseNum() {
        Integer num = sm.getHouseNum();
        logger.info(num.toString());
        return num;
    }

    @Override
    public Integer getHouseNumBySector(Integer sector_id) {
        Integer num = sm.getHouseNumBySector(sector_id);
        logger.info(num.toString());
        return num;
    }

    /**
     * 
     * @param  
     * @return java.util.List<com.kwin.db.entity.Index>
     * @author jyp
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/4 11:08
     */
    @Override
    public List<Index> getIndex() {
        List<Index> list = new ArrayList<>();
        List<House> h_list = sm.getAllHouse();
        List<Map<String,Object>> query = new ArrayList<>();
        Map<String,Object> map = new HashMap<>();
        Integer sector = 0;
        for (House h: h_list) {
            if(!h.getSector_id().equals(sector)){
                if(sector!=0){
                    List<Map<String,Object>> q = new ArrayList<>(query);
                    list.add(new Index(sector,"区块"+sector.toString(),q));
                    query.clear();
                    map.clear();
                }
                sector = h.getSector_id();
            }
            Integer house = h.getHouse_id();
            map.put("id",house);
            String s = sector.toString()+"-"+house.toString();
            map.put("value",s);
            map.put("label",house.toString()+"号大棚");
            Map<String,Object> map1 = new HashMap<>(map);
            query.add(map1);
        }
        if(query.size()!=0){
            list.add(new Index(sector,"区块"+sector.toString(),query));
        }
        return list;
    }
}
