package com.example.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    Uri webaddress;
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
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button secondactivitybtn = (Button) findViewById(R.id.secondactivitybtn);
        Button thirdactivitybtn = (Button) findViewById(R.id.thirdactivitybtn);
        final Button googlebtn = (Button) findViewById(R.id.googlebtn);
        googlebtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                webaddress  = Uri.parse(getResources().getString(R.string.web_address));
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, webaddress));
                 finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        secondactivitybtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(MainActivity.this, Main2Activity.class));
                if(googlebtn.getVisibility() == View.VISIBLE ){
                    googlebtn.setVisibility(View.GONE);
                } else{
                    googlebtn.setVisibility(View.VISIBLE);
                }
            }
        });
        thirdactivitybtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Main3Activity.class));

            }
        });
        }

    private void startIntent(Intent startIntent) {
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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
