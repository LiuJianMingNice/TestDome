package com.example.liujianming.testdemo1.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import com.example.liujianming.testdemo1.android.IPerson;

import androidx.annotation.Nullable;

public class AIDLService extends Service {

    private String name;

    private Binder binder = new IPerson.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {

        }

        @Override
        public void setName(String s) throws RemoteException {
            name = s;
        }

        @Override
        public String getName() throws RemoteException {
            return name;
        }
    };

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("ljm", "onBind");
        return binder;
    }
}
