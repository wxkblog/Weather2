package com.wang.administrator.fuck.Tool;

import com.wang.administrator.fuck.ReaderThread;
import com.wang.administrator.fuck.WriterThread;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Map;

/**
 * post方法获取网络资源
 * Created by Administrator on 2016/4/24.
 */
public class PostUtil {
    /**
     * 设定post方法获取网络资源,如果参数为null,实际上设定为get方法
     *
     * @param url   网络地址
     * @param param 请求参数键值对
     * @return 返回读取数据
     */
    public static String post(String url, Map param) {
        HttpURLConnection conn = null;
        try {
            URL u = new URL(url);
            conn = (HttpURLConnection) u.openConnection();
            if (param != null) {//如果请求参数不为空

                //默认为false,post方法需要写入参数,设定true
                conn.setDoOutput(true);
                //设定post方法,默认get
                conn.setRequestMethod("POST");
                //获得输出流
                OutputStream out = conn.getOutputStream();
                WriterThread w = new WriterThread(out, param);
                w.start();
                w.join();//让线程等待子线程完成
            }
            conn.connect();//建立连接
            //获取连接状态码
            int recode = conn.getResponseCode();
            if (recode == 200) {//返回码不是这个说明出错了，详见官网https://www.juhe.cn/docs/api/id/39/aid/87
                //从连接中获取输入流
                InputStream in = conn.getInputStream();
                ReaderThread rt = new ReaderThread(in);
                rt.start();
                rt.join();//等待子线程完成，否则可能数据未读完，stream已经关闭，导致异常
                in.close();//关闭流
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {//关闭连接
                conn.disconnect();
            }
        }

        return null;
    }
}
