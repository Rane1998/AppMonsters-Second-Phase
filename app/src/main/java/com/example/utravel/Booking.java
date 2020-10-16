package com.example.utravel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;

public class Booking extends AppCompatActivity {
    ArrayList<String> selection  = new ArrayList<String>();

    private static final String TAG  = "Booking";
    private EditText mcusName,mphone,mcheckin,mcheckout,mlocation;
    private CheckBox mac,mnonAc;
    private Button mshowdetail;
    private DatePickerDialog.OnDateSetListener dateSetListener;
    private DatePickerDialog.OnDateSetListener dateSetListener1;
    FirebaseDatabase database;
    DatabaseReference reference;
    int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);



        mcusName = findViewById(R.id.cusName);
        mphone = findViewById(R.id.phone);
        mac = findViewById(R.id.ac);
        mnonAc = findViewById(R.id.nonac);
        mcheckin = findViewById(R.id.checkin);
        mcheckout =  findViewById(R.id.checkout);
        mlocation = findViewById(R.id.location);

        mshowdetail = findViewById(R.id.showdetail);
        final UserDetail userDetail = new UserDetail();

        reference = database.getInstance().getReference().child("Booking");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    i = (int)snapshot.getChildrenCount();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        mshowdetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = mcusName.getText().toString();
                String phone = mphone.getText().toString();
                String location = mlocation.getText().toString();
                String ac = mac.getText().toString();
                String nonAc = mnonAc.getText().toString();
                String checkin = mcheckin.getText().toString();
                String checkout = mcheckout.getText().toString();
                boolean istrue;

                if(TextUtils.isEmpty(name)){
                    mcusName.setError("Enter the customer name!");
                    return;
                }
                else if(TextUtils.isEmpty(phone)){
                    mphone.setError("Enter the phone number!");
                    return;

                }
                else if(TextUtils.isEmpty(phone)){
                    mlocation.setError("Enter the location!");
                    return;

                }
                else if(TextUtils.isEmpty(ac)&&(TextUtils.isEmpty(nonAc))){
                    if(TextUtils.isEmpty(ac)){
                        mac.setError("Enter the room category!");
                    }
                    else if(TextUtils.isEmpty(nonAc)){
                        mnonAc.setError("Enter the room category!");
                    }

                }
                else if (TextUtils.isEmpty(checkin)){
                    mcheckin.setError("Enter the checking date!");
                    return;

                }
                else if(TextUtils.isEmpty(checkout)){
                    mcheckout.setError("Enter the checkout date!");
                    return;

                }
                else if((phone.length() < 10)) {
                    mphone.setError("Enter  valid phone number!");
                    return;
                }

                userDetail.setName(mcusName.getText().toString());
                userDetail.setPhone(mphone.getText().toString());
                userDetail.setLocation(mlocation.getText().toString());
                userDetail.setCheckin(mcheckin.getText().toString());
                userDetail.setCheckout(mcheckout.getText().toString());
                reference.child(String.valueOf(i + 1)).setValue(userDetail);

                if(mac.isChecked()){
                    userDetail.setRoom(ac);
                    reference.child(String.valueOf(i + 1)).setValue(userDetail);

                }else{
                    userDetail.setRoom(nonAc);
                    reference.child(String.valueOf(i + 1)).setValue(userDetail);
                }


                Intent intent = new Intent(Booking.this,MainActivity.class);
                startActivity(intent);
                Toast toast=Toast.makeText(getApplicationContext(),"Successful..",Toast.LENGTH_SHORT);
                toast.show();



            }

        });
        mcheckin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Booking.this,
                        android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                        dateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG,"onDateSet: mm/dd/yyyy" + month + "/" + day +"/" + year);
                String date1 = month + "/" + day +"/" + year;
                mcheckin.setText(date1);
            }
        };
        mcheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        Booking.this,
                        android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                        dateSetListener1,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dateSetListener1 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG,"onDateSet: mm/dd/yyyy" + month + "/" + day +"/" + year);
                String date = month + "/" + day +"/" + year;
                mcheckout.setText(date);
            }
        };
    }


}