package com.kwin.db.service.Imp;

import com.kwin.db.entity.SensorData;
import com.kwin.db.mapper.HistMapper;
import com.kwin.db.service.HistService;
import com.kwin.db.utils.Shift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author JYP
 * @date 2020/11/2
 **/

@Service
public class HistServiceImpl implements HistService {

    @Autowired
    HistMapper histMapper;

    /**
     *
     * @param b 起始时间
	 * @param e 结束时间
     * @return java.util.List<com.kwin.db.entity.SensorData>
     * @author yuxin
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/2 9:49
     */
    @Override
    public List<SensorData> getShowDataByTime(String b, String e) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date begin = sdf.parse(b);
        Date end = sdf.parse(e);
        return histMapper.getShowDataByTime(begin, end);
    }

    /**
     * 
     * @param b 起始时间
	 * @param e
	 * @param id 区块号+大棚号
     * @return java.util.List<com.kwin.db.entity.SensorData>
     * @author jyp
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/17 16:46
     */
    @Override
    public List<SensorData> getShowDataByTimeAndHouse(String b, String e, String id) throws ParseException {
        List<Integer> list1 = Shift.shift(id);
        Integer s_id = list1.get(0);
        Integer h_id = list1.get(1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date begin = sdf.parse(b);
        Date end = sdf.parse(e);
        List<SensorData> list = histMapper.getShowDataByTimeAndHouse(begin,end,s_id,h_id);
        if(list.size()!=0){
            return list;
        }
        return null;
    }
}
