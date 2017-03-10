package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // create an array list of words
        ArrayList<Word> engWords = new ArrayList<>();
        engWords.add(new Word("weṭeṭṭi", "red"));
        engWords.add(new Word("chokokki", "green"));
        engWords.add(new Word("ṭakaakki", "brown"));
        engWords.add(new Word("ṭopoppi", "gray"));
        engWords.add(new Word("kululli", "black"));
        engWords.add(new Word("kelelli", "white"));
        engWords.add(new Word("ṭopiisә", "dusty yellow"));
        engWords.add(new Word("chiwiiṭә", "mustard yellow"));


        WordAdapter adapter = new WordAdapter(this, engWords);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

}
