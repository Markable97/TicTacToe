package com.example.march.tic_tac_toe;

import android.os.Handler;
import android.util.Log;

import static com.example.march.tic_tac_toe.PlayWithAndroid.a;
import static com.example.march.tic_tac_toe.PlayWithAndroid.array;
import static com.example.march.tic_tac_toe.PlayWithAndroid.bt1;
import static com.example.march.tic_tac_toe.PlayWithAndroid.bt2;
import static com.example.march.tic_tac_toe.PlayWithAndroid.bt3;
import static com.example.march.tic_tac_toe.PlayWithAndroid.bt4;
import static com.example.march.tic_tac_toe.PlayWithAndroid.bt5;
import static com.example.march.tic_tac_toe.PlayWithAndroid.bt6;
import static com.example.march.tic_tac_toe.PlayWithAndroid.bt7;
import static com.example.march.tic_tac_toe.PlayWithAndroid.bt8;
import static com.example.march.tic_tac_toe.PlayWithAndroid.bt9;


import static com.example.march.tic_tac_toe.PlayWithAndroid.f_x_win;
import static com.example.march.tic_tac_toe.PlayWithAndroid.proverka_win;


/**
 * Created by march on 07.02.2017.
 */


public class ProferkaWin {

    private static final String TAG = "MyApp";

     void proferka_O() {
        if ((array[0][0] == 2 & array[0][1] == 2 & array[0][2] == 2) | (array[1][0] == 2 & array[1][1] == 2 & array[1][2] == 2) | (array[2][0] == 2 & array[2][1] == 2 & array[2][2] == 2)
                | (array[0][0] == 2 & array[1][0] == 2 & array[2][0] == 2) | (array[0][1] == 2 & array[1][1] == 2 & array[2][1] == 2) | (array[0][2] == 2 & array[1][2] == 2 & array[2][2] == 2) |
                (array[0][0] == 2 & array[1][1] == 2 & array[2][2] == 2) | (array[0][2] == 2 & array[1][1] == 2 & array[2][0] == 2))
        {
            for( int j = 0; j<3; j++)
                for(int l = 0; l<3; l++)
                    Log.i(TAG,"Проверка на нолики array["+j+"]["+l+"]= "+ array[j][l] );
            fon_o();
            block();
            a=1;
            proverka_win = 1;
        }
    }

    int proferka_X() {
        if ((array[0][0] == 1 & array[0][1] == 1 & array[0][2] == 1) | (array[1][0] == 1 & array[1][1] == 1 & array[1][2] == 1) | (array[2][0] == 1 & array[2][1] == 1 & array[2][2] == 1)
                | (array[0][0] == 1 & array[1][0] == 1 & array[2][0] == 1) | (array[0][1] == 1 & array[1][1] == 1 & array[2][1] == 1) | (array[0][2] == 1 & array[1][2] == 1 & array[2][2] == 1) |
                (array[0][0] == 1 & array[1][1] == 1 & array[2][2] == 1) | (array[0][2] == 1 & array[1][1] == 1 & array[2][0] == 1))
        {
            for( int j = 0; j<3; j++)
                for(int l = 0; l<3; l++)
                    Log.i(TAG,"Проверка на крестики array["+j+"]["+l+"]= "+ array[j][l] );
            fon_x();
            block();
            a=2;
            proverka_win = 1;
            return f_x_win=1;
        }

        return f_x_win=0;
    }

    private  void block()
    {
        bt1.setEnabled(false);
        bt2.setEnabled(false);
        bt3.setEnabled(false);
        bt4.setEnabled(false);
        bt5.setEnabled(false);
        bt6.setEnabled(false);
        bt7.setEnabled(false);
        bt8.setEnabled(false);
        bt9.setEnabled(false);
    }

    void fon_o(){

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if (array[0][0] == 2 & array[0][1] == 2 & array[0][2] == 2){
                    bt1.setBackgroundResource(R.drawable.button_win_o);
                    bt2.setBackgroundResource(R.drawable.button_win_o);
                    bt3.setBackgroundResource(R.drawable.button_win_o);
                }
                if(array[1][0] == 2 & array[1][1] == 2 & array[1][2] == 2){
                    bt4.setBackgroundResource(R.drawable.button_win_o);
                    bt5.setBackgroundResource(R.drawable.button_win_o);
                    bt6.setBackgroundResource(R.drawable.button_win_o);
                }
                if(array[2][0] == 2 & array[2][1] == 2 & array[2][2] == 2){
                    bt7.setBackgroundResource(R.drawable.button_win_o);
                    bt8.setBackgroundResource(R.drawable.button_win_o);
                    bt9.setBackgroundResource(R.drawable.button_win_o);
                }
                if(array[0][0] == 2 & array[1][0] == 2 & array[2][0] == 2){
                    bt1.setBackgroundResource(R.drawable.button_win_o);
                    bt4.setBackgroundResource(R.drawable.button_win_o);
                    bt7.setBackgroundResource(R.drawable.button_win_o);
                }
                if(array[0][1] == 2 & array[1][1] == 2 & array[2][1] == 2){
                    bt2.setBackgroundResource(R.drawable.button_win_o);
                    bt5.setBackgroundResource(R.drawable.button_win_o);
                    bt8.setBackgroundResource(R.drawable.button_win_o);
                }
                if(array[0][2] == 2 & array[1][2] == 2 & array[2][2] == 2){
                    bt3.setBackgroundResource(R.drawable.button_win_o);
                    bt6.setBackgroundResource(R.drawable.button_win_o);
                    bt9.setBackgroundResource(R.drawable.button_win_o);
                }
                if(array[0][0] == 2 & array[1][1] == 2 & array[2][2] == 2){
                    bt1.setBackgroundResource(R.drawable.button_win_o);
                    bt5.setBackgroundResource(R.drawable.button_win_o);
                    bt9.setBackgroundResource(R.drawable.button_win_o);
                }
                if (array[0][2] == 2 & array[1][1] == 2 & array[2][0] == 2){
                    bt3.setBackgroundResource(R.drawable.button_win_o);
                    bt5.setBackgroundResource(R.drawable.button_win_o);
                    bt7.setBackgroundResource(R.drawable.button_win_o);
                }
            }
        }, 400);


    }
    void fon_x(){

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                if (array[0][0] == 1 & array[0][1] == 1 & array[0][2] == 1){
                    bt1.setBackgroundResource(R.drawable.button_win_x);
                    bt2.setBackgroundResource(R.drawable.button_win_x);
                    bt3.setBackgroundResource(R.drawable.button_win_x);
                }
                if(array[1][0] == 1 & array[1][1] == 1 & array[1][2] == 1){
                    bt4.setBackgroundResource(R.drawable.button_win_x);
                    bt5.setBackgroundResource(R.drawable.button_win_x);
                    bt6.setBackgroundResource(R.drawable.button_win_x);
                }
                if(array[2][0] == 1 & array[2][1] == 1 & array[2][2] == 1){
                    bt7.setBackgroundResource(R.drawable.button_win_x);
                    bt8.setBackgroundResource(R.drawable.button_win_x);
                    bt9.setBackgroundResource(R.drawable.button_win_x);
                }
                if(array[0][0] == 1 & array[1][0] == 1 & array[2][0] == 1){
                    bt1.setBackgroundResource(R.drawable.button_win_x);
                    bt4.setBackgroundResource(R.drawable.button_win_x);
                    bt7.setBackgroundResource(R.drawable.button_win_x);
                }
                if(array[0][1] == 1 & array[1][1] == 1 & array[2][1] == 1){
                    bt2.setBackgroundResource(R.drawable.button_win_x);
                    bt5.setBackgroundResource(R.drawable.button_win_x);
                    bt8.setBackgroundResource(R.drawable.button_win_x);
                }
                if(array[0][2] == 1 & array[1][2] == 1 & array[2][2] == 1){
                    bt3.setBackgroundResource(R.drawable.button_win_x);
                    bt6.setBackgroundResource(R.drawable.button_win_x);
                    bt9.setBackgroundResource(R.drawable.button_win_x);
                }
                if(array[0][0] == 1 & array[1][1] == 1 & array[2][2] == 1){
                    bt1.setBackgroundResource(R.drawable.button_win_x);
                    bt5.setBackgroundResource(R.drawable.button_win_x);
                    bt9.setBackgroundResource(R.drawable.button_win_x);
                }
                if (array[0][2] == 1 & array[1][1] == 1 & array[2][0] == 1){
                    bt3.setBackgroundResource(R.drawable.button_win_x);
                    bt5.setBackgroundResource(R.drawable.button_win_x);
                    bt7.setBackgroundResource(R.drawable.button_win_x);
                }
            }
        }, 400);


    }
}
