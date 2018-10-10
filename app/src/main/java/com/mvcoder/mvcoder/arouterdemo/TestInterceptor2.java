package com.mvcoder.mvcoder.arouterdemo;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

@Interceptor(priority = 9, name = "test interceptor")
public class TestInterceptor2 implements IInterceptor {

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Log.e("interceptor", "intercept.....7" + postcard.getPath());
        callback.onContinue(postcard);
        //callback.onInterrupt(new RuntimeException("permission not enough"));
    }

    @Override
    public void init(Context context) {

    }
}
