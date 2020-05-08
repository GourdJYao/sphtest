package com.yaojian.sphtest;

import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.yaojian.sphtest.utils.StringUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testStringUtils() {
        assertEquals(StringUtils.UTF_8_STRING,"UTF-8");
    }
}