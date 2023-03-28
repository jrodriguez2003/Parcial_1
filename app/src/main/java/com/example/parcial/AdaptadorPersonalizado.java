package com.example.parcial;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdaptadorPersonalizado extends RecyclerView.Adapter<AdaptadorPersonalizado.ViewHolder>{

    private ArrayList<Partido> listadoInformacion;
    private OnItemClickListener onItemClickListener;

    public void setListadoInformacion(ArrayList<Partido> listadoInformacion) {
        this.listadoInformacion = listadoInformacion;
        notifyDataSetChanged();
    }

    public AdaptadorPersonalizado(ArrayList<Partido> listadoInformacion) {
        this.listadoInformacion = listadoInformacion;
        this.onItemClickListener = null;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public AdaptadorPersonalizado.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View miView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista_partidos,parent,false);
        return new ViewHolder(miView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorPersonalizado.ViewHolder holder, int position) {

        Partido miPartido = listadoInformacion.get(position);
        holder.enlazar(miPartido);

    }

    @Override
    public int getItemCount() {
        return listadoInformacion.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvNombre, tvResultado;
        private ImageView ivPartido;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombre = itemView.findViewById(R.id.tv_item_nombre);
            tvResultado = itemView.findViewById(R.id.tv_item_resultado);
            ivPartido = itemView.findViewById(R.id.iv_item_imagen);

        }

        public void enlazar(Partido miPartido){
            tvNombre.setText(miPartido.getNombre());
            tvResultado.setText(miPartido.getResultado().toString());
            Log.d("url",miPartido.getUrImagen());
            Picasso.get()
                    .load(miPartido.getUrImagen())
                    .error(R.drawable.ic_launcher_background)
                    .into(ivPartido);
            if(onItemClickListener!=null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onItemClickListener.onItemClick(miPartido,getAdapterPosition());
                    }
                });
            }


        }

    }
    public interface OnItemClickListener{
        void onItemClick(Partido miPartido, int posicion);
    }
}
