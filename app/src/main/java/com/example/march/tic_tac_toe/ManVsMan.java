package com.example.march.tic_tac_toe;


import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;



public class ManVsMan extends AppCompatActivity implements View.OnClickListener {

    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_YES);
    }


    String name_player1;
    String name_player2;

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnnext;
    TextView tx1,tx2,tx3,tx4,tx5,tx6;

    private static final String TAG = "MyApp";

    int color;



    int nomer = 1;//номер игры
    int f = 0;//флаг на победу
    int p1 = 0,p2 = 0; //счет игроков
    int nomer_hoda = 1;//номер хода
    int[][] arr = {
            {0,0,0},
            {0,0,0},        //массив для проверки(номера кнопок схожи с индексом массива)
            {0,0,0},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_players);
        //    LinearLayout layout = (LinearLayout) findViewById(R.id.liner);
        //    layout.addView( new Draw(this));
        Log.i(TAG, "Это мое сообщение для записи в журнале");
        for( int j = 0; j<3; j++)
            for(int l = 0; l<3; l++)
                Log.i(TAG,"Проверка в начале array["+j+"]["+l+"]= "+ arr[j][l] );
        Toast.makeText(this,"Player1 for TIC",Toast.LENGTH_SHORT).show();

        // Resources resources = getResources();



        //name_player1 = getIntent().getExtras().getString("name_one");
        name_player1 = "PLAYER1";
        //name_player2 = getIntent().getExtras().getString("name_two");
        name_player2 = "PLAYER2";

        tx1 = (TextView) findViewById(R.id.textView);
        tx2 = (TextView) findViewById(R.id.textView2);
        tx3 = (TextView) findViewById(R.id.textView3);
        tx4 = (TextView) findViewById(R.id.ocher_hod);
        tx5 = (TextView) findViewById(R.id.hod_player1);
        tx6 = (TextView) findViewById(R.id.hod_player2);
        // tx1.setTextColor(Color.BLUE);

        // color = getResources().getColor(Color.GREEN);

        tx1.setTextColor(getResources().getColor(R.color.figurki_X));
        //tx1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/3dhands.ttf"));

        tx1.setText(name_player1+":"+ p1);
        tx2.setTextColor(getResources().getColor(R.color.figurki_O));
        //tx2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/3dhands.ttf"));

        tx2.setText(name_player2+":"+ p2);
        tx3.setText("Game№ "+ nomer);
        // tx4.setTextColor(getResources().getColor(R.color.player1));
       // tx4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/3dhands.ttf"));
        tx4.setTextColor(getResources().getColor(R.color.figurki_X));
        tx4.setText("Turn - X");
        //tx5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/3dhands.ttf"));
        tx5.setTextColor(getResources().getColor(R.color.figurki_X));
        tx5.setText(name_player1 + "-X");
        //tx6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/3dhands.ttf"));
        tx6.setTextColor(getResources().getColor(R.color.figurki_O));
        tx6.setText(name_player2 + "-O");

        btn1 = (Button) findViewById(R.id.btn_1);
        btn1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/3dhands.ttf"));
        btn2 = (Button) findViewById(R.id.btn_2);
        btn2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/3dhands.ttf"));
        btn3 = (Button) findViewById(R.id.btn_3);
        btn3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/3dhands.ttf"));
        btn4 = (Button) findViewById(R.id.btn_4);
        btn4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/3dhands.ttf"));
        btn5 = (Button) findViewById(R.id.btn_5);
        btn5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/3dhands.ttf"));
        btn6 = (Button) findViewById(R.id.btn_6);
        btn6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/3dhands.ttf"));
        btn7 = (Button) findViewById(R.id.btn_7);
        btn7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/3dhands.ttf"));
        btn8 = (Button) findViewById(R.id.btn_8);
        btn8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/3dhands.ttf"));
        btn9 = (Button) findViewById(R.id.btn_9);
        btn9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/3dhands.ttf"));

        btnnext = (Button) findViewById(R.id.btn_next);
        btnnext.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/3dhands.ttf"));


        Log.d(TAG, "i = " + nomer_hoda);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnnext.setOnClickListener(this);

        //Toast.makeText(this, "Конец игры!", Toast.LENGTH_LONG).show();
    }

    private void color_change(){

        Resources res = getResources();

        if(nomer_hoda % 2 == 0)
        {
            if(nomer %  2 == 0)
            {
                color = res.getColor(R.color.figurki_X);}
            else
            {
                color = res.getColor(R.color.figurki_O);
                }
        }
        else
        {
            if (nomer % 2 == 0)
            {
                color = res.getColor(R.color.figurki_O);}
            else
            {
                color = res.getColor(R.color.figurki_X);}
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:

                color_change();
                btn1.setTextColor(color);

                if(nomer_hoda % 2 == 0)
                {
                    btn1.setText("O");
                    arr[0][0]=2;
                    btn1.setEnabled(false);
                }
                else
                {
                    btn1.setText("X");
                    arr[0][0]=1;
                    btn1.setEnabled(false);
                }

                if(nomer_hoda >= 5)
                    proferka( nomer_hoda );

                nomer_hoda++;
                ocher_xod(nomer_hoda);
                viviod_win(f);
                break;
            case R.id.btn_2:

                color_change();
                btn2.setTextColor(color);

                if(nomer_hoda % 2 == 0)
                {
                    btn2.setText("O");
                    arr[0][1]=2;
                    btn2.setEnabled(false);
                }
                else
                {
                    btn2.setText("X");
                    arr[0][1]=1;
                    btn2.setEnabled(false);
                }

               // Log.i(TAG,"нажата Кнопка 2. i= " + i + " Arr[0][1] =" + arr[0][1]);

                if(nomer_hoda >= 5)
                    proferka( nomer_hoda );
                nomer_hoda++;
                ocher_xod(nomer_hoda);
                viviod_win(f);
                break;
            case R.id.btn_3:

                color_change();
                btn3.setTextColor(color);

                if(nomer_hoda % 2 == 0)
                {
                    btn3.setText("O");
                    arr[0][2]=2;
                    btn3.setEnabled(false);
                }
                else
                {
                    btn3.setText("X");
                    arr[0][2]=1;
                    btn3.setEnabled(false);
                }
                //Log.i(TAG,"нажата Кнопка 3. i= " + i + " Arr[0][2] =" + arr[0][2]);

                if(nomer_hoda >= 5)
                    proferka( nomer_hoda );
                nomer_hoda++;
                ocher_xod(nomer_hoda);
                viviod_win(f);
                break;
            case R.id.btn_4:

                color_change();
                btn4.setTextColor(color);

                if(nomer_hoda % 2 == 0)
                {
                    btn4.setText("O");
                    arr[1][0]=2;
                    btn4.setEnabled(false);

                }
                else
                {
                    btn4.setText("X");
                    arr[1][0]=1;
                    btn4.setEnabled(false);
                }
               // Log.i(TAG,"нажата Кнопка 4. i= " + i + " Arr[1][0] =" + arr[1][0]);

                if(nomer_hoda >= 5)
                    proferka( nomer_hoda );
                nomer_hoda++;
                ocher_xod(nomer_hoda);
                viviod_win(f);
                break;
            case R.id.btn_5:

                color_change();
                btn5.setTextColor(color);

                if(nomer_hoda % 2 == 0)
                {
                    btn5.setText("O");
                    arr[1][1]=2;
                    btn5.setEnabled(false);
                }
                else
                {
                    btn5.setText("X");
                    arr[1][1]=1;
                    btn5.setEnabled(false);
                }
               // Log.i(TAG,"нажата Кнопка 5. i= " + i + " Arr[1][1] =" + arr[1][1]);

                if(nomer_hoda >= 5)
                    proferka( nomer_hoda );
                nomer_hoda++;
                ocher_xod(nomer_hoda);
                viviod_win(f);
                break;
            case R.id.btn_6:

                color_change();
                btn6.setTextColor(color);

                if(nomer_hoda % 2 == 0)
                {
                    btn6.setText("O");
                    arr[1][2]=2;
                    btn6.setEnabled(false);
                }
                else
                {
                    btn6.setText("X");
                    arr[1][2]=1;
                    btn6.setEnabled(false);
                }
                //Log.i(TAG,"нажата Кнопка 6. i= " + i + " Arr[1][2] =" + arr[1][2]);

                if(nomer_hoda >= 5)
                    proferka( nomer_hoda );
                nomer_hoda++;
                ocher_xod(nomer_hoda);
                viviod_win(f);
                break;
            case R.id.btn_7:

                color_change();
                btn7.setTextColor(color);

                if(nomer_hoda % 2 == 0)
                {
                    btn7.setText("O");
                    arr[2][0]=2;
                    btn7.setEnabled(false);
                }
                else
                {
                    btn7.setText("X");
                    arr[2][0]=1;
                    btn7.setEnabled(false);
                }
                //Log.i(TAG,"нажата Кнопка 7. i= " + i + " Arr[2][0] =" + arr[2][0]);

                if(nomer_hoda >= 5)
                    proferka( nomer_hoda );
                nomer_hoda++;
                ocher_xod(nomer_hoda);
                viviod_win(f);
                break;
            case R.id.btn_8:

                color_change();
                btn8.setTextColor(color);

                if(nomer_hoda % 2 == 0)
                {
                    btn8.setText("O");
                    arr[2][1]=2;
                    btn8.setEnabled(false);

                }
                else
                {
                    btn8.setText("X");
                    arr[2][1]=1;
                    btn8.setEnabled(false);
                }
                //Log.i(TAG,"нажата Кнопка 8. i= " + i + " Arr[2][1] =" + arr[2][1]);

                if(nomer_hoda >= 5)
                    proferka( nomer_hoda );
                nomer_hoda++;
                ocher_xod(nomer_hoda);
                viviod_win(f);
                break;
            case R.id.btn_9:

                color_change();
                btn9.setTextColor(color);

                if(nomer_hoda % 2 == 0)
                {
                    btn9.setText("O");
                    arr[2][2]=2;
                    btn9.setEnabled(false);

                }
                else
                {
                    btn9.setText("X");
                    arr[2][2]=1;
                    btn9.setEnabled(false);
                }
                //Log.i(TAG,"нажата Кнопка 9. i= " + i + " Arr[2][2] =" + arr[2][2]);

                if(nomer_hoda>= 5)
                    proferka(nomer_hoda );
                nomer_hoda++;
                ocher_xod(nomer_hoda);
                viviod_win(f);
                break;
            case R.id.btn_next:
                clear();
                btnnext.setVisibility(View.INVISIBLE);
                break;
        }

    }

    private void proferka(int i){

        if (i % 2 == 0) {
            proferka_O();
        } else {
            proferka_X();
        }

    }

    private void viviod_win(int f) {

        if (f == 1)
        {
            if(nomer % 2 == 0)
            {
                tx4.setTextColor(getResources().getColor(R.color.figurki_O));
            }
            else
            {
                tx4.setTextColor(getResources().getColor(R.color.figurki_X));
            }
            tx4.setText("WIN-X");
        }
        else if(f == 2){
            if(nomer % 2 == 0)
            {
                tx4.setTextColor(getResources().getColor(R.color.figurki_X));
            }
            else
            {
                tx4.setTextColor(getResources().getColor(R.color.figurki_O));
            }
            tx4.setText("WIN-O");
        }else if(f == 3){
            tx4.setTextColor(getResources().getColor(R.color.white));
            tx4.setText("DRAW");
        }

    }

    private void ocher_xod(int i){



        if( i % 2 == 0)
        {
            if(nomer % 2 == 0)
            {
                tx4.setTextColor(getResources().getColor(R.color.figurki_X));
            }
            else
            {
                tx4.setTextColor(getResources().getColor(R.color.figurki_O));
            }
            tx4.setText("Turn-O");
        }
        else
        {
            if(nomer % 2 == 0)
            {
                tx4.setTextColor(getResources().getColor(R.color.figurki_O));
            }
            else
            {
                tx4.setTextColor(getResources().getColor(R.color.figurki_X));
            }
            tx4.setText("Turn-X");
        }
    }

    private  void block()
    {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }

    private void unblock()
    {

        arr = new int[][]{
                {0, 0, 0},
                {0, 0, 0},        //массив для проверки(номера кнопок схожи с индексом массива)
                {0, 0, 0},
        };

        btn1.setText("");btn1.setEnabled(true);
        btn2.setText("");btn2.setEnabled(true);
        btn3.setText("");btn3.setEnabled(true);
        btn4.setText("");btn4.setEnabled(true);
        btn5.setText("");btn5.setEnabled(true);
        btn6.setText("");btn6.setEnabled(true);
        btn7.setText("");btn7.setEnabled(true);
        btn8.setText("");btn8.setEnabled(true);
        btn9.setText("");btn9.setEnabled(true);
    }




    private void proferka_O(){
        if ( (arr[0][0] == 2 & arr[0][1] ==2 & arr[0][2]==2 ) | (arr[1][0] == 2 & arr[1][1] ==2 & arr[1][2]==2 ) | (arr[2][0] == 2 & arr[2][1] ==2 & arr[2][2]==2 )
                | (arr[0][0]==2 & arr[1][0]==2 & arr[2][0]==2) | (arr[0][1]==2 & arr[1][1]==2 & arr[2][1]==2) | ( arr[0][2]==2 & arr[1][2]==2 & arr[2][2]==2 ) |
                ( arr[0][0]==2 & arr[1][1]==2 & arr[2][2]==2) | (arr[0][2]==2 & arr[1][1]==2 & arr[2][0]==2))
        {
            fon_o();
            if(nomer % 2 == 0)
            {
                f=2;
                Toast.makeText(this, "Game end! Player1 win", Toast.LENGTH_LONG).show();
                for( int j = 0; j<3; j++)
                    for(int l = 0; l<3; l++)
                        Log.i(TAG,"array["+j+"]["+l+"]= "+ arr[j][l] );
                p1++;
                tx1.setText(name_player1+": "+ p1);

                btnnext.setVisibility(View.VISIBLE);
                fon_o();
                block();
            }
            else
            {
                f = 2;
                Toast.makeText(this, "Game end! Player2 win", Toast.LENGTH_LONG).show();
                for( int j = 0; j<3; j++)
                    for(int l = 0; l<3; l++)
                        Log.i(TAG,"array["+j+"]["+l+"]= "+ arr[j][l] );
                p2++;
                tx2.setText(name_player2+": "+p2);
                btnnext.setVisibility(View.VISIBLE);
                fon_x();
                block();
            }
        }
        else{
            if(nomer_hoda == 9)
            {  f = 3;
                btnnext.setVisibility(View.VISIBLE);
                Toast.makeText(this, "Game end! Draw", Toast.LENGTH_LONG).show();}
        }


    }

    private void proferka_X(){
        if ( (arr[0][0] == 1 & arr[0][1] ==1 & arr[0][2]==1 ) | (arr[1][0] == 1 & arr[1][1] ==1 & arr[1][2]==1 ) | (arr[2][0] == 1 & arr[2][1] ==1 & arr[2][2]==1 )
                | (arr[0][0]==1 & arr[1][0]==1 & arr[2][0]==1) | (arr[0][1]==1 & arr[1][1]==1 & arr[2][1]==1) | ( arr[0][2]==1 & arr[1][2]==1 & arr[2][2]==1 ) |
                ( arr[0][0]==1 & arr[1][1]==1 & arr[2][2]==1) | (arr[0][2]==1 & arr[1][1]==1 & arr[2][0]==1))

        {
            fon_x();
            if(nomer % 2 == 0)
            {
                f = 1;
                Toast.makeText(this, "Game end! Player2 win", Toast.LENGTH_LONG).show();
                for( int j = 0; j<3; j++)
                    for(int l = 0; l<3; l++)
                        Log.i(TAG,"array["+j+"]["+l+"]= "+ arr[j][l] );
                p2++;
                tx2.setText(name_player2+": "+ p2);
                btnnext.setVisibility(View.VISIBLE);
                block();
            }
            else
            {
                f = 1;
                Toast.makeText(this, "Game end! Player1 win", Toast.LENGTH_LONG).show();
                for (int j = 0; j < 3; j++)
                    for (int l = 0; l < 3; l++)
                        Log.i(TAG, "array[" + j + "][" + l + "]= " + arr[j][l]);
                p1++;
                tx1.setText(name_player1+": "+ p1);

                btnnext.setVisibility(View.VISIBLE);

                block();
            }
        }
        else {
            if (nomer_hoda == 9)
            {
                f=3;
                btnnext.setVisibility(View.VISIBLE);
                Toast.makeText(this, "Game end! Draw", Toast.LENGTH_LONG).show();
            }
        }
    }



    private void clear()
    {
        unblock();
        nomer_hoda=1;f=0;
        nomer++;
        tx3.setText("Game№"+ nomer);
        if(nomer % 2 ==  0)
        {
            tx5.setText(name_player1 + "-O");
            tx6.setText(name_player2 + "-X");
        }
        else
        {
            tx5.setText(name_player1 + "-X");
            tx6.setText(name_player2 + "-O");
        }


        if(nomer % 2 ==0)
            Toast.makeText(this,"Player2 for TIC",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this,"Player1 for TIC",Toast.LENGTH_SHORT).show();
        ocher_xod(nomer_hoda);
        btn1.setBackgroundResource(R.drawable.button_start);
        btn2.setBackgroundResource(R.drawable.button_start);
        btn3.setBackgroundResource(R.drawable.button_start);
        btn4.setBackgroundResource(R.drawable.button_start);
        btn5.setBackgroundResource(R.drawable.button_start);
        btn6.setBackgroundResource(R.drawable.button_start);
        btn7.setBackgroundResource(R.drawable.button_start);
        btn8.setBackgroundResource(R.drawable.button_start);
        btn9.setBackgroundResource(R.drawable.button_start);
    }

    private void obnylit()
    {
        p1=0;p2=0;nomer_hoda=1;f=0;
        tx1.setText(name_player1 + ":" + p1);
        tx2.setText(name_player2 + ":" + p2);
        nomer=1;
        tx3.setText("Game № "+ nomer);
        tx5.setText(name_player1 + " - X");
        tx6.setText(name_player2 + " - O");
        unblock();
        Toast.makeText(this,"Player1 for TIC",Toast.LENGTH_SHORT).show();
        ocher_xod(nomer_hoda);
    }


    void fon_o(){

        if(nomer % 2 == 0) {
            if (arr[0][0] == 2 & arr[0][1] == 2 & arr[0][2] == 2) {
                btn1.setBackgroundResource(R.drawable.button_win_x);
                btn2.setBackgroundResource(R.drawable.button_win_x);
                btn3.setBackgroundResource(R.drawable.button_win_x);
            }
            if (arr[1][0] == 2 & arr[1][1] == 2 & arr[1][2] == 2) {
                btn4.setBackgroundResource(R.drawable.button_win_x);
                btn5.setBackgroundResource(R.drawable.button_win_x);
                btn6.setBackgroundResource(R.drawable.button_win_x);
            }
            if (arr[2][0] == 2 & arr[2][1] == 2 & arr[2][2] == 2) {
                btn7.setBackgroundResource(R.drawable.button_win_x);
                btn8.setBackgroundResource(R.drawable.button_win_x);
                btn9.setBackgroundResource(R.drawable.button_win_x);
            }
            if (arr[0][0] == 2 & arr[1][0] == 2 & arr[2][0] == 2) {
                btn1.setBackgroundResource(R.drawable.button_win_x);
                btn4.setBackgroundResource(R.drawable.button_win_x);
                btn7.setBackgroundResource(R.drawable.button_win_x);
            }
            if (arr[0][1] == 2 & arr[1][1] == 2 & arr[2][1] == 2) {
                btn2.setBackgroundResource(R.drawable.button_win_x);
                btn5.setBackgroundResource(R.drawable.button_win_x);
                btn8.setBackgroundResource(R.drawable.button_win_x);
            }
            if (arr[0][2] == 2 & arr[1][2] == 2 & arr[2][2] == 2) {
                btn3.setBackgroundResource(R.drawable.button_win_x);
                btn6.setBackgroundResource(R.drawable.button_win_x);
                btn9.setBackgroundResource(R.drawable.button_win_x);
            }
            if (arr[0][0] == 2 & arr[1][1] == 2 & arr[2][2] == 2) {
                btn1.setBackgroundResource(R.drawable.button_win_x);
                btn5.setBackgroundResource(R.drawable.button_win_x);
                btn9.setBackgroundResource(R.drawable.button_win_x);
            }
            if (arr[0][2] == 2 & arr[1][1] == 2 & arr[2][0] == 2) {
                btn3.setBackgroundResource(R.drawable.button_win_x);
                btn5.setBackgroundResource(R.drawable.button_win_x);
                btn7.setBackgroundResource(R.drawable.button_win_x);
            }
        }
        else{
            if (arr[0][0] == 2 & arr[0][1] == 2 & arr[0][2] == 2){
                btn1.setBackgroundResource(R.drawable.button_win_o);
                btn2.setBackgroundResource(R.drawable.button_win_o);
                btn3.setBackgroundResource(R.drawable.button_win_o);
            }
            if(arr[1][0] == 2 & arr[1][1] == 2 & arr[1][2] == 2){
                btn4.setBackgroundResource(R.drawable.button_win_o);
                btn5.setBackgroundResource(R.drawable.button_win_o);
                btn6.setBackgroundResource(R.drawable.button_win_o);
            }
            if(arr[2][0] == 2 & arr[2][1] == 2 & arr[2][2] == 2){
                btn7.setBackgroundResource(R.drawable.button_win_o);
                btn8.setBackgroundResource(R.drawable.button_win_o);
                btn9.setBackgroundResource(R.drawable.button_win_o);
            }
            if(arr[0][0] == 2 & arr[1][0] == 2 & arr[2][0] == 2){
                btn1.setBackgroundResource(R.drawable.button_win_o);
                btn4.setBackgroundResource(R.drawable.button_win_o);
                btn7.setBackgroundResource(R.drawable.button_win_o);
            }
            if(arr[0][1] == 2 & arr[1][1] == 2 & arr[2][1] == 2){
                btn2.setBackgroundResource(R.drawable.button_win_o);
                btn5.setBackgroundResource(R.drawable.button_win_o);
                btn8.setBackgroundResource(R.drawable.button_win_o);
            }
            if(arr[0][2] == 2 & arr[1][2] == 2 & arr[2][2] == 2){
                btn3.setBackgroundResource(R.drawable.button_win_o);
                btn6.setBackgroundResource(R.drawable.button_win_o);
                btn9.setBackgroundResource(R.drawable.button_win_o);
            }
            if(arr[0][0] == 2 & arr[1][1] == 2 & arr[2][2] == 2){
                btn1.setBackgroundResource(R.drawable.button_win_o);
                btn5.setBackgroundResource(R.drawable.button_win_o);
                btn9.setBackgroundResource(R.drawable.button_win_o);
            }
            if (arr[0][2] == 2 & arr[1][1] == 2 & arr[2][0] == 2){
                btn3.setBackgroundResource(R.drawable.button_win_o);
                btn5.setBackgroundResource(R.drawable.button_win_o);
                btn7.setBackgroundResource(R.drawable.button_win_o);
            }
        }}





    void fon_x(){

        if(nomer % 2 == 0){
            if (arr[0][0] == 1 & arr[0][1] == 1 & arr[0][2] == 1){
                btn1.setBackgroundResource(R.drawable.button_win_o);
                btn2.setBackgroundResource(R.drawable.button_win_o);
                btn3.setBackgroundResource(R.drawable.button_win_o);
            }
            if(arr[1][0] == 1 & arr[1][1] == 1 & arr[1][2] == 1){
                btn4.setBackgroundResource(R.drawable.button_win_o);
                btn5.setBackgroundResource(R.drawable.button_win_o);
                btn6.setBackgroundResource(R.drawable.button_win_o);
            }
            if(arr[2][0] == 1 & arr[2][1] == 1 & arr[2][2] == 1){
                btn7.setBackgroundResource(R.drawable.button_win_o);
                btn8.setBackgroundResource(R.drawable.button_win_o);
                btn9.setBackgroundResource(R.drawable.button_win_o);
            }
            if(arr[0][0] == 1 & arr[1][0] == 1 & arr[2][0] == 1){
                btn1.setBackgroundResource(R.drawable.button_win_o);
                btn4.setBackgroundResource(R.drawable.button_win_o);
                btn7.setBackgroundResource(R.drawable.button_win_o);
            }
            if(arr[0][1] == 1 & arr[1][1] == 1 & arr[2][1] == 1){
                btn2.setBackgroundResource(R.drawable.button_win_o);
                btn5.setBackgroundResource(R.drawable.button_win_o);
                btn8.setBackgroundResource(R.drawable.button_win_o);
            }
            if(arr[0][2] == 1 & arr[1][2] == 1 & arr[2][2] == 1){
                btn3.setBackgroundResource(R.drawable.button_win_o);
                btn6.setBackgroundResource(R.drawable.button_win_o);
                btn9.setBackgroundResource(R.drawable.button_win_o);
            }
            if(arr[0][0] == 1 & arr[1][1] == 1 & arr[2][2] == 1){
                btn1.setBackgroundResource(R.drawable.button_win_o);
                btn5.setBackgroundResource(R.drawable.button_win_o);
                btn9.setBackgroundResource(R.drawable.button_win_o);
            }
            if (arr[0][2] == 1 & arr[1][1] == 1 & arr[2][0] == 1){
                btn3.setBackgroundResource(R.drawable.button_win_o);
                btn5.setBackgroundResource(R.drawable.button_win_o);
                btn7.setBackgroundResource(R.drawable.button_win_o);
            }

        }else{
            if (arr[0][0] == 1 & arr[0][1] == 1 & arr[0][2] == 1){
                btn1.setBackgroundResource(R.drawable.button_win_x);
                btn2.setBackgroundResource(R.drawable.button_win_x);
                btn3.setBackgroundResource(R.drawable.button_win_x);
            }
            if(arr[1][0] == 1 & arr[1][1] == 1 & arr[1][2] == 1){
                btn4.setBackgroundResource(R.drawable.button_win_x);
                btn5.setBackgroundResource(R.drawable.button_win_x);
                btn6.setBackgroundResource(R.drawable.button_win_x);
            }
            if(arr[2][0] == 1 & arr[2][1] == 1 & arr[2][2] == 1){
                btn7.setBackgroundResource(R.drawable.button_win_x);
                btn8.setBackgroundResource(R.drawable.button_win_x);
                btn9.setBackgroundResource(R.drawable.button_win_x);
            }
            if(arr[0][0] == 1 & arr[1][0] == 1 & arr[2][0] == 1){
                btn1.setBackgroundResource(R.drawable.button_win_x);
                btn4.setBackgroundResource(R.drawable.button_win_x);
                btn7.setBackgroundResource(R.drawable.button_win_x);
            }
            if(arr[0][1] == 1 & arr[1][1] == 1 & arr[2][1] == 1){
                btn2.setBackgroundResource(R.drawable.button_win_x);
                btn5.setBackgroundResource(R.drawable.button_win_x);
                btn8.setBackgroundResource(R.drawable.button_win_x);
            }
            if(arr[0][2] == 1 & arr[1][2] == 1 & arr[2][2] == 1){
                btn3.setBackgroundResource(R.drawable.button_win_x);
                btn6.setBackgroundResource(R.drawable.button_win_x);
                btn9.setBackgroundResource(R.drawable.button_win_x);
            }
            if(arr[0][0] == 1 & arr[1][1] == 1 & arr[2][2] == 1){
                btn1.setBackgroundResource(R.drawable.button_win_x);
                btn5.setBackgroundResource(R.drawable.button_win_x);
                btn9.setBackgroundResource(R.drawable.button_win_x);
            }
            if (arr[0][2] == 1 & arr[1][1] == 1 & arr[2][0] == 1){
                btn3.setBackgroundResource(R.drawable.button_win_x);
                btn5.setBackgroundResource(R.drawable.button_win_x);
                btn7.setBackgroundResource(R.drawable.button_win_x);
            }
        }


    }

   /* @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.item_clear:
                clear();
                break;
            case R.id.item_obn:
                obnylit();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }*/


}
