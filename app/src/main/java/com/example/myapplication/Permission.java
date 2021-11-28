package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class Permission {
    public static void verifyPermission(Activity activity, String namePermission) {
        if (ContextCompat.checkSelfPermission(activity, namePermission) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(activity,
                    new String[]{namePermission},0);
        }
    }
}
