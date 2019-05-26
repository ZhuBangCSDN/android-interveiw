package com.banana.servicedemo;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by bobsha on 2019/5/26.
 */
public class BActivity extends AppCompatActivity {
    final String TAG = this.getClass().getName();
    ServiceConnection mServiceConnection;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        Button bind_service = findViewById(R.id.bind_service);
        bind_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "bind_service click");
                mServiceConnection = new ServiceConnection() {
                    @Override
                    public void onServiceConnected(ComponentName name, IBinder service) {
                        Log.e(TAG, "onServiceConnected");
                    }

                    @Override
                    public void onServiceDisconnected(ComponentName name) {
                        Log.e(TAG, "onServiceDisconnected");
                    }
                };
                bindService(new Intent(BActivity.this, DemoService.class), mServiceConnection, Service.BIND_AUTO_CREATE);
            }
        });
    }
}
