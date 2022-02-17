package com.example.mycarhystory.fileHandling;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class FileHandler {

    private Context context;

    public FileHandler (Context context) {
        this.context = context;
    }

    public void writeToFile (String filePath, String data) {
        try{
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(filePath, Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<String> readFromFile (String filePath) {
        ArrayList<String> sorok = new ArrayList<>();

        try {
            InputStream inputStream = context.openFileInput(filePath);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                String receiveString = "";
                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    sorok.add(receiveString);
                }

                inputStream.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return  sorok;
    }

    public void deleteFile (String filePath) {
        context.deleteFile(filePath);
    }

    public boolean isFileExisting (String filePath) {
        boolean van = false;

        String[] files = context.fileList();

        for (int i = 0; i<files.length; i++){
            if (files[i].equals(filePath)) {
                van = true;
            }
        }

        return van;
    }

}
