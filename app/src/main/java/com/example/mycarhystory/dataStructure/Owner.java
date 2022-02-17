package com.example.mycarhystory.dataStructure;

import android.util.Log;

import com.example.mycarhystory.fileHandling.FileHandler;

import java.util.ArrayList;

public class Owner {
    public String nev;
    public ArrayList<CarData> autoAdatok = new ArrayList<>();

    public Owner (String sor, FileHandler fileHandler) {
        String[] plusz = sor.split(";");
        nev = plusz[0];

        for (int i = 1; i<plusz.length; i++){
            autoAdatok.add(new CarData(fileHandler.readFromFile(plusz[i]), plusz[i]));
        }

        Log.d("TESZT", nev);
    }
}
