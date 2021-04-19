package com.kwin.db.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author JYP
 * @date 2020/11/4
 **/

@Data
public class Index {

    private Integer id;

    private String label;

    private List<Map<String,Object>> children;

    public Index(Integer id, String label,List<Map<String,Object>> children) {
        this.id = id;
        this.label = label;
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Map<String,Object>> getSub_query() {
        return children;
    }

    public void setChildren(List<Map<String, Object>> children) {
        this.children = children;
    }
}
