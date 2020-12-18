package com.example.liujianming.testdemo1.简书Demo.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


//import com.baidu.ocr.sdk.OCR;
//import com.baidu.ocr.sdk.OnResultListener;
//import com.baidu.ocr.sdk.exception.OCRError;
//import com.baidu.ocr.sdk.model.AccessToken;
//import com.baidu.ocr.sdk.model.GeneralResult;
//import com.baidu.ocr.ui.camera.CameraActivity;
import com.example.liujianming.testdemo1.R;
//import com.example.liujianming.testdemo1.简书Demo.Utils.FileUtil;
//import com.example.liujianming.testdemo1.简书Demo.manager.OCRManager;

public class IdentifyWordsActivity extends AppCompatActivity {

    final static String TAG = "ljm";
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identify_words);
//        OCR.getInstance(this).initAccessToken(new OnResultListener<AccessToken>() {
//            @Override
//            public void onResult(AccessToken accessToken) {
//                //调用成功返回AccessToken对象
//                Log.i(TAG,accessToken.toString());
//                String token = accessToken.getAccessToken();
//            }
//
//            @Override
//            public void onError(OCRError ocrError) {
//                Log.i(TAG,ocrError.toString());
//            }
//        }, getApplicationContext());
//        textView = findViewById(R.id.text_click);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                ocrClick(v);
//            }
//        });
    }

//    public void ocrClick(View view) {
//        //生成intent对象
//        Intent intent = new Intent(IdentifyWordsActivity.this, CameraActivity.class);
//
//        //设置临时存储
//        intent.putExtra(CameraActivity.KEY_OUTPUT_FILE_PATH, FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath());
//
//        // 调用除银行卡，身份证等识别的activity
//        intent.putExtra(CameraActivity.KEY_CONTENT_TYPE, CameraActivity.CONTENT_TYPE_GENERAL);
//
//        startActivityForResult(intent, 111);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 111 && requestCode == Activity.RESULT_OK) {
//            //获取调用参数
//            String contentType = data.getStringExtra(CameraActivity.KEY_CONTENT_TYPE);
//
//            //通过临时文件获取拍摄的图片
//            String filePath = FileUtil.getSaveFile(getApplicationContext()).getAbsolutePath();
//
//            OCRManager.recognizeAccurateBasic(this, filePath, new OCRManager.OCRCallBack<GeneralResult>() {
//                @Override
//                public void succeed(GeneralResult data) {
//                    // 调用成功，返回GeneralResult对象
//                    String content = OCRManager.getResult(data);
//                    Log.e(TAG,content + "");
//                }
//
//                @Override
//                public void failed(OCRError error) {
//                    // 调用失败，返回OCRError对象
//                    Log.e(TAG,"错误信息：" + error.getMessage());
//                }
//            });
//        }
//    }

}