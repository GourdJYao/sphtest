package com.yaojian.sphtest.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.yaojian.sphtest.greendao.entity.SphInfo;
import com.yaojian.sphtest.network.response.SphInfoResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JSONUtils {
    public static List<SphInfo> parseSphInfoList(String sphInfoListString) {
        try {
            Gson gson = new Gson();
            SphInfoResponse sphInfoResponse = gson.fromJson(sphInfoListString, SphInfoResponse.class);
            if (sphInfoResponse.getSuccess()) {
                return sphInfoResponse.getResult().getRecords();
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
