package com.example.recyvlerview.MENU;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.recyvlerview.Pedido;
import com.example.recyvlerview.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AgregarPersona extends AppCompatActivity {

    EditText edt1;
    EditText edt2;
    EditText edt3;
    Button btnAgregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_persona);

        //    edt1 = (EditText) findViewById(R.id.txtmuestra);
        edt2 = (EditText) findViewById(R.id.tttfecha);
        edt3 = (EditText) findViewById(R.id.tttmesa);
        btnAgregar = findViewById(R.id.btnAgregar);
        final DatabaseReference db;

        db = (DatabaseReference) FirebaseDatabase.getInstance().getReference().child("Pedidosx");


        btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String descripcion = edt1.getText().toString();
                final String fecha = edt2.getText().toString();
                final String mesa = edt3.getText().toString();
                Pedido pedi;

                pedi = new Pedido(mesa, fecha, descripcion);


                int id = 0;
                String ide = "1";
                for (id = 0; id < id + 1; id++) {
                    ide = String.valueOf(id);
                    db.child(ide).setValue(pedi);
                    break;

                }


            }
        });


    }


}