package com.edutrading.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class Profile extends AppCompatActivity {
    private TextView Liquidtext, Assettext;
    private Button email, password, Return, Logout;
    PieChart pieChart;
    PieData pieData;
    List<PieEntry> pieEntryList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        Liquidtext = (TextView)findViewById(R.id.LiquidText);
        Assettext = (TextView)findViewById(R.id.StockText);
        Liquidtext.setText("$100");
        Assettext.setText("$430");
        pieChart = findViewById(R.id.pieChart);
        pieChart.setUsePercentValues(true);
        pieEntryList.add(new PieEntry(1, "MSFT"));
        pieEntryList.add(new PieEntry(5, "APPL"));
        pieEntryList.add(new PieEntry(7, "TSLA"));
        pieEntryList.add(new PieEntry(3, "GME"));
        PieDataSet pieDataSet = new PieDataSet(pieEntryList, " ");
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieChart.setDrawHoleEnabled(false);
        pieChart.getDescription().setText(" ");
        pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();

        Return = findViewById(R.id.Returnbutton);
        Return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
        });
        Logout = findViewById(R.id.Logoutbutton);
        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(Profile.this,"Log-out successful",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Profile.this, Main.class);
                startActivity(intent);
                finish();
            }
        });
        email = findViewById(R.id.EmailButton);
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, ChangeEmail.class);
                startActivity(intent);
                finish();
            }
        });
        password = findViewById(R.id.PasswordButton);
        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this, ChangePassword.class);
                startActivity(intent);
                finish();
            }
        });
    }
}




