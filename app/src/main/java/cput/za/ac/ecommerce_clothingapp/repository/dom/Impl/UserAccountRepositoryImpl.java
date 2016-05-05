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
import cput.za.ac.ecommerce_clothingapp.domain.UserAccount;
import cput.za.ac.ecommerce_clothingapp.repository.dom.UserAccountRepository;


/**
 * Created by Admin on 2016-05-03.
 */
public class UserAccountRepositoryImpl extends SQLiteOpenHelper implements UserAccountRepository {

    public static final String TABLE_NAME="userAccount";
    private SQLiteDatabase db;

    public static final String COLUMN_ID="id";
    public static final String COLUMN_ROLEID ="roleId";
    public static final String COLUMN_USERNAME =" userName";
    public static final String COLUMN_PASSWORD =" password";
    public static final String COLUMN_HINTQUESTION="hintQuestion";
    public static final String COLUMN_ANSWER ="answer";
    public static final String COLUMN_DESCRIPTION="description";



    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            +TABLE_NAME +"("
            +COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_ROLEID + "INTEGER  NOT NULL , "
            +COLUMN_USERNAME +"TEXT  NOT NULL ,"
            +COLUMN_PASSWORD +"TEXT NOT NULL ,"
            +COLUMN_ANSWER  +"TEXT NOT NULL ,"
            +COLUMN_DESCRIPTION+ "TEXT NOT NULL ,"
            +COLUMN_HINTQUESTION +"TEXT NOT NULL);";

    public UserAccountRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);

    }


    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public UserAccount findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_ROLEID,
                        COLUMN_USERNAME,
                        COLUMN_PASSWORD,
                        COLUMN_ANSWER,
                        COLUMN_DESCRIPTION,
                        COLUMN_HINTQUESTION},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {

            final UserAccount account = new UserAccount.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .roleId(cursor.getLong(cursor.getColumnIndex(COLUMN_ROLEID)))
                    .answer(cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER)))
                    .description(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)))
                    .hintQuestion(cursor.getString(cursor.getColumnIndex(COLUMN_HINTQUESTION)))
                    .build();
            return account ;
        }else {
            return null;
        }

    }

    @Override
    public UserAccount save(UserAccount entity){

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ROLEID, entity.getRoleId());
        values.put(COLUMN_ANSWER, entity.getAnswer());
        values.put(COLUMN_DESCRIPTION, entity.getDescription());
        values.put(COLUMN_HINTQUESTION, entity.getHintQuestion());



        long id = db.insertOrThrow(TABLE_NAME, null, values);
        UserAccount insertedEntity = new UserAccount.Builder()
                .copy(entity)
                .id(new Long (id))
                .build();
        return insertedEntity;
    }

    @Override
    public UserAccount update(UserAccount entity){
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ROLEID, entity.getRoleId());
        values.put(COLUMN_ANSWER, entity.getAnswer());
        values.put(COLUMN_DESCRIPTION, entity.getDescription());
        values.put(COLUMN_HINTQUESTION, entity.getHintQuestion());

        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;

    }

    @Override
    public UserAccount delete(UserAccount entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<UserAccount> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<UserAccount> user = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final UserAccount user1 = new UserAccount.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .roleId(cursor.getLong(cursor.getColumnIndex(COLUMN_ROLEID)))
                        .answer(cursor.getString(cursor.getColumnIndex(COLUMN_ANSWER)))
                        .description(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)))
                        .hintQuestion(cursor.getString(cursor.getColumnIndex(COLUMN_HINTQUESTION)))
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
