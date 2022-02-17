package com.example.mycarhystory.dataStructure;

import com.example.mycarhystory.fileHandling.FileHandler;

import java.util.ArrayList;

public class DataHandler {

    public ArrayList<Owner> tulajdonosok = new ArrayList<>();
    public FileHandler fileHandler;
    public String rootFilePath;

    public DataHandler (FileHandler fileHandler, String rootFilePath) {
        this.fileHandler = fileHandler;
        this.rootFilePath = rootFilePath;
    }

    public void loadDataFromFile () {
        ArrayList<String> tulajAdatok = fileHandler.readFromFile(rootFilePath);
        System.out.println(tulajAdatok.get(0));

        for (int i = 0; i<tulajAdatok.size(); i++) {
            tulajdonosok.add(new Owner(tulajAdatok.get(i), fileHandler));
        }
    }

    public void addNewCarToOwner (int ownerID, String carData) {
        ArrayList<String> autoAdatok = new ArrayList<>();
        autoAdatok.add(carData);

        String filePath = "";
        do {
            filePath = ""+(int)(Math.random()*1000000)+".txt";
        }while (fileHandler.isFileExisting(filePath));

        CarData auto = new CarData(autoAdatok, filePath);
        tulajdonosok.get(ownerID).autoAdatok.add(auto);
        saveNewCarInFile(auto);
    }

    public ArrayList<CarData> getCarsByOwner (int ownerID) {
        return tulajdonosok.get(ownerID).autoAdatok;
    }

    public void removeCarFromOwner (int ownerID, int carID) {
        fileHandler.deleteFile(tulajdonosok.get(ownerID).autoAdatok.get(carID).getUniqueFilePath());
        tulajdonosok.get(ownerID).autoAdatok.remove(carID);
        refresRootFile();
    }

    public void saveNewCarInFile (CarData auto) {
        fileHandler.writeToFile(auto.getUniqueFilePath(), auto.getWritableDate());
        refresRootFile();
    }

    public void refresRootFile () {
        String adatok = tulajdonosok.get(0).nev;
        for (int i = 0; i<tulajdonosok.get(0).autoAdatok.size(); i++) {
            adatok += ";"+tulajdonosok.get(0).autoAdatok.get(i).getUniqueFilePath();
        }

        for (int k = 1; k<tulajdonosok.size(); k++) {
            adatok += "\n"+tulajdonosok.get(k).nev;
            for (int i = 0; i<tulajdonosok.get(k).autoAdatok.size(); i++) {
                adatok += ";"+tulajdonosok.get(k).autoAdatok.get(i).getUniqueFilePath();
            }
        }

        fileHandler.writeToFile(rootFilePath, adatok);
    }
}
