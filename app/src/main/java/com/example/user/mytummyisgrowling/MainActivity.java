package com.example.user.mytummyisgrowling;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void doSomething (View v) {
        if (v.getId() == R.id.button) {
            android.util.Log.d ("Matt", "Create Profile Button was clicked");
        } else if (v.getId () == R.id.button2) {
            android.util.Log.d ("Matt", "Login Button was clicked");
        }
    }

    public void createProfile (View v) {
        Intent i = new Intent(this, CreateProfile.class);
        startActivity (i);
    }

    int counter = 0;

    @Override
    protected void onResume() {
        super.onResume();
        counter++;
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("counter", counter);
        Log.d("Matt", counter + " " + "was saved");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("counter");
        Log.d("Matt", counter + " " + "was stored");
    }
}
