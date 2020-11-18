package com.example.recyvlerview.MENU;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recyvlerview.R;
import com.example.recyvlerview.recyclerActivity;

public class MenuActivity extends AppCompatActivity {

    Button bt1;
    Button bt2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

       bt1=findViewById(R.id.btn1);
       bt2=findViewById(R.id.btn2);


       bt1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               Intent intent = new Intent(getApplicationContext(), recyclerActivity.class);

                    startActivity(intent);


           }
       });



       bt2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {


               Intent intent = new Intent(getApplicationContext(), AgregarPersona.class);

               startActivity(intent);





           }
       });





    }
}