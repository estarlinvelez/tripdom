package edu.itla.tripdom.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.itla.tripdom.R;
import edu.itla.tripdom.UsuarioActual;
import edu.itla.tripdom.dao.UsuarioDbo;
import edu.itla.tripdom.entity.TipoUsuario;
import edu.itla.tripdom.entity.Usuario;

import static edu.itla.tripdom.dao.DbConnection.LOG_T;

public class RegistroUsuario extends AppCompatActivity {
    private static final String LOG_t = "RegistroUsuarioLog";

    UsuarioDbo db = new UsuarioDbo(this);
    private Usuario usuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        Button btnCambiar = findViewById(R.id.btnCambiar);
        Button btnSave = findViewById(R.id.btnsave);
        final EditText txtNombre = findViewById(R.id.txtNombre);
        final EditText txtEmail = findViewById(R.id.txtEmail);
        final EditText txtTelefono = findViewById(R.id.txtTelefono);


        Bundle parametros = getIntent().getExtras();

        if (parametros != null && parametros.containsKey("Usuario")) {
            usuario = (Usuario) parametros.getSerializable("Usuario");
            txtNombre.setText(usuario.getNombre());
            txtEmail.setText(usuario.getEmail());
            txtTelefono.setText(usuario.getTelefono());
        }


           btnCambiar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if (usuario!=null && usuario.getId()>0){
                     UsuarioActual.setUsuario(usuario);
                 }
                 else{
                     Toast.makeText(RegistroUsuario.this, "Usuario no permitido o no Existe", Toast.LENGTH_SHORT).show();

                 }
             }
         });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (usuario == null) {
                    usuario = new Usuario();
                }
                String userNombre = txtNombre.getText().toString();
                String userEmail = txtEmail.getText().toString();
                String userTelefono = txtTelefono.getText().toString();

                usuario.setNombre(txtNombre.getText().toString());
                usuario.setEmail(txtEmail.getText().toString());
                usuario.setTelefono(txtTelefono.getText().toString());
                usuario.setTipousuario(TipoUsuario.CLIENTE);
                Log.i(LOG_T, usuario.toString());
                db.guardar(usuario);

                Toast.makeText(RegistroUsuario.this, "El registro se ha completado de forma exitosa.", Toast.LENGTH_SHORT).show();
                finish();


            }
        });
    }
}