package project.uni.mobiledevproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Exam_Mainpage extends Activity {

    private EditText n1;
    private EditText opt;
    private EditText n2;
    private Button bac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exam_mainpage);
        init();
        SetFont();
    }

    public void init(){
        n1=findViewById(R.id.e1);
        opt=findViewById(R.id.op);
        n2=findViewById(R.id.e2);
        bac=findViewById(R.id.btnAction);
    }

    public void SetFont(){
        Typeface tf=Typeface.createFromAsset(getAssets(),"font/gothic.ttf");
        n1.setTypeface(tf);
        opt.setTypeface(tf);
        n2.setTypeface(tf);
        bac.setTypeface(tf);
    }

    public int cal(){
        if(opt.getText().toString().equals("+")){
            Integer intd=Integer.parseInt(n1.getText().toString())+Integer.parseInt(n2.getText().toString());
            return intd;
        }
        else if(opt.getText().toString().equals("-")){
            Integer intd=Integer.parseInt(n1.getText().toString())-Integer.parseInt(n2.getText().toString());
            return intd;
        }
        else if(opt.getText().toString().equals("*")){
            Integer intd=Integer.parseInt(n1.getText().toString())*Integer.parseInt(n2.getText().toString());
            return intd;
        }
        else if(opt.getText().toString().equals("/")){
            Integer intd=Integer.parseInt(n1.getText().toString())/Integer.parseInt(n2.getText().toString());
            return intd;
        }
        else{
            return 0;
        }
    }

    public void clk(View v){
        String stringdata=(n1.getText().toString())+" "+opt.getText().toString()+" "+(n2.getText().toString())+" =";
        Integer intdata=cal();
        Intent itn=new Intent(Exam_Mainpage.this,Exam_Aboutpage.class);
        itn.putExtra("strg",stringdata);
        itn.putExtra("intg",intdata.toString());
        startActivity(itn);
    }
}
