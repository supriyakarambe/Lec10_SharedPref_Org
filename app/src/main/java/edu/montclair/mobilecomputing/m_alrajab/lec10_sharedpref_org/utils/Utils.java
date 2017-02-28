package edu.montclair.mobilecomputing.m_alrajab.lec10_sharedpref_org.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Map;


/**
 * Created by m_alrajab on 2/22/17.
 */

public class Utils {

    public static final String SHARED_PREF_FILENAME="edu.montclair.mobilecomputing.m_alrajab.lec10_sharedpref_org.SHAREDFILE1";
    public static final String KEY_TITLE="Title_";
    public static final String KEY_BODY="Body_";


    public static String[] getListFromSP(Context context, String key){
        SharedPreferences sharedPreferences=context.getSharedPreferences(SHARED_PREF_FILENAME,
                Context.MODE_PRIVATE);
        // value dattype in map is unknown
        Map<String, ?> map=sharedPreferences.getAll();
        ArrayList<String> lst= new ArrayList<>();
        for(String str:map.keySet()){
            if(str.startsWith(key))
                lst.add((String)map.get(str));
        }
        return lst.toArray(new String[lst.size()]);
    }


    //Retrive data from file
    public static String[] getListFromFile(Context context,String key){
        ArrayList<String> lst= new ArrayList<>();
        ArrayList<String> lstBody= new ArrayList<>();
        String tenpStr="";
        try {

            File fileDir=context.getFilesDir();
            File[] files=fileDir.listFiles();
            for (File file: files){
                lst.add(file.getName().toString());
            }

            FileInputStream inputStream=context.openFileInput(key.toString().replace(" ",""));
            int c;
            while ((c=inputStream.read())!=-1){
                tenpStr+=Character.toString((char) c);
            }
            lstBody.add(tenpStr);
            inputStream.close();

        }catch (Exception e){}
        if(key.equals("Title"))
        return lst.toArray(new String[lst.size()]);
        else
            return lstBody.toArray(new String[lst.size()]);
    }

}
