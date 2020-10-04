package com.example.appmonsters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ConverterDashboard extends AppCompatActivity {
    Button currency,temp,distance,mass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_dashboard);
        //link distance converter
        distance=(Button)findViewById(R.id.button18);
       distance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConverterDistance();
            }
        });
    }
    //Menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.Home){
            Intent intent = new Intent(ConverterDashboard.this,MainActivity.class);
            startActivity(intent);
        }

        else
        if(id==R.id.MyPackages){
            Intent intent = new Intent(ConverterDashboard.this,Dashboard.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void ConverterDistance(){
        Intent intent = new Intent(this,DistanceConverter.class);
        startActivity(intent);

    }

}