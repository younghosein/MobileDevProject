package project.uni.mobiledevproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class S04_1 extends Activity {
    private TextView tvf;
    private LinearLayout lyt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s04_1);
        tvf=findViewById(R.id.tvTF_4);
        lyt=findViewById(R.id.Lyt_4);
    }
    public void ChangeFont_4(View v){
        Typeface tf1=Typeface.createFromAsset(getAssets(),"font/comic.ttf");
        Typeface tf2=Typeface.createFromAsset(getAssets(),"font/showg.TTF");
        if(v.getId()==R.id.btnF1_4){
            tvf.setTypeface(tf1);
        }
        else if(v.getId()==R.id.btnF2_4){
            tvf.setTypeface(tf2);
        }
        else if(v.getId()==R.id.btnF3_4){
            Intent in=new Intent(S04_1.this, S02_Menu.class);
            startActivity(in);
        }
        else if(v.getId()==R.id.btnF4_4){
            Button b=new Button(this);
            TextView t=new TextView(this);
            ImageView i=new ImageView(this);
            Random r=new Random();
            b.setText(Integer.toString(r.nextInt(1000)));
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplication(), b.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
            lyt.addView(b);
        }
    }
}
