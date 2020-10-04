package com.example.appmonsters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    Button tripPlanner,explore,converter,schedule,tips,map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      converter=(Button)findViewById(R.id.button2);
        converter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openConverter();
            }
        });
       explore=(Button)findViewById(R.id.button4);
        explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openExplore();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.Home){
            Intent intent = new Intent(MainActivity.this,MainActivity.class);
                    startActivity(intent);
        }

        else
        if(id==R.id.MyPackages){
            Intent intent = new Intent(MainActivity.this,Dashboard.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
    public void openConverter(){
        Intent intent = new Intent(this,ConverterDashboard.class);
        startActivity(intent);

    }
    public void openExplore(){
        Intent intent = new Intent(this,Explore.class);
        startActivity(intent);

    }
}