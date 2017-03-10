package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // create an array list of words
        ArrayList<Word> engWords = new ArrayList<>();
        engWords.add(new Word("minto wuksus", "Where are you going?"));
        engWords.add(new Word("tinnә oyaase'nә", "What is our name?"));
        engWords.add(new Word("oyaaset...", "My name is..."));
        engWords.add(new Word("michәksәs?", "How are you feeling?"));
        engWords.add(new Word("kuchi achit", "I'm feeling good."));
        engWords.add(new Word("әәnәs'aa?", "Are you coming?"));
        engWords.add(new Word("hәә’ әәnәm", "Yes, I'm coming."));
        engWords.add(new Word("әәnәm", "I'm coming."));
        engWords.add(new Word("yoowutis", "Let's go."));
        engWords.add(new Word("әnni'nem", "Come here."));


        WordAdapter adapter = new WordAdapter(this, engWords);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

}
