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
import cput.za.ac.ecommerce_clothingapp.domain.User;
import cput.za.ac.ecommerce_clothingapp.repository.dom.UserRepository;

/**
 * Created by Admin on 2016-05-04.
 */
public class UserRepositoryImpl extends SQLiteOpenHelper implements UserRepository {

    public static final String TABLE_NAME="user";
    private SQLiteDatabase db;

    public static final String COLUMN_USERID="userId";
    public static final String COLUMN_ACCOUNTID ="accountId";
    public static final String COLUMN_ADDRESSID ="addressId";
    public static final String COLUMN_FIRSTNAME ="firstName";
    public static final String COLUMN_SURNAME="surName";
    public static final String COLUMN_CONTACTNO="contactNo";
    public static final String COLUMN_GENDER="gender";
    public static final String COLUMN_EMAIL="email";
    public static final String COLUMN_DESCRIPTION="description";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            +TABLE_NAME +"("
            +COLUMN_USERID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_ACCOUNTID + "INTEGER  NOT NULL , "
            +COLUMN_ADDRESSID +"INTEGER  NOT NULL ,"
            +COLUMN_FIRSTNAME+"TEXT NOT NULL ,"
            +COLUMN_SURNAME +"TEXT NOT NULL ,"
            +COLUMN_CONTACTNO + "TEXT NOT NULL,"
            +COLUMN_GENDER +"TEXT NOT NULL ,"
            +COLUMN_EMAIL+ "TEXT NOT NULL ,"
            +COLUMN_DESCRIPTION +"TEXT NOT NULL);";


    public UserRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);

    }
    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public User findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_USERID,
                        COLUMN_ACCOUNTID,
                        COLUMN_ADDRESSID,
                        COLUMN_FIRSTNAME,
                        COLUMN_SURNAME,
                        COLUMN_CONTACTNO,
                        COLUMN_GENDER,
                        COLUMN_EMAIL,
                        COLUMN_DESCRIPTION},
                COLUMN_USERID+ " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {

            final User user = new User.Builder()
                    .userId(cursor.getLong(cursor.getColumnIndex(COLUMN_USERID)))
                    .accountId(cursor.getLong(cursor.getColumnIndex(COLUMN_ACCOUNTID)))
                    .addressId(cursor.getLong(cursor.getColumnIndex(COLUMN_ADDRESSID)))
                    .firstName(cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME)))
                    .surName(cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME)))
                    .contactNo(cursor.getString(cursor.getColumnIndex(COLUMN_CONTACTNO)))
                    .gender(cursor.getString(cursor.getColumnIndex( COLUMN_GENDER)))
                    .email(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)))
                    .description(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)))
                    .build();
            return user ;
        }else {
            return null;
        }

    }

    @Override
    public User save(User entity){

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERID, entity.getUserId());
        values.put(COLUMN_ACCOUNTID, entity.getAccountId());
        values.put(COLUMN_ADDRESSID, entity.getAddressId());
        values.put(COLUMN_FIRSTNAME, entity.getFirstName());
        values.put(COLUMN_SURNAME, entity.getSurName());
        values.put(COLUMN_CONTACTNO, entity.getContactNo());
        values.put(COLUMN_GENDER, entity.getGender());
        values.put(COLUMN_EMAIL, entity.getEmail());
        values.put(COLUMN_DESCRIPTION, entity.getDescription());



        long id = db.insertOrThrow(TABLE_NAME, null, values);
        User insertedEntity = new User.Builder()
                .copy(entity)
                .userId(new Long (id))
                .build();
        return insertedEntity;
    }

    @Override
    public User update(User entity){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERID, entity.getUserId());
        values.put(COLUMN_ACCOUNTID, entity.getAccountId());
        values.put(COLUMN_ADDRESSID, entity.getAddressId());
        values.put(COLUMN_FIRSTNAME, entity.getFirstName());
        values.put(COLUMN_SURNAME, entity.getSurName());
        values.put(COLUMN_CONTACTNO, entity.getContactNo());
        values.put(COLUMN_GENDER, entity.getGender());
        values.put(COLUMN_EMAIL, entity.getEmail());
        values.put(COLUMN_DESCRIPTION, entity.getDescription());

        db.update(
                TABLE_NAME,
                values,
                COLUMN_USERID+ " =? ",
                new String[]{String.valueOf(entity.getUserId())}
        );
        return entity;

    }

    @Override
    public User delete(User entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_USERID + " =? ",
                new String[]{String.valueOf(entity.getUserId())});
        return entity;
    }

    @Override
    public Set<User> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<User> user = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final User user1 = new User.Builder()
                        .userId(cursor.getLong(cursor.getColumnIndex(COLUMN_USERID)))
                        .accountId(cursor.getLong(cursor.getColumnIndex(COLUMN_ACCOUNTID)))
                        .addressId(cursor.getLong(cursor.getColumnIndex(COLUMN_ADDRESSID)))
                        .firstName(cursor.getString(cursor.getColumnIndex(COLUMN_FIRSTNAME)))
                        .surName(cursor.getString(cursor.getColumnIndex(COLUMN_SURNAME)))
                        .contactNo(cursor.getString(cursor.getColumnIndex(COLUMN_CONTACTNO)))
                        .gender(cursor.getString(cursor.getColumnIndex( COLUMN_GENDER)))
                        .email(cursor.getString(cursor.getColumnIndex(COLUMN_EMAIL)))
                        .description(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)))
                        .build();
                user.add(user1);
            } while (cursor.moveToNext());
        }
        return user;
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
