package com.example.recyvlerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.recyvlerview.MODEL.Empleado;
import com.example.recyvlerview.OBJETOS.EmpleadoAdapter;
import com.example.recyvlerview.OBJETOS.FirebaseReference;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spiner1;
    List<Empleado> listaEmpleados;
    EmpleadoAdapter empleadoAdapter;
    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private DatabaseReference db2;
    private SearchView svsearch;
    private EditText edtBuscar;
    private ImageButton imb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //referencio mis elementos
        imb=(ImageButton) findViewById(R.id.imgButton);
        spiner1 = (Spinner) findViewById(R.id.spinner1);
        edtBuscar = (EditText) findViewById(R.id.edtBuscar);
        recycler = (RecyclerView) findViewById(R.id.reciclador);// Obtener el Recycler
        recycler.setHasFixedSize(true);
     //   empleadoAdapter = new EmpleadoAdapter(listaEmpleados);
// Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);




//-----------
        //     svsearch = (SearchView) findViewById(R.id.svSheach);

        ArrayAdapter spinAdapater = ArrayAdapter.createFromResource(this, R.array.Estado, android.R.layout.simple_spinner_item);

        spiner1.setAdapter(spinAdapater);


        listaEmpleados = new ArrayList<>();


// Crear un nuevo adaptador
           // adapter = new EmpleadoAdapter(listaEmpleados);









        //aqui pobngo mi logicaaaaaa de
        spiner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> lista, View view, int position, long id) {




                if (lista.getItemAtPosition(position).equals("ACTIVO")) {

                    obtenerEmpleadoActivo();

                }
                if (lista.getItemAtPosition(position).equals("NO ACTIVO")) {

                    obtenerEmpleadoNoActivo();

                }
                else{
                    obtenerEmpleados();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        ///---------------------------





























       empleadoAdapter = new EmpleadoAdapter(listaEmpleados);

        recycler.setAdapter(empleadoAdapter);


        db2 = (DatabaseReference) FirebaseDatabase.getInstance().getReference().child(FirebaseReference.EMPLEADO_REFERENCE);
        obtenerEmpleados();
        FiltrarEmpleado();

// mi metodo obtener estaba aqui




        filtrarEditTextEmpleado();//aqui estaba
        restablecerBusqueda(imb);





    }


    public void obtenerEmpleados() {


        db2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                listaEmpleados.removeAll(listaEmpleados);
                for (DataSnapshot snapshot1 :
                        dataSnapshot.getChildren()) {

                    Empleado ped = new Empleado();
                    ped = snapshot1.getValue(Empleado.class);
                    listaEmpleados.add(ped);

                    Toast.makeText(MainActivity.this, "hola " + ped.getEstado(), Toast.LENGTH_SHORT).show();
                }
                empleadoAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


    public void obtenerEmpleadoActivo() {

        db2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                listaEmpleados.removeAll(listaEmpleados);
                for (DataSnapshot snapshot1 :
                        dataSnapshot.getChildren()) {
                    Empleado ped = new Empleado();

                    ped = snapshot1.getValue(Empleado.class);
                    if (ped.getEstado().equals("activo")) {


                        listaEmpleados.add(ped);
                    }
                    Log.i("pepe", ped.getEstado());
                    Toast.makeText(getApplicationContext(), "esto es mi toast" + ped.getEstado(), Toast.LENGTH_SHORT).show();
                }
             empleadoAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }


    public void obtenerEmpleadoNoActivo() {

        db2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                listaEmpleados.removeAll(listaEmpleados);
                for (DataSnapshot snapshot1 :
                        dataSnapshot.getChildren()) {
                    Empleado ped = new Empleado();

                    ped = snapshot1.getValue(Empleado.class);
                    if (ped.getEstado().equals("no activo")) {


                        listaEmpleados.add(ped);
                    }
                    Log.i("pepe", ped.getEstado());
                    Toast.makeText(getApplicationContext(), "esto es mi toast" + ped.getEstado(), Toast.LENGTH_SHORT).show();
                }
               empleadoAdapter.notifyDataSetChanged();


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }











    public void FiltrarEmpleado() {


        spiner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> lista, View view, int position, long id) {




                if (lista.getItemAtPosition(position).equals("ACTIVO")) {

                    obtenerEmpleadoActivo();

                }
                if (lista.getItemAtPosition(position).equals("NO ACTIVO")) {

                    obtenerEmpleadoNoActivo();

                }
                else{
                    obtenerEmpleados();
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


    public void filtrarEditTextEmpleado() {
        edtBuscar.addTextChangedListener(new TextWatcher() {

                                             @Override
                                             public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                                             }

                                             @Override
                                             public void onTextChanged(CharSequence s, int start, int before, int count) {

                                             }

                                             @Override
                                             public void afterTextChanged(Editable s) {


                                                 filter(s.toString());


                                             }

                                         }

        );


    }


    public void filter(String text) {


        List<Empleado> filterEmpleados = new ArrayList();


        for (Empleado emple : listaEmpleados) {




    if (emple.getNombres().contains(text) ) {

        //Log.i("ctm", "esto es un nombre " + emple.getNombres());

        filterEmpleados.add(emple);



}





        }

        empleadoAdapter.filterList(filterEmpleados);


    }


    public void restablecerBusqueda(ImageButton mgB){
        ImageButton imb = mgB;
        imb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtBuscar.setText("");

            }
        });












    }












}