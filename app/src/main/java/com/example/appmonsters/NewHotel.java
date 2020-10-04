package com.example.appmonsters;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;

public class NewHotel extends AppCompatActivity {
    EditText hotelName,location,hotelBudget,facility_1,facility_2,facility_3;
    Button hotelAdd,hotelShow,hotelUpdate,hotelDelete;
    DatabaseReference dbRef;
    Hotel hotel;

    public void clearControls(){
        hotelName.setText("");
        location.setText("");
        hotelBudget.setText("");
        facility_1.setText("");
        facility_2.setText("");
        facility_3.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_hotel);
        hotelName=(EditText)findViewById(R.id.editTextTextPersonName);
        location=(EditText)findViewById(R.id.editTextTextPersonName6);
       hotelBudget=(EditText)findViewById(R.id.editTextTextPersonName7);
        facility_1=(EditText)findViewById(R.id.editTextTextPersonName8);
        facility_2=(EditText)findViewById(R.id.editTextTextPersonName9);
        facility_3=(EditText)findViewById(R.id.editTextTextPersonName10);

        hotelAdd=(Button)findViewById(R.id.button14);
        hotelShow=(Button)findViewById(R.id.button20);
        hotelUpdate=(Button)findViewById(R.id.button25);
        hotelDelete=(Button)findViewById(R.id.button26);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.Home){
            Intent intent = new Intent(NewHotel.this,MainActivity.class);
            startActivity(intent);
        }

        else
        if(id==R.id.MyPackages){
            Intent intent = new Intent(NewHotel.this,Dashboard.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}