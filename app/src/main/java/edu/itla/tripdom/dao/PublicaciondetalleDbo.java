package edu.itla.tripdom.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import edu.itla.tripdom.entity.Publicaciondetalle;

/**
 * Created by Estarlin Velez on 3/12/17.
 */

public class PublicaciondetalleDbo {
    private DbConnection connection;

    public PublicaciondetalleDbo(Context context){
        connection = new DbConnection(context);

    }

    public void crear (Publicaciondetalle publicaciondetalle){
      SQLiteDatabase db = connection.getWritableDatabase();

    ContentValues cv = new ContentValues();
     cv.put("publicacion", publicaciondetalle.toString());
     cv.put("lugar", publicaciondetalle.getLugar());
     cv.put("descripcion", publicaciondetalle.getDescripcion());

     SQLiteDatabase conectarDb = connection.getWritableDatabase();
     Long id =  db.insert("publicaciondetalle", null, cv);
     publicaciondetalle.setId(id.intValue());

     db.close();

    }


}
