package com.example.appmonsters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class Explore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);



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
            Intent intent = new Intent(Explore.this,MainActivity.class);
            startActivity(intent);
        }

        else
        if(id==R.id.MyPackages){
            Intent intent = new Intent(Explore.this,Dashboard.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}