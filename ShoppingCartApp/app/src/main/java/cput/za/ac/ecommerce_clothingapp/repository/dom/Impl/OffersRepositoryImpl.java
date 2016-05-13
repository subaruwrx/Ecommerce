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
import cput.za.ac.ecommerce_clothingapp.domain.Offers;
import cput.za.ac.ecommerce_clothingapp.repository.dom.OffersRepository;

/**
 * Created by Admin on 2016-05-03.
 */
public class OffersRepositoryImpl extends SQLiteOpenHelper implements OffersRepository {
    public static final String TABLE_NAME="offers";
    private SQLiteDatabase db;

    public static final String COLUMN_ID="id";
    public static final String COLUMN_PRODUCTID="productId";
    public static final String COLUMN_OFFERPRICE="offerPrice";
    public static final String COLUMN_DESCRIPTION="description";
    public static final String COLUMN_OFFERSTARTDATE="offerStartDate";
    public static final String COLUMN_OFFERENDDATE="offerEndDate";


    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            +TABLE_NAME +"("
            +COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_PRODUCTID + "INTEGER  NOT NULL , "
            +COLUMN_OFFERPRICE +"INTEGER  NOT NULL ,"
            +COLUMN_OFFERSTARTDATE +"DATE  NOT NULL ,"
            +COLUMN_OFFERENDDATE+"DATE  NOT NULL ,"
            +COLUMN_DESCRIPTION +"TEXT NOT NULL);";

    public OffersRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Offers findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_PRODUCTID,
                        COLUMN_OFFERPRICE,
                        COLUMN_OFFERSTARTDATE,
                        COLUMN_OFFERENDDATE,
                        COLUMN_DESCRIPTION},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {

            final Offers  offers = new Offers.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .productId(cursor.getLong(cursor.getColumnIndex(COLUMN_PRODUCTID)))
                    .offerPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_OFFERPRICE)))
                    .offerStartDate(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_OFFERSTARTDATE))))
                    .offerEndDate(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_OFFERENDDATE))))
                    .description(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)))
                    .build();
            return offers ;
        }else {
            return null;
        }

    }
    @Override
    public Offers save(Offers  entity){

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_PRODUCTID, entity.getProductId());
        values.put(COLUMN_OFFERPRICE, entity.getOfferPrice());
        values.put(COLUMN_OFFERSTARTDATE, entity.getOfferStartDate().toString());
        values.put(COLUMN_OFFERENDDATE, entity.getOfferEndDate().toString());
        values.put(COLUMN_DESCRIPTION, entity.getDescription());


        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Offers insertedEntity = new Offers.Builder()
                .copy(entity)
                .id(new Long (id))
                .build();
        return insertedEntity;
    }

    @Override
    public Offers update(Offers entity){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_PRODUCTID, entity.getProductId());
        values.put(COLUMN_OFFERPRICE, entity.getOfferPrice());
        values.put(COLUMN_OFFERSTARTDATE, entity.getOfferStartDate().toString());
        values.put(COLUMN_OFFERENDDATE, entity.getOfferEndDate().toString());
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
    public Offers delete(Offers entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Offers> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Offers> offers = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Offers offers1 = new Offers.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .productId(cursor.getLong(cursor.getColumnIndex(COLUMN_PRODUCTID)))
                        .offerPrice(cursor.getDouble(cursor.getColumnIndex(COLUMN_OFFERPRICE)))
                        .offerStartDate(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_OFFERSTARTDATE))))
                        .offerEndDate((AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_OFFERENDDATE)))))
                        .description(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)))
                        .build();
                offers.add(offers1);
            } while (cursor.moveToNext());
        }
        return offers;
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
