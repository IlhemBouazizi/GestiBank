package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void interfaceConversionDevise(View view){
        Intent i = new Intent(MainActivity.this, ConversionActivity.class);
        startActivity(i);
    }

    public void addNewClient(View view){
        Intent i = new Intent(MainActivity.this, NewClient.class);
        startActivity(i);
    }

    public void CallEspaceAdminActivity(View view){
        Intent i = new Intent(getApplicationContext(), EspaceAdminActivity.class);
        startActivity(i);
    }

    public void CallAuthentificationAdminActivity(View view){
        Intent i = new Intent(getApplicationContext(), AuthentificationActivity.class);
        startActivity(i);
    }
}

