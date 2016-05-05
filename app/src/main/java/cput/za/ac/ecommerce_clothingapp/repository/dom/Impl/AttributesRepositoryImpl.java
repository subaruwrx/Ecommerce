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
import cput.za.ac.ecommerce_clothingapp.domain.Attributes;
import cput.za.ac.ecommerce_clothingapp.repository.dom.AttributesRepository;

/**
 * Created by Admin on 2016-04-23.
 */
public class AttributesRepositoryImpl extends SQLiteOpenHelper implements AttributesRepository
{

    public static final String TABLE_NAME="attributes";
    private SQLiteDatabase db;

    public static final String COLUMN_ID="id";
    public static final String COLUMN_ATTRIBUTENAME="attributeName";
    public static final String COLUMN_ATTRIBUTEVALUE="attributeValue";
    public static final String COLUMN_DESCRIPTION="description";


    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            +TABLE_NAME +"("
            +COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_ATTRIBUTENAME + " TEXT  NOT NULL , "
            +COLUMN_ATTRIBUTEVALUE +"TEXT NOT NULL ,"
            +COLUMN_DESCRIPTION +"TEXT NOT NULL);";

    public AttributesRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Attributes findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_ATTRIBUTENAME,
                        COLUMN_ATTRIBUTEVALUE,
                        COLUMN_DESCRIPTION},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {

            final Attributes  attributes = new Attributes .Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .attributeName(cursor.getString(cursor.getColumnIndex( COLUMN_ATTRIBUTENAME)))
                    .attributeValue(cursor.getString(cursor.getColumnIndex(COLUMN_ATTRIBUTEVALUE)))
                    .description(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)))
                    .build();
            return attributes;
        }else {
            return null;
        }

    }
    @Override
    public Attributes save(Attributes entity){

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ATTRIBUTENAME, entity.getAttributeName());
        values.put(COLUMN_ATTRIBUTEVALUE, entity.getAttributeValue());
        values.put(COLUMN_DESCRIPTION, entity.getDescription());


        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Attributes insertedEntity = new Attributes.Builder()
                .copy(entity)
                .id(new Long (id))
                .build();
        return insertedEntity;
    }

    @Override
    public Attributes update(Attributes entity){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ATTRIBUTENAME, entity.getAttributeName());
        values.put(COLUMN_ATTRIBUTEVALUE, entity.getAttributeValue());
        values.put(COLUMN_DESCRIPTION, entity.getDescription());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;

    }

    @Override
    public Attributes delete(Attributes entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Attributes> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Attributes> attributes = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
            final Attributes attributes1 = new Attributes.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .attributeName(cursor.getString(cursor.getColumnIndex( COLUMN_ATTRIBUTENAME)))
                    .attributeValue(cursor.getString(cursor.getColumnIndex(COLUMN_ATTRIBUTEVALUE)))
                    .description(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)))
                    .build();
                attributes.add(attributes1);
        } while (cursor.moveToNext());
    }
    return attributes;
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
