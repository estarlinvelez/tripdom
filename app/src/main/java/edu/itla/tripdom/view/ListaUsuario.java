package edu.itla.tripdom.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import edu.itla.tripdom.R;
import edu.itla.tripdom.dao.UsuarioDbo;
import edu.itla.tripdom.entity.Usuario;
import edu.itla.tripdom.listadapter.UsuarioListAdapter;

public class ListaUsuario extends AppCompatActivity {
    private static final String LOG_T = ListaUsuario.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_usuario);


        UsuarioDbo usuarioDbo = new UsuarioDbo(this);
        List<Usuario> usuarios = usuarioDbo.buscar();

        Log.i(LOG_T, "Cantidad de usuarios =" + usuarios.size());
        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(new UsuarioListAdapter(this, usuarios));

        Button btnagregar = findViewById(R.id.btnagregar);

        btnagregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registrousuario = new Intent(ListaUsuario.this, RegistroUsuario.class);
                startActivity(registrousuario);

            }
        });



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Usuario u = (Usuario) adapterView.getItemAtPosition(i);

                Intent ru = new Intent(ListaUsuario.this, RegistroUsuario.class);
                ru.putExtra("Usuario", u);
                startActivity(ru);
            }
        });
    }


}
