package com.example.march.tic_tac_toe;

import android.graphics.Color;
import android.os.Handler;

import java.util.Random;

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
import static com.example.march.tic_tac_toe.PlayWithAndroid.nomer_game;
import static com.example.march.tic_tac_toe.PlayWithAndroid.nomer_hoda;
import static com.example.march.tic_tac_toe.PlayWithAndroid.vivod_winner;



/**
 * Created by march on 28.03.2017.
 */

public class LevelEasy  {

    ProferkaWin prWin = new ProferkaWin();

    final Random random = new Random();
    void gameplay(){
        if(nomer_game % 2 ==0){
            if(nomer_hoda >= 5)
            {
                f_x_win = prWin.proferka_X();
                vivod_winner(a);
            }
            if(f_x_win == 0)
            {
                nomer_hoda++;
                vivod_winner(a);
                easy_defend();
            }

        }else{
            if(nomer_hoda >= 6)
            {
                f_x_win = prWin.proferka_X();
                vivod_winner(a);
            }
            if(f_x_win == 0)
            {
                nomer_hoda++;
                vivod_winner(a);
                easy_attack();
            }
        }
    }

    void repeat_at(){

        int i = random.nextInt(3);
        int j = random.nextInt(3);
        if (array[i][j]== 0) {
            array[i][j]=2;
            if(i==0 & j==0){color(1);zaderchka(1);return;}
            if(i==0 & j==1){color(2);zaderchka(2);return;}
            if(i==0 & j==2){color(3);zaderchka(3);return;}
            if(i==1 & j==0){color(4);zaderchka(4);return;}
            if(i==1 & j==1){color(5);zaderchka(5);return;}
            if(i==1 & j==2){color(6);zaderchka(6);return;}
            if(i==2 & j==0){color(7);zaderchka(7);return;}
            if(i==2 & j==1){color(8);zaderchka(8);return;}
            if(i==2 & j==2){color(9);zaderchka(9);return;}
        }else repeat_at();


    }

    private void color(int i) {
        switch (i) {
            case 1:
                bt1.setTextColor(Color.parseColor("#e91e63"));
                break;
            case 2:
                bt2.setTextColor(Color.parseColor("#e91e63"));
                break;
            case 3:
                bt3.setTextColor(Color.parseColor("#e91e63"));
                break;
            case 4:
                bt4.setTextColor(Color.parseColor("#e91e63"));
                break;
            case 5:
                bt5.setTextColor(Color.parseColor("#e91e63"));
                break;
            case 6:
                bt6.setTextColor(Color.parseColor("#e91e63"));
                break;
            case 7:
                bt7.setTextColor(Color.parseColor("#e91e63"));
                break;
            case 8:
                bt8.setTextColor(Color.parseColor("#e91e63"));
                break;
            case 9:
                bt9.setTextColor(Color.parseColor("#e91e63"));
                break;
        }
    }

    public static void zaderchka(final int i){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                switch (i){
                    case 1: bt1.setText("O");bt1.setEnabled(false);break;
                    case 2: bt2.setText("O");bt2.setEnabled(false);break;
                    case 3: bt3.setText("O");bt3.setEnabled(false);break;
                    case 4: bt4.setText("O");bt4.setEnabled(false);break;
                    case 5: bt5.setText("O");bt5.setEnabled(false);break;
                    case 6: bt6.setText("O");bt6.setEnabled(false);break;
                    case 7: bt7.setText("O");bt7.setEnabled(false);break;
                    case 8: bt8.setText("O");bt8.setEnabled(false);break;
                    case 9: bt9.setText("O");bt9.setEnabled(false);break;
                }
            }
        }, 400);
    }


    void easy_attack(){
        if(nomer_hoda == 1){
            repeat_at();
            nomer_hoda++;
        }
        if(nomer_hoda == 3){
            proferka_2def();
            nomer_hoda++;
        }
        if(nomer_hoda == 5){
            repeat_at();
            nomer_hoda++;
            prWin.proferka_O();
            vivod_winner(a);
        }
        if(nomer_hoda == 7){
            repeat_at();
            nomer_hoda++;
            prWin.proferka_O();
            vivod_winner(a);
        }
        if(nomer_hoda == 9){
            repeat_at();
            nomer_hoda++;
            prWin.proferka_O();
            vivod_winner(a);
        }

    }

    void easy_defend(){

        if(nomer_hoda == 2){
            repeat_at();
            nomer_hoda++;
        }
        if(nomer_hoda == 4){
           proferka_2def();
            nomer_hoda++;
        }
        if(nomer_hoda == 6){
            repeat_at();
            nomer_hoda++;
            prWin.proferka_O();
            vivod_winner(a);
        }
        if(nomer_hoda == 8){
            repeat_at();
            nomer_hoda++;
            prWin.proferka_O();
            vivod_winner(a);
        }

    }

    private void proferka_2def(){

        int f=0;

        if((array[1][1] & array[2][2])== 1 & array[0][0]==0){
            color(1);
            zaderchka(1);
            array[0][0]=2;
            return;
        }
////////////////////////////////////////////////////////////
        if((array[1][1] & array[0][1]) == 1 & (array[2][1]==0)){
            color(8);
            zaderchka(8);
            array[2][1]=2;
            return;
        }
        if((array[1][1] & array[2][1]) == 1 & (array[0][1]==0)){
            color(2);
            zaderchka(2);
            array[0][1]=2;
            return;
        }
        if((array[0][1] & array[2][1]) == 1 & (array[1][1]==0)){
            color(5);
            zaderchka(5);
            array[1][1]=2;
            return;
        }

/////////////////////////////////////////////////////
        if((array[1][1] & array[0][2]) == 1 & (array[2][0]==0)){
            color(7);
            zaderchka(7);
            array[2][0]=2;
            return;
        }
        if((array[1][1] & array[2][0]) == 1 & (array[0][2]==0)){
            color(3);
            zaderchka(3);
            array[0][2]=2;
            return;
        }
        if((array[2][0] & array[0][2]) == 1 & (array[1][1]==0)){
            color(5);
            zaderchka(5);
            array[1][1]=2;
            return;
        }
///////////////////////////////////////////////////
        if((array[1][1] & array[1][0]) == 1 & (array[1][2]==0)){
            color(6);
            zaderchka(6);
            array[1][2]=2;
            return;
        }
        if((array[1][1] & array[1][2]) ==1 & (array[1][0]==0)){
            color(4);
            zaderchka(4);
            array[1][0]=2;
            return;
        }

        if((array[1][0] & array[1][2]) == 1 & (array[1][1]==0)) {
            color(5);
            zaderchka(5);
            array[1][1] = 2;
            return;
        }

///////////////////////////////////////////////////
        if((array[2][0] & array[2][1]) == 1 & (array[2][2]==0)){
            color(9);
            zaderchka(9);
            array[2][2] = 2;
            return;
        }
        if((array[2][0] & array[2][2]) == 1 &(array[2][1]==0)){
            color(8);
            zaderchka(8);
            array[2][1]=2;
            return;
        }
        if((array[2][1] & array[2][2]) == 1 &(array[2][0]==0)){
            color(7);
            zaderchka(7);
            array[2][0]=2;
            return;
        }
//////////////////////////////////////////////////
        if((array[0][2] & array[1][2]) == 1 & (array[2][2]==0)){
            color(9);
            zaderchka(9);
            array[2][2]=2;
            return;
        }
        if((array[0][2] & array[2][2]) == 1 & (array[1][2]==0)){
            color(6);
            zaderchka(6);
            array[1][2]=2;
            return;
        }
        if((array[2][2] & array[1][2]) == 1 & (array[0][2]==0)){
            color(3);
            zaderchka(3);
            array[0][2]=2;
            return;
        }
//////////////////////////////////////////////////
        if((array[0][0] & array[1][0]) == 1 & (array[2][0]==0)){
            color(7);
            zaderchka(7);
            array[2][0]=2;
            return;
        }
        if((array[0][0] & array[2][0]) == 1 & (array[1][0]==0)){
            color(4);
            zaderchka(4);
            array[1][0]=2;
            return;
        }
        if((array[2][0] & array[1][0]) == 1 & (array[0][0]==0)){
            color(1);
            zaderchka(1);
            array[0][0]=2;
            return;
        }
///////////////////////////////////////////////////
        if((array[0][0] & array[0][1]) == 1 & (array[0][2]==0)){
            color(3);
            zaderchka(3);
            array[0][2]=2;
            return;
        }
        if((array[0][0] & array[0][2]) == 1 & (array[0][1]==0)){
            color(2);
            zaderchka(2);
            array[0][1]=2;
            return;
        }
        if((array[0][1] & array[0][2]) == 1 & (array[0][0]==0)){
            color(1);
            zaderchka(1);
            array[0][0]=2;
            return;
        }
///////////////////////////////////////////////////
        if((array[2][2] & array[1][1]) == 1 & (array[0][0]==0)){
            color(1);
            zaderchka(1);
            array[0][0]=2;
            return;
        }
        if((array[0][0] & array[2][2]) == 1 & (array[1][1]==0)){
            color(5);
            zaderchka(5);
            array[1][1]=2;
            return;
        }
        if((array[0][0] & array[1][1]) == 1 & (array[2][2]==0)){
            color(9);
            zaderchka(9);
            array[2][2]=2;
            return;
        }


        if (f == 0 ){
            repeat_at();
        }
    }
}
