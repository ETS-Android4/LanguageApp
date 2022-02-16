package com.example.languageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Family_member extends AppCompatActivity {
    MediaPlayer m = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        final ArrayList<Word> Num = new ArrayList<Word>();
        Word w1 = new Word("father", "PAPA",R.drawable.family_father,R.raw.tune_pocket);
        Num.add(w1);
        Word w2 = new Word("mother", "MUMMY",R.drawable.family_mother,R.raw.pocket_2);
        Num.add(w2);
        Word w3 = new Word("older brother", "BHAIYA",R.drawable.family_older_brother,R.raw.tune_pocket);
        Num.add(w3);
        Word w4 = new Word("older sister", "DIDI",R.drawable.family_older_sister,R.raw.pocket_2);
        Num.add(w4);
        Word w5 = new Word("younger sister", "CHOTI",R.drawable.family_younger_sister,R.raw.tune_pocket);
        Num.add(w5);
        Word w6 = new Word("younger brother", "CHOTU",R.drawable.family_younger_brother,R.raw.tune_pocket);
        Num.add(w6);
        Word w7 = new Word("son", "BETA",R.drawable.family_son,R.raw.pocket_2);
        Num.add(w7);
        Word w8 = new Word("grandmother", "DADI",R.drawable.family_grandmother,R.raw.tune_pocket);
        Num.add(w8);
        Word w9 = new Word("grandfather", "DADA",R.drawable.family_grandfather,R.raw.pocket_2);
        Num.add(w9);
        Word w10 = new Word("daughter", "BETI",R.drawable.family_daughter,R.raw.tune_pocket);
        Num.add(w10);

        WordAdapter itemsAdapter = new WordAdapter(this, Num,R.color.green);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(itemsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                Word str = Num.get(i);
                releaseMusic();
                m  = MediaPlayer.create(Family_member.this,str.getAudio());
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
    //protected void onPause() {
      //  super.onPause();
        //releaseMusic();
    //}

}