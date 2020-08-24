package com.fh.model;

import com.fh.util.Page;

public class PropertyQuery extends Page {
    private String name;

    private Integer typeId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

}
