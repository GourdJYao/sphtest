package com.yaojian.sphtest;

import android.app.Application;

import com.yaojian.sphtest.greendao.utils.GreenDaoUtil;

public class SphApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        GreenDaoUtil.getInstances().setDatabase(this);
    }
}
