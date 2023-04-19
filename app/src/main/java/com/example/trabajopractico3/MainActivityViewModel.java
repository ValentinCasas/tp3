package com.example.trabajopractico3;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trabajopractico3.Models.Pelicula;

import java.util.ArrayList;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Pelicula>> lista;
    private ArrayList<Pelicula> peliculas ;

    public MainActivityViewModel() {
        peliculas = new ArrayList<>();
    }

    public LiveData<ArrayList<Pelicula>> getLista() {
        if(this.lista == null){
            this.lista = new MutableLiveData<>();
        }
        return this.lista;
    }

    public void llenarLista(){
        peliculas.add(new Pelicula("El Padrino", R.drawable.anillos, "La familia Corleone es una de las más poderosas de Nueva York en los años 40. El patriarca, Vito Corleone, es respetado y temido por igual. Pero sufre un i", "Francis Ford Coppola", "Mario Puzo"));
        peliculas.add(new Pelicula("Forrest Gump", R.drawable.starwars, "Forrest Gump es un joven con deficiencias mentales, físicas y motrices que se convierte en héroe de un hecho histórico: la guerra de Vietnam. A pesar de", "Robert Zemeckis", "Winston Groom"));
        peliculas.add(new Pelicula("El Club de la Pelea", R.drawable.transformers, "Un hombre sin rumbo en su vida (Edward Norton) que sufre de insomnio crónico decide unirse a un grupo de apoyo para personas que sufren cáncer ", "David Fincher", "Chuck Palahniuk"));
        lista.setValue(peliculas);

    }
}
