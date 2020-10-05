package com.example.appmonsters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class CurrencyConverter extends AppCompatActivity {
    EditText Value;
    TextView USD,EUR, JPY, INR;
    Button convert;
    EditText OutputValue;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter_dashboard);

        Value = findViewById(R.id.Value);
        USD = findViewById(R.id.USD);
        EUR = findViewById(R.id.EUR);
        JPY = findViewById(R.id.JPY);
        INR = findViewById(R.id.INR);
        convert = findViewById(R.id.convert);
        OutputValue = findViewById(R.id.OutputValue);

        convert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (Value.getText().length() == 0){
                    Toast.makeText(CurrencyConverter.this, "Please Enter a Currency Value..!", Toast.LENGTH_SHORT).show();
                    return;
                }

                float inputValue = Float.parseFloat(Value.getText().toString());
            }
        });
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
            Intent intent = new Intent( CurrencyConverter.this, MainActivity.class);
            startActivity(intent);
        }

        /*else
        if(id==R.id.MyPackages){
            Intent intent = new Intent(ConverterDashboard.this, Dashboard.class);
            startActivity(intent);
        }*/

        return super.onOptionsItemSelected(item);
    }

    //Function to generate the USD Value
    public static double LkrtoUsd (float number){
        return (number * 0.0054);
    }

    //Function to generate the EUR Value
    public static double LkrtoEur (float number){
        return (number * 0.0046);
    }

    //Function to generate the JPY Value
    public static double LkrtoJpy (float number){
        return (number * 0.57);
    }

    //Function to generate the INR Value
    public static double LkrtoInr (float number){
        return (number * 0.40);
    }
}