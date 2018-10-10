package com.mvcoder.mvcoder.arouterdemo;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Button btTest;
    private Button btModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btTest = findViewById(R.id.btTest);
        btTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/t/test")
                        .withString("name", TAG)
                        .withInt("key",10086)
                        .navigation(MainActivity.this, 10,  new NavCallback() {
                    @Override
                    public void onArrival(Postcard postcard) {
                        log("onArrival : " + postcard.toString());
                    }

                    @Override
                    public void onLost(Postcard postcard) {
                        super.onLost(postcard);
                        log("onLost : " + postcard.toString());
                    }

                    @Override
                    public void onInterrupt(Postcard postcard) {
                        super.onInterrupt(postcard);
                        log("onInterrupt");
                    }
                });
            }
        });

        btModule = findViewById(R.id.btTestModule);
        btModule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ARouter.getInstance().build("/module2/test").navigation();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 10 && resultCode == RESULT_OK){
            log("on receive result!! " + data.getStringExtra("arouter"));
        }
    }

    private void log(String msg){
        Log.e(TAG, msg);
    }
}
