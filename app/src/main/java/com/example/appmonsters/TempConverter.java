package com.example.appmonsters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmonsters.R;

public class TempConverter extends AppCompatActivity {

    EditText Value;
    RadioButton Celcius , Farenheit;
    TextView txtResult;
    Button btnConvert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_converter);

        Value = findViewById(R.id.Value);
        Celcius = findViewById(R.id.Celcius);
        Farenheit = findViewById(R.id.Farenheit);
        btnConvert = findViewById(R.id.btnConvert);
        txtResult = findViewById(R.id.txtResult);

        btnConvert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (Value.getText().length() == 0){
                    Toast.makeText( TempConverter.this, "Please Enter a Value..!", Toast.LENGTH_SHORT).show();
                    return;
                }

                float inputValue = Float.parseFloat(Value.getText().toString());

                //To generate the Temp Value
                if(Celcius.isChecked()){
                    txtResult.setText(String.valueOf(converttoCelcius(inputValue)));
                    Celcius.setChecked(true);
                    Farenheit.setChecked(false);
                }
                else{
                    txtResult.setText(String.valueOf(converttoFarenheit(inputValue)));
                    Farenheit.setChecked(true);
                    Celcius.setChecked(false);
                }

            }
        });
    }

    //Function to generate the Celcius Value
    public static float converttoCelcius (float number){
        return ((number - 32) * 5 / 9);
    }

    //Function to generate the Farenheit Value
    public static float converttoFarenheit (float number){
        return ((number * 9) / 5 + 32);
    }
}
