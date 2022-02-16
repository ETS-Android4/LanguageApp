package com.example.languageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
public class Numbers extends AppCompatActivity {
    MediaPlayer m = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        final ArrayList<Word> Num = new ArrayList<Word>();
        Word w1 = new Word("one", "Ek", R.drawable.number_one, R.raw.one);
        Num.add(w1);
        Word w2 = new Word("two", "Do", R.drawable.number_two, R.raw.two);
        Num.add(w2);
        Word w3 = new Word("three", "Teen", R.drawable.number_three, R.raw.three);
        Num.add(w3);
        Word w4 = new Word("four", "Char", R.drawable.number_four,  R.raw.four);
        Num.add(w4);
        Word w5 = new Word("five", "Paanch", R.drawable.number_five, R.raw.five);
        Num.add(w5);
        Word w6 = new Word("six", "Chey", R.drawable.number_six, R.raw.six);
        Num.add(w6);
        Word w7 = new Word("seven", "Saat", R.drawable.number_seven, R.raw.seven);
        Num.add(w7);
        Word w8 = new Word("eight", "Aaath", R.drawable.number_eight, R.raw.eight);
        Num.add(w8);
        Word w9 = new Word("nine", "Nou", R.drawable.number_nine, R.raw.nine);
        Num.add(w9);
        Word w10 = new Word("ten", "Dass", R.drawable.number_ten, R.raw.ten);
        Num.add(w10);

        WordAdapter itemsAdapter = new WordAdapter(this, Num, R.color.red);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word str = Num.get(i);
                releaseMusic();
                m  = MediaPlayer.create(Numbers.this,str.getAudio());
                m.start();
                m.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
                {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMusic();
                    }
                });
            }
        });
    }
    private void releaseMusic() {
        if( m != null )
            m.release();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}