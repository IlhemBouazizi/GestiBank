package com.sip.gestibank.remote;

import com.sip.gestibank.models.Agent;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AgentService {

    @GET("list/")
    Call<List<Agent>> getAgents();

    @POST("add/")
    Call<Agent> addAgent(@Body Agent agent);
/*
    @PUT("update/{id}")
    Call<User> updateUser(@Path("id") int id, @Body User user);

    @DELETE("delete/{id}")
    Call<User> deleteUser(@Path("id") int id);*/
}


