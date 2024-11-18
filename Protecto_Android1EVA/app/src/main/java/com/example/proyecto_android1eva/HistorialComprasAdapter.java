package com.example.proyecto_android1eva;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.proyecto_android1eva.Historial_Compra;
import com.example.proyecto_android1eva.R;

import java.util.List;

public class HistorialComprasAdapter extends RecyclerView.Adapter<HistorialComprasAdapter.CompraViewHolder> {

    private List<Historial_Compra> comprasList;

    public HistorialComprasAdapter(List<Historial_Compra> comprasList) {
        this.comprasList = comprasList;
    }

    @NonNull
    @Override
    public CompraViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_historial_compra, parent, false);
        return new CompraViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CompraViewHolder holder, int position) {
        Historial_Compra compra = comprasList.get(position);

        holder.tvProducto.setText(compra.getEquipo());
        holder.tvDescripcionCamiseta.setText(compra.getDescripcionCamiseta());
        holder.tvEquipoLiga.setText(compra.getEquipo() + " - " + compra.getLiga());
        holder.tvFecha.setText(compra.getFechaCompra());
        holder.tvTotal.setText(String.format("$%.2f", compra.getTotalCompra()));

        // Glide para cargar la imagen de la camiseta
        Glide.with(holder.itemView.getContext())
                .load(compra.getImagenCamiseta()) // URL de la imagen desde el objeto HistorialCompra
                .into(holder.ivCamisetaImage);
    }

    @Override
    public int getItemCount() {
        return comprasList.size();
    }

    public static class CompraViewHolder extends RecyclerView.ViewHolder {
        TextView tvProducto, tvDescripcionCamiseta, tvEquipoLiga, tvFecha, tvTotal;
        ImageView ivCamisetaImage;

        public CompraViewHolder(@NonNull View itemView) {
            super(itemView);
            ivCamisetaImage = itemView.findViewById(R.id.ivCamisetaImage);
            tvProducto = itemView.findViewById(R.id.tvProducto);
            tvDescripcionCamiseta = itemView.findViewById(R.id.tvDescripcionCamiseta);
            tvEquipoLiga = itemView.findViewById(R.id.tvEquipoLiga);
            tvFecha = itemView.findViewById(R.id.tvFecha);
            tvTotal = itemView.findViewById(R.id.tvTotal);
        }
    }
}
