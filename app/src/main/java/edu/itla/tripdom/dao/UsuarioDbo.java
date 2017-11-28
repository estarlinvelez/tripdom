package edu.itla.tripdom.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import edu.itla.tripdom.entity.TipoUsuario;
import edu.itla.tripdom.entity.Usuario;

/**
 * Created by Estarlin Velez on 26/11/17.
 */

public class UsuarioDbo {
    private DbConnection connection;

    public UsuarioDbo(Context context){
        connection = new DbConnection(context);

    }

    public void crear (Usuario usuario){
        SQLiteDatabase db = connection.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put ("nombre",usuario.getNombre());
        cv.put ("email", usuario.getEmail());
        cv.put ("tipo_usuario", usuario.toString());
        cv.put ("telefono", usuario.getTelefono());

        SQLiteDatabase conectarDb = connection.getWritableDatabase();
        Long id = db.insert ("usuario", null, cv);
        usuario.setId(id.intValue());

        db.close();

    }

    public List <Usuario> buscar (){
        List<Usuario> usuarios = new ArrayList<>();
        String columna []  = new String[]{"id", "nombre", "email", "tipo_usuario"};
        SQLiteDatabase db = connection.getReadableDatabase();
        Cursor cursor = db.query ("usuario", columna, null, null, null, null, null );
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Usuario u = new Usuario();

            u.setId(cursor.getInt(cursor.getColumnIndex("id")));
            u.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
            u.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            u.setTipousuario(TipoUsuario.valueOf((cursor.getString(cursor.getColumnIndex("tipo_usuario")))));
            usuarios.add(u);
            cursor.moveToNext();

        }
       cursor.close();
        db.close();

        return usuarios;

    }


}
