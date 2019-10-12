package android.tadoo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.tadoo.ui.LoginActivity;
import android.tadoo.ui.Home.HomeActivity;
import android.util.Log;

import static android.tadoo.DB.DataBase.getInstance;

public class LoadingActivity extends AppCompatActivity {

    private SQLiteDatabase _dataBase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        _dataBase = getInstance(this).getReadableDatabase();

        try {
            Cursor cursor = _dataBase.rawQuery("SELECT * FROM User;", null);

            if (cursor.getCount() > 0) {

                Log.e("LOGIN", "Tenemos usuario");
                while (cursor.moveToNext()){
                    String data = cursor.getString(1);
                    Log.e("LOGIN", data);

                    GoToHomePage();
                }
                cursor.close();
            } else {
                GoToLoginActivity();
            }
        } catch (Exception ex) {
            Log.e("DB", ex.getMessage());
        }
    }

    private void GoToHomePage() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    private void GoToLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }


}
