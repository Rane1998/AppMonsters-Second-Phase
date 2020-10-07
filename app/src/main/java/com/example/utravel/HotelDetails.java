package com.example.utravel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class   HotelDetails extends AppCompatActivity{

    private ImageView imageView;
    private TextView textView;
    private Button book;





    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);

        imageView = findViewById(R.id.hotel_details);
        textView = findViewById(R.id.hotel_name);
        book = findViewById(R.id.book_now);
        databaseReference = FirebaseDatabase.getInstance().getReference("Hotels");



        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HotelDetails.this, Payment.class);
                startActivity(intent);

            }
        });




        final String Title = getIntent().getStringExtra("Title");
        databaseReference.child(Title).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String title = snapshot.child("Title").getValue().toString();
                    String image = snapshot.child("image").getValue().toString();

                    Picasso.get().load(image).into(imageView);
                    textView.setText(title);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }

}