package android.tadoo.ui;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.tadoo.R;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import static android.tadoo.DB.DataBase.getInstance;

public class LoginActivity extends AppCompatActivity {

    private SQLiteDatabase _dataBase;

    private TextView textEmailAddress, textPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        GetReferences();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                _dataBase = getInstance(getApplicationContext()).getWritableDatabase();

                if (_dataBase != null) {
                    Log.e("DB", "DB created");

                    try {
                        ContentValues values = new ContentValues();

                        values.put("Password", textPassword.getText().toString());
                        values.put("Name", textEmailAddress.getText().toString());

                        boolean result = _dataBase.insert("User", null, values) > 0;
                        _dataBase.close();

                    } catch (Exception ex) {
                        Log.e("DB", ex.getMessage());
                    }
                }
            }
        });

    }

    private void GetReferences() {
        textEmailAddress = findViewById(R.id.email);
        textPassword = findViewById(R.id.password);

        btnLogin = findViewById(R.id.btnLogin);
    }
}
