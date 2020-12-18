package com.example.liujianming.testdemo1.audioandvideo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.AudioTrack;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.liujianming.testdemo1.R;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class Dome1Activity extends AppCompatActivity implements View.OnClickListener {

    private Button open_audio, close_audio;
    File pcmFile;
    int sampleRateInHz;
    private boolean isRecording = false;

    private final static String TAG = Dome1Activity.class.getSimpleName();
    private int channelConfig;
    private int audioFromat;
    private int bufferSize;
    private AudioRecord audioRecord;
    private int state;
    private int channels;
    private boolean hasPcmFile = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dome1);
        open_audio = findViewById(R.id.open_audio);
        close_audio = findViewById(R.id.close_audio);
        open_audio.setOnClickListener(this);
        close_audio.setOnClickListener(this);
    }

    private void createAudioRecord() {
        sampleRateInHz = 44100;
        channelConfig = AudioFormat.CHANNEL_IN_MONO;
        audioFromat = AudioFormat.ENCODING_PCM_16BIT;
        bufferSize = AudioRecord.getMinBufferSize(sampleRateInHz, channelConfig, audioFromat);
        audioRecord = new AudioRecord(MediaRecorder.AudioSource.MIC, sampleRateInHz, channelConfig, audioFromat, bufferSize);
        state = audioRecord.getState();
        Log.d(TAG, "createAudioRecord: state=" + state + "bufferSize=" + bufferSize);
        if (AudioRecord.STATE_INITIALIZED != state) {
            new Exception("AudioRecord无法初始化,请检查录制权限或者是否其他app没有释放录音器");
        }
    }

    private void initPCMFile() {
        pcmFile = new File(getExternalFilesDir(Environment.DIRECTORY_MUSIC), "raw.pcm");
        Log.d(TAG, "initPCMFile: pcmFile=" + pcmFile);
    }

    private void startRecord() {
        if (pcmFile.exists()) {
            pcmFile.delete();
        }

        isRecording = true;
        final byte[] buffer = new byte[bufferSize];
        audioRecord.startRecording();

        new Thread(new Runnable() {
            @Override
            public void run() {
                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = new FileOutputStream(pcmFile);
                    if (fileOutputStream != null) {
                        while (isRecording) {
                            int readStatus = audioRecord.read(buffer, 0, bufferSize);
                            Log.d(TAG, "run: readStatus=" + readStatus);
                            fileOutputStream.write(buffer);
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    private void stopRecord() {
        isRecording = false;
        if (audioRecord != null) {
            audioRecord.stop();
        }
        Looper.loop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (audioRecord != null) {
            audioRecord.release();
        }
        audioRecord = null;
    }

    private void initAudioTrackParams() {
        sampleRateInHz = 44100;
        channels = AudioFormat.CHANNEL_OUT_MONO;
        audioFromat = AudioFormat.ENCODING_PCM_16BIT;
        bufferSize = AudioTrack.getMinBufferSize(sampleRateInHz, channels, audioFromat);

        pcmFile = new File(getExternalFilesDir(Environment.DIRECTORY_MUSIC), "raw.pcm");
        if (pcmFile.exists()) {
            hasPcmFile = true;
        };
    }

    private void initStaticBuff() {
        //static模式是一次读取全部的数据,在play之前要先完成{@link audioTrack.write()}
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.open_audio:
//                createAudioRecord();
//                initPCMFile();
//                startRecord();
                isWifi5G(this);
              break;
            case R.id.close_audio:
                stopRecord();
                break;
        }
    }

    //判断当前网络是不是5G频段的网络
    public boolean isWifi5G(Context context) {
        int freq = 0;
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (android.os.Build.VERSION.SDK_INT > android.os.Build.VERSION_CODES.LOLLIPOP) {
            freq = wifiInfo.getFrequency();
        } else {
            String ssid = wifiInfo.getSSID();
            if (ssid != null && ssid.length() > 2) {
                String ssidTemp = ssid.substring(1, ssid.length() - 1);
                List<ScanResult> scanResults = wifiManager.getScanResults();
                for (ScanResult scanResult : scanResults) {
                    if (scanResult.SSID.equals(ssidTemp)) {
                        freq = scanResult.frequency;
                        break;
                    }
                }
            }
        }
        Toast.makeText(this,"freg===>>> " + freq,Toast.LENGTH_SHORT).show();
        return freq > 4900 && freq < 5900;
    }
}