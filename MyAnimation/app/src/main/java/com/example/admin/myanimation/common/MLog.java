package com.example.admin.myanimation.common;

import android.util.Log;

/**
 * Created by admin on 2016/8/1.
 */

public class MLog {
    public static final String Mylog = "mylog";
    public static final void e(String tag, String content){
        Log.e(tag, content);
    }
}
