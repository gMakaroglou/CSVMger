package com.example.csvtesting;

import android.content.Context;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Csv {
    Context context;
    String filename;
    public static String TAG="CSVPRINTERTAG";
    List<String> rows = new ArrayList<>();
    public Csv(Context context,String filename){
        this.context=context;
        this.filename=filename;
    }

    public List<String> readCSV() throws IOException{
        InputStream is = context.getAssets().open("3/"+filename);
        InputStreamReader isr= new InputStreamReader(is);
        BufferedReader br=new BufferedReader(isr);
        String line;
        while((line=br.readLine())!=null){
            String row = line;
            rows.add(row);
        }
        return rows;
    }

}
