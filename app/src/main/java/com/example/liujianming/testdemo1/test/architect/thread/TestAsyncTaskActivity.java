package com.example.liujianming.testdemo1.test.architect.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.liujianming.testdemo1.R;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class TestAsyncTaskActivity extends AppCompatActivity implements View.OnClickListener{

    TextView textView;
    Button btnDownload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_async_task);

        textView = findViewById(R.id.textview);
        btnDownload = findViewById(R.id.download);

        Log.i("ljm","TestAsyncTaskActivity -> onCreate,Thread name: " + Thread.currentThread().getName());
    }

    @Override
    public void onClick(View v) {

        String[] urls = {
                "https://blog.csdn.net/iispring/article/details/47115879",
                "https://blog.csdn.net/iispring/article/details/47180325",
                "https://blog.csdn.net/iispring/article/details/47300819",
                "https://blog.csdn.net/iispring/article/details/47320407",
                "https://blog.csdn.net/iispring/article/details/47622705"
        };

        DownloadTask downloadTask1 = new DownloadTask();
//        downloadTask1.execute(urls);
        downloadTask1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,urls);

        DownloadTask downloadTask2 = new DownloadTask();
//        downloadTask2.execute(urls);
        downloadTask2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR,urls);


    }

    private class DownloadTask extends AsyncTask<String,Object,Long> {

        @Override
        protected void onPreExecute() {
            Log.i("ljm","DownloadTask -> onPreExecute,Thread name: " + Thread.currentThread().getName());
            super.onPreExecute();
            btnDownload.setEnabled(false);
            textView.setText("开始下载");

        }

        @Override
        protected Long doInBackground(String... strings) {
            Log.i("ljm","DownloadTask -> doInBackground,Thread name: " + Thread.currentThread().getName());

            long totalByte = 0;

            for (String url : strings){
                Object[] result = downloadSingleFile(url);
                int byteCount = (int) result[0];

                totalByte += byteCount;

                publishProgress(result);

                if (isCancelled()) {
                    break;
                }
            }
            return totalByte;
        }

        private Object[] downloadSingleFile(String str) {
            Object[] result = new Object[2];
            int byteCount = 0;
            String blogName ="";

            HttpURLConnection conn = null;

            try {
                URL url = new URL(str);
                conn = (HttpURLConnection) url.openConnection();
                InputStream is = conn.getInputStream();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buf = new byte[1024];
                int length = -1;
                while((length = is.read(buf)) != -1) {
                    baos.write(buf,0,length);
                    byteCount += length;
                }
                String respone = new String(baos.toByteArray(),"utf-8");
                int startIndex = respone.indexOf("<title>");
                if (startIndex > 0) {
                    startIndex += 7;
                    int endIndex = respone.indexOf("</title>");
                    if (endIndex > startIndex) {
                        blogName = respone.substring(startIndex,endIndex);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if (conn != null) {
                    conn.disconnect();
                }
            }

            result[0] = byteCount;
            result[1] = blogName;
            return result;
        }

        @Override
        protected void onProgressUpdate(Object... values) {
            Log.i("ljm","DownloadTask -> onProgressUpdate,Thread name: " + Thread.currentThread().getName());
            super.onProgressUpdate(values);

            int byteCount = (int) values[0];

            String blogName = (String) values[1];

            String text = textView.getText().toString();

            text += "\n博客<<" + blogName + ">>下载完成，共" + byteCount + "字节";
            textView.setText(text);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            Log.i("ljm","DownloadTask -> onPostExecute,Thread name: " + Thread.currentThread().getName());
            super.onPostExecute(aLong);

            String text = textView.getText().toString();
            text += "\n全部下载完成，总共下载了" + aLong + "个字节";
            textView.setText(text);

            btnDownload.setEnabled(true);
        }

        @Override
        protected void onCancelled() {
            Log.i("ljm","DownloadTask -> onCancelled,Thread name: " + Thread.currentThread().getName());
            super.onCancelled();

            textView.setText("取消下载");

            btnDownload.setEnabled(true);
        }
    }
}


