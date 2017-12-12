package edu.itla.tripdom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import edu.itla.tripdom.view.ListaUsuario;
import edu.itla.tripdom.view.RegistroUsuario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText txtNombre = findViewById(R.id.txtNombre);
                Button btnUsuario = findViewById(R.id.btnUsuario);
        Button btnPublicacion = findViewById(R.id.btnPublicacion);
        Button btnListadepublicaciones = findViewById(R.id.btnListadepublicaciones);


       btnUsuario.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent vista = new Intent(MainActivity.this, ListaUsuario.class);

               startActivity(vista);
           }
       });




    }
}