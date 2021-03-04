package com.sip.gestibank;


import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sip.gestibank.models.User;
import com.sip.gestibank.remote.APIUtil;
import com.sip.gestibank.remote.AuthService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AuthentificationActivity extends AppCompatActivity {
    AuthService authService;

    EditText email;
    EditText password;
    String myEmail="";
    String myPassword="";
    User user;
    String role ="invalide";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);


        // affectation des attributs aux view
        email = (EditText) findViewById(R.id.editEmail);
        password = (EditText) findViewById(R.id.editPassword);
        authService = APIUtil.getAuthService();
    }

    public void dashboardUser(View v){


        myEmail = email.getText().toString();
        myPassword = password.getText().toString();


        // récupération du user et donc de son role

        Call<User> call = authService.getUserByEmail(myEmail);

        call.enqueue(new Callback<User>() {
            @Override

            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    user = response.body();

                    //Toast.makeText(AuthentificationActivity.this, "STEP1", Toast.LENGTH_SHORT).show();

                    if(user.getPassword().equals(myPassword))
                    {
                        role = user.getRole();
                        //Toast.makeText(AuthentificationActivity.this, "Login OK, Name=" + user.getName() + ", Role=" + user.getRole(), Toast.LENGTH_SHORT).show();

                        switch(role) {
                            case "AGENT":
                                Intent intent1 = new Intent(AuthentificationActivity.this, EspaceAgentActivity.class);
                                startActivity(intent1);
                                break;
                            case "CLIENT":
                                Intent intent2 = new Intent(AuthentificationActivity.this, EspaceClientActivity.class);
                                startActivity(intent2);
                                break;
                            case "ADMIN":
                                Intent intent3 = new Intent(AuthentificationActivity.this,  EspaceAdminActivity.class);
                                startActivity(intent3);
                                break;
                            default:

                        }
                    }
                    else
                    {
                        Toast.makeText(AuthentificationActivity.this, "Login ou Password invalide", Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(AuthentificationActivity.this, "Connexion error", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
                Toast.makeText(AuthentificationActivity.this, "Callback Failed !", Toast.LENGTH_SHORT).show();

            }
        });
        // fin récupération

        //Redirection vers le dashboard en question : Admin, Client ou Agent




    }


}