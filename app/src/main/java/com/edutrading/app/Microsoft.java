package com.edutrading.app;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.math.MathContext;

public class Microsoft extends AppCompatActivity {
    private EditText Amount;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button Return, Logout, Buy, Sell;
        TextView Stock;
        final double[] Shares = new double[1];
        final double[] Money = new double[1];
        Money[0] = 100;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.microsoft);
        Amount = findViewById(R.id.editTextAmount);


        Return = findViewById(R.id.button7);
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Microsoft.this, Stocks.class);
                startActivity(intent);
                finish();
            }
        });
        Stock = findViewById(R.id.textView12);
        Buy = findViewById(R.id.button13);
        Buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Value= Amount.getText().toString();
                int finalValue=Integer.parseInt(Value);
                if(finalValue <= Money[0])
                {
                    Toast.makeText(Microsoft.this,"Purchase Complete",Toast.LENGTH_LONG).show();
                    Shares[0] = (1.0+(finalValue/252.0));
                    Money[0] = 100-finalValue;
                    BigDecimal bd = new BigDecimal(Shares[0]);
                    bd = bd.round(new MathContext(3));
                    double rounded = bd.doubleValue();
                    Stock.setText("Shares Owned: " + rounded);
                }
                else if (finalValue == 0)
                {
                    Toast.makeText(Microsoft.this,"No Value Entered",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(Microsoft.this,"Not Enough Funds",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
