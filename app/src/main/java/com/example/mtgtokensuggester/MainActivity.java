package com.example.mtgtokensuggester;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import static com.example.mtgtokensuggester.Utils.sREQUEST_CODE_SETTINGS;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               openAddTokenActivity();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.action_settings) {
            showSettings();
        }

        return super.onOptionsItemSelected(item);
    }

    private void showSettings() {
        // Here, we open up our settings activity
        Intent intent = new Intent (getApplicationContext (), SettingsActivity.class);
        startActivityForResult (intent, sREQUEST_CODE_SETTINGS);
    }

    public void showAbout (MenuItem item)
    {
        Utils.showInfoDialog (MainActivity.this, R.string.about_dialog_title,
                R.string.about_dialog_banner);
    }

    public void openAddTokenActivity(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(), TokenAddingActivity.class);
        startActivity(intent);
    }

    public void openAddTokenActivity() {
        Intent intent = new Intent(getApplicationContext(), TokenAddingActivity.class);
        startActivity(intent);
    }

    public void openTokenListActivity(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(), TokenListActivity.class);
        startActivity(intent);
    }


}

