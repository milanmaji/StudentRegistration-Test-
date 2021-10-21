package com.sitapuramargram.studentregistration.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.sitapuramargram.studentregistration.R;
import com.sitapuramargram.studentregistration.fragments.ExamLocationFragment;
import com.sitapuramargram.studentregistration.fragments.SubjectListFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TextView toolbarText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbarText = findViewById(R.id.toolbar_title);
        navigationView.setNavigationItemSelectedListener(this);

        if(savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new SubjectListFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_subject_list);
            toolbarText.setText(getResources().getString(R.string.subjects));
        }

        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });
        toggle.setHomeAsUpIndicator(R.drawable.ic_menu_white);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_subject_list:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SubjectListFragment()).commit();
                toolbarText.setText(getResources().getString(R.string.subjects));
                navigationView.setCheckedItem(R.id.nav_subject_list);
                break;

            case R.id.nav_exam_location:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ExamLocationFragment()).commit();
                toolbarText.setText(getResources().getString(R.string.exam_location));
                navigationView.setCheckedItem(R.id.nav_exam_location);
                break;


        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}