package com.example.parcial;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {

    private ArrayList<Partido> listaPrincipalPartidos;
    private RecyclerView rvListadoPartidos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(getString(R.string.txt_Partidos_Jugados));
        cargarDatos();

        rvListadoPartidos = findViewById(R.id.rv_listado_partidos);

        AdaptadorPersonalizado miAdaptador = new AdaptadorPersonalizado(listaPrincipalPartidos);
        miAdaptador.setOnItemClickListener(new AdaptadorPersonalizado.OnItemClickListener() {
            @Override
            public void onItemClick(Partido miPartido, int posicion) {

                Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                intent.putExtra("partido",miPartido);
                startActivity(intent);
            }

        });

        rvListadoPartidos.setAdapter(miAdaptador);
        rvListadoPartidos.setLayoutManager(new LinearLayoutManager(this));

    }

        public void cargarDatos(){
            Partido partido1 = new Partido();
            partido1.setNombre("Vs Atletico Nacional");
            partido1.setResultado("1-1");
            partido1.setUrImagen("https://upload.wikimedia.org/wikipedia/commons/9/9a/Escudo_de_Atl%C3%A9tico_Nacional.png");

            Partido partido2 = new Partido("Vs Aguilas Doradas", "0-1", "https://aguilasdoradas.com.co/wp-content/uploads/2018/05/Escudo-%C3%81guilas-Doradas-2020.png");
            Partido partido3 = new Partido("Vs Once caldas", "0-1", "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Once_Caldas_logo-svg.svg/1200px-Once_Caldas_logo-svg.svg.png");
            Partido partido4 = new Partido("Vs Deportivo Cali", "1-1", "https://upload.wikimedia.org/wikipedia/commons/a/a4/Deportivo-cali-escudo.png");
            Partido partido5 = new Partido("Vs Deportes Tolima", "1-1", "https://upload.wikimedia.org/wikipedia/commons/4/41/Escudo_Deportes_Tolima_Sin_A%C3%B1o_2.png");

            //inicializar el arraylist
            listaPrincipalPartidos = new ArrayList<>();
            //agregar los productos al arraylist
            listaPrincipalPartidos.add(partido1);
            listaPrincipalPartidos.add(partido2);
            listaPrincipalPartidos.add(partido3);
            listaPrincipalPartidos.add(partido4);
            listaPrincipalPartidos.add(partido5);
    }
}