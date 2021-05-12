package com.example.sqlite_travel.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.sqlite_travel.Model_travel.Travel;

import java.util.ArrayList;
import java.util.List;

public class DBManager extends SQLiteOpenHelper {

    private final String TAG="DBManager";
    private static final String DATABASE_NAME="travels_manager";
    private static final String TABLE_NAME="travels";
    private static final String ID="id";
    private static final String NAME="name";
    private static int VERSION = 1;
    private Context context;
    private String SQLQuery="CREATE TABLE "+ TABLE_NAME +" ("+
            ID + "integer primary key, " +
            NAME +" TEXT)";

    public DBManager(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
        this.context=context;
        Log.d(TAG,"DBManager: ");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQLQuery);
        Log.d(TAG,"onCreate: ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.d(TAG,"onUpgrade: ");
    }

    public void hello(){
        Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show();
    }

    public void addTravel(Travel trv){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NAME,trv.getmName());

        db.insert(TABLE_NAME,null , values);
        db.close();
        Log.d(TAG, "addTravel Sucessfuly");
    }

    public List<Travel> getAllTravel(){
        List<Travel> listTravel = new ArrayList<>();
        String selectQuyery ="SELECT * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuyery,null);
        if(cursor.moveToFirst()){
            do{
                Travel travel = new Travel();
                travel.setmId(cursor.getInt(0));
                travel.setmName(cursor.getString(1)+"");
                listTravel.add(travel);
            }while(cursor.moveToNext());
        }
        db.close();
        return listTravel;
    }
}
