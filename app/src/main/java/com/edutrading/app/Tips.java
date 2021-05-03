package com.edutrading.app;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class Tips extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button button;
    private static final String[] paths = {"item 1", "item 2", "item 3"};
    private TextView tiptext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tips);
        tiptext = (TextView)findViewById(R.id.textView2);
        tiptext.setText(" ");
        Spinner dropdown = findViewById(R.id.spinner1);
//create a list of items for the spinner.
        String[] items = new String[]{"Select a Tip", "1: Where to Start", "2: Kinds of Markets", "3: How the Market Works" +
                "" ,"4: Ways to Trade", "5: Set Realistic Expectations", "5: Diversify", "6: Don't Overreact"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
//set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        button = findViewById(R.id.returnbutton);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Tips.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
    });
        dropdown.setOnItemSelectedListener(this);
}
    @SuppressLint("SetTextI18n")
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){

        switch (position) {
            case 0:
                tiptext.setText("Improve your stock trading skills!");
                break;
            case 1:
                tiptext.setText("It is necessary when trading stocks to set realistic goals.\n" +
                        "\nTrading stocks is not a get rich scheme. \n\nLook to play it safe and slow.");
                break;
            case 2:
                tiptext.setText("Bull Market: When the market is experiencing a surge in prices. " +
                        "\n\nBear Market: When the majority of the market is in a decline." +
                        "\n\nWhen starting, look for bull markets for prime trading opportunities!");
                break;
            case 3:
                tiptext.setText("The stock market opens every weekday at 9:30 AM Eastern Time, and closes at 4:00 PM\n\n" +
                        "Trade orders placed outside of market hours will not occur until market open the next business day." +
                        "\n\nAvoid trading around market open or near market close due to high volatility.");
                break;
            case 4:
                tiptext.setText("Stocks can be bought or sold to make a profit on gains in the stock's value. The most that can " +
                        "be lost on a buy is your initial investment" +
                        "\n\nIt is also possible to capitalize on dips in value through 'shorts'. " +
                        "This is highly dangerous has can cost even more than your initial investment if it goes wrong");
                break;
            case 5:
                tiptext.setText("Whatever you invest in the stock market can be lost. \n\nSet expectations" +
                        " at a realistic level and ONLY invest what you are capable of losing.");
                break;
            case 6:
                tiptext.setText("Don't put all your eggs into one basket. Don't put all of your investment" +
                        " assets into a single stock.\n\nTrading is a calculated process, the more diversity " +
                        "in your portfolio, the less likely you are to gamble your assets.");
                break;
            case 7:
                tiptext.setText("Resist the temptation to check stock all the time. Let it sit. \n\nDips are normal, " +
                        "and surges can be misleading. Avoid buying/selling on impulse.");
                break;
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //Keep Empty. Necessary for function
    }
}