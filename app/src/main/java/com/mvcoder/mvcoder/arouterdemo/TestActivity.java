package com.mvcoder.mvcoder.arouterdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/t/test", extras = 2)
public class TestActivity extends AppCompatActivity {

    private Button btFinish;
    private TextView tvInfo;
    @Autowired//(name = "name")
    String name;
    @Autowired(name = "key")
    int keycode;
    @Autowired(name = "/service/sayhello")
    TestService testService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        ARouter.getInstance().inject(this);
        tvInfo = findViewById(R.id.tvInfo);
        tvInfo.setText("name : " + name + " , keycode : " + keycode + " " + (testService != null ? testService.sayHello():"inject null"));
        btFinish = findViewById(R.id.btFinish);
        btFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_OK, getIntent().putExtra("arouter","yes"));
                finish();
            }
        });
    }
}
