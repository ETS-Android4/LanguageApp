package com.example.languageapp;

import android.app.Activity;
import android.media.Image;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    private int Color_Resource;

    public WordAdapter(Activity context, ArrayList<Word> N,int R) {

        super(context,0,N);
        Color_Resource = R;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        Word str = getItem(position);

        TextView T = convertView.findViewById(R.id.list_items);
        T.setText(str.getHindi());


        TextView T1 = convertView.findViewById(R.id.list_itemsA);
        T1.setText(str.getEnglish());

        ImageView I = convertView.findViewById(R.id.list_itemsB);
        I.setImageResource(str.getImage());

        LinearLayout L = convertView.findViewById(R.id.list_items_color);
        int color = ContextCompat.getColor(getContext(),Color_Resource);
        L.setBackgroundColor(color);

        return convertView;
    }

}
