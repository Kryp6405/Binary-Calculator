package com.example.binarycalc1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button z, o, p, e, c;
    TextView t;
    Switch s;
    LinearLayout l;
    int i1, i2, count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        z = findViewById(R.id.button);
        o = findViewById(R.id.button2);
        p = findViewById(R.id.button3);
        e = findViewById(R.id.button4);
        c = findViewById(R.id.button5);
        t = findViewById(R.id.textView);
        s = findViewById(R.id.switch1);
        l = findViewById(R.id.linLay);
        i1 = 0;
        i2 = 0;
        count = 0;

        l.setBackgroundColor(Color.WHITE);
        t.setTextColor(Color.BLACK);
        s.setTextColor(Color.BLACK);
        z.setBackgroundColor(Color.rgb(76,76,76));
        o.setBackgroundColor(Color.rgb(76,76,76));
        p.setBackgroundColor(Color.rgb(255,165,0));
        c.setBackgroundColor(Color.rgb(130,130,130));
        e.setBackgroundColor(Color.rgb(130,130,130));
        z.setTextColor(Color.WHITE);
        o.setTextColor(Color.WHITE);
        p.setTextColor(Color.WHITE);
        c.setTextColor(Color.WHITE);
        e.setTextColor(Color.WHITE);

        s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    l.setBackgroundColor(Color.BLACK);
                    t.setTextColor(Color.WHITE);
                    s.setTextColor(Color.WHITE);
                    z.setBackgroundColor(Color.rgb(230,230,230));
                    o.setBackgroundColor(Color.rgb(230,230,230));
                    p.setBackgroundColor(Color.rgb(0,255,255));
                    c.setBackgroundColor(Color.rgb(169,169,169));
                    e.setBackgroundColor(Color.rgb(169,169,169));
                    z.setTextColor(Color.BLACK);
                    o.setTextColor(Color.BLACK);
                    p.setTextColor(Color.BLACK);
                    c.setTextColor(Color.BLACK);
                    e.setTextColor(Color.BLACK);
                }
                else{
                    l.setBackgroundColor(Color.WHITE);
                    t.setTextColor(Color.BLACK);
                    s.setTextColor(Color.BLACK);
                    z.setBackgroundColor(Color.rgb(76,76,76));
                    o.setBackgroundColor(Color.rgb(76,76,76));
                    p.setBackgroundColor(Color.rgb(255,165,0));
                    c.setBackgroundColor(Color.rgb(130,130,130));
                    e.setBackgroundColor(Color.rgb(130,130,130));
                    z.setTextColor(Color.WHITE);
                    o.setTextColor(Color.WHITE);
                    p.setTextColor(Color.WHITE);
                    c.setTextColor(Color.WHITE);
                    e.setTextColor(Color.WHITE);
                }
            }
        });
    }

    public void print(View view) {
        if (count < 8) {
            if (t.getText().toString().equals(""))
                t.setText(((Button) view).getText());
            else
                t.append(((Button) view).getText());
        }
        else{
            z.setEnabled(false);
            o.setEnabled(false);
        }
        count++;
    }

    public void add(View view){
        i1 = Integer.parseInt(t.getText().toString());
        t.setText("");
        z.setEnabled(true);
        o.setEnabled(true);
        count = 0;
    }

    public void clear(View view){
        t.setText("");
        z.setEnabled(true);
        o.setEnabled(true);
        count = 0;
        i1 = 0;
        i2 = 0;
    }

    public void equal(View view){
        ArrayList<Integer> a = new ArrayList<Integer>();
        int r = 0;
        String result = "";
        i2 = Integer.parseInt(t.getText().toString());
        while (i1 != 0 || i2 != 0) {
            a.add((int)((i1 % 10 + i2 % 10 + r) % 2));
            r = (int)((i1 % 10 + i2 % 10 + r) / 2);
            i1 = i1 / 10;
            i2 = i2 / 10;
        }
        if (r != 0) {
            a.add(r);
        }
        for(int i = a.size()-1; i >= 0; i--){
            result += String.valueOf(a.get(i));
        }
        t.setText(result);
    }
}