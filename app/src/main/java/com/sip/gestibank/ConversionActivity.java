package com.sip.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Spinner;

import android.widget.ArrayAdapter;
import android.widget.TextView;


import android.os.Bundle;


public class ConversionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);

        String[] arraySpinner = new String[] {
                "EUR", "TND", "GBP", "CAD", "CNY"
        };
        Spinner s = (Spinner) findViewById(R.id.spinner_devices);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, arraySpinner);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
    }

    public void PerformConversion(View view)
    {
        double Coeffesion = 0.8;

        TextView ResultTextView = (TextView)findViewById(R.id.textView_resultat);

        TextView MontantTextView = (TextView)findViewById(R.id.editPassword);

        if (!MontantTextView.getText().toString().equals("")) {
            double MontantValue = Double.parseDouble(MontantTextView.getText().toString());

            ResultTextView.setText(Double.toString(MontantValue * Coeffesion));
        }
    }
}