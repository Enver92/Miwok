package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 09.03.2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {
    private int colorResourceID;

    public WordAdapter(Activity context, ArrayList<Word> Words, int colorResourceID) {
        super(context, 0, Words);
        this.colorResourceID = colorResourceID;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if( listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        miwokTextView.setText(currentWord.getMiwokiWord());

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.eng_text_view);
        defaultTextView.setText(currentWord.getDefaultLangWord());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image_view);

        if (currentWord.hasImage()) {
            imageView.setImageResource(currentWord.getImageSource());
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }

        View textContainer = listItemView.findViewById(R.id.text_container);
        textContainer.setBackgroundResource(colorResourceID);

        int color = ContextCompat.getColor(getContext(), colorResourceID);

        textContainer.setBackgroundColor(color);

        return listItemView;

    }

}
