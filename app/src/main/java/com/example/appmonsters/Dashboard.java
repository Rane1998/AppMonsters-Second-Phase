package com.example.appmonsters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {
    Button btn1,btn2,btn3,btn4,btn5,btn6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        //link button 1
        btn1=(Button)findViewById(R.id.button7);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCreateOneDayPack();
            }
        });
        //link button 2

        //link button 3
        btn3=(Button)findViewById(R.id.button12);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewHotel();
            }
        });

        //link button 4

        // link button  5

        // link button 6

    }
    public void openCreateOneDayPack(){
        Intent intent = new Intent(this,CreatetOnedayPack.class);
        startActivity(intent);

    }
    public void openNewHotel(){
        Intent intent = new Intent(this,NewHotel.class);
        startActivity(intent);

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
            Intent intent = new Intent(Dashboard.this,MainActivity.class);
            startActivity(intent);
        }

        else
        if(id==R.id.MyPackages){
            Intent intent = new Intent(Dashboard.this,Dashboard.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}