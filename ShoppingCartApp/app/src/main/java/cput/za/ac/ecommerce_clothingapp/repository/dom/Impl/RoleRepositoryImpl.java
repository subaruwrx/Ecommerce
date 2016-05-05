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
import cput.za.ac.ecommerce_clothingapp.domain.Role;
import cput.za.ac.ecommerce_clothingapp.repository.dom.RoleRepository;

/**
 * Created by Admin on 2016-05-04.
 */
public class RoleRepositoryImpl extends SQLiteOpenHelper implements RoleRepository {

    public static final String TABLE_NAME="role";
    private SQLiteDatabase db;

    public static final String COLUMN_ID="id";
    public static final String COLUMN_ROLE="role";
    public static final String COLUMN_DESCRIPTION="description";



    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            +TABLE_NAME +"("
            +COLUMN_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COLUMN_ROLE + "TEXT NOT NULL , "
            +COLUMN_DESCRIPTION +"TEXT NOT NULL);";

    public RoleRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }



    @Override
    public Role findById(Long id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_ROLE,
                        COLUMN_DESCRIPTION},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);

        if (cursor.moveToFirst()) {

            final Role  role = new Role.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .role(cursor.getString(cursor.getColumnIndex(COLUMN_ROLE)))
                    .description(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)))
                    .build();
            return role ;
        }else {
            return null;
        }

    }
    @Override
    public Role save(Role  entity){

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ROLE, entity.getRole());
        values.put(COLUMN_DESCRIPTION, entity.getDescription());


        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Role insertedEntity = new Role.Builder()
                .copy(entity)
                .id(new Long (id))
                .build();
        return insertedEntity;
    }

    @Override
    public Role update(Role entity){

        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_ROLE, entity.getRole());
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
    public Role delete(Role entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Role> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Role> role = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Role role1 = new Role.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .role(cursor.getString(cursor.getColumnIndex(COLUMN_ROLE)))
                        .description(cursor.getString(cursor.getColumnIndex(COLUMN_DESCRIPTION)))
                        .build();
                role.add(role1);
            } while (cursor.moveToNext());
        }
        return role;
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
