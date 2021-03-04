package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.sip.gestibank.models.Agent;

import com.sip.gestibank.remote.APIUtil;
import com.sip.gestibank.remote.AgentService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListeDesAgentsActivity extends AppCompatActivity {

    AgentService agentService;
    List<Agent> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_des_agents);

      /*  agentService = APIUtil.getAgentService();




        ListView listView = (ListView) findViewById(R.id.listViewAgents);

        List<Agent> image_details = getAgentsList();

        listView.setAdapter(new CustomListAdapter(this, image_details));*/



       /*Agent agent1 = new Agent("test1", "test1","test1", "1234", "1234");
        Agent agent2 = new Agent("test2", "test2","test2", "1234", "1234");
        Agent agent3 = new Agent("test3", "test3","test3", "1234", "1234");
        Agent[] agents = new Agent[]{agent1,agent2,agent3};
        ArrayAdapter<Agent> arrayAdapter
                = new ArrayAdapter<Agent>(this, android.R.layout.simple_list_item_1, agents);
        listView.setAdapter(arrayAdapter);*/


        // When the user clicks on the ListItem
        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id)
            {
                Object o = listView.getItemAtPosition(position);
                Agent agent = (Agent) o;
                Toast.makeText(ListeDesAgentsActivity.this, "Selected :" + " " + agent,
                        Toast.LENGTH_LONG).show();
            }
        });*/
    }
/*
    private List<Agent> getAgentsList3(){
        List<Agent> list_to_return = new ArrayList<Agent>();
        Call<List<Agent>> call = agentService.getAgents();
        call.enqueue(new Callback<List<Agent>>() {
            @Override
            public void onResponse(Call<List<Agent>> call, Response<List<Agent>> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    Log.i("Data: ", list.toString());

                    StringBuffer buffer = new StringBuffer();
                    for (Agent user : list) {

                        buffer.append("Nom et prénom: " + user.getName() + " "+ user.getPrenom() + "\n\n");
                        buffer.append("Email: " + user.getEmail() + "\n\n");
                        buffer.append("Matricule: " + user.getMatricule() + "\n\n");
                        list_to_return.add(user);
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

        return list_to_return;
    }

    private List<Agent> getAgentsList7() {
        List<Agent> list = new ArrayList<Agent>();
        Agent Ali = new Agent("BENALI","Ali","ali@gmail.com","0611223344","G124");
        Agent Salah = new Agent("BENSALAH","Salah","salah@gmail.com","0611223355","G125");
        Agent Ahmed = new Agent("BENAHMED","Ahmed","ahmed@gmail.com","0611223366","G126");

        list.add(Ali);
        list.add(Salah);
        list.add(Ahmed);

        return list;
    }

    private List<Agent>  getAgentsList(){

        List<Agent> list_to_return = new ArrayList<Agent>();
        Call<List<Agent>> call = agentService.getAgents();

        StringBuffer buffer = new StringBuffer();

        buffer.append("Gazouz 1 \n\n");

        showMessage("Liste des agents dans la banque", buffer.toString());




        call.enqueue(new Callback<List<Agent>>() {
            @Override
            public void onResponse(Call<List<Agent>> call, Response<List<Agent>> response) {

                buffer.append("Gazouz 2 \n\n");

                if (response.isSuccessful()) {

                    buffer.append("Gazouz 3 \n\n");

                    list = response.body();
                    Log.i("Data: ", list.toString());

                    StringBuffer buffer = new StringBuffer();
                    for (Agent user : list) {

                        buffer.append("Nom et prénom: " + user.getName() + " "+ user.getPrenom() + "\n\n");
                        buffer.append("Email: " + user.getEmail() + "\n\n");
                        buffer.append("Matricule: " + user.getMatricule() + "\n\n");
                    }
                    showMessage("Liste des agents dans la banque", buffer.toString());

                    // listView.setAdapter(new UserAdapter(MainActivity.this, R.layout.list_user, list));
                }
                else
                {
                    buffer.append("Gazouz 3 \n\n");
                }


            }
            @Override
            public void onFailure(Call<List<Agent>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());

                buffer.append("Gazouz 3 \n\n");

                showMessage("Liste des agents dans la banque", buffer.toString());

            }



        });

        return list_to_return;
    }
    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }*/
}