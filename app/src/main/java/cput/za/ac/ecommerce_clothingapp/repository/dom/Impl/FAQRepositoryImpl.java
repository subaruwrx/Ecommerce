package cput.za.ac.ecommerce_clothingapp.repository.dom.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;

import cput.za.ac.ecommerce_clothingapp.config.databases.DBConstants;
import cput.za.ac.ecommerce_clothingapp.domain.FAQ;
import cput.za.ac.ecommerce_clothingapp.repository.dom.FAQRepository;

/**
 * Created by Admin on 2016-05-10.
 */
public class FAQRepositoryImpl  extends SQLiteOpenHelper implements FAQRepository {
    public static final String TABLE_NAME="FAQ";
    private SQLiteDatabase db;

    public static final String COLUMN_ID="id";
    public static final String COLUMN_QUESTIONS="questions";
    public static final String COLUMN_ANSWER="answer";



    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            +TABLE_NAME +"("
            +COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_QUESTIONS + " TEXT NOT NULL , "
            +COLUMN_ANSWER +" TEXT NOT NULL);";

    public FAQRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }



    @Override
    public FAQ findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_QUESTIONS,
                        COLUMN_ANSWER},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {

            final FAQ  faq = new FAQ.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .question(cursor.getString(cursor.getColumnIndex(COLUMN_QUESTIONS)))
                    .answer(cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER)))
                    .build();
            return faq ;
        }else {
            return null;
        }

    }
    @Override
    public FAQ save(FAQ entity){

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_QUESTIONS, entity.getQuestion());
        values.put(COLUMN_ANSWER, entity.getAnswer());


        long id = db.insertOrThrow(TABLE_NAME, null, values);
        FAQ insertedEntity = new FAQ.Builder()
                .copy(entity)
                .id(new Long (id))
                .build();
        return insertedEntity;
    }

    @Override
    public FAQ update(FAQ entity){

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_QUESTIONS, entity.getQuestion());
        values.put(COLUMN_ANSWER, entity.getAnswer());


        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;

    }

    @Override
    public FAQ delete(FAQ entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<FAQ> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<FAQ> faq = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final FAQ faq1 = new FAQ.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .question(cursor.getString(cursor.getColumnIndex(COLUMN_QUESTIONS)))
                        .answer(cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER)))
                        .build();
                faq.add(faq1);
            } while (cursor.moveToNext());
        }
        return faq;
    }

    @Override
    public int deleteAll() {

        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }



}
