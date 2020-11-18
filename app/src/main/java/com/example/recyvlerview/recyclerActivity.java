package com.example.recyvlerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

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
            List<Persona> listapersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        rvLista=(RecyclerView)findViewById(R.id.rvLista);
        LinearLayoutManager lm = new   LinearLayoutManager (this);
        rvLista.setLayoutManager(lm);
        rvLista.setHasFixedSize(true);



        listapersonas   = new ArrayList<>();
       /// aqui referencia





      final  RVAdapter adapter = new RVAdapter(listapersonas);
        rvLista.setAdapter(adapter);


     db=(DatabaseReference)FirebaseDatabase.getInstance().getReference().child(FirebaseReference.PERSONA_REFERENCE);

     eventListener=new ValueEventListener() {


         @Override
         public void onDataChange(DataSnapshot datasnapshot) {


             listapersonas.removeAll(listapersonas);
             for (DataSnapshot snapshot1 :
                     datasnapshot.getChildren()) {

                 Persona person = snapshot1.getValue(Persona.class);


                 listapersonas.add(person);



                 }
                 adapter.notifyDataSetChanged();

             }

             @Override
             public void onCancelled (@NonNull DatabaseError error){
                 Log.e("ERROR", error.getMessage());
             }
         };

     db.addValueEventListener(eventListener);




    /*  private void cargarData(){
   listapersonas = new ArrayList<>();
        listapersonas.add(new Persona("Aldo Corzo", "31 años",R.drawable.corzo));
        listapersonas.add(new Persona("Luis Advincula", "30 años",R.drawable.lucho));
        listapersonas.add(new Persona("Yoshimar Yotun ", "30 años",R.drawable.yoshi));
        listapersonas.add(new Persona("Edinson Flores", "26 años",R.drawable.flores));
        listapersonas.add(new Persona("Jefeerson farfan" ,"35 años" , R.drawable.farfan));
        listapersonas.add(new Persona("Paolo Guerrero " ,"36 años" , R.drawable.guerrero));
        listapersonas.add(new Persona("Carrillo", "29 años",R.drawable.carrillo));
*/


    }







}