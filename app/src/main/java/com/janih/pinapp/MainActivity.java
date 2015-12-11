package com.janih.pinapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView tv;
    private boolean ok = false;

    @Override
    protected void onResume() {
        super.onResume();
        if (!ok) checkPin();
        else go();
    }
    @Override
    protected void onPause() {
        ok = false;
        super.onPause();
    }

    private void checkPin() {
        Intent intent = new Intent(this,PinActivity.class);
        startActivityForResult(intent,0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != 0) return;
        if (resultCode == RESULT_OK)
            ok = true;
    }

    private void go() {
        Log.i("jee", "go"); // before onresume
        tv.setText(String.valueOf(Integer.valueOf(tv.getText().toString())+1));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.tv);
    }

}
