package com.modosa.intent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;

import java.util.Objects;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.LAUNCHER");

        ApplicationInfo appInfo = null;
        try {
            appInfo = this.getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Objects.requireNonNull(appInfo);
        String _pkg=appInfo.metaData.getString("ComponentName_pkg");
        String _cls=appInfo.metaData.getString("ComponentName_class");
        intent.setComponent(new ComponentName(_pkg, _cls));
        /*
        res\values\strings.xml
        <resources>
        <string name="app_name">IntentDemo</string>
        <string name="ComponentName_pkg">com.android.settings</string>
        <string name="ComponentName_class">com.android.settings.Settings</string>
        </resources>

        intent.setComponent(new ComponentName(getString(R.string.ComponentName_pkg), getString(R.string.ComponentName_class)));
        */
        startActivity(intent);
        finish();
    }
}
