package com.example.csvtesting;

import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CSVManager {
    private static String TAG="CSVMANAGERTAG";
    private boolean eyesclosed;
    private boolean eyesopen;
    private String[] CSVlist; //CSV list of CSV Files in assets
        CSVManager(String[] CSVlist)
        {
            this.CSVlist=CSVlist;
            CSVgetlist(); //Print to log the list
        }
    //Print List of CSV Files
    private void CSVgetlist()
    {

            for(String file : CSVlist)
            {
                Log.d(TAG,"Arxeio CSV : "+file);
            }

    }
    //Random CSV index function
    public Integer RandomCSV(String[] CSVlist)
    {
        Integer length=CSVlist.length;
        //Get a Random Integer Between index 0 ----> CSVlist.length
        int CSVindex=randInt(0,length);
        //Write to Log the Chosen file
        Log.d(TAG,"to tuxaio CSV arxeio einai : "+CSVlist[CSVindex]);
        //Return the index to Main
        return CSVindex;
    }
    //Check Eyes CSV function
    public void CheckeyesCSV(String[] CSVlist,int CSVindex)
    {
        //eyes --> EyesClosed

        //Title of CSV
        String CSVtitle;
        CSVtitle=CSVlist[CSVindex];
        //If title of CSV contains eye closed then its an eye closed CSV
        eyesclosed= CSVtitle.toLowerCase().contains("eyesclosed".toLowerCase());
        eyesopen=CSVtitle.toLowerCase().contains("eyesopen".toLowerCase());
        if(eyesclosed) //Print to Log and Fetch the Selected Eyes Closed File
        {
            Log.d(TAG,"EYES CLOSED!");
        }
        //Check if Eyes open
        else if(eyesopen)
        {
            Log.d(TAG,"EYES OPEN");
        }
    }

    public static int randInt(int min, int max) {
        Random rand=new Random();
        int randomNum = rand.nextInt((max - min)) + min;
        Log.d(TAG,"o tuxaios arithmos einai : "+randomNum);
        return randomNum;
    }

}
