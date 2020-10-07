package com.example.utravel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UnitConverter extends AppCompatActivity {

    EditText mkilo;
    TextView mvalue;
    Button mconvertBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);




        mvalue = findViewById(R.id.value);

        mkilo = findViewById(R.id.kilo);

        mconvertBtn = findViewById(R.id.convertBtn);


        mconvertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(mkilo.getText().length()==0) {
                        Toast.makeText(getApplicationContext(),"Please Enter a number",Toast.LENGTH_SHORT).show();
                        return;
                    }

                float kilo = Float.parseFloat(mkilo.getText().toString());

                        mvalue.setText(String.valueOf(convertKiloToPounds(kilo))+"lb");

                    }
        });


    }
    public static float convertKiloToPounds(float number) {
                    return (float) (number * 2.20462);
    }

}