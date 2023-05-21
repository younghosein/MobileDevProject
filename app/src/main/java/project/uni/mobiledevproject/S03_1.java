package project.uni.mobiledevproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.Nullable;

public class S03_1 extends Activity {
    private EditText tt;
    private EditText tn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s03_1);

        tt=findViewById(R.id.txtName_3);
        tn=findViewById(R.id.txtNum_3);
    }
    public void Click_3(View v){
        if(v.getId()==R.id.btnAct_3){
            Intent int1=new Intent(S03_1.this,S03_2.class);
            startActivity(int1);
        }
        else if(v.getId()==R.id.btnSit_3){
            String link="https://www.google.com/";
            Intent int2=new Intent(Intent.ACTION_VIEW, Uri.parse(link));
            startActivity(int2);
        }
        else if(v.getId()==R.id.btnSms_3){
            String number="09929846114";
            Intent int3=new Intent(Intent.ACTION_SENDTO,Uri.parse(number));
            int3.putExtra("Amohosein","Ye paiam daram brato doste aziz");
            startActivity(int3);
        }
        else if(v.getId()==R.id.btnDo_3){
            Intent TT=new Intent(S03_1.this,S03_2.class);
            TT.putExtra("intT",tt.getText().toString());
            TT.putExtra("intN",tn.getText().toString());
            startActivity(TT);
        }
    }
}
