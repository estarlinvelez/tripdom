package edu.itla.tripdom.listadapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.List;

import edu.itla.tripdom.R;
import edu.itla.tripdom.entity.Publicacion;

/**
 * Created by Estarlin Velez on 7/12/17.
 */

public class PublicacionListAdapter extends BaseAdapter {
    private final List<Publicacion> pub;
    private Activity context;
    private List<Publicacion> pun;

    public PublicacionListAdapter (Activity context, List<Publicacion> pub){
        this.context = context;
        this.pub = pub;

    }

    @Override
    public int getCount() {
        return pub.size();
    }

    @Override
    public Object getItem(int i) {
        return pub.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            LayoutInflater layoutInflater = context.getLayoutInflater();
            view = layoutInflater.inflate(R.layout.lista_publicacion_row, null, true);
        }
        TextView lvNombre = view.findViewById(R.id.lvNombre);
        TextView lvCosto = view.findViewById(R.id.lvCosto);
        TextView lvDescripcion = view.findViewById(R.id.lvDescripcion);
        TextView lvEstado = view.findViewById(R.id.lvEstado);
        TextView lvCupo = view.findViewById((R.id.lvCupo));
        Publicacion publicacion = pub.get(i);


        lvNombre.setText(publicacion.getUsuario().getNombre());
        lvCosto.setText(String.valueOf(publicacion.getCosto()));
        lvDescripcion.setText(publicacion.getDescripcion());
        lvEstado.setText(publicacion.getEstado());
        lvCupo.setText(String.valueOf(publicacion.getCupo()));


        return view;
    }
}