package edu.itla.tripdom.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.Editable;
import android.util.Log;

import java.sql.SQLClientInfoException;

/**
 * Created by Estarlin Velez on 26/11/17.
 */

public class DbConnection extends SQLiteOpenHelper {

    public static String DATABASE_NAME = "tripdom.db";
    public static String LOG_T = "DbConnection";

    public DbConnection(Context context) {
        super(context, DATABASE_NAME, null,  1);

    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i (LOG_T, "Iniciando onCreate...");

        sqLiteDatabase.execSQL(SqlHelperSchema.USUARIO_TABLE);
        sqLiteDatabase.execSQL(SqlHelperSchema.PUBLICACION_TABLE);
        sqLiteDatabase.execSQL(SqlHelperSchema.DETALLE_PUBLICACION_TABLE);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
