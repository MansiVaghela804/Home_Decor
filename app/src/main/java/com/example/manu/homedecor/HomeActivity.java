package com.example.manu.homedecor;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener  {

    DatabaseHelper dbhelper;
    ListView listview;
    SearchView searchView;
    private Context context = this;
    ImageView voice;
    private static final int REQUEST_CODE = 1234;
    CustomAdapter customAdapter;
    String[] items = new String[]{"Furniture", "Decor", "Furnishing", "Kitchen", "Dining", "Bath & Laundary", "Kids"};
    public static int[] language_images = {R.drawable.furniture,
            //temporary images
            R.drawable.decor,
            R.drawable.furnishing,
            R.drawable.kitchen,
            R.drawable.dining,
            R.drawable.bathlaundary,
            R.drawable.kids,
            R.mipmap.ic_launcher};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        searchView = (SearchView) findViewById(R.id.searchview);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        voice = (ImageView) findViewById(R.id.voice);
        voice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Voice searching...");
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        dbhelper = new DatabaseHelper(HomeActivity.this);
        listview = findViewById(R.id.ListView);

        customAdapter = new CustomAdapter( items,HomeActivity.this, language_images);
        listview.setAdapter(customAdapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(HomeActivity.this, FurnitureActivity.class);
                   startActivity(intent);
                }
                if (position == 1) {
                    Intent intent = new Intent(HomeActivity.this, DecorActivity.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(HomeActivity.this, FurnishingActivity.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(HomeActivity.this, KitchenActivity.class);
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(HomeActivity.this, DiningActivity.class);
                    startActivity(intent);
                }
                if (position == 5) {
                    Intent intent = new Intent(HomeActivity.this, BathLaundaryActivity.class);
                    startActivity(intent);
                }
                if (position == 6) {
                    Intent intent = new Intent(HomeActivity.this, KidsActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_camera) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivity(intent);
        } else if (id == R.id.nav_my_account) {
            Intent intent = new Intent(HomeActivity.this, MyAccountActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_my_models) {

        } else if (id == R.id.nav_wishlist) {

        } else if (id == R.id.nav_rating_feedback) {
            Intent intent = new Intent(HomeActivity.this, RatingFeedbackActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_contact_us) {
            Intent intent = new Intent(HomeActivity.this, ContactUsActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_logout) {
            AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
            builder.setTitle("Confirm Logout");
            builder.setMessage("Are you sure you want to close this app?");
            builder.setCancelable(false);
            builder.setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                    Toast.makeText(HomeActivity.this, "Logout Sucessfully", Toast.LENGTH_SHORT).show();
                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(HomeActivity.this, "Cancel", Toast.LENGTH_SHORT).show();
                }
            });
            builder.show();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
