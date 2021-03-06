package com.sip.gestibank.remote;
import com.sip.gestibank.models.Client;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ClientService {

    @GET("list/")
    Call<List<Client>> getClients();

    @GET("list/attente")
    Call<List<Client>> getClientsEnAttentes();

    @GET("list/valide")
    Call<List<Client>> getClientsValides();

    @POST("add/")
    Call<Client> addClient(@Body Client client);
/*
    @PUT("update/{id}")
    Call<User> updateUser(@Path("id") int id, @Body User user);

    @DELETE("delete/{id}")
    Call<User> deleteUser(@Path("id") int id);*/
}
