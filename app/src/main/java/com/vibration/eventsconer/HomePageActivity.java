package com.vibration.eventsconer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }



    public void GoToLogin(View view) {
        startActivity(new Intent(HomePageActivity.this, LoginActivity.class));
    }

    public void GoToEventsType(View view) {
        startActivity(new Intent(HomePageActivity.this,EventsTypes.class));
    }
}
