package com.wang.administrator.fuck.Tool;

/**
 * Created by Administrator on 2016/4/24.
 */
public class GetUtil {
    /**
     * get方法直接调用post方法
     *
     * @param url 网络地址
     * @return 返回网络数据
     */
    public static void get(String url) {
        PostUtil.post(url, null);
    }
}
