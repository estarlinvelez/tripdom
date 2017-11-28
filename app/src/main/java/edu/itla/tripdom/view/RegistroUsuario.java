package edu.itla.tripdom.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import edu.itla.tripdom.R;
import edu.itla.tripdom.dao.UsuarioDbo;
import edu.itla.tripdom.entity.TipoUsuario;
import edu.itla.tripdom.entity.Usuario;

public class RegistroUsuario extends AppCompatActivity {
    private static final String LOG_t = "RegistroUsuarioLog";
    UsuarioDbo db = new UsuarioDbo(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        Button btnLista = findViewById(R.id.btnListar);
               Button btnSave = findViewById(R.id.btnsave);
        final EditText txtnombre = findViewById(R.id.txtnombre);
        final EditText txtEmail = findViewById(R.id.txtemail);
        final EditText txtTelefono = findViewById(R.id.txtTelefono);

        btnLista.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Usuario> usuarios = db.buscar();
                for (Usuario u: usuarios){
                    Log.i("ListUusuarios", u.toString());
                }
            }
        });
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Usuario user = new Usuario();
                        user.setNombre(txtnombre.getText().toString());
                        user.setEmail(txtEmail.getText().toString());
                        user.setTelefono(txtTelefono.getText().toString());
                        user.setTipousuario(TipoUsuario.CLIENTE);
                        Log.i(LOG_t, user.toString());
                        db.crear(user);
                        Toast.makeText(RegistroUsuario.this, "El registro se ha completado de forma exitosa.", Toast.LENGTH_SHORT).show();

                    }
                });

    }
}
