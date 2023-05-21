package project.uni.mobiledevproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;

public class S01_Table extends Activity {
    private Button btnOG;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s01_table);
        btnOG=findViewById(R.id.button8);
        btnOG.setOnClickListener(BtnOGClick);
    }
    private  View.OnClickListener BtnOGClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String WebName1="https://www.google.com/";
            Intent in=new Intent(Intent.ACTION_VIEW, Uri.parse(WebName1));
            startActivity(in);
        }
    };
}
