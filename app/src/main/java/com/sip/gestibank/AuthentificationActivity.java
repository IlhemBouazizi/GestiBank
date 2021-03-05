package com.sip.gestibank;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
    User user;

    EditText email;
    EditText password;
    String myEmail = "";
    String myPassword = "";

    String role = "invalide";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);


        // affectation des attributs aux view
        email = (EditText) findViewById(R.id.editEmail);
        password = (EditText) findViewById(R.id.myInput);
        authService = APIUtil.getAuthService();
    }

    public void dashboardUser(View v) {

            myEmail = email.getText().toString();
            myPassword = password.getText().toString();
            // récupération du user et donc de son role
            /*try
            {*/
                Call<User> call = authService.getUserByEmail(myEmail);
            //debut enqueue
            call.enqueue(new Callback<User>() {
                             @Override
                             //debut onResponse
                             public void onResponse(Call<User> call, Response<User> response) {
                                 if (response.isSuccessful()) {
                                     user = response.body();
                                     if (user != null)
                                     {
                                     //Log.i("Data: ", user.toString());
                                     //Log.i("Mot de passe: ", user.getPassword());
                                     //Toast.makeText(AuthentificationActivity.this, "STEP1", Toast.LENGTH_SHORT).show();
                                     if (user.getPassword().equals(myPassword)) {
                                         if (user.getEmail().equals(myEmail)) {
                                             role = user.getRole();
                                             //Toast.makeText(AuthentificationActivity.this, "Login OK, Name=" + user.getName() + ", Role=" + user.getRole(), Toast.LENGTH_SHORT).show();

                                             switch (role) {
                                                 case "AGENT":
                                                     Intent intent1 = new Intent(AuthentificationActivity.this, EspaceAgentActivity.class);
                                                     startActivity(intent1);
                                                     break;
                                                 case "CLIENT":
                                                     Intent intent2 = new Intent(AuthentificationActivity.this, EspaceClientActivity.class);
                                                     startActivity(intent2);
                                                     break;
                                                 case "ADMIN":
                                                     Intent intent3 = new Intent(AuthentificationActivity.this, EspaceAdminActivity.class);
                                                     startActivity(intent3);
                                                     break;
                                                 default:
                                             }
                                         } else {
                                             Toast.makeText(AuthentificationActivity.this, "Login invalide", Toast.LENGTH_SHORT).show();
                                         }
                                     }
                                     //fin if email et password valides
                                     else {
                                         Toast.makeText(AuthentificationActivity.this, "Mot de passe invalide", Toast.LENGTH_SHORT).show();
                                     }
                                     }
                                     else
                                         {
                                             Toast.makeText(AuthentificationActivity.this, "Utilisateur  inexistant", Toast.LENGTH_SHORT).show();
                                         }
                                 }
                                 //fin response.isSuccessful
                                 else {
                                     Toast.makeText(AuthentificationActivity.this, "Erreur de connexion", Toast.LENGTH_SHORT).show();
                                 }
                             }

                             //fin onResponse
                             @Override
                             //debut onFailure
                             public void onFailure(Call<User> call, Throwable t) {
                                 Log.e("ERREUR: ", t.getMessage());
                                 Toast.makeText(AuthentificationActivity.this, "Callback Failed !", Toast.LENGTH_SHORT).show();
                             }
                             //fin onFailure
                         }
                    //fin callback
            );
            // fin récupération
            //Redirection vers le dashboard en question : Admin, Client ou Agent
        /*} catch (NullPointerException e) {
            Toast.makeText(AuthentificationActivity.this, "Login invalide !", Toast.LENGTH_SHORT).show();
        }*/
        //fin dachboardUser
    }
}
//fin classe