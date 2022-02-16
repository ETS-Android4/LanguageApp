package com.example.languageapp;

import android.view.View;
import android.widget.ImageView;
public class Word {

    private String english;
    private String hindi;
    private int I,Audio;
    public Word(String S1, String S2, int R,int M)
    {
        english = S1;
        hindi = S2;
        I = R;
        Audio = M;
    }

    public String getHindi() {
        return hindi;
    }

    public String getEnglish() {
        return english;
    }

    public int getImage() {
        return I;
    }

    public int getAudio() {
        return Audio;
    }
}
