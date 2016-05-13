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
import cput.za.ac.ecommerce_clothingapp.domain.ShoppingCart;
import cput.za.ac.ecommerce_clothingapp.repository.dom.ShoppingCartRepository;

/**
 * Created by Admin on 2016-05-04.
 */
public class ShoppingCartRepositoryImpl extends SQLiteOpenHelper implements ShoppingCartRepository {

    public static final String TABLE_NAME="shoppingCart";
    private SQLiteDatabase db;

    public static final String COLUMN_ID="id";
    public static final String COLUMN_PRODUCTID="productId";
    public static final String COLUMN_SESSIONID="sessionId";
    public static final String COLUMN_QUANTITY="quantity";
    public static final String COLUMN_PRICE="price";
    public static final String COLUMN_CREATE="created";



    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            +TABLE_NAME +"("
            +COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_PRODUCTID + "INTEGER  NOT NULL , "
            +COLUMN_SESSIONID +"INTEGER  NOT NULL ,"
            +COLUMN_QUANTITY +"INTEGER NOT NULL ,"
            +COLUMN_PRICE +"INTEGER NOT NULL ,"
            +COLUMN_CREATE +"DATE NOT NULL);";

    public ShoppingCartRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);

    }


    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public ShoppingCart findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_PRODUCTID,
                        COLUMN_SESSIONID,
                        COLUMN_QUANTITY,
                        COLUMN_PRICE,
                        COLUMN_CREATE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {

            final ShoppingCart cart = new ShoppingCart.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .productId(cursor.getLong(cursor.getColumnIndex(COLUMN_PRODUCTID)))
                    .sessionId(cursor.getLong(cursor.getColumnIndex(COLUMN_SESSIONID)))
                    .quantity(cursor.getInt(cursor.getColumnIndex(COLUMN_QUANTITY)))
                    .price(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)))
                    .dateCreated(AppUtil.getDate(cursor.getString(cursor.getColumnIndex( COLUMN_CREATE))))
                    .build();
            return cart ;
        }else {
            return null;
        }

    }

    @Override
    public ShoppingCart save(ShoppingCart entity){

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_PRODUCTID, entity.getProductId());
        values.put(COLUMN_SESSIONID, entity.getSessionId());
        values.put(COLUMN_QUANTITY, entity.getQauntity());
        values.put(COLUMN_PRICE, entity.getPrice());
        values.put(COLUMN_CREATE, entity.getCreated().toString());




        long id = db.insertOrThrow(TABLE_NAME, null, values);
        ShoppingCart insertedEntity = new ShoppingCart.Builder()
                .copy(entity)
                .id(new Long (id))
                .build();
        return insertedEntity;
    }

    @Override
    public ShoppingCart update(ShoppingCart entity){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_PRODUCTID, entity.getProductId());
        values.put(COLUMN_SESSIONID, entity.getSessionId());
        values.put(COLUMN_QUANTITY, entity.getQauntity());
        values.put(COLUMN_PRICE, entity.getPrice());
        values.put(COLUMN_CREATE, entity.getCreated().toString());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;

    }

    @Override
    public ShoppingCart  delete(ShoppingCart  entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<ShoppingCart > findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<ShoppingCart>  cart = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final ShoppingCart  cart1 = new ShoppingCart.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .productId(cursor.getLong(cursor.getColumnIndex(COLUMN_PRODUCTID)))
                        .sessionId(cursor.getLong(cursor.getColumnIndex(COLUMN_SESSIONID)))
                        .quantity(cursor.getInt(cursor.getColumnIndex(COLUMN_QUANTITY)))
                        .price(cursor.getDouble(cursor.getColumnIndex(COLUMN_PRICE)))
                        .dateCreated(AppUtil.getDate(cursor.getString(cursor.getColumnIndex( COLUMN_CREATE))))
                        .build();
                cart.add(cart1);
            } while (cursor.moveToNext());
        }
        return cart;
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
