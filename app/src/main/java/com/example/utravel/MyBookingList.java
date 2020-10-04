package com.example.utravel;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MyBookingList extends AppCompatActivity {


    RecyclerView recyclerView;
    FirebaseRecyclerOptions<UserDetail>options;
    FirebaseRecyclerAdapter<UserDetail,ViewHolder>adapter;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_booking_list);

        reference = FirebaseDatabase.getInstance().getReference().child("Booking");
        recyclerView = findViewById(R.id.myrecyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);

    LoadMyData();

    }

    private void  LoadMyData(){

        options = new FirebaseRecyclerOptions.Builder<UserDetail>().setQuery(reference,UserDetail.class).build();
        adapter = new FirebaseRecyclerAdapter<UserDetail, ViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull UserDetail model) {
                holder.name.setText(model.getName());
                holder.phone.setText(model.getPhone());
                holder.budget.setText(model.getBudget());
                holder.people.setText(model.getPeople());
                holder.room.setText(model.getRoom());
                holder.checkin.setText(model.getCheckin());
                holder.checkout.setText(model.getCheckout());
            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_booking_details,parent,false);
                return new ViewHolder(view);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

}