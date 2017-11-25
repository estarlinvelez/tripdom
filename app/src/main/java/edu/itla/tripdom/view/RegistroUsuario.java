package edu.itla.tripdom.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.itla.tripdom.R;
import edu.itla.tripdom.entity.TipoUsuario;
import edu.itla.tripdom.entity.Usuario;

public class RegistroUsuario extends AppCompatActivity {
    private static final String LOG_t = "RegistroUsuarioLog";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
               Button btnSave = findViewById(R.id.btnsave);
        final EditText txtnombre = findViewById(R.id.txtnombre);
        final EditText txtEmail = findViewById(R.id.txtemail);
        final EditText txtTelefono = findViewById(R.id.txtTelefono);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario user = new Usuario();
                user.setNombre(txtnombre.getText().toString());
                user.setEmail(txtEmail.getText().toString());
                user.setTelefono (txtTelefono.getText().toString());
                user.setTipousuario(TipoUsuario.CLIENTE);
                Log.i(LOG_t, user.toString());

            }
        });

    }
}
