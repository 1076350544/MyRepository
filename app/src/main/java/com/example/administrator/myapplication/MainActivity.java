package com.example.administrator.myapplication;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    float InitailY,lastY;
    LinearLayout layout;

    boolean first = true;
	@SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = (LinearLayout) findViewById(R.id.layout);

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        LinearLayout.LayoutParams lp0 = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,870);
        Button t0 = new Button(this);
        final Button t1 = new Button(this);
        final Button t2 = new Button(this);
        t1.setText("aaaa1");
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"ddd",Toast.LENGTH_LONG).show();
            }
        });
//        t1.setLayoutParams(lp);
        t2.setText("aaaaa");
//        t2.setLayoutParams(lp);

        layout.addView(t1,0,lp);
        layout.addView(t0,lp0);
        layout.addView(t2,-1,lp);
//        layout.setOnTouchListener();
        layout.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                if(first){
                    int pLeft = layout.getPaddingLeft();
					int pTop;
                    int pRight = layout.getPaddingRight();
					int pBottom;
                    t2.setHeight(layout.getHeight() / 5);
                    pBottom = - layout.getHeight() / 5;

                    t1.setHeight(layout.getHeight() / 5);
                    pTop = - layout.getHeight() / 5;

                    layout.setPadding(pLeft,pTop,pRight,pBottom);
                    first = false;
                }

            }
        });

    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
//        Log.i("test",ev + "" );
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN :
                InitailY = lastY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                lastY = event.getY();
                int scrollValue = (int) Math.round((lastY - InitailY) / 2.0);
                layout.scrollTo(0,- scrollValue);
                break;
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                layout.scrollTo(0,0);
                break;
        }
        return true;
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        Log.i("test",event.getAction() + "" );
//
//        switch (event.getAction()){
//            case MotionEvent.ACTION_DOWN :
//                InitailY = lastY = event.getY();
//                break;
//            case MotionEvent.ACTION_MOVE:
//                lastY = event.getY();
//                int scrollValue = (int) Math.round((InitailY - lastY) / 2.0);
//                layout.scrollTo(0, scrollValue);
//                break;
//            case MotionEvent.ACTION_CANCEL:
//            case MotionEvent.ACTION_UP:
//                layout.scrollTo(0,0);
//                break;
//        }
//        return true;
//    }
}
