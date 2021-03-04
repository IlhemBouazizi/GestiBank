package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.sip.gestibank.models.Client;
import com.sip.gestibank.remote.APIUtil;
import com.sip.gestibank.remote.ClientService;

public class NewClient extends AppCompatActivity {
    ClientService clientService;
    List<Client>list;

    EditText name;
    EditText prenom;
    EditText email;
    EditText tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_client);
        clientService = APIUtil.getClientService();

        name = (EditText) findViewById(R.id.editEmail);
        prenom = (EditText) findViewById(R.id.editPassword);
        email = (EditText) findViewById(R.id.editMail);
        tel = (EditText) findViewById(R.id.editTel);

        String[] arraySpinner = new String[] {
                "Compte courant sans découvert", "Compte courant avec découvert", "Compte épargne"
        };
        Spinner s = (Spinner) findViewById(R.id.spinner_type_compte);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);


    }


    public void addNewClient(View v){


        Client client= new Client(name.getText().toString(),prenom.getText().toString(), email.getText().toString(),tel.getText().toString());
        Call<Client> call = clientService.addClient(client);
        call.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                if(response.isSuccessful()){
                    Toast.makeText(NewClient.this, "Client created successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });

    }


    public void getClientsList(View v){
        Call<List<Client>> call = clientService.getClients();
        call.enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    Log.i("Data: ", list.toString());

                    StringBuffer buffer=new StringBuffer();
                    for (Client user : list)
                    {

                        buffer.append("Name: "+user.getName()+"\n");
                        buffer.append("Email: "+user.getEmail()+"\n\n");

                    }
                    showMessage("Clients List", buffer.toString());

                    // listView.setAdapter(new UserAdapter(MainActivity.this, R.layout.list_user, list));
                }
            }

            @Override
            public void onFailure(Call<List<Client>> call, Throwable t) {
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

    public void CallAuthentificationAgentActivity(View view){
        Intent i = new Intent(getApplicationContext(), AuthentificationActivity.class);
        startActivity(i);
    }
}