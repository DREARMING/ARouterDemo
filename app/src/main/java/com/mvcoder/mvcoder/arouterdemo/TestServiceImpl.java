package com.mvcoder.mvcoder.arouterdemo;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;

@Route(path = "/service/sayhello")
public class TestServiceImpl implements TestService {
    @Override
    public String sayHello() {
        Log.e("service", "Test service : say hello");
        return "say Hello";
    }

    @Override
    public void init(Context context) {

    }
}
