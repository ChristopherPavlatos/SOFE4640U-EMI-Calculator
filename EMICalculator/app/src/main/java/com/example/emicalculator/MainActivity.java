package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public MainActivity() {
        if(BuildConfig.DEBUG)
            StrictMode.enableDefaults();
    }

    //Creating variables
    private EditText loanAmount;
    private EditText interestRate;
    private EditText loanTenure;
    private Button calculateEMI;
    private TextView emi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Referencing variables with layout IDs
        loanAmount = (EditText) findViewById(R.id.etLoanAmount);
        interestRate = (EditText) findViewById(R.id.etInterestRate);
        loanTenure = (EditText) findViewById(R.id.etLoanTenure);
        calculateEMI = (Button) findViewById(R.id.btnCalculate);
        emi = (TextView) findViewById(R.id.tvEMI);

        //EMI calculation after button click and return value
        calculateEMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double p = Double.parseDouble(loanAmount.getText().toString());
                double i = Double.parseDouble(interestRate.getText().toString());
                double n = Double.parseDouble(loanTenure.getText().toString());
                double r = i / (12 * 100);
                double e = (p * r * Math.pow(1 + r,n)) / (Math.pow(1 + r,n) - 1);
                emi.setText("EMI is: " + String.format("%.2f", e));
            }
        });

    }
}