package android.tadoo.ui.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.tadoo.R;
import android.tadoo.ui.home.HomeActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        BottomNavBarActions();
    }

    private void BottomNavBarActions() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavView_Bar);

        Menu menu = bottomNavigationView.getMenu();
        MenuItem menuItem = menu.getItem(2);
        menuItem.setChecked(true);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch(menuItem.getItemId())
                {
                    case R.id.navigation_home:
                        intent = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                        break;

                    case R.id.navigation_notifications:
                        intent = new Intent(getApplicationContext(), UserActivity.class);
                        startActivity(intent);
                        break;
                }

                return false;
            }
        });
    }
}
