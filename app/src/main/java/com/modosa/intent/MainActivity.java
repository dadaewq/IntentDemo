package com.modosa.intent;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import java.util.Objects;

/*
res\values\strings.xml
<resources>
<string name="app_name">IntentDemo</string>
<string name="ComponentName_pkg">com.android.settings</string>
<string name="ComponentName_class">com.android.settings.Settings</string>
</resources>

intent.setComponent(new ComponentName(getString(R.string.ComponentNamepkg_), getString(R.string.ComponentName_class)));
*/

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ApplicationInfo appInfo = null;
        try {
            appInfo = this.getPackageManager().getApplicationInfo(getPackageName(), PackageManager.GET_META_DATA);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        Objects.requireNonNull(appInfo);
        String Pkg = appInfo.metaData.getString("ComponentName_pkg");
        String Cls = appInfo.metaData.getString("ComponentName_class");
        if (Pkg == null || Cls == null || TextUtils.isEmpty(Pkg.trim()) || TextUtils.isEmpty(Cls.trim())) {
            Toast.makeText(this, "Empty !", Toast.LENGTH_SHORT).show();
        } else {

//            Intent intent = new Intent("android.intent.action.MAIN");
//            intent.addCategory("android.intent.category.LAUNCHER");

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setComponent(new ComponentName(Objects.requireNonNull(Pkg), Objects.requireNonNull(Cls)));
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            try {
                startActivity(intent);
            } catch (Exception e) {
//            e.printStackTrace();
                Toast.makeText(this, e + "", Toast.LENGTH_SHORT).show();
            }
            finish();
        }

    }
}
