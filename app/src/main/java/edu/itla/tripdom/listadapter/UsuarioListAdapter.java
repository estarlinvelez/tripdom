package edu.itla.tripdom.listadapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import edu.itla.tripdom.R;
import edu.itla.tripdom.entity.Usuario;

/**
 * Created by Estarlin Velez on 3/12/17.
 */

public class UsuarioListAdapter extends BaseAdapter{

    public UsuarioListAdapter(Activity context, List<Usuario> usuarios) {
        this.context = context;
        this.usuarios = usuarios;
    }

    private Activity context;
    private List <Usuario> usuarios;



    @Override
    public int getCount() {
        return usuarios.size();
    }

    @Override
    public Object getItem(int i) {
        return usuarios.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view == null){
            LayoutInflater inteflater = context.getLayoutInflater();
            view = inteflater.inflate(R.layout.listview_usuario_row, null, true);
        }

        TextView LvNombre = view.findViewById(R.id.lvNombreUsuario);
        TextView LvEmail = view.findViewById(R.id.lvEmail);
        TextView LvTipoUsuario = view.findViewById(R.id.lvTipoUsuario);


        Usuario u = usuarios.get(i);

        LvNombre.setText(u.getNombre());
        LvEmail.setText(u.getEmail());
        LvTipoUsuario.setText(u.getTipousuario().toString());


        return null;
    }
}
