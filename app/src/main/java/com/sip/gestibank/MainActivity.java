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

    public void CallCreationCompteActivity(View view){
        Intent i = new Intent(getApplicationContext(), CreationCompteActivity.class);
        startActivity(i);
    }

    public void CallConversionActivity(View view){
        Intent i = new Intent(getApplicationContext(), ConversionActivity.class);
        startActivity(i);
    }
}

