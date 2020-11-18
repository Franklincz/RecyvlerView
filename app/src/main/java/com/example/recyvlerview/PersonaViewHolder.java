package com.example.recyvlerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PersonaViewHolder extends RecyclerView.ViewHolder {

    TextView txtNombre;
    TextView txtAnio;
  TextView txtdescrip;
  //  ImageView imgFoto;




    public PersonaViewHolder(@NonNull View itemView) {


        super(itemView);

        txtNombre = itemView.findViewById(R.id.txtnombre);
        txtAnio=itemView.findViewById(R.id.txtanio);
      //  imgFoto = itemView.findViewById(R.id.imgfoto);
        txtdescrip=itemView.findViewById(R.id.txtdescripcion);




    }
}
