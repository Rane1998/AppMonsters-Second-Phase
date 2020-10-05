package com.example.appmonsters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ConverterDashboard extends AppCompatActivity {

    Button currencyConverter, temperatureConverter, massConverter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_dashboard);

        //link to currency converter
        /*currencyConverter = (Button) findViewById(R.id.currencyConverter);
        currencyConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ConverterDashboard.this.ConverterCurrency();
            }
        });*/
    }

    //menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id== R.id.Home){
            Intent intent = new Intent( ConverterDashboard.this, MainActivity.class);
            startActivity(intent);
        }

        /*else
        if(id==R.id.MyPackages){
            Intent intent = new Intent(ConverterDashboard.this, Dashboard.class);
            startActivity(intent);
        }*/

        return super.onOptionsItemSelected(item);
    }

    /*private void ConverterCurrency() {
        Intent intent = new Intent(this, CurrencyConverter.class);
        startActivity(intent);
    }*/

    private void TempConverter(){
        Intent intent = new Intent(this, TempConverter.class);
        startActivity(intent);
    }

}