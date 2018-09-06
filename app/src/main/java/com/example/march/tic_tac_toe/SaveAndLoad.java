package com.example.march.tic_tac_toe;

import android.content.SharedPreferences;
import android.view.View;

import static android.content.Context.MODE_PRIVATE;

import static com.example.march.tic_tac_toe.StartActivity.save_1;
import static com.example.march.tic_tac_toe.StartActivity.save_2;
import static com.example.march.tic_tac_toe.StartActivity.save_3;
//import static com.example.march.tic_tac_toe.StartActivity.sPref;
import android.content.SharedPreferences;


/**
 * Created by march on 21.07.2017.
 */

public class SaveAndLoad {

    SharedPreferences sPref;

    StartActivity startActivity = new StartActivity();

    final String SAVED_ONE = "saved achivments 1";
    final String SAVED_TWO = "saved achivments 2";
    final String SAVED_THREE = "saved achivments 3";

    void save_achivments(){
        //sPref = getSharedPreferences();
        SharedPreferences.Editor editor = sPref.edit();
        editor.putInt(SAVED_ONE, save_1);
        editor.putInt(SAVED_TWO, save_2);
        editor.putInt(SAVED_THREE, save_3);
        editor.commit();
        //Toast.makeText(this, "Save Achievements", Toast.LENGTH_SHORT).show();
    }



    public void load_achivments(){
        //sPref = getPreferences(MODE_PRIVATE);
        save_1 = sPref.getInt(SAVED_ONE,0);
        save_2 = sPref.getInt(SAVED_TWO,0);
        save_3 = sPref.getInt(SAVED_THREE, 0);
        //Toast.makeText(this, "Load Achievements", Toast.LENGTH_SHORT).show();
        if(save_1 == 1){
            //im1.setVisibility(View.INVISIBLE);
            //im3.setVisibility(View.VISIBLE);
        }
        if(save_2 == 1){
            //im2.setVisibility(View.INVISIBLE);
            //im4.setVisibility(View.VISIBLE);
        }
    }


}
