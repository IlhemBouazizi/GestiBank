package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EspaceAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_admin);
    }

    public void CallAjouterUnAgentActivity(View view){
        Intent i = new Intent(getApplicationContext(), AjouterUnAgentActivity.class);
        startActivity(i);
    }

    public void CallConsulterLesDemandesActivity(View view){
        Intent i = new Intent(getApplicationContext(), ConsulterLesDemandesActivity.class);
        startActivity(i);
    }

    public void CallListeDesAgentsActivity(View view){
        Intent i = new Intent(getApplicationContext(), ListeDesAgentsActivity.class);
        startActivity(i);
    }
}