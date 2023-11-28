package com.example.ascafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class OrderDetailActivity extends AppCompatActivity {


    private static final String EXTRA_USER_NAME = "userName";
    private static final String EXTRA_DRINK = "drink";
    private static final String EXTRA_DRINK_TYPE = "drinktype";
    private static final String EXTRA_ADDITIVEES = "additives";


    private TextView txtvName;
    private TextView txtvDrink;
    private TextView txtvDrinkType;
    private TextView txtvAdditives;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        initViews();

        Intent intent = getIntent();
        txtvName.setText(intent.getStringExtra(EXTRA_USER_NAME));
        txtvDrink.setText(intent.getStringExtra(EXTRA_DRINK));
        txtvDrinkType.setText(intent.getStringExtra(EXTRA_DRINK_TYPE));
        txtvAdditives.setText(intent.getStringExtra(EXTRA_ADDITIVEES));
    }

    private void initViews(){
        txtvName= findViewById(R.id.txtvName);
        txtvDrink= findViewById(R.id.txtvDrink);
        txtvDrinkType= findViewById(R.id.txtvDrinkType);
        txtvAdditives= findViewById(R.id.txtvAdditives);

    }

    public static Intent newIntent(
            Context context,
             String userName,
             String drink,
             String drinkType,
             String additives) {
            Intent intent = new Intent(context, OrderDetailActivity.class);
            intent.putExtra(EXTRA_USER_NAME,userName);
            intent.putExtra(EXTRA_DRINK,drink);
            intent.putExtra(EXTRA_DRINK_TYPE,drinkType);
            intent.putExtra(EXTRA_ADDITIVEES,additives);
            return intent;
    }
}