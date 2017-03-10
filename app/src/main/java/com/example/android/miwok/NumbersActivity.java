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
        engWords.add(new Word("lutti", "one", R.drawable.number_one));
        engWords.add(new Word("otiko", "two", R.drawable.number_two));
        engWords.add(new Word("tolookosu", "three", R.drawable.number_three));
        engWords.add(new Word("oyyisa", "four", R.drawable.number_four));
        engWords.add(new Word("massokka", "five", R.drawable.number_five));
        engWords.add(new Word("temmokka", "six", R.drawable.number_six));
        engWords.add(new Word("kenekaku", "seven", R.drawable.number_seven));
        engWords.add(new Word("kawinta", "eight", R.drawable.number_eight));
        engWords.add(new Word("wo'e", "nine", R.drawable.number_nine));
        engWords.add(new Word("na'aacha", "ten", R.drawable.number_ten));


        WordAdapter adapter = new WordAdapter(this, engWords);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

}
