package com.example.matthew.testkotlin.sql

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.matthew.testkotlin.model.User

/**
 * Created by matthew on 10/2/18.
 */

val DATABASE_NAME = "UserManager"
val TABLE_USER = "User"
val COL_NAME = "user_name"
val COL_ID = "user_id"
val COL_EMAIL = "user_email"
val COL_NUM = "user_number"
val COL_PASSWORD = "user_password"

class dataBaseHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null,1){

    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = ("CREATE TABLE" + TABLE_USER + "("
                + COL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " TEXT," + COL_EMAIL + " TEXT," + COL_PASSWORD + " TEXT," + COL_NUM + " INTEGER" + ")")

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {


    }

    fun insertData(user: User){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME, user.name)
        cv.put(COL_EMAIL, user.email)
        cv.put(COL_PASSWORD, user.password)
        cv.put(COL_NUM,user.whatsApp)

        db.insert(TABLE_USER, null,cv)

    }

        fun readData() : MutableList<User>{

                var list : MutableList<User> = ArrayList()
                val db = this.readableDatabase
                val query = "Select * from " + TABLE_USER
                val result = db.rawQuery(query, null)
                if(result.moveToFirst()){
                        do{
                                var user = User()
                                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                                user.name = result.getString(result.getColumnIndex(COL_NAME))
                                user.email = result.getString(result.getColumnIndex(COL_EMAIL))
                                user.whatsApp = result.getString(result.getColumnIndex(COL_NUM)).toInt()
                                list.add(user)


                        }while (result.moveToFirst())
                }

                result.close()
                db.close()


                return list

        }


}


/**
        for java

        package com.example.matthew.testkotlin.sql;

        import android.content.ContentValues;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;

        /**
         * Created by matthew on 9/25/18.
        */

        public class databaseHelper extends SQLiteOpenHelper {

        private static final int DATABASE_VERSION = 1;

        private static final String DATABASE_NAME = "UserManager.db";
        private static final String TABLE_USER = "user";
        private static final String COLUMN_USER_ID = "user_id";
        private static final String COLUMN_USER_NAME = "user_name";
        private static final String COLUMN_USER_EMAIL= "user_email";
        private static final String COLUMN_USER_PASSWORD = "user_password";
        private static final String COLUMN_USER_LEVEL = "user_level";

        private String CREATE_USER_TABLE = "CREATE TABLE" + TABLE_USER + "("
        + COLUMN_USER_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_NAME + " TEXT," + COLUMN_USER_EMAIL + " TEXT," + COLUMN_USER_PASSWORD + " TEXT," + COLUMN_USER_LEVEL + " TEXT" + ")";
        private String DROP_USER_TABLE = "DROP USER IF EXISTS " + TABLE_USER;
        public databaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db){
        db.execSQL(CREATE_USER_TABLE);
        }

        @Override

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(DROP_USER_TABLE);
        onCreate(db);
        }

        public void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USER_NAME, user.getName());
        values.put(COLUMN_USER_EMAIL, user.getEmail());
        values.put(COLUMN_USER_LEVEL, user.getLevel());
        values.put(COLUMN_USER_PASSWORD, user.getPassword());

        db.insert(TABLE_USER, null, values);
        db.close();
        }

        public boolean checkUser(String email){
        String[] columns = {
        COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_EMAIL + " = ?";
        String[] selectionArgs = { email };

        Cursor cursor = db.query(TABLE_USER,
        columns,
        selection,
        selectionArgs,
        null,
        null,
        null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if(cursorCount > 0){
        return true;
        }
        return false;
        }

        public boolean checkUser(String email, String password){
        String[] columns = {
        COLUMN_USER_ID
        };
        SQLiteDatabase db = this.getWritableDatabase();
        String selection = COLUMN_USER_EMAIL + " = ?" + " AND " + COLUMN_USER_PASSWORD + " =?";
        String[] selectionArgs = { email };

        Cursor cursor = db.query(TABLE_USER,
        columns,
        selection,
        selectionArgs,
        null,
        null,
        null);
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if(cursorCount > 0){
        return true;
        }
        return false;
        }

        }
**/