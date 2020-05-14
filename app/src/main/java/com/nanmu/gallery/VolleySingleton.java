package com.nanmu.gallery;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by kusunoki on 2020/5/14 0014 14:52.
 */
public class VolleySingleton {
    private static VolleySingleton  INSTANCE;
    private static Context context;
    RequestQueue queue;
    private VolleySingleton(Context context) {
        this.context = context;
        INSTANCE = null;
    }

    static synchronized VolleySingleton getinstance(Context context){
        if (INSTANCE == null){
            INSTANCE =  new VolleySingleton(context);
            }
        return INSTANCE;
    }

    public RequestQueue getRequestQueue() {
        if (queue == null) {
            // getApplicationContext() 是关键, 它避免了你
            //传递进Activity或BroadcastReceiver导致的内存泄漏
            queue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return queue;
    }
}

