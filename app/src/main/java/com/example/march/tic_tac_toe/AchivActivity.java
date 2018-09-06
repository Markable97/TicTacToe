package com.example.march.tic_tac_toe;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static android.R.drawable.ic_lock_lock;

/**
 * Created by march on 18.07.2017.
 */

public class AchivActivity extends AppCompatActivity {

    String[] array_achiv;


    public void onCreate( Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.achivments_activity);

        ListView listView = (ListView) findViewById(R.id.achiv_layout);

        array_achiv = getResources().getStringArray(R.array.array_achivments);


        MyAdapter adapter = new MyAdapter(this, array_achiv);
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_2,R.id.label, array_achiv);
        listView.setAdapter(adapter);
    }
}
;