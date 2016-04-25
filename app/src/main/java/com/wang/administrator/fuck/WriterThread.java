package com.wang.administrator.fuck;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 2016/4/24.
 */
public class WriterThread extends Thread {
    private OutputStream outputStream;
    private Map param;

    public WriterThread(OutputStream outputStream,Map param) {
        this.outputStream = outputStream;
        this.param = param;
    }

    @Override
    public void run() {
        StringBuffer sb = new StringBuffer();
        //对输出流封装成高级输出流
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        //将参数封装成键值对的形式
        Set<Map.Entry<String, String>> p = param.entrySet();
        for (Map.Entry s : p) {
            sb.append(s.getKey()).append("=").append(s.getValue()).append("&");
        }
        //将参数通过输出流写入
        try {
            writer.write(sb.deleteCharAt(sb.toString().length() - 1).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                writer.close();//一定要关闭,不然可能出现参数不全的错误
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
