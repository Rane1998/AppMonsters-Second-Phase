package com.example.utravel;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView title;
    TextView name,phone,budget,people,room,checkin,checkout;
    View view;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.single_hotel);
        title = itemView.findViewById(R.id.title);
        view = itemView;
        name = itemView.findViewById(R.id.myname);
        phone = itemView.findViewById(R.id.myphone);
        budget = itemView.findViewById(R.id.mybudget);
        people = itemView.findViewById(R.id.mypeople);
        room = itemView.findViewById(R.id.myroom);
        checkin = itemView.findViewById(R.id.mycheckin);
        checkout = itemView.findViewById(R.id.mycheckout);



    }
}
