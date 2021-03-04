package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
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
    Agent[] AgentTableau = new Agent[100];
    View v;
    static String agent_name;
    static String agent_prenom;


    static String agent_email;


    static String agent_matr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_des_agents);



        getAgentsList();




        /*ListView listView = (ListView) findViewById(R.id.listViewAgents);

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

    public void getAgentsList() {
        agentService = APIUtil.getAgentService();
        Call<List<Agent>> call = agentService.getAgents();
        call.enqueue(new Callback<List<Agent>>() {
            @Override
            public void onResponse(Call<List<Agent>> call, Response<List<Agent>> response) {
                if (response.isSuccessful()) {
                    list = response.body();
                    Log.i("Data: ", list.toString());

                    ListView listView = (ListView) findViewById(R.id.listViewAgents);

                    listView.setAdapter(new CustomListAdapter(ListeDesAgentsActivity.this, list));

                    /*StringBuffer buffer = new StringBuffer();
                    for (Agent user : list) {

                        buffer.append("Nom et prénom : " + user.getName() + " " + user.getPrenom() + "\n\n");
                        buffer.append("Email: " + user.getEmail() + "\n\n");
                        buffer.append("Matricule: " + user.getMatricule() + "\n\n");
                    }
                    showMessage("Liste des agents dans la banque", buffer.toString());*/

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


    public void  getAgentsList2(Context Context) {

        agentService = APIUtil.getAgentService();

        Call<List<Agent>> call = agentService.getAgents();

        call.enqueue(new Callback<List<Agent>>() {
            @Override
            public void onResponse(Call<List<Agent>> call, Response<List<Agent>> response) {
                if (response.isSuccessful()) {

                    Toast.makeText(Context, "Succeed to get List", Toast.LENGTH_SHORT).show();

                    list = response.body();

                    ListView listView = (ListView) findViewById(R.id.listViewAgents);

                    listView.setAdapter(new CustomListAdapter(Context, list));

                    Log.i("Data: ", list.toString());

                    StringBuffer buffer = new StringBuffer();
                    for (Agent user : list) {

                        /*AgentTableau[Count].setName(user.getName());
                        AgentTableau[Count].setPrenom(user.getPrenom());
                        AgentTableau[Count].setEmail(user.getEmail());
                        AgentTableau[Count].setMatricule(user.getMatricule());*/


                        agent_name = user.getName();
                        agent_prenom = user.getPrenom();
                        agent_email= user.getEmail();
                        agent_matr = user.getMatricule();




                        buffer.append("Nom et prénom: " + agent_name + " " + agent_prenom + "\n\n");
                        buffer.append("Email: " + agent_email + "\n\n");
                        buffer.append("Matricule: " + agent_matr + "\n\n");

                    }
                    showMessage("Liste des agents dans la banque", buffer.toString());

                    // listView.setAdapter(new UserAdapter(MainActivity.this, R.layout.list_user, list));
                }
                else
                {
                    Toast.makeText(Context, "Error to get List", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Agent>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
                Toast.makeText(Context, "onFailure", Toast.LENGTH_SHORT).show();
            }
        });

        /*Agent Ali = new Agent("BENALI1","Ali","ali@gmail.com","0611223344","G124");
        Agent Salah = new Agent("BENSALAH1","Salah","salah@gmail.com","0611223355","G125");
        Agent Ahmed = new Agent("BENAHMED1","Ahmed","ahmed@gmail.com","0611223366","G126");

        list_to_return.add(Ali);
        list_to_return.add(Salah);
        list_to_return.add(Ahmed);

        AgentTableau[0].setName(Ali.getName());
        AgentTableau[0].setPrenom(Ali.getPrenom());
        AgentTableau[0].setEmail(Ali.getEmail());
        AgentTableau[0].setMatricule(Ali.getMatricule());

        AgentTableau[1].setName(Salah.getName());
        AgentTableau[1].setPrenom(Salah.getPrenom());
        AgentTableau[1].setEmail(Salah.getEmail());
        AgentTableau[1].setMatricule(Salah.getMatricule());

        AgentTableau[2].setName(Ahmed.getName());
        AgentTableau[2].setPrenom(Ahmed.getPrenom());
        AgentTableau[2].setEmail(Ahmed.getEmail());
        AgentTableau[2].setMatricule(Ahmed.getMatricule());*/

        /*list_to_return.add(AgentTableau[0]);
        list_to_return.add(AgentTableau[1]);
        list_to_return.add(AgentTableau[2]);*/




        /*AgentTableau[0] = new Agent(agent_name,agent_prenom,agent_email,"0611223344",agent_matr);
        AgentTableau[1] = new Agent("BENSALAH1","Salah","salah@gmail.com","0611223355","G125");
        AgentTableau[2] = new Agent("BENAHMED1","Ahmed","ahmed@gmail.com","0611223366","G126");

        list_to_return.add(AgentTableau[0]);
        list_to_return.add(AgentTableau[1]);
        list_to_return.add(AgentTableau[2]);*/




    }

    public void getAgentsList8() {

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