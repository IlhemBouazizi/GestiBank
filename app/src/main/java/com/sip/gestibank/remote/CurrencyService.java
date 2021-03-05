package com.sip.gestibank.remote;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;
import com.sip.gestibank.models.Currency;

public interface CurrencyService {
    @GET
    Call<Currency> getData(@Url String url);
}
