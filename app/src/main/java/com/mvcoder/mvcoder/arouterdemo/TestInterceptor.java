package com.mvcoder.mvcoder.arouterdemo;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

@Interceptor(priority = 8, name = "test interceptor")
public class TestInterceptor implements IInterceptor {

    boolean hasLogin = true;

    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Log.e("interceptor", "intercept....." + postcard.getPath());
        String path = postcard.getPath();
        if("/t/test".equals(path)){
            //可以检查extra，假设extra的第二个bit是1的时候，代表要检查登录状态
            int extra = postcard.getExtra();
            if((extra & 2) != 0){
                if(hasLogin)
                    callback.onContinue(postcard);
                else
                    callback.onInterrupt(new IllegalAccessError("需要登录"));
            }
        }
        callback.onContinue(postcard);
        //callback.onInterrupt(new RuntimeException("permission not enough"));
    }

    @Override
    public void init(Context context) {

    }
}
