package com.encryptionapp.junaid.encryptionapp;

import android.content.Context;
import android.content.SharedPreferences;

public class savetolocal {

    private String mypreference="mypref";
    SharedPreferences sharedPreferences;

    public savetolocal(String phoneno,Context context){
        sharedPreferences = context.getSharedPreferences(mypreference,
                Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();

        editor.putString("Phonekey",phoneno);
        editor.apply();

    }


}
