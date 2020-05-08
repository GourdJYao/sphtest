package com.yaojian.sphtest.greendao.entity;

import java.util.ArrayList;
import java.util.List;

public class MonthData {
    private String monthString;
    private boolean isWave;
    private Float totalData;
    private List<SphInfo> sphInfoList = new ArrayList<SphInfo>();

    public Float getTotalData() {
        return totalData;
    }

    public void setTotalData(Float totalData) {
        this.totalData = totalData;
    }

    public String getMonthString() {
        return monthString;
    }

    public void setMonthString(String monthString) {
        this.monthString = monthString;
    }

    public boolean isWave() {
        return isWave;
    }

    public void setWave(boolean wave) {
        isWave = wave;
    }

    public List<SphInfo> getSphInfoList() {
        return sphInfoList;
    }

    public void setSphInfoList(List<SphInfo> sphInfoList) {
        this.sphInfoList = sphInfoList;
    }

    public void addSphInfo(SphInfo sphInfo){
        this.sphInfoList.add(sphInfo);
    }
}
