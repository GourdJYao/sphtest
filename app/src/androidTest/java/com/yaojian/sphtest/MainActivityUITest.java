package com.yaojian.sphtest;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import com.robotium.solo.Solo;
import com.yaojian.sphtest.activity.MainActivity;
import com.yaojian.sphtest.view.SphInfoRecyclerAdapter;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityUITest {
    private static final String TAG = MainActivityUITest.class.getName();
    private static Context context;
    private Solo solo;
    @Rule
    public ActivityTestRule activityTestRule = new ActivityTestRule(MainActivity.class);

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
        Log.e(TAG, "MainActivityUITest 测试开始");
        context = InstrumentationRegistry.getInstrumentation().getTargetContext();
    }

    @AfterClass
    public static void endTest() {
        Log.e(TAG, "MainActivityUITest 测试结束");
    }

    @Test
    public void testData() throws Exception {
        solo.sleep(10000);
        RecyclerView recyclerView = (RecyclerView) solo.getView(R.id.sphinfo_ryv);
        Assert.assertNotNull(recyclerView);
        SphInfoRecyclerAdapter sphInfoRecyclerAdapter = (SphInfoRecyclerAdapter) recyclerView.getAdapter();
        int childcount = sphInfoRecyclerAdapter.getItemCount();
        Log.e(TAG, "childcount:" + childcount);
        Assert.assertTrue(childcount == 11);
    }

    @Test
    public void testImageVisible() throws Exception {
        solo.sleep(10000);
        RecyclerView recyclerView = (RecyclerView) solo.getView(R.id.sphinfo_ryv);
        Assert.assertNotNull(recyclerView);
        SphInfoRecyclerAdapter sphInfoRecyclerAdapter = (SphInfoRecyclerAdapter) recyclerView.getAdapter();
        Assert.assertTrue(sphInfoRecyclerAdapter.getItemCount() > 0);
        ImageView clickImage = recyclerView.getChildAt(3).findViewById(R.id.click_img);
        Assert.assertTrue(clickImage.getVisibility() == View.VISIBLE);
    }
    @Test
    public void testImageInVisible() throws Exception {
        solo.sleep(10000);
        RecyclerView recyclerView = (RecyclerView) solo.getView(R.id.sphinfo_ryv);
        Assert.assertNotNull(recyclerView);
        SphInfoRecyclerAdapter sphInfoRecyclerAdapter = (SphInfoRecyclerAdapter) recyclerView.getAdapter();
        Assert.assertTrue(sphInfoRecyclerAdapter.getItemCount() > 0);
        ImageView clickImage = recyclerView.getChildAt(2).findViewById(R.id.click_img);
        Assert.assertTrue(clickImage.getVisibility() == View.INVISIBLE);
    }

    @Test
    public void testImageClick() throws Exception {
        solo.sleep(10000);
        RecyclerView recyclerView = (RecyclerView) solo.getView(R.id.sphinfo_ryv);
        Assert.assertNotNull(recyclerView);
        SphInfoRecyclerAdapter sphInfoRecyclerAdapter = (SphInfoRecyclerAdapter) recyclerView.getAdapter();
        Assert.assertTrue(sphInfoRecyclerAdapter.getItemCount() > 0);
        ImageView clickImage = recyclerView.getChildAt(3).findViewById(R.id.click_img);
        solo.clickOnView(clickImage);
    }
}
