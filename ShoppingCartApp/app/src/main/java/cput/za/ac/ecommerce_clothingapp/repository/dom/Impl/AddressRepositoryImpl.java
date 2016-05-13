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
import cput.za.ac.ecommerce_clothingapp.domain.Address;
import cput.za.ac.ecommerce_clothingapp.repository.Repository;


/**
 * Created by Admin on 2016-04-25.
 */
public class AddressRepositoryImpl extends SQLiteOpenHelper implements Repository<Address,Long> {


    public static final String TABLE_NAME="address";
    private SQLiteDatabase db;

    public static final String COLUMN_ID="id";
    public static final String COLUMN_CITY="city";
    public static final String COLUMN_STREET="street";
    public static final String COLUMN_COUNTRY="country";
    public static final String COLUMN_ZIPCODE="zipCode";


    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            +TABLE_NAME +"("
            +COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_CITY + " TEXT  NOT NULL , "
            +COLUMN_STREET +"TEXT NOT NULL ,"
            +COLUMN_COUNTRY +"TEXT NOT NULL ,"
            +COLUMN_ZIPCODE +"TEXT NOT NULL ,";

    public  AddressRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Address findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_CITY,
                        COLUMN_STREET,
                        COLUMN_COUNTRY,
                        COLUMN_ZIPCODE,},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {

            final Address address = new Address.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .city(cursor.getString(cursor.getColumnIndex(COLUMN_CITY)))
                    .street(cursor.getString(cursor.getColumnIndex(COLUMN_STREET)))
                    .country(cursor.getString(cursor.getColumnIndex(COLUMN_COUNTRY)))
                    .zipCode(cursor.getString(cursor.getColumnIndex(COLUMN_ZIPCODE)))
                    .build();
            return address;
        }else {
            return null;
        }

    }

    @Override
    public Address save(Address entity){

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_CITY, entity.getCity());
        values.put(COLUMN_STREET, entity.getStreet());
        values.put(COLUMN_COUNTRY, entity.getCountry());
        values.put(COLUMN_ZIPCODE,entity.getZipCode());


        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Address insertedEntity = new Address.Builder()
                .copy(entity)
                .id(new Long (id))
                .build();
        return insertedEntity;
    }

    @Override
    public Address update(Address entity){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_CITY, entity.getCity());
        values.put(COLUMN_STREET, entity.getStreet());
        values.put(COLUMN_COUNTRY, entity.getCountry());
        values.put(COLUMN_ZIPCODE,entity.getZipCode());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;

    }

    @Override
    public Address delete(Address entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Address> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Address> addressess = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {

            final Address address = new Address.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .city(cursor.getString(cursor.getColumnIndex(COLUMN_CITY)))
                    .street(cursor.getString(cursor.getColumnIndex(COLUMN_STREET)))
                    .country(cursor.getString(cursor.getColumnIndex(COLUMN_COUNTRY)))
                    .zipCode(cursor.getString(cursor.getColumnIndex(COLUMN_ZIPCODE)))
                    .build();
            addressess.add(address);
            } while (cursor.moveToNext());
        }
        return addressess;
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
