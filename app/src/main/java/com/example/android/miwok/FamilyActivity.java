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
        engWords.add(new Word("әpә", "father"));
        engWords.add(new Word("әṭa", "mother"));
        engWords.add(new Word("angsi", "son"));
        engWords.add(new Word("tune", "daughter"));
        engWords.add(new Word("taachi", "older brother"));
        engWords.add(new Word("chalitti", "younger brother"));
        engWords.add(new Word("teṭe", "older sister"));
        engWords.add(new Word("kolliti", "younger sister"));
        engWords.add(new Word("ama", "grandmother"));
        engWords.add(new Word("paapa", "grandfather"));


        WordAdapter adapter = new WordAdapter(this, engWords);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

}