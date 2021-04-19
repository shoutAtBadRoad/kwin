package com.kwin.db.service;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public interface MonitorService {

    public Map<String,Object> getSwitch(String id);

}
