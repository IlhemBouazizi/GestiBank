package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

import com.sip.gestibank.models.Currency;
import com.sip.gestibank.remote.APIUtil;
import com.sip.gestibank.remote.CurrencyService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ConversionActivity extends AppCompatActivity {
    double cours;
    double input;
    double res;

    CurrencyService currencyService;

    EditText myData;
    TextView myRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        String[] arraySpinner = new String[] {
                "EUR", "TND", "GBP", "CAD", "CNY"
        };
        myData = (EditText) findViewById(R.id.TextMontant);
        myRes = (TextView)findViewById(R.id.textView_resultat);
        Spinner s = (Spinner) findViewById(R.id.spinner_devices);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        currencyService =  APIUtil.getCurrencyService();
    }

    public void PerformConversion(View view)
    {

        input = Double.parseDouble(myData.getText().toString());


        TextView MontantTextView = (TextView)findViewById(R.id.TextMontant);

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner_devices);
        String to = mySpinner.getSelectedItem().toString();
        //Toast.makeText(ConversionActivity.this, "Devise="+to, Toast.LENGTH_SHORT).show();
        String rul = "live?access_key=c7dd6f03f1ee260993147bfc06ab9673&currencies="+to+"&format=1/";
        Call<Currency> call = currencyService.getData(rul);
        call.enqueue(new Callback<Currency>() {
            @Override
            public void onResponse(Call<Currency> call, Response<Currency> response) {
                if(response.isSuccessful()){
                    String quotes = response.body().getQuotes().toString();
                    // récupération du cours
                    String rate = quotes.substring(quotes.indexOf("=")+1,quotes.indexOf("}"));
                    cours = Double.parseDouble(rate);
                    res = cours*input;
                    res = (double)((int)(res*100))/100;
                    myRes.setText(Double.valueOf(res).toString());
                }
            }

            @Override
            public void onFailure(Call<Currency> call, Throwable t) {
                Log.e("Problème: ", t.getMessage());
            }
        });

     //   if (!MontantTextView.getText().toString().equals("")) {
     //       double MontantValue = Double.parseDouble(MontantTextView.getText().toString());

           // ResultTextView.setText(Double.toString(MontantValue * Coeffesion));
        }


    }
