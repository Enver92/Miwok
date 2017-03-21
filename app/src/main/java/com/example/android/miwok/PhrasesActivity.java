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
        engWords.add(new Word("minto wuksus", "Where are you going?", R.raw.phrase_where_are_you_going));
        engWords.add(new Word("tinnә oyaase'nә", "What is our name?", R.raw.phrase_what_is_your_name));
        engWords.add(new Word("oyaaset...", "My name is...", R.raw.phrase_my_name_is));
        engWords.add(new Word("michәksәs?", "How are you feeling?", R.raw.phrase_how_are_you_feeling));
        engWords.add(new Word("kuchi achit", "I'm feeling good.", R.raw.phrase_im_feeling_good));
        engWords.add(new Word("әәnәs'aa?", "Are you coming?", R.raw.phrase_are_you_coming));
        engWords.add(new Word("hәә’ әәnәm", "Yes, I'm coming.", R.raw.phrase_yes_im_coming));
        engWords.add(new Word("әәnәm", "I'm coming.", R.raw.phrase_im_coming));
        engWords.add(new Word("yoowutis", "Let's go.", R.raw.phrase_lets_go));
        engWords.add(new Word("әnni'nem", "Come here.", R.raw.phrase_come_here));


        WordAdapter adapter = new WordAdapter(this, engWords, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }

}
