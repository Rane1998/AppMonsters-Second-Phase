package com.example.appmonsters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TravellerRegistrationForm extends AppCompatActivity {

    TextView FullName, BirthOfDate, TelNo, Address, Email, VerifyEmail, EmgName, EmgNo;
    EditText FullNameAnswer, BirthOfDateAnswer, TelNoAnswer, EmailAnswer, VerifyEmailAnswer, EmgNameAnswer, EmgNoAnswer;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traveller_registration_form);

        FullName = findViewById(R.id.FullName);
        BirthOfDate = findViewById(R.id.BirthOfDate);
        TelNo = findViewById(R.id.TelNo);
        Address = findViewById(R.id.Address);
        Email = findViewById(R.id.Email);
        VerifyEmail = findViewById(R.id.VerifyEmail);
        EmgName = findViewById(R.id.EmgName);
        EmgNo = findViewById(R.id.EmgNo);
        FullNameAnswer = findViewById(R.id.FullNameAnswer);
        BirthOfDateAnswer = findViewById(R.id.BirthOfDateAnswer);
        TelNoAnswer = findViewById(R.id.TellNoAnswer);
        EmailAnswer = findViewById(R.id.EmailAnswer);
        VerifyEmailAnswer = findViewById(R.id.VerifyEmailAnswer);
        EmgNameAnswer = findViewById(R.id.EmgNameAnswer);
        EmgNoAnswer = findViewById(R.id.EmgNoAnswer);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (FullNameAnswer.getText().length() == 0) {
                    Toast.makeText(TravellerRegistrationForm.this, "Please Fill Mandatory Fields...!", Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });

    }

}