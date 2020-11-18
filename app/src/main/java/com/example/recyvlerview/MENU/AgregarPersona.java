package com.example.recyvlerview.MENU;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.recyvlerview.Persona;
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

                    edt1 = (EditText) findViewById(R.id.edtNombre);
                    edt2=(EditText)findViewById(R.id.edtANio);
                    edt3=(EditText)findViewById(R.id.edtDescripcion);
                    btnAgregar=findViewById(R.id.btnAgregar);
                     final DatabaseReference db;

        db=(DatabaseReference) FirebaseDatabase.getInstance().getReference().child("Personas");




                    btnAgregar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            final String nombre = edt1.getText().toString();
                            final String anio = edt2.getText().toString();
                      final String descripcion =edt3.getText().toString();
                            Persona persona ;

                        persona= new Persona(nombre,anio,descripcion);
                         //   persona= new Persona(nombre,anio);

                            db.push().setValue(persona);
                        }
                    });


    }
}