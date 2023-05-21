package project.uni.mobiledevproject;

import static android.widget.Toast.makeText;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class Exam1 extends Activity {
    private SeekBar seekbar_R;
    private SeekBar seekbar_G;
    private SeekBar seekbar_B;
    private SeekBar seekbar_A;
    private TextView LblR;
    private TextView LblG;
    private TextView LblB;
    private TextView LblA;
    private LinearLayout Mylayout;
    private EditText Colorcode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam1);
        seekbar_R.findViewById(R.id.seekbarR);
        seekbar_G.findViewById(R.id.seekbarG);
        seekbar_B.findViewById(R.id.seekbarB);
        seekbar_A.findViewById(R.id.seekbarA);
        LblR.findViewById(R.id.lblR);
        LblG.findViewById(R.id.lblG);
        LblB.findViewById(R.id.lblB);
        LblA.findViewById(R.id.lblA);
        Mylayout.findViewById(R.id.myLayout);
        Colorcode.findViewById(R.id.colorCode);
        seekbar_R.setOnSeekBarChangeListener(SeekbarChanged);
        seekbar_G.setOnSeekBarChangeListener(SeekbarChanged);
        seekbar_B.setOnSeekBarChangeListener(SeekbarChanged);
        seekbar_A.setOnSeekBarChangeListener(SeekbarChanged);
        Colorcode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                    Mylayout.setBackgroundColor(Color.parseColor(Colorcode.getText().toString()));
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
    private SeekBar.OnSeekBarChangeListener SeekbarChanged=new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            int colorR= seekbar_R.getProgress();
            int colorG= seekbar_G.getProgress();
            int colorB= seekbar_B.getProgress();
            int colorA= seekbar_A.getProgress();
            String hexCode="#"+Integer.toHexString(colorR)+Integer.toHexString(colorG)+Integer.toHexString(colorB)+Integer.toHexString(colorA);
            Colorcode.setText(hexCode);
            Mylayout.setBackgroundColor(Color.parseColor(Colorcode.getText().toString()));
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {}
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {}
    };
}
