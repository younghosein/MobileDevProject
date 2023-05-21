package project.uni.mobiledevproject;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.Date;

public class S01_Basic extends Activity {
    private TextView lbl;
    private Button btn;
    private Button btn0;
    private LinearLayout Form;
    private EditText txt;
    private Button BtnOpenUStmb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s01_basic);

        lbl=findViewById(R.id.C_lbl);
        btn=findViewById(R.id.C_btn);
        btn0=findViewById(R.id.C_btn0);
        Form=findViewById(R.id.Lyt_basic);
        txt=findViewById(R.id.C_txt);

        BtnOpenUStmb=findViewById(R.id.btnOU);
        BtnOpenUStmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String WebName1="https://amoozesh.ustmb.ac.ir/SamaWeb/Index.aspx";
                Intent in=new Intent(Intent.ACTION_VIEW, Uri.parse(WebName1));
                startActivity(in);
            }
        });
    }

    public void btn_Click(View v){
        if(v.getId()==R.id.C_btn0){
            lbl.setText("Welcome to my program");
        }
        else if(v.getId()==R.id.C_btn){
            lbl.setText(new Date().toString());
        }
        else if(v.getId()==R.id.C_btn1){
            Form.setBackgroundColor(Color.parseColor(txt.getText().toString()));
        }
        else if(v.getId()==R.id.C_btn2){
            Intent i=new Intent(S01_Basic.this,S01_Table.class);
            startActivity(i);
        }
    }
}