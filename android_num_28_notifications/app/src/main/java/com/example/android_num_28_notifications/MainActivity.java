package com.example.android_num_28_notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void click_btn(View v){
        NotificationManager msg_str = (NotificationManager)
                getSystemService(Context.NOTIFICATION_SERVICE);
        Bitmap msg_img = BitmapFactory.decodeResource(getResources(),
                R.mipmap.cat);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0,
                        new Intent(this, MainActivity.class), 0);

        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ico) //在上方狀態列顯示小圖示
                .setLargeIcon(msg_img)      //大圖示
                .setContentTitle("Notification 練習")             //標題
                .setContentText("可是這是作業啊!")                 //內容
                .setWhen(System.currentTimeMillis())
                .setDefaults(Notification.DEFAULT_ALL)            //震動提醒
                .setLights(Color.GREEN, 1000, 1000) //閃爍
                .setContentIntent(pendingIntent)                  // 設置Intent
                .setAutoCancel(true)                              //點擊關閉
                .build();

        msg_str.notify(0, notification);

    }
}