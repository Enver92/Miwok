package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // create an array list of words
        ArrayList<Word> engWords = new ArrayList<>();
        engWords.add(new Word("lutti", "one"));
        engWords.add(new Word("otiko", "two"));
        engWords.add(new Word("tolookosu", "three"));
        engWords.add(new Word("oyyisa", "four"));
        engWords.add(new Word("massokka", "five"));
        engWords.add(new Word("temmokka", "six"));
        engWords.add(new Word("kenekaku", "seven"));
        engWords.add(new Word("kawinta", "eight"));
        engWords.add(new Word("wo'e", "nine"));
        engWords.add(new Word("na'aacha", "ten"));


        WordAdapter adapter = new WordAdapter(this, engWords);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

}
