package com.wang.administrator.fuck;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.wang.administrator.fuck.Tool.HideKeyBoard;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";

    private Button getWeather;
    private EditText city;
    private static TextView now_time, weather;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        getWeather = (Button) findViewById(R.id.getWeather);
        city = (EditText) findViewById(R.id.city);
        now_time = (TextView) findViewById(R.id.now_time);
        weather = (TextView) findViewById(R.id.city_weather);

        city.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_ENTER) {
                    getWeather();
                }
                return false;
            }
        });
        getWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getWeather();
            }
        });
    }

    public static Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            ArrayList<String> list = null;
            list = msg.getData().getStringArrayList("list");
            now_time.setText(list.get(0));//14:25
            weather.setText(list.get(1));//晴转霾
        }
    };

    public void getWeather() {

        //隐藏键盘
        HideKeyBoard.HideKeyBoard(this);

        String cityName = city.getText().toString();
        if (cityName != null && !cityName.equals("")) {
            new NetThread(cityName).start();
        }

    }
}