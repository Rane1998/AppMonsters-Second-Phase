package com.example.utravel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.orhanobut.dialogplus.DialogPlus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBooking extends AppCompatActivity {


    RecyclerView recyclerView;
    FirebaseRecyclerOptions<UserDetail> options;
    FirebaseRecyclerAdapter<UserDetail,ViewHolder> adapter;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_booking);

        databaseReference = FirebaseDatabase.getInstance().getReference("Booking");
        recyclerView = findViewById(R.id.booking_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setHasFixedSize(true);

       LoadMyData();

    }

    private void LoadMyData(){
        
        options = new FirebaseRecyclerOptions.Builder<UserDetail>().setQuery(databaseReference,UserDetail.class).build();
        adapter  = new FirebaseRecyclerAdapter<UserDetail, ViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final ViewHolder holder, final int position, @NonNull final UserDetail model) {

                holder.name.setText(model.getName());
                holder.phone.setText(model.getPhone());
                holder.budget.setText(model.getBudget());
                holder.people.setText(model.getPeople());
                holder.room.setText(model.getRoom());
                holder.checkin.setText(model.getCheckin());
                holder.checkout.setText(model.getCheckout());

                holder.edit.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        final DialogPlus dialogPlus = DialogPlus.newDialog(holder.phone.getContext())
                                        .setContentHolder(new com.orhanobut.dialogplus.ViewHolder(R.layout.update_dialog))
                                        .setExpanded(true,1100)
                                        .create();



                        View myview=dialogPlus.getHolderView();

                        final EditText name = myview.findViewById(R.id.cus_name);
                        final EditText phone = myview.findViewById(R.id.cus_phone);
                        final EditText budget = myview.findViewById(R.id.cus_budget);
                        final EditText people = myview.findViewById(R.id.cus_people);
                        final EditText checkin = myview.findViewById(R.id.cus_checkin);
                        final EditText checkout = myview.findViewById(R.id.cus_checkout);
                        Button submit = myview.findViewById(R.id.update_button);


                        name.setText(model.getName());
                        phone.setText(model.getPhone());
                        budget.setText(model.getBudget());
                        people.setText(model.getPeople());
                        checkin.setText(model.getCheckin());
                        checkout.setText(model.getCheckout());

                        dialogPlus.show();

                        submit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Map<String,Object>map = new HashMap<>();
                                map.put("name",name.getText().toString());
                                map.put("phone",phone.getText().toString());
                                map.put("budget",budget.getText().toString());
                                map.put("people",people.getText().toString());
                                map.put("checkin",checkin.getText().toString());
                                map.put("checkout",checkout.getText().toString());

                                FirebaseDatabase.getInstance().getReference().child("Booking")
                                        .child(getRef(position).getKey()).updateChildren(map)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void aVoid) {
                                                dialogPlus.dismiss();
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                dialogPlus.dismiss();
                                            }
                                        });

                            }
                        });




                    }
                });
                holder.cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(holder.phone.getContext());
                        builder.setTitle("Cancel Panel!");
                        builder.setMessage("Are you sure that you want to cancel this package!");

                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                FirebaseDatabase.getInstance().getReference().child("Booking")
                                        .child(getRef(position).getKey()).removeValue();
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        builder.show();
                    }
                });


            }//End Of OnBindView Method

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_booking,parent,false);
                return new ViewHolder(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}