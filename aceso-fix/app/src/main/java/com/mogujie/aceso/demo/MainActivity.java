package com.mogujie.aceso.demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;
import com.android.annotations.FixMtd;
import com.mogujie.aceso.HotPatchUtil;

import java.io.File;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fix(View view) {
        File fixFile = new File(Environment.getExternalStorageDirectory(), "fix.apk");
        if (!fixFile.exists()) {
            Toast.makeText(this, "hotfix file not exist!", Toast.LENGTH_SHORT).show();
            return;
        }
        File optFile = new File(this.getFilesDir(), "fix_opt");
        optFile.mkdirs();
        new HotPatchUtil().fix(optFile, fixFile);
    }

    @FixMtd
    public void test(View view) {
        Toast.makeText(this, "has been fixed ! ", Toast.LENGTH_SHORT).show();
    }
}