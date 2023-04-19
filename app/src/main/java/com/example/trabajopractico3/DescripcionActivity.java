package com.example.trabajopractico3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.trabajopractico3.Models.Pelicula;
import com.example.trabajopractico3.databinding.ActivityDescripcionBinding;


public class DescripcionActivity extends AppCompatActivity {

    private ActivityDescripcionBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityDescripcionBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Pelicula pelicula = (Pelicula) bundle.getSerializable("pelicula");

        binding.tvTituloPeli.setText(pelicula.getTitulo());
        binding.tvDirector.setText(pelicula.getDirector());
        binding.tvActores.setText(pelicula.getActores());
        binding.tvResenia.setText(pelicula.getResenia());
        binding.ivFotoPeli.setImageResource(pelicula.getImagenUrl());
    }
}