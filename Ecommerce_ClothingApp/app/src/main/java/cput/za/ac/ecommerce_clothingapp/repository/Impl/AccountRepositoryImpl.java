package cput.za.ac.ecommerce_clothingapp.repository.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.HashSet;
import java.util.Set;
import cput.za.ac.ecommerce_clothingapp.config.util.AppUtil;
import cput.za.ac.ecommerce_clothingapp.domain.Account;
import cput.za.ac.ecommerce_clothingapp.config.databases.DBConstants;
import cput.za.ac.ecommerce_clothingapp.repository.AccountRepository;

/**
 * Created by Admin on 2016-04-23.
 */
public class AccountRepositoryImpl extends SQLiteOpenHelper implements AccountRepository
{

    public static final String TABLE_NAME="account";
    private SQLiteDatabase db;

    public static final String COLUMN_ID="id";
    public static final String COLUMN_ACCOUNTNUMBER="accountNumber";
   // public static final String COLUMN_ADDRESS="address";
    public static final String COLUMN_OPENINGDATE="open";
    public static final String COLUMN_CLOSEDATE="closedate";
    public static final String COLUMN_IS_CLOSED="is_closed";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            +TABLE_NAME +"("
            +COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_ACCOUNTNUMBER + " TEXT  NOT NULL , "
            //+COLUMN_ADDRESS + "TEXT NOT NULL ,"
            +COLUMN_OPENINGDATE +"DATE NOT NULL ,"
            +COLUMN_CLOSEDATE +"DATE NOT NULL ,"
            +COLUMN_IS_CLOSED + "TEXT NOT NULL);";

    public  AccountRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Account findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_ACCOUNTNUMBER,
                      //  COLUMN_ADDRESS,
                        COLUMN_OPENINGDATE,
                        COLUMN_CLOSEDATE,
                        COLUMN_IS_CLOSED},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {

            final Account account = new Account.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .accountNumber(cursor.getString(cursor.getColumnIndex(COLUMN_ACCOUNTNUMBER)))
                    .open(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_OPENINGDATE))))
                    .closed(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_CLOSEDATE))))
                     .is_Closed(cursor.getString(cursor.getColumnIndex(COLUMN_IS_CLOSED)))
                    .build();
            return account;
        }else {
            return null;
        }

    }
    //@Override
    public Account save(Account entity){

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ACCOUNTNUMBER, entity.getAccountNumber());
        values.put(COLUMN_OPENINGDATE, entity.getOpen().toString());
        values.put(COLUMN_CLOSEDATE, entity.getClosed().toString());
        values.put(COLUMN_IS_CLOSED, entity.is_closed());

        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Account insertedEntity = new Account.Builder()
                .copy(entity)
                .id(new Long (id))
                .build();
        return insertedEntity;
    }

    @Override
    public Account update(Account entity){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ACCOUNTNUMBER, entity.getAccountNumber());
        values.put(COLUMN_OPENINGDATE, entity.getOpen().toString());
        values.put(COLUMN_CLOSEDATE, entity.getClosed().toString());
        values.put(COLUMN_IS_CLOSED, entity.is_closed());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;

    }

    @Override
    public Account delete(Account entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Account> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Account> accounts = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
            final Account account = new Account.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .accountNumber(cursor.getString(cursor.getColumnIndex(COLUMN_ACCOUNTNUMBER)))
                    .open(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_OPENINGDATE))))
                    .closed(AppUtil.getDate(cursor.getString(cursor.getColumnIndex(COLUMN_CLOSEDATE))))
                    .is_Closed(cursor.getString(cursor.getColumnIndex(COLUMN_IS_CLOSED)))
                    .build();
            accounts.add(account);
        } while (cursor.moveToNext());
    }
    return accounts;
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
