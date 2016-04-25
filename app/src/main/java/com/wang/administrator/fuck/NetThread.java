package com.wang.administrator.fuck;

import android.util.Log;

import com.wang.administrator.fuck.Tool.DataUtil;
import com.wang.administrator.fuck.Tool.GetUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2016/4/24.
 */
public class NetThread extends Thread {

    private String cityName;

    public NetThread(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public void run() {
        try {
            Log.e("NetThread", "NetThread已启动");

            //调用聚合数据的数据
            GetUtil.get(DataUtil.DataOfJUHE.URL + "?" + DataUtil.DataOfJUHE.CITY_NAME +
                    URLEncoder.encode(cityName, "UTF-8") + DataUtil.DataOfJUHE.KEY);

            Log.e("NetThread", "NetThread已关闭");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
