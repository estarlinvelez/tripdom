package edu.itla.tripdom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static edu.itla.tripdom.R.layout.activity_main;

public class Visualizar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);

        Bundle parametros =getIntent().getExtras();
        TextView texto = findViewById(R.id.txtNombre);
        texto.setText(parametros.getString( "Nombre"));



    }
}
