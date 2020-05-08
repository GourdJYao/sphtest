package com.yaojian.sphtest.activity;

import android.Manifest;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.yaojian.sphtest.R;
import com.yaojian.sphtest.greendao.entity.MonthData;
import com.yaojian.sphtest.greendao.entity.SphInfo;
import com.yaojian.sphtest.greendao.service.SphInfoService;
import com.yaojian.sphtest.network.NetWorkTools;
import com.yaojian.sphtest.utils.JSONUtils;
import com.yaojian.sphtest.utils.StringUtils;
import com.yaojian.sphtest.view.SphInfoRecyclerAdapter;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getName();

    private List<MonthData> monthDataList = new ArrayList<MonthData>();
    private RecyclerView sphinfoRyv;
    private SphInfoRecyclerAdapter sphInfoRecyclerAdapter;
    private SphInfoService sphInfoService;
    private static final int ACTION_REQUEST_PERMISSIONS = 1;

    //需要的权限
    private static final String[] NEEDED_PERMISSIONS = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.INTERNET,
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sphinfoRyv = findViewById(R.id.sphinfo_ryv);
        sphInfoService = new SphInfoService();
        sphinfoRyv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        sphInfoRecyclerAdapter = new SphInfoRecyclerAdapter(this, monthDataList);
        sphinfoRyv.setAdapter(sphInfoRecyclerAdapter);
        if (!checkPermissions(NEEDED_PERMISSIONS)) {
            ActivityCompat.requestPermissions(this, NEEDED_PERMISSIONS, ACTION_REQUEST_PERMISSIONS);
        }
        showProgressDialog();
        NetWorkTools.getInstance().setAsyncHttpResponseHandler(new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                dismissProgressDialog();
                if (statusCode == 200) {
                    try {
                        String responseString = new String(responseBody, StringUtils.UTF_8_STRING);
                        List<SphInfo> sphInfoList = JSONUtils.parseSphInfoList(responseString);
                        processData(sphInfoList);
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                    sphInfoRecyclerAdapter.updateData(monthDataList);
                } else {
                    //失败，则加载本地数据
                    List<SphInfo> sphInfoList = sphInfoService.findAllData();
                    processData(sphInfoList);
                    if (sphInfoList != null) {
                        sphInfoRecyclerAdapter.updateData(monthDataList);
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                dismissProgressDialog();
                //失败，则加载本地数据
                List<SphInfo> sphInfoList = sphInfoService.findAllData();
                processData(sphInfoList);
                if (sphInfoList != null) {
                    sphInfoRecyclerAdapter.updateData(monthDataList);
                }
            }
        });
        //获取服务器数据
        NetWorkTools.getInstance().getSphInfoDataForNetwork();
    }

    private void processData(List<SphInfo> sphInfoList) {
        if (sphInfoList != null && sphInfoList.size() > 0) {
            MonthData monthData = null;
            SphInfo tempSphInfo = null;
            for (SphInfo sphInfo : sphInfoList) {
                String monthString = sphInfo.getQuarter();
                if (tempSphInfo != null && !sphInfo.getQuarter().contains(monthData.getMonthString())) {
                    tempSphInfo = null;
                }
                if (tempSphInfo == null) {
                    //上一个数据为空，初始进入或者新得一年
                    monthData = new MonthData();
                    monthData.setMonthString(monthString.substring(0, monthString.indexOf("-")));
                    monthData.setTotalData(sphInfo.getVolume_of_mobile_data());
                    monthData.setWave(false);
                    monthData.addSphInfo(sphInfo);
                    sphInfoService.addData(sphInfo);
                    monthDataList.add(monthData);
                    tempSphInfo = sphInfo;
                } else {
                    //上一个数据不为空
                    monthData.setTotalData(monthData.getTotalData() + sphInfo.getVolume_of_mobile_data());
                    monthData.addSphInfo(sphInfo);
                    sphInfoService.addData(sphInfo);
                    if (tempSphInfo.getVolume_of_mobile_data() > sphInfo.getVolume_of_mobile_data()) {
                        //有波动
                        monthData.setWave(true);
                    }
                    tempSphInfo = sphInfo;
                }
            }
        }
    }

}
