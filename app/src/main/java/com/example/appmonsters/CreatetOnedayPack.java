package com.example.appmonsters;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CreatetOnedayPack extends AppCompatActivity {
    EditText name, number, budget, destination;
    Button oneAdd, oneShow, oneUpdate, oneDelete;
    DatabaseReference dbRef;
    OneDayPackage onePack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createt_oneday_pack);

        name = (EditText) findViewById(R.id.editTextTextPersonName2);
        number = (EditText) findViewById(R.id.editTextTextPersonName3);
        budget = (EditText) findViewById(R.id.editTextTextPersonName4);
        destination = (EditText) findViewById(R.id.editTextTextPersonName5);

        oneAdd = (Button) findViewById(R.id.button10);

        oneShow = (Button) findViewById(R.id.button21);
        oneUpdate = (Button) findViewById(R.id.button22);
        oneDelete = (Button) findViewById(R.id.button23);
        onePack = new OneDayPackage();
//Add Details to database
        oneAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("OneDayPackage");

                try {
                    if (TextUtils.isEmpty(name.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Enter the name please..", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(number.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Enter the number of people please..", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(budget.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Enter the budget please..", Toast.LENGTH_SHORT).show();
                    else if (TextUtils.isEmpty(destination.getText().toString()))
                        Toast.makeText(getApplicationContext(), "Enter the destinations please..", Toast.LENGTH_SHORT).show();
                    else {

                        onePack.setName(name.getText().toString().trim());
                        onePack.setNum(Integer.parseInt(number.getText().toString().trim()));
                        onePack.setBudget(Integer.parseInt(budget.getText().toString().trim()));
                        onePack.setDestination(destination.getText().toString().trim());


                        //pass details into db
                        dbRef.push().setValue(onePack);

                        //feedback
                        Toast.makeText(getApplicationContext(), "Data Added Successfully", Toast.LENGTH_SHORT).show();
                        //clearControls();

                    }

                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(), "Invalid Budget", Toast.LENGTH_SHORT).show();
                }

            }


        });


//Read Details

        /*oneShow.setOnClickListener(new View.OnClickListener() {


                                       @Override
                                       public void onClick(View view) {
                                           DatabaseReference readRef = FirebaseDatabase.getInstance().getReference().child("OneDayPackage");
                                           readRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                               @Override
                                               public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                   if (dataSnapshot.hasChildren()) {
                                                       name.setText(dataSnapshot.child("name").getValue().toString());
                                                       number.setText(dataSnapshot.child("num").getValue().toString());
                                                       budget.setText(dataSnapshot.child("budget").getValue().toString());
                                                       destination.setText(dataSnapshot.child("destination").getValue().toString());

                                                   } else
                                                       Toast.makeText(getApplicationContext(), "No Source to Display", Toast.LENGTH_SHORT).show();
                                               }

                                               @Override
                                               public void onCancelled(@NonNull DatabaseError databaseError) {

                                               }
                                           });

                                          /* oneUpdate.setOnClickListener(new View.OnClickListener() {


                                               @Override
                                               public void onClick(View view) {
                                                   DatabaseReference upRef = FirebaseDatabase.getInstance().getReference().child("OneDayPackage");
                                                   upRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                                       @Override
                                                       public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                           if (dataSnapshot.hasChild("onePack")) {
                                                               try {
                                                                   onePack.setName(name.getText().toString().trim());
                                                                   onePack.setNum(Integer.parseInt(number.getText().toString().trim()));
                                                                   onePack.setBudget(Integer.parseInt(budget.getText().toString().trim()));
                                                                   onePack.setDestination(destination.getText().toString().trim());
                                                                   dbRef = FirebaseDatabase.getInstance().getReference().child("OneDayPackage");
                                                                   dbRef = setValue();
                                                                   clearControls();

                                                                   Toast.makeText(getApplicationContext(), "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                                                               } catch (NumberFormatException e) {
                                                                   Toast.makeText(getApplicationContext(), "Invalid Budget", Toast.LENGTH_SHORT).show();
                                                               }

                                                           } else {
                                                               Toast.makeText(getApplicationContext(), "No Source to Update", Toast.LENGTH_SHORT).show();
                                                           }
                                                       }

                                                       @Override
                                                       public void onCancelled(@NonNull DatabaseError databaseError) {

                                                       }
                                                   });
                                                   //Delete Details
                                                   oneDelete.setOnClickListener(new View.OnClickListener() {
                                                       @Override
                                                       public void onClick(View view) {
                                                           DatabaseReference delRef =FirebaseDatabase.getInstance().getReference().child("OneDayPackage");
                                                           delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                                                               @Override
                                                               public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                                   if (dataSnapshot.hasChild("onePack")) {
                                                                       dbRef = FirebaseDatabase.getInstance().getReference().child("OneDayPack").child("onePack");
                                                                       dbRef.removeValue();
                                                                       clearControls();
                                                                       Toast.makeText(getApplicationContext(), "Data Deleted Successfully", Toast.LENGTH_SHORT).show();
                                                                   } else
                                                                       Toast.makeText(getApplicationContext(), "No Source to Delete", Toast.LENGTH_SHORT).show();
                                                               }
                                                               @Override
                                                               public void onCancelled(@NonNull DatabaseError databaseError) {

                                                               }
                                                           });





                                                       }
                                                   });*/
                                               }


                                               public void clearControls() {

                                                   name.setText("");
                                                   number.setText("");
                                                   budget.setText("");
                                                   destination.setText("");

                                               }
                                           //});
                                      // }
                                  // }
        //);
   // }
    //Menu bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.Home){
            Intent intent = new Intent(CreatetOnedayPack.this,MainActivity.class);
            startActivity(intent);
        }

        else
        if(id==R.id.MyPackages){
            Intent intent = new Intent(CreatetOnedayPack.this,Dashboard.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}






