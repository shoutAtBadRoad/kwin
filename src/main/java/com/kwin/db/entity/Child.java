package com.kwin.db.entity;

import lombok.Data;

/**
 * @author JYP
 * @date 2020/11/4
 **/

@Data
public class Child {

    private Integer id;
    private String query;
    private String label;

    public Child(Integer id, String query, String label) {
        this.id = id;
        this.query = query;
        this.label = label;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
