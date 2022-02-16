package com.example.languageapp;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Colours extends AppCompatActivity {
    MediaPlayer m = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        final ArrayList<Word> Num = new ArrayList<Word>();
        Word w1 = new Word("red", "LAAL", R.drawable.color_red, R.raw.red);
        Num.add(w1);
        Word w2 = new Word("green", "HARAA", R.drawable.color_green, R.raw.green);
        Num.add(w2);
        Word w3 = new Word("yellow", "PILA", R.drawable.color_dusty_yellow, R.raw.yellow);
        Num.add(w3);
        Word w6 = new Word("brown", "KATTHA", R.drawable.color_brown, R.raw.brown);
        Num.add(w6);
        Word w7 = new Word("white", "SAFED", R.drawable.color_white, R.raw.white);
        Num.add(w7);
        Word w8 = new Word("black", "KALA", R.drawable.color_black, R.raw.black);
        Num.add(w8);

        WordAdapter itemsAdapter = new WordAdapter(this, Num, R.color.blue);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word str = Num.get(i);
                releaseMusic();
                m = MediaPlayer.create(Colours.this, str.getAudio());
                m.start();

                m.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMusic();
                    }
                });
            }
        });
    }
    private void releaseMusic() {
        if( m  != null )
            m.release();
    }
    protected void onPause() {
        super.onPause();
        releaseMusic();
    }
}