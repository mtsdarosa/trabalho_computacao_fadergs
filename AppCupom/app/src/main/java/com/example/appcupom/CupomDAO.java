package com.example.appcupom;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CupomDAO {
    private static SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");

    public static void inserir(Cupom cupom, Context context){
        ContentValues valores = new ContentValues();
        valores.put("codigoCupom", cupom.getCodigoCupom());
        valores.put("dataValidade", cupom.getDataValidade().toString());
        valores.put("valorDesconto", cupom.getValorDesconto());

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        db.insert("cupom", null, valores);
    }

    public static void editar(Cupom cupom, Context context){
        ContentValues valores = new ContentValues();
        valores.put("codigoCupom", cupom.getCodigoCupom());
        valores.put("dataValidade", cupom.getDataValidade().toString());
        valores.put("valorDesconto", cupom.getValorDesconto());

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();

        db.update("cupom", valores, " id = " + cupom.getId(), null);
    }

    public static void excluir(int id, Context context){
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getWritableDatabase();
        db.delete("cupom", " id = " + id , null);
    }

    public static List<Cupom> getCupons(Context context) throws ParseException {

        List<Cupom> lista = new ArrayList<>();

        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id, codigoCupom, dataValidade, valorDesconto FROM cupom ORDER BY codigoCupom", null);
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Cupom cupom = new Cupom();
                cupom.setId(cursor.getInt(0));
                cupom.setCodigoCupom(cursor.getString(1));
                cupom.setDataValidade(cursor.getString(2));
                cupom.setValorDesconto(cursor.getFloat(3));

                lista.add(cupom);
            }while(cursor.moveToNext());
        }

        return lista;
    }

    public static Cupom getCupomById(Context context ,int id) throws ParseException {
        Banco banco = new Banco(context);
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT id, codigoCupom, dataValidade, valorDesconto FROM cupom WHERE id = " + id, null);
        if (cursor.getCount() > 0){
            cursor.moveToFirst();
            Cupom cupom = new Cupom();
            cupom.setId(cursor.getInt(0));
            cupom.setCodigoCupom(cursor.getString(1));
            cupom.setDataValidade(cursor.getString(2));
            cupom.setValorDesconto(cursor.getFloat(3));
            return cupom;
        }else{
            return null;
        }
    }
}
