package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EspaceClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_client);
    }

    public void CallAuthentificationClientActivity(View view){
        Intent i = new Intent(getApplicationContext(), AuthentificationActivity.class);
        startActivity(i);
    }
}