package com.yaojian.sphtest.network.response;

import com.yaojian.sphtest.greendao.entity.SphInfo;

import java.util.List;

public class ResultInfo {
    private String resource_id;
    private List<FieldInfo> fields;
    private List<SphInfo> records;

    public String getResource_id() {
        return resource_id;
    }

    public void setResource_id(String resource_id) {
        this.resource_id = resource_id;
    }

    public List<FieldInfo> getFields() {
        return fields;
    }

    public void setFields(List<FieldInfo> fields) {
        this.fields = fields;
    }

    public List<SphInfo> getRecords() {
        return records;
    }

    public void setRecords(List<SphInfo> records) {
        this.records = records;
    }
}
