package com.kwin.db.service.Imp;

import com.kwin.db.service.SensorReqService;
import com.kwin.db.entity.Camera;
import com.kwin.db.service.CamService;
import com.kwin.db.service.MonitorService;
import com.kwin.db.utils.Shift;
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
 * @date 2020/11/5
 **/

@Service
public class MonitorServiceImpl implements MonitorService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    CamService camService;
    @Autowired
    SensorReqService sensorReqService;

    /**
     *
     * @param id 是‘1-1’、‘2-1’这种字符串
     * @return java.util.Map<java.lang.String,java.lang.Object>
     * @author jyp
     * @creed: Talk is cheap,show me the code
     * @date 2020/11/8 13:14
     * 第一个数字代表区块号、第二个数字代表大棚号
     * 接收大棚切换时的请求
     * 解析‘i-j’字符串
     * 返回区块i和大棚j的主传感器id和摄像头信息
     */
    @Override
    public Map<String, Object> getSwitch(String id) {
        Map<String,Object> map = new HashMap<>();
        List<Integer> list = Shift.shift(id);
        System.out.println(list.get(0) + list.get(1));
        Camera cam = camService.getCamBy2Id(list.get(0),list.get(1));
        Integer i = sensorReqService.getOneSensorReq(list.get(0),list.get(1)).getId();
        logger.info(cam.toString());
        logger.info(i.toString());
        map.put("sensor_id",i);
        map.put("cam",cam);
        return map;
    }

//    public static List<Integer> shift(String id){
//        List<Integer> list = new ArrayList<>();
//        int flag = 0;
//        StringBuilder a = new StringBuilder();
//        StringBuilder b = new StringBuilder();
//        for(int i=0;i<=id.length()-1;i++){
//            CharSequence ch = id.subSequence(i,i+1);
//            if(ch.equals("-")){
//                flag=1;
//            }
//            if(flag==0){
//                a.append(ch);
//            }
//            else if(!ch.equals("-")){
//                b.append(ch);
//            }
//        }
//        list.add(Integer.valueOf(String.valueOf(a)));
//        list.add(Integer.valueOf(String.valueOf(b)));
//        return list;
//    }
}
