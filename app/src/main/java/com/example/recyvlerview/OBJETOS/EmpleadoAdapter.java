package com.example.recyvlerview.OBJETOS;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.recyvlerview.MODEL.Empleado;
import com.example.recyvlerview.R;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoAdapter extends RecyclerView.Adapter<EmpleadoAdapter.EmpleadoViewHolder> {
    private List<Empleado> items;

    public EmpleadoAdapter(List<Empleado> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public EmpleadoViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item, viewGroup, false);
        return new EmpleadoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(EmpleadoViewHolder viewHolder, int i) {
        //viewHolder);
        viewHolder.nombre.setText(items.get(i).getNombre());
        viewHolder.id.setText("IDENTIFICADOR:" + items.get(i).getId());
        viewHolder.labor.setText("labor:"+ items.get(i).getLabor());
    }

    public static class EmpleadoViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView id;
        public TextView nombre;
        public TextView labor;

        public EmpleadoViewHolder(View v) {
            super(v);
            id= (TextView) v.findViewById(R.id.id);
            nombre = (TextView) v.findViewById(R.id.nombre);
            labor= (TextView) v.findViewById(R.id.apellidos);
        }
    }

    public  void filterList(List<Empleado> filteritems){
        this.items=filteritems;
        notifyDataSetChanged();

    }












}




