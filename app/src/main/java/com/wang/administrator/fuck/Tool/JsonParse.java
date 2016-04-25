package com.wang.administrator.fuck.Tool;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/4/24.
 */
public class JsonParse {
    public static ArrayList<String> jsonParse(String data){
        if(data != null) {
            ArrayList<String> list = new ArrayList<>();
            try {
                //由于官网json格式不是很好，转起来很麻烦，所以这里挑几个转一下
                JSONObject jsonObject = new JSONObject(data);
                JSONObject result = jsonObject.getJSONObject("result");
                JSONObject sk = result.getJSONObject("sk");
                JSONObject today = result.getJSONObject("today");
                JSONObject weather_id = today.getJSONObject("weather_id");//只获取，不做使用
                String time = sk.getString("time");//获取sk中的time
                String weather = today.getString("weather");//获取today中的

                list.add(time);
                list.add(weather);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return list;
        }else {
            System.out.println("数据为空");
            return null;
        }
    }
}

//JSON返回示例：
//{
//        "resultcode": "200",
//        "reason": "查询成功!",
//        "result": {
//        "sk": {	/*当前实况天气*/
//        "temp": "21",	/*当前温度*/
//        "wind_direction": "西风",	/*当前风向*/
//        "wind_strength": "2级",	/*当前风力*/
//        "humidity": "4%",	/*当前湿度*/
//        "time": "14:25"	/*更新时间*/
//        },
//        "today": {
//        "city": "天津",
//        "date_y": "2014年03月21日",
//        "week": "星期五",
//        "temperature": "8℃~20℃",	/*今日温度*/
//        "weather": "晴转霾",	/*今日天气*/
//        "weather_id": {	/*天气唯一标识*/
//        "fa": "00",	/*天气标识00：晴*/
//        "fb": "53"	/*天气标识53：霾 如果fa不等于fb，说明是组合天气*/
//        },
//        "wind": "西南风微风",
//        "dressing_index": "较冷", /*穿衣指数*/
//        "dressing_advice": "建议着大衣、呢外套加毛衣、卫衣等服装。",	/*穿衣建议*/
//        "uv_index": "中等",	/*紫外线强度*/
//        "comfort_index": "",/*舒适度指数*/
//        "wash_index": "较适宜",	/*洗车指数*/
//        "travel_index": "适宜",	/*旅游指数*/
//        "exercise_index": "较适宜",	/*晨练指数*/
//        "drying_index": ""/*干燥指数*/
//        },
//        "future": [	/*未来几天天气*/
//        {
//        "temperature": "28℃~36℃",
//        "weather": "晴转多云",
//        "weather_id": {
//        "fa": "00",
//        "fb": "01"
//        },
//        "wind": "南风3-4级",
//        "week": "星期一",
//        "date": "20140804"
//        },
//        {
//        "temperature": "28℃~36℃",
//        "weather": "晴转多云",
//        "weather_id": {
//        "fa": "00",
//        "fb": "01"
//        },
//        "wind": "东南风3-4级",
//        "week": "星期二",
//        "date": "20140805"
//        },
//        {
//        "temperature": "27℃~35℃",
//        "weather": "晴转多云",
//        "weather_id": {
//        "fa": "00",
//        "fb": "01"
//        },
//        "wind": "东南风3-4级",
//        "week": "星期三",
//        "date": "20140806"
//        },
//        {
//        "temperature": "27℃~34℃",
//        "weather": "多云",
//        "weather_id": {
//        "fa": "01",
//        "fb": "01"
//        },
//        "wind": "东南风3-4级",
//        "week": "星期四",
//        "date": "20140807"
//        },
//        {
//        "temperature": "27℃~33℃",
//        "weather": "多云",
//        "weather_id": {
//        "fa": "01",
//        "fb": "01"
//        },
//        "wind": "东北风4-5级",
//        "week": "星期五",
//        "date": "20140808"
//        },
//        {
//        "temperature": "26℃~33℃",
//        "weather": "多云",
//        "weather_id": {
//        "fa": "01",
//        "fb": "01"
//        },
//        "wind": "北风4-5级",
//        "week": "星期六",
//        "date": "20140809"
//        },
//        {
//        "temperature": "26℃~33℃",
//        "weather": "多云",
//        "weather_id": {
//        "fa": "01",
//        "fb": "01"
//        },
//        "wind": "北风4-5级",
//        "week": "星期日",
//        "date": "20140810"
//        }
//        ]
//        },
//        "error_code": 0
//        }