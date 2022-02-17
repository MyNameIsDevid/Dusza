package com.example.mycarhystory.dataStructure;

import android.util.Log;

import java.util.ArrayList;

public class CarData {
    private String uniqueFilePath;

    public String marka;
    public int evjarat;
    public int alvazszam;
    public String motorkod;
    public int kmAllas;
    public float uzemanyagszint;
    public String olajTipus;
    public String legutobbiSzerviz;
    public String rendszam;

    public ArrayList<Service> szervizkonyv = new ArrayList<>();

    public CarData (ArrayList<String> sorok, String uniqueFileID) {
        this.uniqueFilePath = uniqueFileID;
        setData(sorok.get(0));

        for (int i = 1; i<sorok.size(); i++) {
            szervizkonyv.add(new Service(sorok.get(i)));
        }
    }

    private void setData (String sor) {
        String[] plusz = sor.split(";");

        marka = plusz[0];
        evjarat = Integer.parseInt(plusz[1]);
        alvazszam = Integer.parseInt(plusz[2]);
        motorkod = plusz[3];
        kmAllas = Integer.parseInt(plusz[4]);
        uzemanyagszint = Float.parseFloat(plusz[5]);
        olajTipus = plusz[6];
        legutobbiSzerviz = plusz[7];
        rendszam = plusz[8];

        Log.d("TESZT", sor);
    }

    public String getUniqueFilePath() {
        return uniqueFilePath;
    }

    public String getWritableDate () {
        String adatok = marka+";"+evjarat+";"+alvazszam+";"+motorkod+";"+kmAllas+";"+uzemanyagszint+";"+olajTipus+";"+legutobbiSzerviz+";"+rendszam;

        for (int i = 0; i<szervizkonyv.size(); i++) {
            adatok += "\n"+szervizkonyv.get(i).getWritableDate();
        }

        return adatok;
    }
}
