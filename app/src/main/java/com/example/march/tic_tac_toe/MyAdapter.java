package com.example.march.tic_tac_toe;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import static com.example.march.tic_tac_toe.StartActivity.save_1;
import static com.example.march.tic_tac_toe.StartActivity.save_2;
import static com.example.march.tic_tac_toe.StartActivity.save_3;


/**
 * Created by march on 18.07.2017.
 */

public class MyAdapter extends ArrayAdapter<String> {

    private final Context context;
    private final String[] values;
    private static final String TAG = "MyApp";




    public MyAdapter (Context context, String[] values){
        super(context, R.layout.rowlayout, values);
        this.context = context;
        this.values = values;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        textView.setText(values[position]);
        String s = values[position];

        Log.i(TAG,"Adapter:"+"save_1= "+ save_1 +"; save_2 =" + save_2 + "; save_3 =" + save_3);
        if(save_1 == 1){
            if(s.startsWith("Play 5 games")){
                imageView.setImageResource(R.drawable.ic_check_black_24dp);
            }
        }
        if(save_2 == 1){
            if(s.startsWith("Win 5 games")){
                imageView.setImageResource(R.drawable.ic_check_black_24dp);
            }
        }
        if(save_3 == 1){
            if(s.startsWith("Play to easy level 5 games")){
                imageView.setImageResource(R.drawable.ic_check_black_24dp);
            }
        }

        return rowView;
    }


}
