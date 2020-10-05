package com.example.appmonsters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.CaseMap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appmonsters.R;
import com.example.appmonsters.Review;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ReviewManagementBackend extends AppCompatActivity {

    TextView title, Review, nickname, Email;
    EditText titleAnswer, reviewAnswer, nicknameAnswer, emailAnswer;
    Button btnCreate, btnUpdate, btnDelete, btnShow;
    DatabaseReference dbRef;
    com.example.appmonsters.Review rev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_management_backend);

        title = findViewById(R.id.title);
        Review = findViewById(R.id.Review);
        nickname = findViewById(R.id.nickname);
        Email = findViewById(R.id.Email);
        titleAnswer = findViewById(R.id.titleAnswer);
        reviewAnswer = findViewById(R.id.reviewAnswer);
        nicknameAnswer = findViewById(R.id.nicknameAnswer);
        emailAnswer = findViewById(R.id.emailAnswer);
        btnCreate = findViewById(R.id.btnCreate);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnDelete = findViewById(R.id.btnDelete);
        btnShow = findViewById(R.id.btnShow);

        rev = new Review();

        //CREATE
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Review");

                try {
                    if (TextUtils.isEmpty(titleAnswer.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Title", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(reviewAnswer.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Review", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(nicknameAnswer.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Nickname", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(emailAnswer.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Please Enter Email Address", Toast.LENGTH_SHORT).show();

                    else {
                        //Take inputs from the user and assigning them to this instance (rev) of the Review
                        rev.setTitleAnswer(titleAnswer.getText().toString().trim());
                        rev.setReviewAnswer(reviewAnswer.getText().toString().trim());
                        rev.setNicknameAnswer(nicknameAnswer.getText().toString().trim());
                        rev.setEmailAnswer(emailAnswer.getText().toString().trim());
                        //insert into the database...
                        dbRef.push().setValue(rev);
                        dbRef.child("Review1").setValue(rev);
                        //Feedback to the user via Toast..
                        Toast.makeText(getApplicationContext(), "Review Submitted", Toast.LENGTH_SHORT).show();
                        clearControls();
                    }
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid Data", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //SHOW
        DatabaseReference readRef =FirebaseDatabase.getInstance().getReference().child("Review").child("Review1");
        readRef.addListenerForSingleValueEvent(new ValueEventListener(){
            @Override
            public void onDataChange(@NonNull  DataSnapshot dataSnapshot){
                if (dataSnapshot.hasChildren()){
                    titleAnswer.setText(dataSnapshot.child("Title").getValue().toString());
                    reviewAnswer.setText(dataSnapshot.child("Review").getValue().toString());
                    nicknameAnswer.setText(dataSnapshot.child("Nickname").getValue().toString());
                    emailAnswer.setText(dataSnapshot.child("Email").getValue().toString());
                }
                else
                    Toast.makeText(getApplicationContext(), "Haven't Display", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError){

            }
        });

        //UPDATE
        DatabaseReference updRef = FirebaseDatabase.getInstance().getReference().child("Review");
        updRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.hasChild("Rev1")){
                    try {
                        rev.setTitleAnswer(titleAnswer.getText().toString().trim());
                        rev.setReviewAnswer(reviewAnswer.getText().toString().trim());
                        rev.setNicknameAnswer(nicknameAnswer.getText().toString().trim());
                        rev.setEmailAnswer(emailAnswer.getText().toString().trim());

                        dbRef = FirebaseDatabase.getInstance().getReference().child("Rev1");
                        dbRef.setValue(rev);
                        clearControls();
                        //Feedback to the user via Toast..
                        Toast.makeText(getApplicationContext(), "Review Updated", Toast.LENGTH_SHORT).show();
                    }
                    catch (NumberFormatException e) {
                        Toast.makeText(getApplicationContext(), "Invalid Data", Toast.LENGTH_SHORT).show();
                    }
                }

                else
                    Toast.makeText(getApplicationContext(), "No Source to Update", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //DELETE
        DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("Review1");
        delRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild("Review1")){
                    dbRef = FirebaseDatabase.getInstance().getReference().child("Review").child("Review1");
                    dbRef.removeValue();
                    clearControls();
                    Toast.makeText(getApplicationContext(), "Deleted Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(getApplicationContext(), "Haven't Deleted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

    //method to clear all user inputs
    private void clearControls(){
        titleAnswer.setText("");
        reviewAnswer.setText("");
        nicknameAnswer.setText("");
        emailAnswer.setText("");
    }


}