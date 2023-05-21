package project.uni.mobiledevproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class S05_2 extends Activity {
    private Spinner s;
    private Button b;
    private MediaPlayer mdplr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s05_2);
        s=findViewById(R.id.spnr1_5);
        b=findViewById(R.id.btnSpin5);
        b.setOnClickListener(chtap);
        mdplr=MediaPlayer.create(S05_2.this,R.raw.beat);
    }
    public void buildArr(){
        List<String> AA=new ArrayList<String>();
        AA.add("Tupac");
        AA.add("Ice Cube");
        AA.add("Dr.Dre");
        AA.add("Easy-E");
        AA.add("Dmx");
        ArrayAdapter<String> Adp=new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,AA);
        Adp.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        s.setAdapter(Adp);
        s.setOnItemSelectedListener(selItm);
    }

    private View.OnClickListener chtap=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            buildArr();
        }
    };

    private AdapterView.OnItemSelectedListener selItm=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String str="You Clicked At "+String.valueOf(s.getSelectedItem());
            Toast.makeText(getApplication(),str,Toast.LENGTH_SHORT).show();
        }
        @Override
        public void onNothingSelected(AdapterView<?> parent) {}
    };

    public void tabe5(View v){
        AlertDialog.Builder bldr=new AlertDialog.Builder(this);
        bldr.setTitle("Exit Alert");
        bldr.setMessage("Do you want to exit ?");
        bldr.setCancelable(false);
        bldr.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                S05_2.this.finish();
            }
        });
        bldr.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dlog=bldr.create();
        dlog.show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mdplr.isPlaying()){
            mdplr.stop();
            mdplr.release();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mdplr.isPlaying()){
            mdplr.pause();
        }
    }

    public  void plymp3(View v){
        if(v.getId()==R.id.bPly5){
            mdplr.start();
        }
        else if(v.getId()==R.id.bPus5){
            mdplr.pause();
        }
        else if(v.getId()==R.id.bStp5){
            mdplr.stop();
        }
    }
}