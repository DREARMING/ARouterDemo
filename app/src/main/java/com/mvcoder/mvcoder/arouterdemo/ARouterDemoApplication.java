package com.mvcoder.mvcoder.arouterdemo;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;

public class ARouterDemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if(BuildConfig.DEBUG){
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }
}
