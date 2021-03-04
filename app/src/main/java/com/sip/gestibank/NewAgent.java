package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.sip.gestibank.models.Agent;

import com.sip.gestibank.models.Agent;
import com.sip.gestibank.remote.APIUtil;
import com.sip.gestibank.remote.AgentService;
import android.os.Bundle;

public class NewAgent extends AppCompatActivity {
    AgentService agentService;
    List<Agent>list;

    EditText name;
    EditText prenom;
    EditText email;
    EditText tel;
    EditText matricule;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_agent);
        agentService = APIUtil.getAgentService();

        name = (EditText) findViewById(R.id.editNameAgent);
        prenom = (EditText) findViewById(R.id.editPrenomAgent);
        email = (EditText) findViewById(R.id.editMailAgent);
        tel = (EditText) findViewById(R.id.editTelAgent);
        matricule = (EditText) findViewById(R.id.editMatriculeAgent);

    }
    public void addNewAgent(View v){


        Agent agent= new Agent(name.getText().toString(),prenom.getText().toString(), email.getText().toString(),tel.getText().toString(),matricule.getText().toString());
        Call<Agent> call = agentService.addAgent(agent);
        call.enqueue(new Callback<Agent>() {
            @Override
            public void onResponse(Call<Agent> call, Response<Agent> response) {
                if(response.isSuccessful()){
                    Toast.makeText(NewAgent.this, "Agent created successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Agent> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

    }
    public void getAgentsList(){
        Call<List<Agent>> call = agentService.getAgents();
        call.enqueue(new Callback<List<Agent>>() {
            @Override
            public void onResponse(Call<List<Agent>> call, Response<List<Agent>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    Log.i("Data: ", list.toString());

                    StringBuffer buffer=new StringBuffer();
                    for (Agent user : list)
                    {

                        buffer.append("Name: "+user.getName()+"\n");
                        buffer.append("Email: "+user.getEmail()+"\n\n");

                    }
                    showMessage("Agents List", buffer.toString());

                    // listView.setAdapter(new UserAdapter(MainActivity.this, R.layout.list_user, list));
                }
            }

            @Override
            public void onFailure(Call<List<Agent>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}