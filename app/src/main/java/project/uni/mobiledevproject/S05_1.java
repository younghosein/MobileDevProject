package project.uni.mobiledevproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

public class S05_1 extends Activity {
    private Button bn5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s05_1);
        bn5=findViewById(R.id.btnNp_5);
        bn5.setOnClickListener(nxpag5);
    }
    private View.OnClickListener nxpag5=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent in=new Intent(S05_1.this,S05_2.class);
            startActivity(in);
        }
    };
}
