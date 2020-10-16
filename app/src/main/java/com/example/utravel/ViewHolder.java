package com.example.utravel;



import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.orhanobut.dialogplus.Holder;


public class ViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView title,name,phone,location,room,checkin,checkout;
    ImageButton edit,cancel;

    View view;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        //Hotels view holder
        imageView = itemView.findViewById(R.id.single_hotel);
        title = itemView.findViewById(R.id.title);
        view = itemView;


        //Booking view holder
        name = itemView.findViewById(R.id.myname);
        phone = itemView.findViewById(R.id.myphone);
        location = itemView.findViewById(R.id.mylocation);
        room = itemView.findViewById(R.id.myroom);
        checkin = itemView.findViewById(R.id.mycheckin);
        checkout = itemView.findViewById(R.id.mycheckout);
        edit = itemView.findViewById(R.id.update_btn);
        cancel = itemView.findViewById(R.id.cancel_btn);



    }

}
