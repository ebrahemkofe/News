package com.colleg.project.news.NavigationDrawer;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.colleg.project.news.R;

public class navigationInOurApp extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_in_our_app);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            getWindow().getDecorView().setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         final DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        toolbar.setNavigationIcon(R.drawable.right);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() { @Override public void onClick(View v) { drawer.openDrawer(Gravity.RIGHT); } });
displaySelectedScreen(R.id.main_home);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_in_our_app, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void displaySelectedScreen(int id)
    {
        Fragment frag = null ;

        switch (id) {
            case R.id.home:
                frag = new MainHome();
                break;
            case R.id.urgent:
                frag = new Urgent();
                break;
            case R.id.detection:
                frag = new Detection();
                break;
            case R.id.politics:
                frag = new Politics();
                break;
            case R.id.events:
                frag = new Events();
                break;
            case R.id.reports:
                frag = new Reports();
                break;
            case R.id.governorates:
                frag = new Governorates();
                break;
            case R.id.settings:
                frag = new Settings();
                break;
            case R.id.logout:
                frag = new Logout();
                break;
        }
                if (frag != null)
                {
                    FragmentTransaction FT = getSupportFragmentManager().beginTransaction();
                    FT.replace(R.id.content_main , frag);
                    FT.commit();
                }
            DrawerLayout drawer =  findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


displaySelectedScreen(id);

        return true;
    }
}
