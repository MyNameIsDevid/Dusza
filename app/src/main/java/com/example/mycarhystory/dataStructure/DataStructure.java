package com.example.mycarhystory.dataStructure;

import com.example.mycarhystory.fileHandling.FileHandler;

import java.util.ArrayList;

public class DataStructure {
    public ArrayList<Owner> tulajdonosok = new ArrayList<>();

    public DataStructure (ArrayList<String> tulajAdatok, FileHandler fileHandler) {
        for (int i = 0; i<tulajAdatok.size(); i++) {
            tulajdonosok.add(new Owner(tulajAdatok.get(i), fileHandler));
        }
    }
}
