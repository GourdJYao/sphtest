package com.yaojian.sphtest;

import android.content.Context;
import android.util.Log;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.yaojian.sphtest.greendao.dao.SphInfoDao;
import com.yaojian.sphtest.greendao.entity.SphInfo;
import com.yaojian.sphtest.greendao.service.SphInfoService;
import com.yaojian.sphtest.greendao.utils.GreenDaoUtil;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class DataBaseTest {
    private static final String TAG = DataBaseTest.class.getName();
    static SphInfoDao sphInfoDao;
    static Context context;
    static SphInfoService sphInfoService;

    @BeforeClass
    public static void startTest() {
        Log.e(TAG, "测试开始");
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        GreenDaoUtil.getInstances().setDatabase(context);
        sphInfoDao = GreenDaoUtil.getInstances().getDaoSession().getSphInfoDao();
        sphInfoService = new SphInfoService();
    }

    @AfterClass
    public static void endTest() {
        Log.e(TAG, "测试结束");
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.yaojian.sphtest", appContext.getPackageName());
    }

    /**
     * 测试插入数据方法
     */
    @Test
    public void testAddSphInfoData() {
        SphInfo sphInfo = new SphInfo();
        sphInfo.set_id(10000);
        sphInfo.setQuarter("2015-Q4");
        sphInfo.setVolume_of_mobile_data(0.4566f);
        sphInfoDao.save(sphInfo);
        SphInfo sphInfoTemp = sphInfoDao.load(sphInfo.getDatabaseid());
        assertTrue(sphInfoTemp != null);
        assertEquals(sphInfo.get_id(), sphInfoTemp.get_id());
        assertEquals(sphInfo.getQuarter(), sphInfoTemp.getQuarter());
        assertEquals(sphInfo.getVolume_of_mobile_data(), sphInfoTemp.getVolume_of_mobile_data());
        sphInfoDao.delete(sphInfo);
    }

    /**
     * 测试更新数据
     */
    @Test
    public void testUpdateSphInfoData() {
        SphInfo sphInfo = new SphInfo();
        sphInfo.set_id(10000);
        sphInfo.setQuarter("2015-Q4");
        Float volumeofmobiledata = 0.4566f;
        sphInfo.setVolume_of_mobile_data(volumeofmobiledata);
        sphInfoDao.save(sphInfo);
        SphInfo sphInfoTemp = sphInfoDao.load(sphInfo.getDatabaseid());
        assertTrue(sphInfoTemp != null);
        assertEquals(sphInfo.get_id(), sphInfoTemp.get_id());
        assertEquals(sphInfo.getQuarter(), sphInfoTemp.getQuarter());
        assertEquals(sphInfo.getVolume_of_mobile_data(), sphInfoTemp.getVolume_of_mobile_data());
        sphInfo.setVolume_of_mobile_data(0.55555f);
        sphInfoDao.update(sphInfo);
        sphInfoTemp = sphInfoDao.load(sphInfo.getDatabaseid());
        assertTrue(sphInfoTemp != null);
        assertFalse(sphInfoTemp.getVolume_of_mobile_data().equals(volumeofmobiledata));
        sphInfoDao.delete(sphInfo);
    }

    /**
     * 测试删除数据
     */
    @Test
    public void testDeleteSphInfoData() {
        SphInfo sphInfo = new SphInfo();
        sphInfo.set_id(10000);
        sphInfo.setQuarter("2015-Q4");
        Float volumeofmobiledata = 0.4566f;
        sphInfo.setVolume_of_mobile_data(volumeofmobiledata);
        sphInfoDao.save(sphInfo);
        SphInfo sphInfoTemp = sphInfoDao.load(sphInfo.getDatabaseid());
        assertTrue(sphInfoTemp != null);
        assertEquals(sphInfo.get_id(), sphInfoTemp.get_id());
        assertEquals(sphInfo.getQuarter(), sphInfoTemp.getQuarter());
        assertEquals(sphInfo.getVolume_of_mobile_data(), sphInfoTemp.getVolume_of_mobile_data());
        sphInfoDao.delete(sphInfo);
        sphInfoTemp = sphInfoDao.load(sphInfo.getDatabaseid());
        assertNull(sphInfoTemp);
    }

    /**
     * 测试删除数据
     */
    @Test
    public void testLoadSphInfoData() {
        SphInfo sphInfo = new SphInfo();
        sphInfo.set_id(10000);
        sphInfo.setQuarter("2015-Q4");
        Float volumeofmobiledata = 0.4566f;
        sphInfo.setVolume_of_mobile_data(volumeofmobiledata);
        sphInfoDao.save(sphInfo);
        SphInfo sphInfoTemp = sphInfoDao.load(sphInfo.getDatabaseid());
        assertTrue(sphInfoTemp != null);
        assertEquals(sphInfo.get_id(), sphInfoTemp.get_id());
        assertEquals(sphInfo.getQuarter(), sphInfoTemp.getQuarter());
        assertEquals(sphInfo.getVolume_of_mobile_data(), sphInfoTemp.getVolume_of_mobile_data());
        sphInfoDao.delete(sphInfo);
    }

    /**
     * 测试删除数据
     */
    @Test
    public void testLoadAllSphInfoData() {
        SphInfo sphInfo = new SphInfo();
        sphInfo.set_id(10000);
        sphInfo.setQuarter("2015-Q4");
        Float volumeofmobiledata = 0.4566f;
        sphInfo.setVolume_of_mobile_data(volumeofmobiledata);
        sphInfoDao.save(sphInfo);
        List<SphInfo> sphInfoTempList = sphInfoDao.loadAll();
        assertTrue((sphInfoTempList != null && sphInfoTempList.size() >= 1));
        sphInfoDao.delete(sphInfo);
    }

    /**
     * 测试service插入数据
     */
    @Test
    public void testServiceAddSphInfoData() {
        SphInfo sphInfo = new SphInfo();
        sphInfo.set_id(10000);
        sphInfo.setQuarter("2015-Q4");
        Float volumeofmobiledata = 0.4566f;
        sphInfo.setVolume_of_mobile_data(volumeofmobiledata);
        sphInfoService.addData(sphInfo);
        SphInfo sphInfoTemp = sphInfoDao.load(sphInfo.getDatabaseid());
        assertTrue(sphInfoTemp != null);
        sphInfoDao.delete(sphInfo);
    }

    /**
     * 测试service重复插入数据
     */
    @Test
    public void testServiceRepeatAddSphInfoData() {
        SphInfo sphInfo = new SphInfo();
        sphInfo.set_id(10000);
        sphInfo.setQuarter("2015-Q4");
        Float volumeofmobiledata = 0.4566f;
        sphInfo.setVolume_of_mobile_data(volumeofmobiledata);
        sphInfoService.addData(sphInfo);
        sphInfoService.addData(sphInfo);
        List<SphInfo> sphInfoList = sphInfoDao.queryBuilder().where(SphInfoDao.Properties._id.eq(sphInfo.get_id())).list();
        assertTrue((sphInfoList != null && sphInfoList.size() == 1));
        sphInfoDao.delete(sphInfo);
    }

    /**
     * 测试service重复插入数据
     */
    @Test
    public void testServiceLoadSphInfoAllData() {
        SphInfo sphInfo = new SphInfo();
        sphInfo.set_id(10000);
        sphInfo.setQuarter("2015-Q4");
        Float volumeofmobiledata = 0.4566f;
        sphInfo.setVolume_of_mobile_data(volumeofmobiledata);
        sphInfoService.addData(sphInfo);
        List<SphInfo> sphInfoList = sphInfoService.findAllData();
        assertTrue((sphInfoList != null && sphInfoList.size() >=1));
        sphInfoDao.delete(sphInfo);
    }
}
