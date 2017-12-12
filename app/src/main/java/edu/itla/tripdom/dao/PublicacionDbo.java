package edu.itla.tripdom.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.itla.tripdom.entity.Publicacion;

/**
 * Created by Estarlin Velez on 2/12/17.
 */

public class PublicacionDbo {
    private static final SimpleDateFormat DF = new SimpleDateFormat("dd-MM-yyyy");

    private DbConnection connection;

    public PublicacionDbo(Context context) {
        connection = new DbConnection(context);


    }

    public void crear (Publicacion publicacion){
        SQLiteDatabase db = connection.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put("fecha", publicacion.getFecha());
        cv.put("usuario_id", publicacion.toString());
        cv.put("descripcion", publicacion.getDescripcion());
        cv.put("costo", publicacion.getCosto());
        cv.put("estado", publicacion.getCosto());
        cv.put("cupo", publicacion.getCupo());
        cv.put("usuario", publicacion.toString());
        cv.put("origen", publicacion.getOrigen());

        SQLiteDatabase conectarDb = connection.getWritableDatabase();
        Long id =  db.insert(   "publicacion", null, cv);
        publicacion.setId(id.intValue());
        db.close();

    }

    public List<Publicacion> buscar(){
        List<Publicacion> publicacion = new ArrayList<>();


        String[] campos = {"id", "fecha","usuario_id", "descripcion", "costo", "estado", "cupo", "usuario", "origen"};
        SQLiteDatabase db = connection.getReadableDatabase();

        Cursor cursor = db.query("publicacion", campos, null, null, null, null, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Publicacion p = new Publicacion();

            p.setId(cursor.getInt(cursor.getColumnIndex("id")));
           try{
               p.setFecha(DF.parse(cursor.getString(cursor.getColumnIndex("fecha"))));
           }catch (ParseException ex){
               p.setFecha(new Date());
           }

            p.setUsuarioid(StringToUser(cursor.getString(cursor.getColumnIndex("usuario"))).getId());
            p.setDescripcion(cursor.getString(cursor.getColumnIndex("descripcion")));
            p.setCosto(cursor.getFloat(cursor.getColumnIndex("costo")));
            p.setEstado(cursor.getString(cursor.getColumnIndex("estado")));
            p.setCupo(cursor.getInt(cursor.getColumnIndex("cupo")));
            p.setUsuario(StringToUser(cursor.getString(cursor.getColumnIndex("usuario"))));



