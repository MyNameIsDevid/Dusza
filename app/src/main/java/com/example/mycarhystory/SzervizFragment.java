package com.example.mycarhystory;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class SzervizFragment extends Fragment {

    public SzervizFragment() { }
    Button btn = (Button) getView().findViewById(R.id.button4);
    Button btn2 = (Button) getView().findViewById(R.id.szuro);

    LinearLayout ln = (LinearLayout) getView().findViewById(R.id.linearLayout3);
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

       /*btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ln.setVisibility(LinearLayout.GONE);
           }
       });

       btn2.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ln.setVisibility(LinearLayout.VISIBLE);
           }
       });*/

        return inflater.inflate(R.layout.fragment_szerviz, container, false);
    }



}