package com.example.appmonsters;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Review_Management extends AppCompatActivity {

    TextView rating, title, Review, nickname, Email;
    EditText titleAnswer, reviewAnswer, nicknameAnswer, emailAnswer;
    CheckBox agree, emailReceive;
    Button btnPostReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review__management);

        rating = findViewById(R.id.rating);
        title = findViewById(R.id.title);
        Review = findViewById(R.id.Review);
        nickname = findViewById(R.id.nickname);
        Email = findViewById(R.id.Email);
        titleAnswer = findViewById(R.id.titleAnswer);
        reviewAnswer = findViewById(R.id.reviewAnswer);
        nicknameAnswer = findViewById(R.id.nicknameAnswer);
        emailAnswer = findViewById(R.id.emailAnswer);
        btnPostReview = findViewById(R.id.btnPostReview);

        agree = (CheckBox)findViewById(R.id.agree);
        emailReceive = (CheckBox)findViewById(R.id.emailRecieve);

        btnPostReview.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (Review.getText().length() == 0) {
                    Toast.makeText(Review_Management.this, "Please fill Mandatory fields...!", Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                    if (nickname.getText().length() == 0){
                        Toast.makeText(Review_Management.this, "Please fill Mandatory fields...!", Toast.LENGTH_SHORT).show();
                    }
            }
        });



    }
}