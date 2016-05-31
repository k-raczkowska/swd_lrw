package com.example.karolinar.swd;

import java.io.Serializable;
import java.util.List;

/**
 * Created by KarolinaR on 2016-05-31.
 */
public class Option implements Serializable{

    private Klimat klimat;
    private List<Aktywnosc> aktywnoscList;
    private List<Lokalizacja> lokalizacjaList;

    public Option(Klimat klimat, List<Aktywnosc> aktywnoscList, List<Lokalizacja> lokalizacjaList){
        this.klimat = klimat;
        this.aktywnoscList = aktywnoscList;
        this.lokalizacjaList = lokalizacjaList;
    }

    public Klimat getKlimat() {
        return klimat;
    }

    public void setKlimat(Klimat klimat) {
        this.klimat = klimat;
    }

    public List<Aktywnosc> getAktywnoscList() {
        return aktywnoscList;
    }

    public void setAktywnoscList(List<Aktywnosc> aktywnoscList) {
        this.aktywnoscList = aktywnoscList;
    }

    public List<Lokalizacja> getLokalizacjaList() {
        return lokalizacjaList;
    }

    public void setLokalizacjaList(List<Lokalizacja> lokalizacjaList) {
        this.lokalizacjaList = lokalizacjaList;
    }

    @Override
    public boolean equals(Object option){
        return true;//TODO
    }
}
