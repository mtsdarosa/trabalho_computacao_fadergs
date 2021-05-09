package com.example.appcupom;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Banco extends SQLiteOpenHelper {
    private static final int VERSAO = 3;
    private static final String NOME = "AppCupom";

    public Banco(Context context){
        super(context, NOME, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS cupom (" +
                "      id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT," +
                "      codigoCupom TEXT NOT NULL, " +
                "      dataValidade TEXT NOT NULL, " +
                "      valorDesconto REAL NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
