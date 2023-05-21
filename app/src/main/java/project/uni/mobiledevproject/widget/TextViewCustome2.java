package project.uni.mobiledevproject.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

@SuppressLint("AppCompatCustomView")
public class TextViewCustome2 extends TextView {
    public TextViewCustome2(Context context) {
        super(context);
        initTV2(context);
    }
    public TextViewCustome2(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initTV2(context);
    }
    public TextViewCustome2(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTV2(context);
    }
    public void initTV2(Context c) {
        Typeface t = Typeface.createFromAsset(c.getAssets(), "font/showg.TTF");
        this.setTypeface(t);
        this.setTextSize(22);
        this.setTextColor(Color.parseColor("#FFFFFF"));
        this.setText("Khodet begir chi mikhastam begam");
    }
}
