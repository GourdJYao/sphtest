package com.yaojian.sphtest.greendao.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;
import org.greenrobot.greendao.annotation.Property;

@Entity
public class SphInfo {
    public static final String SERVER_ID = "server_id";
    public static final String VOLUME_OF_MOBILE_DATA = "volume_of_mobile_data";
    public static final String QUARTER = "quarter";
    //本地缓存自增长ID
    @Id(autoincrement = true)
    private Long databaseid;
    //服务端ID
    @Property(nameInDb = SERVER_ID)
    private Integer _id;
    //服务端数据
    @Property(nameInDb = VOLUME_OF_MOBILE_DATA)
    private Float volume_of_mobile_data;
    //服务端日期
    @Property(nameInDb = QUARTER)
    private String quarter;

    @Generated(hash = 1064711214)
    public SphInfo(Long databaseid, Integer _id, Float volume_of_mobile_data,
            String quarter) {
        this.databaseid = databaseid;
        this._id = _id;
        this.volume_of_mobile_data = volume_of_mobile_data;
        this.quarter = quarter;
    }

    @Generated(hash = 1877691150)
    public SphInfo() {
    }

    public Long getId() {
        return databaseid;
    }

    public void setId(Long id) {
        this.databaseid = id;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public Float getVolume_of_mobile_data() {
        return volume_of_mobile_data;
    }

    public void setVolume_of_mobile_data(Float volume_of_mobile_data) {
        this.volume_of_mobile_data = volume_of_mobile_data;
    }

    public String getQuarter() {
        return quarter;
    }

    public void setQuarter(String quarter) {
        this.quarter = quarter;
    }

    public Long getDatabaseid() {
        return this.databaseid;
    }

    public void setDatabaseid(Long databaseid) {
        this.databaseid = databaseid;
    }
}
