package project.uni.mobiledevproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class S02_1 extends Activity {
    private LinearLayout LytS02_1;
    private EditText TxtClr;
    private TextView TvA;

    private ImageView imV;

    private SeekBar skb1;
    private SeekBar skb2;
    private SeekBar skb3;
    private SeekBar skb4;
    private TextView TvRGB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s02_1);

        LytS02_1=findViewById(R.id.Lyt_S02_1);
        TxtClr=findViewById(R.id.txtColor);
        TvA=findViewById(R.id.tvAlert);
        TxtClr.addTextChangedListener(textChange);
        COLORIZE();

        imV=findViewById(R.id.imgV);

        skb1=findViewById(R.id.sb1);
        skb2=findViewById(R.id.sb2);
        skb3=findViewById(R.id.sb3);
        skb3=findViewById(R.id.sb4);
        TvRGB=findViewById(R.id.tvRGB);
        skb1.setOnSeekBarChangeListener(skbrChanged);
        skb2.setOnSeekBarChangeListener(skbrChanged);
        skb3.setOnSeekBarChangeListener(skbrChanged);
        /*TxtClr.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                try{
                    LytS02_1.setBackgroundColor(Color.parseColor(TxtClr.getText().toString()));
                    TvA.setTextColor(Color.parseColor("#00FF0A"));
                    TvA.setText("Done");
                }
                catch (Exception e){
                    TvA.setTextColor(Color.parseColor("#FF0000"));
                    TvA.setText("Wrong");
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void afterTextChanged(Editable s) {}
        });*/
    }
    private TextWatcher textChange = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            COLORIZE();
        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        @Override
        public void afterTextChanged(Editable s) {}
    };

    public void btnImgClick(View v){
        if(v.getId()==R.id.Bpic1){
            imV.setBackgroundResource(R.drawable.picture1);
        }
        else if(v.getId()==R.id.Bpic2){
            imV.setBackgroundResource(R.drawable.picture2);
        }
        else if(v.getId()==R.id.Bpic3){
            imV.setBackgroundResource(R.drawable.picture3);
        }
        else if(v.getId()==R.id.btnBKP){
            LytS02_1.setBackground(getResources().getDrawable(R.drawable.array9));
        }
        else if(v.getId()==R.id.btnPage2){
            Intent i = new Intent(S02_1.this, S02_Menu.class);
            startActivity(i);
        }
    }

    private void COLORIZE(){
        try{
            LytS02_1.setBackgroundColor(Color.parseColor(TxtClr.getText().toString()));
            TvA.setTextColor(Color.parseColor("#00FF0A"));
            TvA.setText("Done");
        }
        catch (Exception e){
            TvA.setTextColor(Color.parseColor("#FF0000"));
            TvA.setText("Wrong");
        }
    }

    private void skRGB(){
        int rc=skb1.getProgress();
        int gc=skb2.getProgress();
        int bc=skb3.getProgress();
        int oc=skb3.getProgress();
        String Clr="#"+Integer.toHexString(oc)+Integer.toHexString(rc)+Integer.toHexString(gc)+Integer.toHexString(bc);
        TxtClr.setText(Clr);
        COLORIZE();
    }

    private SeekBar.OnSeekBarChangeListener skbrChanged=new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            skRGB();
            TvRGB.setText(Integer.toString(seekBar.getProgress()));
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {}
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {}
    };
}
