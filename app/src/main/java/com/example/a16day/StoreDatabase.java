package com.example.a16day;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

public class StoreDatabase extends SQLiteOpenHelper implements BaseColumns{

    static String DATABASE_NAME = "store.db";
    private static int DATABASE_VERSION = 2;

    String SQL_CREATE_ENTRIES1 = "CREATE TABLE users(name VARCHAR(50));";

    String SQL_DELETE_ENTRIES1 = "DROP TABLE IF EXISTS users";
    public StoreDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES1);
    }
    public void cleanTable(SQLiteDatabase db, String tableName) {
        db.execSQL("delete from "+tableName);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES1);
        onCreate(db);
    }
}
