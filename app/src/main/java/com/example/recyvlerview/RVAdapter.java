package com.example.recyvlerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<PersonaViewHolder> {
    List<Persona> personas;
    RVAdapter(List<Persona> personas){
    this.personas =personas;
    }
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_player,parent ,
                false);

        PersonaViewHolder pvh = new PersonaViewHolder(vista);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {



        holder.txtNombre.setText(personas.get(position).getNombre());
        holder.txtAnio.setText(personas.get(position).getAnio());
        holder.txtdescrip.setText(personas.get(position).getDescripcion());
  //  holder.imgFoto.setImageResource(personas.get(position).getFotoID());

    }

    @Override
    public int getItemCount() {
        return personas.size();

    }
}

