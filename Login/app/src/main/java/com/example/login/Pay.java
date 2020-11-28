package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import com.braintreepayments.cardform.view.CardForm;
//import com.craftman.cardform.CardForm;

import java.util.jar.Attributes;

public class Pay extends AppCompatActivity {

   // CardForm cardForm;
   // TextView txtDes;
    Button btnPay;
    EditText ed1,ed2,ed3,ed4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
     //   cardForm=findViewById(R.id.card_name);
     //   txtDes=findViewById(R.id.payment_amount);
        btnPay=findViewById(R.id.btn_pay);
        ed1=findViewById(R.id.payname);
        ed2=findViewById(R.id.card_number);
        ed3=findViewById(R.id.exp);
        ed4=findViewById(R.id.cvv);
   //     btnPay.setText(String.format("payer %s",txtDes.getText()));

        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Pay Successful",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),Rate.class));

            }
        });
    }
}
