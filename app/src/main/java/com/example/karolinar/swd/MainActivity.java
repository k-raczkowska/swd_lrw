package com.example.karolinar.swd;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button zapiszButton;
    private boolean czyMorze = false;
    private boolean czyGory = false;
    private boolean czyMiasto = false;
    private boolean czyOpalanie = false;
    private boolean czyZwiedzanie = false;
    private boolean czySport = false;
    private boolean czyCieply = false;
    private boolean czyUmiarkowany = false;
    private boolean czyZimny = false;

    private ImageButton cieplyKlimat;
    private ImageButton umiarkowanyKlimat;
    private ImageButton zimnyKlimat;
    private ImageButton morzeButton;
    private ImageButton goryButton;
    private ImageButton miastoButton;
    private ImageButton opalanieButton;
    private ImageButton zwiedzanieButton;
    private ImageButton sportButton;

    private final int color = Color.argb(100, 51, 153, 255);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(true);
        zapiszButton = (Button)findViewById(R.id.zapisz_button);
        morzeButton = (ImageButton) findViewById(R.id.morze);
        goryButton = (ImageButton) findViewById(R.id.gory);
        miastoButton = (ImageButton) findViewById(R.id.miasto);
        opalanieButton = (ImageButton) findViewById(R.id.opalanie);
        zwiedzanieButton = (ImageButton) findViewById(R.id.zwiedzanie);
        sportButton = (ImageButton) findViewById(R.id.sport);
        cieplyKlimat = (ImageButton) findViewById(R.id.cieplo);
        umiarkowanyKlimat = (ImageButton) findViewById(R.id.umiarkowanie);
        zimnyKlimat = (ImageButton) findViewById(R.id.zimno);

        morzeButton.setOnClickListener(this);
        goryButton.setOnClickListener(this);
        miastoButton.setOnClickListener(this);
        opalanieButton.setOnClickListener(this);
        zwiedzanieButton.setOnClickListener(this);
        sportButton.setOnClickListener(this);
        cieplyKlimat.setOnClickListener(this);
        umiarkowanyKlimat.setOnClickListener(this);
        zimnyKlimat.setOnClickListener(this);

        this.setFilters();
        //button.setColorFilter(Color.argb(100, 51, 153, 255));
    }

    private void setFilters(){
        morzeButton.setColorFilter(color);
        goryButton.setColorFilter(color);
        miastoButton.setColorFilter(color);
        opalanieButton.setColorFilter(color);
        zwiedzanieButton.setColorFilter(color);
        sportButton.setColorFilter(color);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.morze:
                if(czyMorze){
                    morzeButton.clearColorFilter();
                    czyMorze = false;
                }
                else{
                    morzeButton.setColorFilter(color);
                    czyMorze = true;
                }
                break;
            case R.id.gory:
                if(czyGory){
                    goryButton.clearColorFilter();
                    czyGory = false;
                }
                else{
                    goryButton.setColorFilter(color);
                    czyGory = true;
                }
                break;
            case R.id.miasto:
                if(czyMiasto){
                    miastoButton.clearColorFilter();
                    czyMiasto = false;
                }
                else{
                    miastoButton.setColorFilter(color);
                    czyMiasto = true;
                }
                break;
            case R.id.opalanie:
                if(czyOpalanie){
                    opalanieButton.clearColorFilter();
                    czyOpalanie = false;
                }
                else{
                    opalanieButton.setColorFilter(color);
                    czyOpalanie = true;
                }
                break;
            case R.id.zwiedzanie:
                if(czyZwiedzanie){
                    zwiedzanieButton.clearColorFilter();
                    czyZwiedzanie = false;
                }
                else{
                    zwiedzanieButton.setColorFilter(color);
                    czyZwiedzanie = true;
                }
                break;
            case R.id.sport:
                if(czySport){
                    sportButton.clearColorFilter();
                    czySport = false;
                }
                else{
                    sportButton.setColorFilter(color);
                    czySport = true;
                }
                break;
            case R.id.cieplo:
                if(czyCieply){
                    cieplyKlimat.clearColorFilter();
                    czyCieply = false;
                }
                else{
                    cieplyKlimat.setColorFilter(color);
                    czyCieply = true;
                }
                break;
            case R.id.umiarkowanie:
                if(czyUmiarkowany){
                    umiarkowanyKlimat.clearColorFilter();
                    czyUmiarkowany = false;
                }
                else{
                    umiarkowanyKlimat.setColorFilter(color);
                    czyUmiarkowany = true;
                }
                break;
            case R.id.zimno:
                if(czyZimny){
                    zimnyKlimat.clearColorFilter();
                    czyZimny = false;
                }
                else{
                    zimnyKlimat.setColorFilter(color);
                    czyZimny = true;
                }
                break;
        }
    }

    public void zapisz(View view) {
        List<Aktywnosc> aktywnoscList = new ArrayList<>();
        List<Lokalizacja> lokalizacjaList = new ArrayList<>();
        Klimat klimat = null;
        if(czySport){
            aktywnoscList.add(Aktywnosc.SPORT);
        }
        if(czyZwiedzanie){
            aktywnoscList.add(Aktywnosc.ZWIEDZANIE);
        }
        if(czyOpalanie){
            aktywnoscList.add(Aktywnosc.OPALANIE);
        }
        if(czyMiasto){
            lokalizacjaList.add(Lokalizacja.MIASTO);
        }
        if(czyGory){
            lokalizacjaList.add(Lokalizacja.GORY);
        }
        if(czyMorze){
            lokalizacjaList.add(Lokalizacja.MORZE);
        }
        if(czyCieply){
            klimat = Klimat.CIEPLY;
        }
        else if(czyUmiarkowany){
            klimat = Klimat.UMIARKOWANY;
        }
        else if(czyZimny){
            klimat = Klimat.ZIMNY;
        }
        Option option = new Option(klimat, aktywnoscList, lokalizacjaList);
        Intent intent = new Intent(MainActivity.this, ListActivity.class);
        ListActivity.options.add(option);
        intent.putExtra("created", option);
        startActivity(intent);
    }
}
