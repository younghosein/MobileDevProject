package project.uni.mobiledevproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ExFirst extends Activity {
    private TextView lblCounter;
    private static int _counter = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exfirst);
        lblCounter = findViewById(R.id.lblCounter);
        ShowCounter();
        Method01();
    }
    private void ShowCounter() {
        Thread _thread = new Thread() {
            public void run() {
                try {
                    sleep(1 * 1000);
                    ShowCounter();
                    _counter++;
                    lblCounter.setText(Integer.toString(_counter));
                } catch (Exception e) {
                }
            }
        };
        _thread.start();
    }

    private void LoadSplash() {
        Intent myInnt = new Intent(ExFirst.this, ExMain.class);
        startActivity(myInnt);
        finish();
    }

    private void Method01() {
        Thread _thread = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                    LoadSplash();
                } catch (Exception e) {
                }
            }
        };
        _thread.start();
    }

}
