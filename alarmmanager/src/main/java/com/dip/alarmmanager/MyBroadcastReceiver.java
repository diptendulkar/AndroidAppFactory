package com.dip.alarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class MyBroadcastReceiver  extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction().equals("android.intent.action.BOOT_COMPLETED")) {
            // Set the alarm here.
        }
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://stackoverflow.com/users/5295085/diptendu-das"));
        context.startActivity(browserIntent);
        Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show();
    }
}