# IntentDemo

startActivity via intent.setComponent(ComponentName_pkg,ComponentName_class)


All required parameters can be modified via AndroidManifest.xml,You can simply modify it to get what you want.

Example:

    <application
        .....        
        android:label="IntentDemo"
        <meta-data android:name="ComponentName_pkg" android:value="com.android.settings"/>
        <meta-data android:name="ComponentName_class" android:value="com.android.settings.Settings"/>
        ......     
    </application>
