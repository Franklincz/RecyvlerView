package com.example.recyvlerview;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyvlerview.OBJETOS.ArayProductos;
import com.example.recyvlerview.OBJETOS.Utilidades;

import java.util.ArrayList;

public class PedidoViewHolder extends RecyclerView.ViewHolder {

    TextView txtNropedido;
    TextView txtMesa;
    TextView txtdescrip;
    TextView txtFecha;
    TextView txtHora;
    //  ImageView imgFoto;

    Button btn;
    //referencia de contexto
    Context context;

    public PedidoViewHolder(View itemView) {


        super(itemView);
        //capturamos el contexto
        context = itemView.getContext();

        ///referenciamos elementos
        txtNropedido = itemView.findViewById(R.id.txtnropedido);
        txtMesa = itemView.findViewById(R.id.txtmesa);
        txtFecha = itemView.findViewById(R.id.txtfecha);
        txtHora = itemView.findViewById(R.id.txthora);
        //  imgFoto = itemView.findViewById(R.id.imgfoto);
        txtdescrip = itemView.findViewById(R.id.txtdescripcion);
        ///capturamos la referencias de nuestros botones
        btn = (Button) itemView.findViewById(R.id.btnVerpedido);


    }

    public void setOnclickListeners(final String detale, final ArrayList<ArayProductos> p, final String numer_pedido) {

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ahora ya accedemos al contexto correspondiente
                Intent intent = new Intent(context, Details_Pedido.class);
                Utilidades.p = p;

                intent.putExtra("idpedido", numer_pedido);
                context.startActivity(intent);
            }
        });

    }


}
