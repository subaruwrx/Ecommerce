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
import cput.za.ac.ecommerce_clothingapp.config.util.AppUtil;
import cput.za.ac.ecommerce_clothingapp.domain.WishList;
import cput.za.ac.ecommerce_clothingapp.repository.dom.WishListRepository;

/**
 * Created by Admin on 2016-05-03.
 */
public class WishListRepoditoryImpl extends SQLiteOpenHelper implements WishListRepository {

    public static final String TABLE_NAME="wishList";
    private SQLiteDatabase db;

    public static final String COLUMN_ID="id";
    public static final String COLUMN_PRODUCTID="productId";
    public static final String COLUMN_CUSTOMERID="customerId";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_INSERTDATE="insertDate";



    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            +TABLE_NAME +"("
            +COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_PRODUCTID + "INTEGER  NOT NULL , "
            +COLUMN_CUSTOMERID +"INTEGER  NOT NULL ,"
            +COLUMN_NAME +"TEXT NOT NULL ,"
            +COLUMN_INSERTDATE +"DATE NOT NULL);";

    public WishListRepoditoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);

    }


    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public WishList findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_PRODUCTID,
                        COLUMN_CUSTOMERID,
                        COLUMN_NAME,
                        COLUMN_INSERTDATE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {

            final WishList list = new WishList.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .productId(cursor.getLong(cursor.getColumnIndex(COLUMN_PRODUCTID)))
                    .customerId(cursor.getLong(cursor.getColumnIndex( COLUMN_CUSTOMERID)))
                    .insertDate(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_INSERTDATE))))
                    .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                    .build();
            return list ;
        }else {
            return null;
        }

    }

    @Override
    public WishList save(WishList entity){

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_PRODUCTID, entity.getProductId());
        values.put(COLUMN_CUSTOMERID, entity.getCustomerId());
        values.put(COLUMN_INSERTDATE, entity.getInsertDate().toString());
        values.put(COLUMN_NAME, entity.getName());



        long id = db.insertOrThrow(TABLE_NAME, null, values);
        WishList insertedEntity = new WishList.Builder()
                .copy(entity)
                .id(new Long (id))
                .build();
        return insertedEntity;
    }

    @Override
    public WishList update(WishList entity){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_PRODUCTID, entity.getProductId());
        values.put(COLUMN_CUSTOMERID, entity.getCustomerId());
        values.put(COLUMN_INSERTDATE, entity.getInsertDate().toString());
        values.put(COLUMN_NAME, entity.getName());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;

    }

    @Override
    public WishList delete(WishList entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<WishList> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<WishList> list = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final WishList list1 = new WishList.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .productId(cursor.getLong(cursor.getColumnIndex(COLUMN_PRODUCTID)))
                        .customerId(cursor.getLong(cursor.getColumnIndex( COLUMN_CUSTOMERID)))
                        .insertDate(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_INSERTDATE))))
                        .name(cursor.getString(cursor.getColumnIndex(COLUMN_NAME)))
                        .build();
                list.add(list1);
            } while (cursor.moveToNext());
        }
        return list;
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
