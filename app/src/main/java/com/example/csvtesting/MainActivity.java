package com.example.csvtesting;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.content.res.AssetManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import au.com.bytecode.opencsv.CSVReader;

public class MainActivity extends AppCompatActivity {
public static String TAG = "CSVPRINTERTAG";
private Integer CSVindex; //Index of CSV list files
public AssetManager AMger;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
         AMger = getAssets();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void csv(View view){
//        try {
//          //  File csvfile = new File(Environment.getExternalStorageDirectory() + "/6.eyesopen.csv");
//         //   CSVReader reader = new CSVReader(new FileReader("csvfile.getAbsolutePath()"));
//            String csvfileString = this.getApplicationInfo().dataDir + File.separatorChar + "6.eyesopen.csv";
//            File csvfile = new File(csvfileString);
//            CSVReader reader = new CSVReader(new FileReader(csvfile.getAbsolutePath()));
//            String[] nextLine;
//            while ((nextLine = reader.readNext()) != null) {
//                // nextLine[] is an array of values from the line
//                System.out.println(nextLine[0] + nextLine[1] + "etc...");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            Toast.makeText(this, "The specified file was not found", Toast.LENGTH_SHORT).show();
//        }
        String filename = "myfile";
        String fileContents = "Hello world!";
        FileOutputStream outputStream;
        try {
            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(fileContents.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void test(View view)
    {
//        String [] list;
//        try {
//            list = getAssets().list(path);
//            if (list.length > 0) {
//                // This is a folder
//                for (String file : list) {
//                    if (!listAssetFiles(path + "/" + file))
//                        return false;
//                    else {
//                        // This is a file
//                        // TODO: add file name to an array list
//                    }
//                }
//            }
//        } catch (IOException e) {
//            return false;
//        }
//
        String path = " sladlsad";
      //  String [] List;
        try {
            String[] CSVLIST = getAssets().list("3");
//            for(String file : List2)
//            {
//                Log.d(TAG,"Arxeio CSV : "+file);
//            }
      //      int length = List2.length;
            //Create New object of CSV manager with CSV list
            CSVManager csvm=new CSVManager(CSVLIST);
            //Get a random Integer that indexes the CSV list
            CSVindex=csvm.RandomCSV(CSVLIST);
            //Check if the Random Selected CSV is Eyes Closed or Open
            csvm.CheckeyesCSV(CSVLIST,CSVindex);
            //Print the CSV file
            getfile(CSVLIST[CSVindex]);

         //   randomcsv(length,List2);
//            for(String file : List)
//            {
//                Log.d(TAG,file);
//            }

        }
        catch(IOException e)
        {
            return;
        }
          //  listAssetFiles("");

    }
    private void randomcsv(int length,String[] CSVlist)
    {
    int CSVindex=randInt(0,length);
    Log.d(TAG,"to tuxaio CSV arxeio einai : "+CSVlist[CSVindex]);
    checkeyes(CSVlist,CSVindex);
    }
    private void checkeyes(String[] CSVlist,int CSVindex)
    {
        boolean eyes;
        String teststring;
        teststring=CSVlist[CSVindex];
        eyes= teststring.toLowerCase().contains("eyesclosed".toLowerCase());
        if(eyes)
        {
            Log.d(TAG,"EYES CLOSED!");
            getfile(CSVlist[CSVindex]);
        }
    }
    private void getfile(String CSVfile)
    {
        String csv_me;
        List<String> rows=new ArrayList<>();
        Csv csvReader = new Csv(MainActivity.this,CSVfile);
        try{
            rows=csvReader.readCSV();
        } catch(IOException e)
        {
            Log.d(TAG,"Error");
        }
        StringBuilder sb = new StringBuilder();
        for(String s : rows)
        {
            sb.append(s);
            sb.append("\n");
        }
        csv_me=sb.toString();
       Log.d(TAG,"CSV file : "+CSVfile+"\n" + csv_me);
    }


    public static int randInt(int min, int max) {

        // NOTE: This will (intentionally) not run as written so that folks
        // copy-pasting have to think about how to initialize their
        // Random instance.  Initialization of the Random instance is outside
        // the main scope of the question, but some decent options are to have
        // a field that is initialized once and then re-used as needed or to
        // use ThreadLocalRandom (if using at least Java 1.7).
        //
        // In particular, do NOT do 'Random rand = new Random()' here or you
        // will get not very good / not very random results.
        Random rand=new Random();


        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min)) + min;
        Log.d(TAG,"o tuxaios arithmos einai : "+randomNum);

        return randomNum;
    }
    private boolean listAssetFiles(String path) {
        AssetManager AM=getAssets();

        String [] list;
        try {
            list = getAssets().list(path);
            if (list.length > 0) {
                // This is a folder
                for (String file : list) {
                    if (!listAssetFiles(path + "/" + file)) {
                        Log.d(TAG, "komple");
                        return false;
                    }
                    else {
                        // This is a file
                        // TODO: add file name to an array list
                    }
                }
            }
        } catch (IOException e) {
            return false;
        }

        return true;
    }
//    private void prepArray() {
//
//        try{
//            CSVReader reader = new CSVReader(new InputStreamReader(getResources().openRawResource(R.raw.strings)));//Specify asset file name
//            String [] nextLine;
//
//            while ((nextLine = reader.readNext()) != null) {
//                // nextLine[] is an array of values from the line
//                System.out.println(nextLine[0] + nextLine[1] + "etc...");
//                Log.d("VariableTag", nextLine[0]);
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//            Toast.makeText(this, "The specified file was not found", Toast.LENGTH_SHORT).show();
//        }
//
//    }
}
