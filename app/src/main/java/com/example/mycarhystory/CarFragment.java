package com.example.mycarhystory;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mycarhystory.dataStructure.CarData;

public class CarFragment extends Fragment {

    public TextView autoNeve;
    public TextView showEvjarat;
    public TextView showAlvaz;
    public TextView showMotor;
    public TextView showKm;
    public TextView showUzemanyag;
    public TextView showOlajtipus;
    public TextView showLegutolso;
    public TextView showRendszam;

    public Button btSzerviz;
    public Button btTankolas;

    public CarFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_car, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btSzerviz = (Button) view.findViewById(R.id.btSzerviz);
        btSzerviz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.carToSzervizFragment);
            }
        });
        btTankolas = (Button) view.findViewById(R.id.btTankolas);
        /*btTankolas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.carToSzervizFragment);
            }
        });*/

        autoNeve = (TextView) view.findViewById(R.id.autoNeve);
        showEvjarat = (TextView) view.findViewById(R.id.showEvjarat);
        showAlvaz = (TextView) view.findViewById(R.id.showAlvaz);
        showMotor = (TextView) view.findViewById(R.id.showMotor);
        showKm = (TextView) view.findViewById(R.id.showKm);
        showUzemanyag = (TextView) view.findViewById(R.id.showUzemanyag);
        showOlajtipus = (TextView) view.findViewById(R.id.showOlajtipus);
        showLegutolso = (TextView) view.findViewById(R.id.showLegutolso);
        showRendszam = (TextView) view.findViewById(R.id.showRendszam);

        displayCarData();
    }

    public void displayCarData () {
        CarData adatok = MainActivity.dataHandler.tulajdonosok.get(MainActivity.choosenOwnerID).autoAdatok.get(HomeFragment.choosenCarID);

        autoNeve.setText(adatok.marka+"");
        showEvjarat.setText(adatok.evjarat+"");
        showAlvaz.setText(adatok.alvazszam+"");
        showMotor.setText(adatok.motorkod+"");
        showKm.setText(adatok.kmAllas+" km");
        showUzemanyag.setText(adatok.uzemanyagszint+" liter");
        showOlajtipus.setText(adatok.olajTipus+"");
        showLegutolso.setText(adatok.legutobbiSzerviz+"");
        showRendszam.setText(adatok.rendszam+"");
    }
}