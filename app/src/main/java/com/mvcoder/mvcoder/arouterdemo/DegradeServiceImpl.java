package com.mvcoder.mvcoder.arouterdemo;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.DegradeService;

/**
 * 全局降级策略是在Arouter跳转时不指定任何Nav回调时发生onLost事件，才会执行降级策略
 */
@Route(path = "/xxx/xxx")
public class DegradeServiceImpl implements DegradeService {

    @Override
    public void onLost(Context context, Postcard postcard) {
        Log.e("degrade", "onLost now!!");
        System.out.println("degrade ....");
    }

    @Override
    public void init(Context context) {

    }
}
