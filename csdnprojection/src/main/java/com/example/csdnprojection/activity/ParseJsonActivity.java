package com.example.csdnprojection.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.csdnprojection.R;

import org.apache.http.util.EncodingUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class ParseJsonActivity extends AppCompatActivity {

    //文件内容字符串
    private String content;

    //文件内容标签
    private TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parse_json);

        tvContent = findViewById(R.id.tv_content);
    }

    public void doReadJson(View view) {

        try {
            //读取assets目录里的test.json文件,获取字节输入流
            InputStream is = getResources().getAssets().open("test.json");
            //获取字节输入流长度
            int length = is.available();
            //定义字节缓冲区
            byte[] buffer = new byte[length];
            //读取字节输入流,存放到字节缓冲区里
            is.read(buffer);
            //将字节缓冲区里的数据转换成UTF-8字符串
            content = EncodingUtils.getString(buffer, "utf-8");
            //将字符串显示在标签里
            tvContent.setText(content);
            //设置标签文本颜色
            tvContent.setTextColor(Color.BLUE);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void doParseJson(View view) {
        //判断用户是否读取了Json文件
        if (content == null) {
            Toast.makeText(this, "请先读取Json文件!", Toast.LENGTH_SHORT).show();
        } else {
            try {
                //清空标签内容
                tvContent.setText("");
                //基于content字符串创建Json数组
                JSONArray jsonArray = new JSONArray(content);
                //遍历Json数组
                for (int i = 0; i < jsonArray.length(); i++) {
                    //通过下标获取json数组元素-Json对象
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    //对Json对象按键取值
                    int id = jsonObject.getInt("id");
                    String name = jsonObject.getString("name");
                    String press = jsonObject.getString("press");
                    String author = jsonObject.getString("author");
                    double price = jsonObject.getDouble("price");

                    // 拼接成一本图书信息
                    String book = "编号：" + id
                            + "\n书名：" + name
                            + "\n出版社：" + press
                            + "\n作者：" + author
                            + "\n单价：" + price + "\n\n";
                    // 将图书信息追加到标签里
                    tvContent.append(book);
                }
                tvContent.setTextColor(Color.RED);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}