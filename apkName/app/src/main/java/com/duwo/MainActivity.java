package com.duwo;

import java.util.List;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.duwo.apkname.R;

public class MainActivity
        extends Activity {
    /** Called when the activity is first created. */
    TextView texView;
    String _info;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        texView = (TextView) findViewById(R.id.text);
        List<PackageInfo> packages = getPackageManager().getInstalledPackages();

        for (int i = 0; i < packages.size(); i++) {
            PackageInfo packageInfo = packages.get(i);

            _info +=
                    packageInfo.applicationInfo.loadLabel(getPackageManager()).toString() + "->" +
                            packageInfo.packageName + "\n";
            texView.setText(_info);
        }

        Log.d("lx11", "onCreate: " + _info);

    }
}