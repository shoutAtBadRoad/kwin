package com.kwin.db.controller;

import com.kwin.db.entity.SensorData;
import com.kwin.db.service.HistService;
import com.kwin.db.service.SensorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author JYP
 * @date 2020/10/28
 **/

@Controller
@RequestMapping("/hist")
public class HistorydtController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    SensorService sensorService;
    @Autowired
    HistService histService;

    @ResponseBody
    @GetMapping("/getall")
    public List<SensorData> getAll(){
        return sensorService.getAllShowData();
    }

//    @ResponseBody
//    @GetMapping("/getallbytime")
//    public List<SensorData> getAllByTime(@RequestParam("begin")String begin,@RequestParam("end")String end) throws ParseException {
//        logger.info("历史数据接口"+":获取"+begin+"到"+end+"之间的数据");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date d1 = sdf.parse(begin);
////        String d2 = sdf.format(end);
//        logger.info(d1.toString());
////        logger.info(d2);
//        return histService.getShowDataByTime(begin,end);
//    }

    @ResponseBody
    @GetMapping("/getallbytime")
    public List<SensorData> getAllByTimeAndHouse(@RequestParam("begin")String begin, @RequestParam("end")String end, HttpServletRequest request) throws ParseException {
        String id = request.getParameter("id");
        if(id.length()>=3) {
            logger.info("历史数据接口" + ":获取" + begin + "到" + end + "之间的数据");
            logger.info("大棚号:" + id);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d1 = sdf.parse(begin);
//        String d2 = sdf.format(end);
            logger.info(d1.toString());
//        logger.info(d2);
            return histService.getShowDataByTimeAndHouse(begin, end, id);
        }else {
            logger.info("历史数据接口"+":获取"+begin+"到"+end+"之间的数据");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date d1 = sdf.parse(begin);
//        String d2 = sdf.format(end);
            logger.info(d1.toString());
//        logger.info(d2);
            return histService.getShowDataByTime(begin,end);
        }
    }
}
