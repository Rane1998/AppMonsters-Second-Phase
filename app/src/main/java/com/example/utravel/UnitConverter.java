package com.example.utravel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UnitConverter extends AppCompatActivity {

    EditText mkilo;
    TextView textView2,textView3,mvalue;
    Button mconvertBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_converter);



        textView3 = findViewById(R.id.textView3);
        mvalue = findViewById(R.id.value);

        mkilo = findViewById(R.id.kilo);

        mconvertBtn = findViewById(R.id.convertBtn);

        mconvertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertFormKiloToPound(mvalue);
            }
        });


    }

    public void convertFormKiloToPound(TextView input) {

        String valueKilo = mkilo.getText().toString();
        double kilo = Double.parseDouble(valueKilo);

        double pounds =   kilo * 2.205;
        mvalue.setText(""+pounds);
    }
}