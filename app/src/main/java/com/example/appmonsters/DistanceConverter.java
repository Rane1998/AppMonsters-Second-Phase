package com.example.appmonsters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class DistanceConverter extends AppCompatActivity {
    Button btnConvert;
    EditText input,answer;
    RadioButton convertMeter,convertYards,convertMiles,convertFeet;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distance_converter);
btnConvert=(Button)findViewById(R.id.button15);
input=(EditText)findViewById(R.id.editTextTextPersonName11);
        answer=(EditText)findViewById(R.id.editTextTextPersonName12);
        convertMeter=(RadioButton)findViewById(R.id.radioButton);
        convertYards=(RadioButton)findViewById(R.id.radioButton2);
        convertMiles=(RadioButton)findViewById(R.id.radioButton3);
        convertFeet=(RadioButton)findViewById(R.id.radioButton4);

btnConvert.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if (input.getText().length() == 0) {

            Toast.makeText(getApplicationContext(),"Please Enter a Number",Toast.LENGTH_SHORT).show();
            return;
        }
        float inputValue = Float.parseFloat(input.getText().toString());
        if(convertMeter.isChecked()) {
            answer.setText("Result :" + (convertToMeters(inputValue)) + "m");
            convertMeter.setChecked(true);
            convertYards.setChecked(false);
            convertMiles.setChecked(false);
            convertFeet.setChecked(false);

        }

        else if (convertYards.isChecked()) {
            answer.setText("Result :" + (convertToYards(inputValue)) + " yards");
            convertMeter.setChecked(false);
            convertYards.setChecked(true);
            convertMiles.setChecked(false);
            convertFeet.setChecked(false);

        }
          else if (convertMiles.isChecked()) {
            answer.setText("Result :" + (convertToMiles(inputValue)) + " miles");
            convertMeter.setChecked(false);
            convertYards.setChecked(false);
            convertMiles.setChecked(true);
            convertFeet.setChecked(false);

        }
        else if (convertFeet.isChecked()) {
            answer.setText("Result :" + (convertToFeet(inputValue)) + " feet");
            convertMeter.setChecked(false);
            convertYards.setChecked(false);
            convertMiles.setChecked(false);
            convertFeet.setChecked(true);

        }
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
            Intent intent = new Intent(DistanceConverter.this,MainActivity.class);
            startActivity(intent);
        }

        else
        if(id==R.id.MyPackages){
            Intent intent = new Intent(DistanceConverter.this,Dashboard.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    //Meter converter function
    public static float convertToMeters(float number)
    {
        return (number*1000);
    }
    //Yards converter function
    public static float convertToYards(float number)
    {
        return (float) (number*1093.61);
    }
    //Miles converter function
    public static float convertToMiles(float number)
    {
        return (float) (number/1.609);
    }
    //Feet converter function
    public static float convertToFeet(float number)
    {
        return (float) (number*3280.84);
    }


}