package com.yaojian.sphtest.network;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

public class NetWorkTools {

   private AsyncHttpClient client;
    /**
     * 定义一个变量来存储创建好的类实例
     */

    private static NetWorkTools uniqueInstance = null;

    private AsyncHttpResponseHandler asyncHttpResponseHandler;

    /**
     * 私有化构造方法，好在内部控制创建实例的数目
     */

    private NetWorkTools() {
        client = new AsyncHttpClient();
    }

    /**
     * 定义一个方法来为客户端提供类实例
     *
     * @return 一个Singleton的实例
     */

    public static synchronized NetWorkTools getInstance() {

        //判断存储实例的变量是否有值
        if (uniqueInstance == null) {
            //如果没有，就创建一个类实例，并把值赋值给存储类实例的变量
            uniqueInstance = new NetWorkTools();
        }

        //如果有值，那就直接使用
        return uniqueInstance;
    }

    /**
     * 示意方法，单例可以有自己的操作
     */

    public void singletonOperation() {

        //功能处理

    }

    /**
     * 示意属性，单例可以有自己的属性
     */

    private String singletonData;

    /**
     * 示意方法，让外部通过这些方法来访问属性的值
     *
     * @return 属性的值
     */

    public String getSingletonData() {
        return singletonData;
    }

    public void getSphInfoDataForNetwork(){
        client.get("https://data.gov.sg/api/action/datastore_search?offset=14&limit=44&resource_id=a807b7ab-6cad-4aa6-87d0-e283a7353a0f",asyncHttpResponseHandler);
    }

    public void setAsyncHttpResponseHandler(AsyncHttpResponseHandler asyncHttpResponseHandler) {
        this.asyncHttpResponseHandler = asyncHttpResponseHandler;
    }
}
