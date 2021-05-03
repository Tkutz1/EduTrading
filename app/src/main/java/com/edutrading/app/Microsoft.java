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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.microsoft);
        Amount = findViewById(R.id.editTextAmount);
        double MSFT = User.getMSFTNum();
        int Money = User.getCash();
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
                if (!Value.equals("")) {
                    int finalValue = Integer.parseInt(Value);
                    if (finalValue <= Money) {
                        Toast.makeText(Microsoft.this, "Purchase Complete", Toast.LENGTH_LONG).show();
                        User.AddMSFT(finalValue / 252);
                        User.ChangeCash(finalValue);
                        BigDecimal bd = new BigDecimal(User.getMSFTNum());
                        bd = bd.round(new MathContext(3));
                        double rounded = bd.doubleValue();
                        Stock.setText("Shares Owned: " + rounded);
                    }
                    else
                    {
                        Toast.makeText(Microsoft.this,"Not Enough Funds",Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(Microsoft.this,"No Value Entered",Toast.LENGTH_LONG).show();
                }

            }
        });
        Sell = findViewById(R.id.button14);
        Sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Value = Amount.getText().toString();
                if (!Value.equals("")) {
                    int finalValue = Integer.parseInt(Value);
                    if (finalValue <= MSFT) {
                        Toast.makeText(Microsoft.this, "Sale Complete", Toast.LENGTH_LONG).show();
                        User.SubCash(finalValue * 252);
                        User.SubMSFT(finalValue);
                        BigDecimal bd = new BigDecimal(User.getMSFTNum());
                        bd = bd.round(new MathContext(3));
                        double rounded = bd.doubleValue();
                        Stock.setText("Shares Owned: " + rounded);
                    } else {
                        Toast.makeText(Microsoft.this, "Not Enough Shares", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(Microsoft.this, "No Value Entered", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
