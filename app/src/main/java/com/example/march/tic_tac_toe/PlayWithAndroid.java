package com.example.march.tic_tac_toe;


import android.graphics.Typeface;
import android.os.Bundle;



import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.march.tic_tac_toe.StartActivity.save_1;
import static com.example.march.tic_tac_toe.StartActivity.save_3;
import static com.example.march.tic_tac_toe.StartActivity.save_2;


/**
 * Created by march on 27.01.2017.
 */

public class PlayWithAndroid  extends AppCompatActivity implements View.OnClickListener {

    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_YES);
    }

    public static   Button bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9;
    static Button bt_clear;
    static TextView you_count_tv;
    static TextView draw_count_tv;
    static TextView android_count_tv;

    TextView game_tablo_view;

    //final Random random = new Random();

    public static int[][] array = {
            {0,0,0},
            {0,0,0},        //массив для проверки(номера кнопок схожи с индексом массива)
            {0,0,0},
    };
    public static int a=0;//переменная для определения выиграша а=1 для ноликов а=2 для крестиков
    public static   int f_x_win = 0;//проверка на победу крестиков
    public static   int proverka_win=0;//проверка на победу


    public static int count_you=0;//кол-во побед игрока
    public static int count_draw =0;//кол-во ничей
    public static int count_android=0;//кол-во побед андроида
    public static int  nomer_game = 1;//номер игры
    public static int nomer_hoda = 1; //номер хода
    public static int f = 0;//проверка на атаку

    public static int achiv_5games = 0;
    public static int achiv_5wins = 0;
    public static int achiv_5easywin = 0;
    public static int achiv_playfriend = 0;

    int level; //уровен игры 1-легкий, 2-средний, 3-сложный

    private static final String TAG = "MyApp";

    LevelEasy lvl_easy = new LevelEasy();
    LevelMedium lvl_medium = new LevelMedium();
    LevelHard lvl_hard = new LevelHard();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_player);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/3dhands.ttf");



        game_tablo_view = (TextView) findViewById(R.id.game_tablo);

        you_count_tv = (TextView) findViewById(R.id.you_count);
        //draw_count_tv = (TextView) findViewById(R.id.draw_count);
        android_count_tv = (TextView) findViewById(R.id.android_count);

        count_you=0;
        count_draw=0;
        count_android=0;
        nomer_game=1;
        nomer_hoda=1;

        you_count_tv.setText(Integer.toString(count_you));
        //draw_count_tv.setText(Integer.toString(count_draw));
        android_count_tv.setText(Integer.toString(count_android));

        level = getIntent().getIntExtra("level_game",0);

        if(level == 1) Toast.makeText(this,"level = easy. You turn",Toast.LENGTH_SHORT).show();
        else if (level == 2) Toast.makeText(this,"level = medium. You turn",Toast.LENGTH_SHORT).show();
             else Toast.makeText(this,"level = hard. You turn",Toast.LENGTH_SHORT).show();

        bt_clear = (Button) findViewById(R.id.btn_clear);
        bt_clear.setTypeface(typeface);
        bt_clear.setOnClickListener(this);

        for( int j = 0; j<3; j++)
            for(int l = 0; l<3; l++)
                Log.i(TAG,"Проверка в начале array["+j+"]["+l+"]= "+ array[j][l] );
        bt1 = (Button) findViewById(R.id.button1);
        bt1.setTypeface(typeface);
        bt2 = (Button) findViewById(R.id.button2);
        bt2.setTypeface(typeface);
        bt3 = (Button) findViewById(R.id.button3);
        bt3.setTypeface(typeface);
        bt4 = (Button) findViewById(R.id.button4);
        bt4.setTypeface(typeface);
        bt5 = (Button) findViewById(R.id.button5);
        bt5.setTypeface(typeface);
        bt6 = (Button) findViewById(R.id.button6);
        bt6.setTypeface(typeface);
        bt7 = (Button) findViewById(R.id.button7);
        bt7.setTypeface(typeface);
        bt8 = (Button) findViewById(R.id.button8);
        bt8.setTypeface(typeface);
        bt9 = (Button) findViewById(R.id.button9);
        bt9.setTypeface(typeface);

        bt1.setTextColor(getResources().getColor(R.color.figurki_X));
        bt2.setTextColor(getResources().getColor(R.color.figurki_X));
        bt3.setTextColor(getResources().getColor(R.color.figurki_X));
        bt4.setTextColor(getResources().getColor(R.color.figurki_X));
        bt5.setTextColor(getResources().getColor(R.color.figurki_X));
        bt6.setTextColor(getResources().getColor(R.color.figurki_X));
        bt7.setTextColor(getResources().getColor(R.color.figurki_X));
        bt8.setTextColor(getResources().getColor(R.color.figurki_X));
        bt9.setTextColor(getResources().getColor(R.color.figurki_X));

        bt1.setOnClickListener(this);
        bt2.setOnClickListener(this);
        bt3.setOnClickListener(this);
        bt4.setOnClickListener(this);
        bt5.setOnClickListener(this);
        bt6.setOnClickListener(this);
        bt7.setOnClickListener(this);
        bt8.setOnClickListener(this);
        bt9.setOnClickListener(this);

   /*    rb_easy = (RadioButton) findViewById(R.id.rb_easy);rb_easy.setOnClickListener(this);
       rb_medium = (RadioButton) findViewById(R.id.rb_mediun);rb_medium.setOnClickListener(this);
       rb_medium = (RadioButton) findViewById(R.id.rb_mediun);rb_hard.setOnClickListener(this);
*/
        gameplay();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();


        unblock();
        count_you=0;
        count_draw=0;
        count_android=0;
        f=0;
        f_x_win=0;
        nomer_hoda=1;
        a=0;
        color(0);
        proverka_win=0;

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button1:
                bt1.setText("X");
                bt1.setEnabled(false);
                array[0][0] = 1;
                switch (level){
                    case 1:
                        lvl_easy.gameplay();
                        break;
                    case 2:
                        lvl_medium.gameplay();
                        break;
                    case 3:
                        lvl_hard.gameplay();
                        break;
                }
                break;
            case R.id.button2:

                    bt2.setText("X");
                    array[0][1] = 1;
                    bt2.setEnabled(false);

                switch (level){
                    case 1:
                        lvl_easy.gameplay();
                        break;
                    case 2:
                        lvl_medium.gameplay();
                        break;
                    case 3:
                        lvl_hard.gameplay();
                        break;
                }
                break;
            case R.id.button3:

                    bt3.setText("X");
                    array[0][2] = 1;
                    bt3.setEnabled(false);

                switch (level) {
                    case 1:
                        lvl_easy.gameplay();
                        break;
                    case 2:
                        lvl_medium.gameplay();
                        break;
                    case 3:
                        lvl_hard.gameplay();
                        break;
                }

                break;
            case R.id.button4:

                    bt4.setText("X");
                    bt4.setEnabled(false);
                    array[1][0] = 1;
                switch (level) {
                    case 1:
                        lvl_easy.gameplay();
                        break;
                    case 2:
                        lvl_medium.gameplay();
                        break;
                    case 3:
                        lvl_hard.gameplay();
                        break;
                }
                break;
            case R.id.button5:

                    bt5.setText("X");
                    bt5.setEnabled(false);
                    array[1][1] = 1;
                switch (level) {
                    case 1:
                        lvl_easy.gameplay();
                        break;
                    case 2:
                        lvl_medium.gameplay();
                        break;
                    case 3:
                        lvl_hard.gameplay();
                        break;
                }
                break;
            case R.id.button6:

                    bt6.setText("X");
                    bt6.setEnabled(false);
                    array[1][2] = 1;
                switch (level) {
                    case 1:
                        lvl_easy.gameplay();
                        break;
                    case 2:
                        lvl_medium.gameplay();
                        break;
                    case 3:
                        lvl_hard.gameplay();
                        break;
                }
                break;
            case R.id.button7:

                    bt7.setText("X");
                    bt7.setEnabled(false);
                    array[2][0] = 1;
                switch (level) {
                    case 1:
                        lvl_easy.gameplay();
                        break;
                    case 2:
                        lvl_medium.gameplay();
                        break;
                    case 3:
                        lvl_hard.gameplay();
                        break;
                }
                break;
            case R.id.button8:

                    bt8.setText("X");
                    bt8.setEnabled(false);
                    array[2][1] = 1;
                switch (level) {
                    case 1:
                        lvl_easy.gameplay();
                        break;
                    case 2:
                        lvl_medium.gameplay();
                        break;
                    case 3:
                        lvl_hard.gameplay();
                        break;
                }
                break;
            case R.id.button9:
                    bt9.setText("X");
                    bt9.setEnabled(false);
                    array[2][2] = 1;
                switch (level) {
                    case 1:
                        lvl_easy.gameplay();
                        break;
                    case 2:
                        lvl_medium.gameplay();
                        break;
                    case 3:
                        lvl_hard.gameplay();
                        break;

                }
                break;
            case R.id.btn_clear:
                clear();
                bt_clear.setVisibility(View.INVISIBLE);
                unlock_achivments();
                break;
            default: break;

        }
    }


     void unblock()
    {

        for(int i = 0; i<3; i++)
            for(int j = 0; j<3; j++)
                array[i][j]=0;

        Log.i(TAG,"произведена очистка /n");

        bt1.setText("");bt1.setEnabled(true);
        bt2.setText("");bt2.setEnabled(true);
        bt3.setText("");bt3.setEnabled(true);
        bt4.setText("");bt4.setEnabled(true);
        bt5.setText("");bt5.setEnabled(true);
        bt6.setText("");bt6.setEnabled(true);
        bt7.setText("");bt7.setEnabled(true);
        bt8.setText("");bt8.setEnabled(true);
        bt9.setText("");bt9.setEnabled(true);
    }


   public void color(int i){
        switch (i){
            case 0:bt1.setTextColor(getResources().getColor(R.color.figurki_X));
                bt2.setTextColor(getResources().getColor(R.color.figurki_X));
                bt3.setTextColor(getResources().getColor(R.color.figurki_X));
                bt4.setTextColor(getResources().getColor(R.color.figurki_X));
                bt5.setTextColor(getResources().getColor(R.color.figurki_X));
                bt6.setTextColor(getResources().getColor(R.color.figurki_X));
                bt7.setTextColor(getResources().getColor(R.color.figurki_X));
                bt8.setTextColor(getResources().getColor(R.color.figurki_X));
                bt9.setTextColor(getResources().getColor(R.color.figurki_X));
                bt1.setBackgroundResource(R.drawable.button_start);
                bt2.setBackgroundResource(R.drawable.button_start);
                bt3.setBackgroundResource(R.drawable.button_start);
                bt4.setBackgroundResource(R.drawable.button_start);
                bt5.setBackgroundResource(R.drawable.button_start);
                bt6.setBackgroundResource(R.drawable.button_start);
                bt7.setBackgroundResource(R.drawable.button_start);
                bt8.setBackgroundResource(R.drawable.button_start);
                bt9.setBackgroundResource(R.drawable.button_start);
                break;

        }
    }

     void clear()
    {

            unblock();
            f=0;
            f_x_win=0;
            nomer_hoda=1;
            nomer_game++;
            a=0;
            color(0);
            gameplay();
            proverka_win=0;

            }
    void gameplay(){
        switch (level){
            case 1:
                if(nomer_game % 2 == 0){
                    Toast.makeText(this,"You turn. EASY",Toast.LENGTH_LONG).show();
                    lvl_easy.easy_defend();
                }else{
                    lvl_easy.easy_attack();
                }
                break;
            case 2:
                if(nomer_game % 2 == 0){
                    Toast.makeText(this,"You turn. MEDIUM",Toast.LENGTH_LONG).show();
                    lvl_medium.medium_defend();
                }else{
                    lvl_medium.medium_attack();
                }
                break;
            case 3:
                if(nomer_game % 2 == 0){
                    Toast.makeText(this,"You turn. HARD",Toast.LENGTH_LONG).show();
                    lvl_hard.defend();
                }else{
                    lvl_hard.attack();
                }
                break;
        }

    }


    public static void vivod_winner(int a){

        if(a==1){
            //Toast.makeText(context,"YOU LOSE",Toast.LENGTH_SHORT).show();
            count_android++;
            String str = Integer.toString(count_android);
            android_count_tv.setText(str);
            //color(11);
            bt_clear.setVisibility(View.VISIBLE);
        }else{
            if(a==2) {
                //Toast.makeText(this,"YOU WIN",Toast.LENGTH_SHORT).show();
                count_you++;
                String str  = Integer.toString(count_you);
                you_count_tv.setText(str);
                //color(10);
                bt_clear.setVisibility(View.VISIBLE);
            }
        }
        if (nomer_hoda>9){
            if(a==0){
                count_draw++;
                //String str = Integer.toString(count_draw);
               // draw_count_tv.setText(str);
                //Toast.makeText(this,"DRAW",Toast.LENGTH_SHORT).show();
                //color(12);
                bt_clear.setVisibility(View.VISIBLE);}
        }

    }

    void unlock_achivments(){

        if(level == 1){
            if(nomer_game == 6){
                if(save_3 == 0){
                    save_3=1;
                    Toast toast;
                    toast = Toast.makeText(this, "Achievements unlock: Play to easy level 5 games", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.BOTTOM, 0, 0);
                    LinearLayout toastContainer = (LinearLayout) toast.getView();
                    ImageView imageAchiv = new ImageView(this);
                    imageAchiv.setImageResource(R.drawable.ic_check_circle_black_24dp);
                    toastContainer.addView(imageAchiv, 0);
                    toast.show();
                }

            }
        }
        if(nomer_game == 6){
            Toast toast;
            save_1 = 1;
            toast = Toast.makeText(this, "Achievements unlock: Play 5 games", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0, 0);
            LinearLayout toastContainer = (LinearLayout) toast.getView();
            ImageView imageAchiv = new ImageView(this);
            imageAchiv.setImageResource(R.drawable.ic_check_circle_black_24dp);
            toastContainer.addView(imageAchiv, 0);
           ;
            toast.show();
        }
        if (count_you==5){
            Toast toast;
            save_2 = 1;
            toast = Toast.makeText(this, "Achievements unlock: Win 5 games", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.BOTTOM, 0, 0);
            LinearLayout toastContainer = (LinearLayout) toast.getView();
            ImageView imageAchiv = new ImageView(this);
            imageAchiv.setImageResource(R.drawable.ic_check_circle_black_24dp);
            toastContainer.addView(imageAchiv, 0);
            toast.show();
        }


    }


    /*   @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.item_clear:
                 clear();
                //gameplay();
                break;
            case R.id.item_obn:
                //obnylit();
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


