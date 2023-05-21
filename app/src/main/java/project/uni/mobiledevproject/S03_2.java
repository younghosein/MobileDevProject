package project.uni.mobiledevproject;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class S03_2 extends Activity {
    private TextView tv1;
    private TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s03_2);

        tv1=findViewById(R.id.tv1_3);
        tv2=findViewById(R.id.tv2_3);

        Intent TT=getIntent();
        tv1.setText(TT.getStringExtra("intT"));
        tv2.setText(TT.getStringExtra("intN"));

        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
    public void Exit_3(View v){
        this.finish();
    }
}
