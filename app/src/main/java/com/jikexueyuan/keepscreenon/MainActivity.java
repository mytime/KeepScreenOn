package com.jikexueyuan.keepscreenon;

import android.os.PowerManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 保持屏幕点亮
 *
 * 需要wake lock 权限
 *
 */

public class MainActivity extends AppCompatActivity {

    private PowerManager pm;
    private PowerManager.WakeLock wakeLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取系统服务里的电源服务
        pm = (PowerManager) getSystemService(POWER_SERVICE);

        /**
         * newWakeLock：新建一个唤醒锁服务，
         * FULL_WAKE_LOCK:cpu,屏幕，键盘都被唤醒
         */

        wakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK,"Wake");

    }

    //重新开始
    @Override
    protected void onResume() {
        super.onResume();
        wakeLock.acquire(); //获得
    }

    //暂停
    @Override
    protected void onPause() {
        super.onPause();
        wakeLock.release(); //释放
    }
}
