package com.yaojian.sphtest;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.yaojian.sphtest.greendao.entity.SphInfo;
import com.yaojian.sphtest.network.response.SphInfoResponse;
import com.yaojian.sphtest.utils.JSONUtils;
import com.yaojian.sphtest.utils.StringUtils;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class UtilsTest {
    @Test
    public void testStringUtils() {
        assertEquals(StringUtils.UTF_8_STRING,"UTF-8");
    }

    @Test
    public void testJSONUtilsNull() {
        String result = "{\"help\": \"https://data.gov.sg/api/3/action/help_show?name=datastore_search\", \"success\": false}";
        List<SphInfo> sphInfoResponse = JSONUtils.parseSphInfoList(result);
        Assert.assertNull(sphInfoResponse);
    }

    @Test
    public void testJSONUtilsException() {
        String result = "";
        List<SphInfo> sphInfoResponse = JSONUtils.parseSphInfoList(result);
        Assert.assertNull(sphInfoResponse);
    }
}
