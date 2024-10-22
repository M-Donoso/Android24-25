package com.example.recyclermoviesmvp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclermoviesmvp.R;
import com.example.recyclermoviesmvp.beans.Pelicula;

import java.util.List;

public class PeliculaAdapter1 extends RecyclerView.Adapter<PeliculaAdapter1.ViewHolder>{
    private List<Pelicula> peliculas;
    private Context context;

    public PeliculaAdapter1(Context context, List<Pelicula> peliculas) {
        this.context = context;
        this.peliculas = peliculas;
    }

    @NonNull
    @Override
    public PeliculaAdapter1.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row1,
                    parent,
                    false);
            return new PeliculaAdapter1.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculaAdapter1.ViewHolder holder, int position) {
        // ASIGNA CONTENIDO --> API, ARRAYLIST, DE DONDE QUERAMOS
        Pelicula pelicula = peliculas.get(position);
        holder.tvTitulo.setText(pelicula.getTitulo());
        holder.bind(pelicula);
    }

    @Override
    public int getItemCount() {
        return peliculas.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitulo;
        public ImageView ivPeliculaImagen;
        private Pelicula currentPelicula;

        public ViewHolder(View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);

            ivPeliculaImagen = itemView.findViewById(R.id.ivPeliculaImagen);

        }
        public void bind(Pelicula pelicula) {
            currentPelicula = pelicula;
        }
    }

}
