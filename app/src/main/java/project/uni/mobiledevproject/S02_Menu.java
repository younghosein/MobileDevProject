package project.uni.mobiledevproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;

public class S02_Menu extends Activity {
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.s02_menu);
        btn=findViewById(R.id.btn_menu);
        btn.setOnCreateContextMenuListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu m) {
        getMenuInflater().inflate(R.menu.s02_menu,m);
        return super.onCreateOptionsMenu(m);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem i) {
        if(i.getItemId()==R.id.bm1){
            Toast.makeText(getApplication(),"آفرين، رو اولي کليد کردي",Toast.LENGTH_SHORT).show();
        }
        else if(i.getItemId()==R.id.bm2_1){
            Toast.makeText(getApplication(),"يه پيام دارم براي تو دوست عزيز",Toast.LENGTH_SHORT).show();
        }
        else if(i.getItemId()==R.id.bm2_2){
            Toast.makeText(getApplication(),"نزار بقيشو بکم",Toast.LENGTH_SHORT).show();
        }
        else if(i.getItemId()==R.id.bm3){
            Toast.makeText(getApplication(),"کامپيوتر: تو دلم بهت فوش دادم",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(i);
    }

    @Override
    public void onCreateContextMenu(ContextMenu m, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.s04_menu,m);
        super.onCreateContextMenu(m, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem i) {
        if(i.getItemId()==R.id.mi1_4){
            Toast.makeText(getApplication(),"خب که چی |:",Toast.LENGTH_SHORT).show();
        }
        else if(i.getItemId()==R.id.mi2_4){
            Toast.makeText(getApplication(),"|:",Toast.LENGTH_SHORT).show();
        }
        else if(i.getItemId()==R.id.mi3_4){
            Toast.makeText(getApplication(),"پایینیو بزن sick کن",Toast.LENGTH_SHORT).show();
        }
        else if(i.getItemId()==R.id.mi4_4){
            this.finish();
        }
        return super.onContextItemSelected(i);
    }
}
