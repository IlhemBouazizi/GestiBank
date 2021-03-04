package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.sip.gestibank.models.Agent;
import com.sip.gestibank.remote.APIUtil;
import com.sip.gestibank.remote.AgentService;

public class EspaceAdminActivity extends AppCompatActivity {
    AgentService agentService;
    List<Agent> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espace_admin);
        agentService = APIUtil.getAgentService();


    }

    public void getAgentsList(View v) {

        Call<List<Agent>> call = agentService.getAgents();
        call.enqueue(new Callback<List<Agent>>() {
            @Override
            public void onResponse(Call<List<Agent>> call, Response<List<Agent>> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    Log.i("Data: ", list.toString());

                    StringBuffer buffer = new StringBuffer();
                    for (Agent user : list) {

                        buffer.append("Nom et prénom: " + user.getName() + " " + user.getPrenom() + "\n\n");
                        buffer.append("Email: " + user.getEmail() + "\n\n");
                        buffer.append("Matricule: " + user.getMatricule() + "\n\n");
                    }
                    showMessage("Liste des agents dans la banque", buffer.toString());

                    // listView.setAdapter(new UserAdapter(MainActivity.this, R.layout.list_user, list));
                }
            }

            @Override
            public void onFailure(Call<List<Agent>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    public void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }


    public void CallAjouterUnAgentActivity(View view){
        Intent i = new Intent(getApplicationContext(), NewAgent.class);
        startActivity(i);
    }

    public void CallConsulterLesDemandesActivity(View view){
        Intent i = new Intent(getApplicationContext(), ConsulterLesDemandesActivity.class);
        startActivity(i);
    }

    public void CallAuthentificationAdminActivity(View view){
        Intent i = new Intent(getApplicationContext(), AuthentificationActivity.class);
        startActivity(i);
    }
/*
   public void CallListeDesAgentsActivity(View view){
        Intent i = new Intent(getApplicationContext(), ListeDesAgentsActivity.class);
        startActivity(i);
    }*/
}