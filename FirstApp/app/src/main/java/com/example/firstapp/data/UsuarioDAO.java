package com.example.firstapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.firstapp.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private DBHelper dbHelper;

    public UsuarioDAO(Context context){
        dbHelper = new DBHelper(context);
    }

    //CREATE
    public long insertarUsuario(String nombre, String email){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_NOMBRE, nombre);
        values.put(DBHelper.COLUMN_EMAIL, email);
        return db.insert(DBHelper.TABLE_USUARIOS, null, values);
    }

    //READ
    public List<Usuario> obtenerUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        //query(table, columns, selection, selectionargs, groupby, orderby
        Cursor cursor = db.query(DBHelper.TABLE_USUARIOS,
                null, null, null, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_ID));
                String nombre = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_NOMBRE));
                String email = cursor.getString(cursor.getColumnIndexOrThrow(DBHelper.COLUMN_EMAIL));
                lista.add(new Usuario(id, nombre, email));
            } while (cursor.moveToNext());
        }
        cursor.close();
        return lista;
    }


    //UPDATE
    public int actualizarUsuario(int id, String nombre, String email){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DBHelper.COLUMN_NOMBRE, nombre);
        values.put(DBHelper.COLUMN_EMAIL, email);
        return db.update(DBHelper.TABLE_USUARIOS, values,
                DBHelper.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)});
    }
    //DELETE
    public int eliminarUsuario(int id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        return db.delete(DBHelper.TABLE_USUARIOS,
                DBHelper.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)});
    }
//    public Cursor obtenerUsuarios(){
//        SQLiteDatabase db = dbHelper.getReadableDatabase();
//        //query(table, columns, selection, selectionargs, groupby, orderby
//        return db.query(DBHelper.TABLE_USUARIOS,
//                null, null, null, null, null, null );
//    }

}
