package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Rate extends AppCompatActivity {

    RatingBar rate;
    Button btn;
    float r;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate);
        rate=findViewById(R.id.rating);
        btn=findViewById(R.id.btn);
        tv=findViewById(R.id.show);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                r=rate.getRating();
                tv.setText("RATING is:"+String.valueOf(r));
            }
        });
    }
}
