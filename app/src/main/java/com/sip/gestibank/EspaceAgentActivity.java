package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EspaceAgentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_agent);
    }
    public void CallAuthentificationClientActivity(View view){
        Intent i = new Intent(getApplicationContext(), AuthentificationActivity.class);
        startActivity(i);
    }
}