package com.example.android.pets.data;

import android.content.Context;
import com.example.android.pets.data.PetContract.PetEntry;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Yash Kumar Gupta on 1/13/2018.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = PetDbHelper.class.getSimpleName();

    private static final String DATABASE_NAME = "shelter.db";

    private static final int DATABASE_VERSION = 1;

    public PetDbHelper(Context context)
    {
        super(context,DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        //String created that contains the SQL Statement to crete the pets table
        String SQL_CREATE_PETS_TABLE = "CREATE TABLE " + PetEntry.TABLE_NAME + " ("
                + PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
                + PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL , "
                + PetEntry.COLUMN_PET_BREED + " TEXT , "
                + PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL , "
                + PetEntry.COLUMN_PET_WEIGHT + " INEGER NOT NULL DEFAULT 0 ); ";

        db.execSQL(SQL_CREATE_PETS_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){

        //The database is still at version 1, so there's nothing to do be done here.
    }
}
