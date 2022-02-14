package com.android.anas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Operation_activity extends AppCompatActivity {
    ArrayList<Operation> operations = new ArrayList<>();
    ListView listView;
    MyDBHelper database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);
        listView = findViewById(R.id.listTranscation);
        database = new MyDBHelper(this);
        operations = database.getAllTransactions();
        listView.setAdapter(new AdapterTransactionList(this,R.layout.cutsom_transaction_list, operations));

    }
}