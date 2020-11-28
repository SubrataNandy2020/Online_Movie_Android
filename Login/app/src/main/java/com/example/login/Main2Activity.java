package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Main2Activity extends AppCompatActivity {
    private EditText e1,e2,e3,e4;
    private Button b2,b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        e1=findViewById(R.id.name);
        e2=findViewById(R.id.email);
        e3=findViewById(R.id.mob);
        e4=findViewById(R.id.password);
        b1=findViewById(R.id.btn);
        b2=findViewById(R.id.bt1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==b1){
                    register();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Main2Activity.this,MainActivity.class));
                Toast.makeText(getApplicationContext(),"GOING TO LOGIN",Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void register(){
        final String name=e1.getText().toString().trim();
        final String email=e2.getText().toString().trim();
        final String mob=e3.getText().toString().trim();
        final String password=e4.getText().toString().trim();

        StringRequest stq=new StringRequest(Request.Method.POST, Constant.Root_UrL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.equals("1"))
                {
                    Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_SHORT).show();
                }
                else if (response.equals("2")){
                    Toast.makeText(getApplicationContext(),"Applied",Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error.equals("0"))
                {
                    Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_SHORT).show();
                }
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params= new HashMap<>();
                params.put("uName",name);
                params.put("uEmail",email);
                params.put("uMobile",mob);
                params.put("uPassword",password);
                return params;

            }
        };
        RequestQueue requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(stq);

    }
}
