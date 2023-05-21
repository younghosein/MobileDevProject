package project.uni.mobiledevproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Exam_Aboutpage extends Activity {

    private TextView t1;
    private TextView t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_aboutpage);
        init();
        GetValue();
    }

    public void init(){
        t1=findViewById(R.id.tvstr);
        t2=findViewById(R.id.tvint);
    }

    public void GetValue(){
        Intent itn=getIntent();
        t1.setText(itn.getStringExtra("strg"));
        t2.setText(itn.getStringExtra("intg"));
    }
}
