package com.example.languageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView Numbers = findViewById(R.id.textView);
        TextView Family = findViewById(R.id.textView2);
        TextView Color = findViewById(R.id.textView3);
        TextView Phrase = findViewById(R.id.textView4);

        Numbers.setOnClickListener
                (new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(MainActivity.this, Numbers.class);
                        startActivity(i);
                    }
                });
        Family.setOnClickListener
                (new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(MainActivity.this, Family_member.class);
                        startActivity(i);
                    }
                });
        Color.setOnClickListener
                (new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(MainActivity.this, Colours.class);
                        startActivity(i);
                    }
                });
        Phrase.setOnClickListener
                (new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent(MainActivity.this, Phrases.class);
                        startActivity(i);
                    }
                });

    }

}