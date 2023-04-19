package com.example.trabajopractico3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trabajopractico3.Models.Pelicula;

import java.util.List;

public class peliculaAdapter extends RecyclerView.Adapter<peliculaAdapter.ViewHolder> {
private Context context;
private List<Pelicula> peliculas;
private LayoutInflater layoutInflater;

    public peliculaAdapter(Context context, List<Pelicula> peliculas, LayoutInflater layoutInflater) {
        this.context = context;
        this.peliculas = peliculas;
        this.layoutInflater = layoutInflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root=layoutInflater.inflate(R.layout.item_pelicula,parent,false);
        return new  ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.titulo.setText(peliculas.get(position).getTitulo());
        holder.resenia.setText(peliculas.get(position).getResenia()+"");
        holder.fotoPelicula.setImageResource(peliculas.get(position).getImagenUrl());
       /* Glide.with(context)
                .load(productos.get(position).getUrlFoto())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.fotoProducto); */
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }

public class ViewHolder extends RecyclerView.ViewHolder{
ImageView fotoPelicula;
TextView titulo,resenia;
Button boton;

    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        fotoPelicula=itemView.findViewById(R.id.ivFoto);
        titulo=itemView.findViewById(R.id.tvTitulo);
        resenia=itemView.findViewById(R.id.tvResenia);
        boton = itemView.findViewById(R.id.btnDetalle);
        boton.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), DescripcionActivity.class);

            Bundle bundle = new Bundle();
            bundle.putSerializable("pelicula", peliculas.get(getAdapterPosition()));

            intent.putExtras(bundle);

            v.getContext().startActivity(intent);
        });
    }
}


}
