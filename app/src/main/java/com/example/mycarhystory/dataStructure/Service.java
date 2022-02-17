package com.example.mycarhystory.dataStructure;

import android.util.Log;

public class Service {
    public String datum;
    public  int ev, ho, nap;
    public String javitasNeve;
    public String kategoria;
    public int ar;
    public int kmAllas;
    public int gyari;

    public Service(String sor){
        String[] plusz = sor.split(";");
        String[] dt = plusz[0].split("/");

        datum = plusz[0];
        ev = Integer.parseInt(dt[0]);
        ho = Integer.parseInt(dt[1]);
        nap = Integer.parseInt(dt[2]);

        javitasNeve = plusz[1];
        kategoria = plusz[2];
        ar = Integer.parseInt(plusz[3]);
        kmAllas = Integer.parseInt(plusz[4]);
        gyari = Integer.parseInt(plusz[5]);

        Log.d("TESZT", sor);
    }

    public String getWritableDate () {
        String adatok = datum+";"+javitasNeve+";"+kategoria+";"+ar+";"+kmAllas+";"+gyari;
        return adatok;
    }
}
