package com.kwin.db.config.schedule;


import com.kwin.db.entity.SensorRequest;
import com.kwin.db.service.Imp.CurrentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ScheduledTask {
    @Autowired
    private CurrentServiceImpl currentServiceImpl;
//    @Scheduled(cron = "0 0/15 * * * ?")
    public void task(){
        System.out.println("run");
        for (SensorRequest i : SensorRequestCache.list) {
            currentServiceImpl.insertDt(i.getLogo(),i.getSensor_name(),i.getChannel_name(),i.getId());
        }
    }
}
