package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // create an array list of words
        ArrayList<Word> engWords = new ArrayList<>();
        engWords.add(new Word("әpә", "father", R.drawable.family_father));
        engWords.add(new Word("әṭa", "mother", R.drawable.family_mother));
        engWords.add(new Word("angsi", "son", R.drawable.family_son));
        engWords.add(new Word("tune", "daughter", R.drawable.family_daughter));
        engWords.add(new Word("taachi", "older brother", R.drawable.family_older_brother));
        engWords.add(new Word("chalitti", "younger brother", R.drawable.family_younger_brother));
        engWords.add(new Word("teṭe", "older sister", R.drawable.family_older_sister));
        engWords.add(new Word("kolliti", "younger sister", R.drawable.family_younger_sister));
        engWords.add(new Word("ama", "grandmother", R.drawable.family_grandmother));
        engWords.add(new Word("paapa", "grandfather", R.drawable.family_grandfather));


        WordAdapter adapter = new WordAdapter(this, engWords);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

}