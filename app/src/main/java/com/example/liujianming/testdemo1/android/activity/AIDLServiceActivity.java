package com.example.liujianming.testdemo1.android.activity;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.liujianming.testdemo1.R;
import com.example.liujianming.testdemo1.android.IBookManager;
import com.example.liujianming.testdemo1.android.IPerson;
import com.example.liujianming.testdemo1.android.service.AIDLService;

public class AIDLServiceActivity extends AppCompatActivity {

    @BindView(R.id.binder_service)
    Button binder_service;
    @BindView(R.id.set_name)
    Button set_name;
    @BindView(R.id.get_name)
    Button get_name;
    @BindView(R.id.et_name)
    EditText et_name;

    private IPerson iPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_i_d_l_service);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.binder_service, R.id.set_name, R.id.get_name})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.binder_service:
                bindServiceByAidl();
                break;
            case R.id.set_name:
                setName();
                break;
            case R.id.get_name:
                getName();
                break;
        }
    }

    private void bindServiceByAidl() {
        Intent intent = new Intent(this, AIDLService.class);
        bindService(intent, new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                Log.i("ljm", "==onServiceConnected==>>>");
                iPerson = IPerson.Stub.asInterface(service);
            }

            @Override
            public void onServiceDisconnected(ComponentName name) {
                Log.i("ljm", "==onServiceDisconnected==>>>");
            }
        }, BIND_AUTO_CREATE);
    }

    private void setName() {
        if (iPerson != null) {
            try {
                iPerson.setName(et_name.getText().toString());
            } catch (RemoteException e) {
                e.printStackTrace();
                Toast.makeText(this, "setName error= " + e, Toast.LENGTH_SHORT).show();
            } finally {
                try {
                    Toast.makeText(this, "getName=" + iPerson.getName(), Toast.LENGTH_SHORT).show();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void getName() {
        if (iPerson != null) {
            try {
                Toast.makeText(this, iPerson.getName(), Toast.LENGTH_SHORT).show();
                Toast.makeText(this, "getName=" + iPerson.getName(), Toast.LENGTH_SHORT).show();
                iPerson.getName();
            } catch (RemoteException e) {
                e.printStackTrace();
                Toast.makeText(this, "getName error=" + e, Toast.LENGTH_SHORT).show();
            }
        }
    }
}