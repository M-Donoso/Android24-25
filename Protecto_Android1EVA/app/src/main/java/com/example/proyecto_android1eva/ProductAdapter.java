package com.example.proyecto_android1eva;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Camiseta> camisetaList;
    private OnProductBuyListener listener;

    // Interfaz para manejar el evento de compra
    public interface OnProductBuyListener {
        void onProductBuy(Camiseta camiseta);
    }

    public ProductAdapter(List<Camiseta> camisetaList, OnProductBuyListener listener) {
        this.camisetaList = camisetaList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Camiseta camiseta = camisetaList.get(position);

        holder.tvProductName.setText(camiseta.getNombreEquipo());
        holder.tvProductDescription.setText(camiseta.getDescripcion());
        holder.tvProductPrice.setText(String.format("$%.2f", camiseta.getPrecio()));

        // Glide para cargar la imagen
        Glide.with(holder.itemView.getContext())
                .load(camiseta.getImagen()) // Asegúrate de que este método devuelve la URL de la imagen
                .placeholder(R.drawable.logo)
                .into(holder.ivProductImage);

        // Configurar el botón de compra
        holder.btnBuy.setOnClickListener(v -> {
            if (listener != null) {
                listener.onProductBuy(camiseta); // Notifica al listener sobre la compra
            }
        });
    }

    @Override
    public int getItemCount() {
        return camisetaList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView tvProductName, tvProductDescription, tvProductPrice;
        ImageView ivProductImage;
        Button btnBuy;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductDescription = itemView.findViewById(R.id.tvProductDescription);
            tvProductPrice = itemView.findViewById(R.id.tvProductPrice);
            ivProductImage = itemView.findViewById(R.id.ivProductImage);
            btnBuy = itemView.findViewById(R.id.btnBuy);
        }
    }
}


