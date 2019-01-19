package com.adancruz.cedehaaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class StudentActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment;
            switch (item.getItemId()) {
                case R.id.st_navigation_home:
                    selectedFragment = new StHomeFragment();
                    break;
                case R.id.st_navigation_courses:
                    selectedFragment = new StCoursesFragment();
                    break;
                case R.id.st_navigation_notifications:
                    selectedFragment = new StNotificationsFragment();
                    break;
                case R.id.st_navigation_user:
                    selectedFragment = new StUserFragment();
                    break;
                default:
                    selectedFragment = new StHomeFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.st_container_activity,
                    selectedFragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.st_navView);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.st_container_activity,
                new StHomeFragment()).commit();

        Intent intent = this.getIntent();
        String nombre = intent.getStringExtra("nombre");
        AlertDialog.Builder builder = new AlertDialog.Builder(StudentActivity.this);
        builder.setMessage("¡Bienvenido estudiante, " + nombre + "!")
                .setNegativeButton("Continuar", null)
                .create()
                .show();
    }
}