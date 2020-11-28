package com.example.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.DialogPreference;
import android.preference.PreferenceManager;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MovieHall extends AppCompatActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    ListView lv;
    ArrayAdapter arrayAdapter;
    String[] info={"Bioscope","Inox","RDB","Carnival","PVR","Cinepolis"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_hall);
        preferences=PreferenceManager.getDefaultSharedPreferences(this);
        editor=preferences.edit();
        lv=findViewById(R.id.lv1);
        arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,info);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getApplicationContext(),MovieHall.class));
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.setting) {
            Toast.makeText(this,"settings clicked",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId()==R.id.logout) {
            getDialog();

        }
        return super.onOptionsItemSelected(item);
    }

    private void getDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Do you want to logout ??");
        alert.setCancelable(false);
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                editor.putString("username", " ");
                editor.commit();
                startActivity(new Intent(MovieHall.this, MainActivity.class));
                Toast.makeText(MovieHall.this, "LOGOUT", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        alert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alert.create();
        alert.show();
    }
}
