package android.tadoo.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {

    private String db_name;

    private DataBase(Context context) {
        super(context, "Workito", null, 1);
        //super(context, Resources.getSystem().getString(R.string.db_table_User), null, Integer.valueOf(Resources.getSystem().getString(R.string.db_version)));
    }

    private String SQLiteCreate = "CREATE TABLE User (id INT PRIMARY KEY, Name TEXT, Password TEXT)";

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLiteCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private static DataBase INSTANCE = null;

    public static DataBase getInstance(Context ctx) {

        if (INSTANCE == null) {
            INSTANCE = new DataBase(ctx.getApplicationContext());
        }

        return INSTANCE;
    }
}
