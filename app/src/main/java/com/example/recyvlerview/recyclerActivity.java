package com.example.recyvlerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.recyvlerview.OBJETOS.FirebaseReference;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class recyclerActivity extends AppCompatActivity {
    private  ValueEventListener eventListener;
    private DatabaseReference db;

            RecyclerView rvLista;
            List<Pedido> listapedidos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);



        rvLista=(RecyclerView)findViewById(R.id.rvLista);
        LinearLayoutManager lm = new   LinearLayoutManager (this);
        rvLista.setLayoutManager(lm);
        rvLista.setHasFixedSize(true);



        listapedidos   = new ArrayList<>();
       /// aqui referencia





        final  RVAdapter adapter = new RVAdapter(listapedidos);
        rvLista.setAdapter(adapter);


     db=(DatabaseReference)FirebaseDatabase.getInstance().getReference().child(FirebaseReference.PEDIDOS_REFERENCE);

     eventListener=new ValueEventListener() {


         @Override
         public void onDataChange(DataSnapshot datasnapshot) {


             listapedidos.removeAll(listapedidos);
             for (DataSnapshot snapshot1 :
                     datasnapshot.getChildren()) {

                 Pedido ped = new Pedido();
                         ped= snapshot1.getValue(Pedido.class);


                 listapedidos.add(ped);



                 }
                 adapter.notifyDataSetChanged();

             }

             @Override
             public void onCancelled (@NonNull DatabaseError error){
                 Log.e("ERROR", error.getMessage());
             }
         };

     db.addValueEventListener(eventListener);





    }









}