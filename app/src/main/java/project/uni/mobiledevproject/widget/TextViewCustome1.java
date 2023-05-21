package project.uni.mobiledevproject.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

@SuppressLint("AppCompatCustomView")
public class TextViewCustome1 extends TextView {
    public TextViewCustome1(Context context) {
        super(context);
        initTV1(context);
    }
    public TextViewCustome1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initTV1(context);
    }
    public TextViewCustome1(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTV1(context);
    }
    public void initTV1(Context c){
        Typeface t=Typeface.createFromAsset(c.getAssets(),"font/comic.ttf");
        this.setTypeface(t);
        this.setTextSize(24);
        this.setTextColor(Color.parseColor("#FFFFFF"));
        this.setText("Ye paiam daram bara to karbar aziz");
    }
}
