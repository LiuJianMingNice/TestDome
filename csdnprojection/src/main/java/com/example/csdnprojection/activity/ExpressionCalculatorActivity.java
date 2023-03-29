package com.example.csdnprojection.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;

import com.example.csdnprojection.R;

public class ExpressionCalculatorActivity extends AppCompatActivity {

    private WebView webView;
    private EditText edtExpression;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expression_calculator);

        webView = findViewById(R.id.webview);
        tvResult = findViewById(R.id.tv_result);
        edtExpression = findViewById(R.id.edt_expression);

        //设置JavaScript可用
        webView.getSettings().setJavaScriptEnabled(true);
        //利用webView加载本地页面
        webView.loadUrl("file:///android_asset/calculate.html");
        //设置网页浏览器客户端能监听到网页弹出警告框
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                //创建一个安卓警告对话框
                AlertDialog.Builder builder = new AlertDialog.Builder(ExpressionCalculatorActivity.this);
                //设置对话框图标
                builder.setIcon(R.mipmap.ic_launcher);
                if (message.equals("表达是不能为空!")) {
                    builder.setTitle("错误提示");
                    //设置对话框正文
                    builder.setMessage(message);
                } else {
                    //设置对话框标题
                    builder.setTitle("运算结果");
                    //设置对话框正文
                    builder.setMessage(edtExpression.getText().toString() + " = " + message);
                    //设置结果标签内容
                    tvResult.setText(edtExpression.getText().toString() + " = " + message);
                }
                //设置确定按钮
                builder.setPositiveButton("确定", null);
                //根据设置创建警告对话框
                AlertDialog dialog = builder.create();
                //显示警告对话框
                dialog.show();
                //处理用户的确认操作
                result.confirm();
                //事件处理完毕
                return true;
            }
        });
    }

    //计算按钮单击事件处理方法
    public void doCalculate (View view) {
        //获取用户输入的表达式
        String strExpression = edtExpression.getText().toString().trim();
        //利用webview调用JavaScript函数
        webView.loadUrl("javascript:calculate(" + strExpression + ")");
    }

    //清空按钮单击事件处理方法
    public void doClear(View view) {
        //清空表达式文本框内容
        edtExpression.setText("");
        //清空结果标签内容
        tvResult.setText("");
        //表达式文本框获取焦点
        edtExpression.requestFocus();
    }
}