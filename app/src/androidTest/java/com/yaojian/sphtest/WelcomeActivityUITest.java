package com.yaojian.sphtest;

import android.content.Context;
import android.util.Log;
import android.widget.TextView;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.robotium.solo.Solo;
import com.yaojian.sphtest.activity.MainActivity;
import com.yaojian.sphtest.activity.WelcomeActivity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class WelcomeActivityUITest {
    private static final String TAG = WelcomeActivityUITest.class.getName();
    private static Context context;
    private Solo solo;
    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(WelcomeActivity.class);

    @Before
    public void setUp() throws Exception {
        solo = new Solo(InstrumentationRegistry.getInstrumentation(),
                activityTestRule.getActivity());
    }

    @After
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

    @BeforeClass
    public static void startTest() {
        Log.e(TAG, "WelcomeActivityUITest 测试开始");
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
    }

    @AfterClass
    public static void endTest() {
        Log.e(TAG, "WelcomeActivityUITest 测试结束");
    }

    @Test
    public void testWelcomeGotoMain() throws Exception {
       solo.sleep(5000);
       Assert.assertTrue(solo.getCurrentActivity() instanceof MainActivity);
    }

}
