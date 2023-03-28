package com.example.parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

public class DetalleActivity extends AppCompatActivity {

    private TextView tvTituloDetalle,tvResultadoDetalle;
    private ImageView ivImagenPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle2);
        setTitle(getString(R.string.txt_Detalle_Partido));

        tvTituloDetalle = findViewById(R.id.tv_titulo_detalle);
        tvResultadoDetalle = findViewById(R.id.tv_resultado_detalle);
        ivImagenPrincipal = findViewById(R.id.iv_imagen_detalle);

        Partido miPartidoAtrapado = (Partido)getIntent().getSerializableExtra("partido");

        tvTituloDetalle.setText(miPartidoAtrapado.getNombre());
        tvResultadoDetalle.setText(miPartidoAtrapado.getResultado());
        Picasso.get()
                .load(miPartidoAtrapado.getUrImagen())
                .error(R.drawable.ic_launcher_background)
                .into(ivImagenPrincipal);
    }
}