package com.example.karolinar.swd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by KarolinaR on 2016-05-31.
 */
public class ListActivity extends AppCompatActivity implements View.OnClickListener{

    static List<Option> options = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_activity);
        Button dodajOpcje = (Button) findViewById(R.id.dodajOpcje);
        dodajOpcje.setOnClickListener(this);
        ListView lista = (ListView) findViewById(R.id.lista);
        //ArrayList<Option> list = new ArrayList<>();

        /*list.add(new Option("ZeroZero", "ZeroJeden"));
        list.add(new Option("JedenZero", "JedenJeden"));*/
        OptionAdapter adapter = new OptionAdapter(this, options);
        lista.setAdapter(adapter);
    }

    @Override
    public void onResume(){
        super.onResume();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(ListActivity.this, MainActivity.class);
        ListActivity.this.startActivity(intent);
    }
}
