package com.yaojian.sphtest.greendao.service;

import com.yaojian.sphtest.greendao.dao.SphInfoDao;
import com.yaojian.sphtest.greendao.entity.SphInfo;
import com.yaojian.sphtest.greendao.utils.GreenDaoUtil;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class SphInfoService {
    private SphInfoDao sphInfoDao;

    public SphInfoService() {
        sphInfoDao = GreenDaoUtil.getInstances().getDaoSession().getSphInfoDao();
    }

    public void addData(SphInfo sphInfo) {
        QueryBuilder sphInfoBuilder = sphInfoDao.queryBuilder();
        sphInfoBuilder.where(SphInfoDao.Properties._id.eq(sphInfo.get_id())).build();
        List<SphInfo> sphInfoList = sphInfoBuilder.list();
        if (sphInfoList == null || sphInfoList.size() == 0) {
            sphInfoDao.save(sphInfo);
        } else {
            sphInfo.setDatabaseid(sphInfoList.get(0).getDatabaseid());
            sphInfoDao.update(sphInfo);
        }
    }

    public List<SphInfo> findAllData() {
        return sphInfoDao.queryBuilder().orderAsc(SphInfoDao.Properties.Quarter).list();
    }
}
