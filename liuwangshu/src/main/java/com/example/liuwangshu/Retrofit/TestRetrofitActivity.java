package com.example.liuwangshu.Retrofit;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.liuwangshu.R;

public class TestRetrofitActivity extends AppCompatActivity {

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_retrofit);
        btn = findViewById(R.id.btn_retrofit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getIpInformation("59.108.54.37");
            }
        });
    }

    private void getIpInformation(String ip) {
        //http://ip.taobao.com/service/59.108.54.37
        String url = "http://ip.taobao.com/service/";
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                //增加返回值为String的支持
                /*.addConverterFactory(ScalarsConverterFactory.create())*/
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        IpService ipService = retrofit.create(IpService.class);
        Call<IpModel> call=ipService.getIpMsg(ip);
        call.enqueue(new Callback<IpModel>() {
            @Override
            public void onResponse(Call<IpModel> call, Response<IpModel> response) {
                Log.i("ljm", "response: " + response.toString());
                String country= response.body().getData().getCountry();
                Log.i("ljm","country"+country);
                Toast.makeText(getApplicationContext(),country,Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onFailure(Call<IpModel> call, Throwable t) {
            }
        });
    }

    private void test() {
        // 第2部分：在创建Retrofit实例时通过.baseUrl()设置
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://fanyi.youdao.com/") //设置网络请求的Url地址
                .addConverterFactory(GsonConverterFactory.create()) //设置数据解析器
                .build();

    }
}