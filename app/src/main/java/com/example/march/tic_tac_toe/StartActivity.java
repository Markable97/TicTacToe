package com.example.march.tic_tac_toe;

import android.content.Context;
import android.content.Intent;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.march.tic_tac_toe.PlayWithAndroid.count_you;
import static com.example.march.tic_tac_toe.PlayWithAndroid.nomer_game;

public class StartActivity extends AppCompatActivity implements View.OnClickListener{

    Button bt_start, bt_start_android, bt_avhivka ;
    RadioButton rb_easy, rb_medium, rb_hard;
    ImageView im1,im2,im3,im4;
    TextView achivment;

    SharedPreferences sPref; //для сохранения достижений


    final String SAVED_ONE = "saved achivments 1";
    final String SAVED_TWO = "saved achivments 2";
    final String SAVED_THREE = "saved achivments 3";


    private static final String TAG = "MyApp";



    public int level = 0; //уровень игры
    public static int save_3 = 0,save_1 = 0,save_2 = 0; //переменные для сохранения достижений

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);



        achivment = (TextView) findViewById(R.id.tv_achivments);
        achivment.setOnClickListener(this);

        bt_start = (Button) findViewById(R.id.button_star);
        bt_start.setOnClickListener(this);

        bt_start_android = (Button) findViewById(R.id.button_android);
        bt_start_android.setOnClickListener(this);

        bt_avhivka = (Button) findViewById(R.id.button_achiv);
        bt_avhivka.setOnClickListener(this);

        rb_easy = (RadioButton) findViewById(R.id.rb_easy);
        rb_easy.setOnClickListener(radioButtonClickListener);
        rb_medium = (RadioButton) findViewById(R.id.rb_mediun);
        rb_medium.setOnClickListener(radioButtonClickListener);
        rb_hard = (RadioButton) findViewById(R.id.rb_hard);
        rb_hard.setOnClickListener(radioButtonClickListener);

        im1 = (ImageView) findViewById(R.id.im_pos1);
        im1.setOnClickListener(this);
        im2 = (ImageView) findViewById(R.id.im_pos2);
        im2.setOnClickListener(this);
        im3 = (ImageView) findViewById(R.id.im_pos3);
        im4 = (ImageView) findViewById(R.id.im_pos4);


        Log.i(TAG,"OnCreate:"+"save_1= "+ save_1 +"; save_2 =" + save_2 + "; save_3 =" + save_3);
        load_achivments();
    }



    View.OnClickListener radioButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton)v;
            switch (rb.getId()){
                case R.id.rb_easy:
                    level = 1;
                    rb_hard.setChecked(false);
                    rb_medium.setChecked(false);
                    break;
                case R.id.rb_mediun:
                    level = 2;
                    rb_hard.setChecked(false);
                    rb_easy.setChecked(false);
                    break;
                case R.id.rb_hard:
                    level = 3;
                    rb_medium.setChecked(false);
                    rb_easy.setChecked(false);
                    break;

            }
        }
    };




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_star:
                Intent intent = new Intent(StartActivity.this, ManVsMan.class);
                startActivity(intent);
                break;
            case R.id.button_android:
                if (level != 0){
                    rb_easy.setChecked(false);
                    rb_medium.setChecked(false);
                    rb_hard.setChecked(false);
                    Intent intent1 = new Intent(StartActivity.this, PlayWithAndroid.class);
                    intent1.putExtra("level_game",level);
                    startActivity(intent1);
                }else Toast.makeText(this,"Choose a level of play",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_achiv:
                //load_achivments();
                Intent intent2 = new Intent(StartActivity.this, AchivActivity.class);
                startActivity(intent2);
                break;
            case R.id.im_pos1:
                Toast.makeText(this,"Play 5 game",Toast.LENGTH_SHORT).show();
                break;
            case R.id.im_pos2:
                Toast.makeText(this,"Win 5 game",Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_achivments:
                Toast.makeText(this,"Click on the star and see the task", Toast.LENGTH_SHORT).show();
                break;
        }
    }



    @Override
    protected void onResume(){
        super.onResume();
        //load_achivments();
        Log.i(TAG,"OnResume"+"save_1= "+ save_1 +"; save_2 =" + save_2 + "; save_3 =" + save_3);


    }

    @Override
    protected void onStop(){
        super.onStop();
        save_achivments();
        Log.i(TAG,"OnStop:"+"save_1= "+ save_1 +"; save_2 =" + save_2 + "; save_3 =" + save_3);


    } @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG,"OnDestroy:"+"save_1= "+ save_1 +"; save_2 =" + save_2 + "; save_3 =" + save_3);


    }
    void star_select(){
        if(nomer_game >= 5){
            im1.setVisibility(View.INVISIBLE);
            im3.setVisibility(View.VISIBLE);
            save_1 = 1;
        }
        if(count_you >= 5){
            im2.setVisibility(View.INVISIBLE);
            im4.setVisibility(View.VISIBLE);
            save_2 = 1;
        }
    }

   public  void save_achivments(){
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sPref.edit();
        editor.putInt(SAVED_ONE, save_1);
        editor.putInt(SAVED_TWO, save_2);
        editor.putInt(SAVED_THREE, save_3);
        editor.commit();
        //Toast.makeText(this, "Save Achievements", Toast.LENGTH_SHORT).show();
    }

    public void load_achivments(){
        sPref = getPreferences(MODE_PRIVATE);
        save_1 = sPref.getInt(SAVED_ONE,0);
        save_2 = sPref.getInt(SAVED_TWO,0);
        save_3 = sPref.getInt(SAVED_THREE, 0);
        //Toast.makeText(this, "Load Achievements", Toast.LENGTH_SHORT).show();
        if(save_1 == 1){
            im1.setVisibility(View.INVISIBLE);
            im3.setVisibility(View.VISIBLE);
        }
        if(save_2 == 1){
            im2.setVisibility(View.INVISIBLE);
            im4.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id){
            case R.id.item_obn:
                im1.setVisibility(View.VISIBLE);
                im3.setVisibility(View.INVISIBLE);
                save_1 = 0;

                im2.setVisibility(View.VISIBLE);
                im4.setVisibility(View.INVISIBLE);
                save_2 = 0;
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
}
