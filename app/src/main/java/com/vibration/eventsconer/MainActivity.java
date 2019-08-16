package com.vibration.eventsconer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Go_To_Home_Page(View view) {
        startActivity(new Intent(MainActivity.this, HomePageActivity.class));
    }
}
