package project.uni.mobiledevproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class S06_1 extends Activity {
    //private ProgressBar pb1;
    private ProgressBar pb2;
    private TextView tv;
    private int counter=0;
    private Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s06_1);
        //pb1=findViewById(R.id.progbar1);
        pb2=findViewById(R.id.progbar2);
        tv=findViewById(R.id.tv_6);
        b=findViewById(R.id.btnStop_6);
        counter=pb2.getProgress();
    }
    public void pbClk(View v){
        if(v.getId()==R.id.btnMove_6) {
            int c = pb2.getProgress();
            if (pb2.getMax() >= 100) {
                pb2.setProgress(c + 5);
            } else {
                pb2.setProgress(0);
            }
            tv.setText(pb2.getProgress() + " %");
        }
        if(v.getId()==R.id.btnAmove_6){
            Thread t=new Thread(new Runnable() {
                @Override
                public void run() {
                    while (counter<100){
                        try{
                            Thread.sleep(500);
                            //if(counter<100)
                                counter+=5;
                            //else
                                //counter=0;
                        }
                        catch(Exception e){
                            e.printStackTrace();
                        }
                        pb2.post(new Runnable() {
                            @Override
                            public void run() {
                                pb2.setProgress(counter);
                                tv.setText(pb2.getProgress()+" %");
                            }
                        });
                    }
                }
            });
            t.start();
        }
    }
}
