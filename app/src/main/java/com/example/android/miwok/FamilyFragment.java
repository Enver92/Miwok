package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT;
import static android.media.AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK;

/**
 * A simple {@link Fragment} subclass.
 */
public class FamilyFragment extends Fragment {

    /** Handles playback of all the sound files */
    private MediaPlayer mp;

    /** Handles audio focus when playing a sound file */
    private AudioManager mAudioManager;

    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener afChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                mp.pause();
                mp.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                mp.start();
                // Resume playback
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                releaseMediaPlayer();
            }
        }
    };


    /**
     *  This listener is triggered when the {@link MediaPlayer} has completed playing audio
     */
    private MediaPlayer.OnCompletionListener mOnCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);


        // create an array list of words
        final ArrayList<Word> engWords = new ArrayList<>();
        engWords.add(new Word("әpә", "father", R.drawable.family_father, R.raw.family_father));
        engWords.add(new Word("әṭa", "mother", R.drawable.family_mother, R.raw.family_mother));
        engWords.add(new Word("angsi", "son", R.drawable.family_son, R.raw.family_son));
        engWords.add(new Word("tune", "daughter", R.drawable.family_daughter, R.raw.family_daughter));
        engWords.add(new Word("taachi", "older brother", R.drawable.family_older_brother, R.raw.family_older_brother));
        engWords.add(new Word("chalitti", "younger brother", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        engWords.add(new Word("teṭe", "older sister", R.drawable.family_older_sister, R.raw.family_older_sister));
        engWords.add(new Word("kolliti", "younger sister", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        engWords.add(new Word("ama", "grandmother", R.drawable.family_grandmother, R.raw.family_grandmother));
        engWords.add(new Word("paapa", "grandfather", R.drawable.family_grandfather, R.raw.family_grandfather));

        // Create a {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(getActivity(), engWords, R.color.category_family);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();

                Word word = engWords.get(position);
                // Request audio focus so in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.
                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now.

                    // Create and setup the {@link MediaPlayer} for the audio resource associated
                    // with the current word
                    mp = MediaPlayer.create(getActivity(), word.getAudioSource());

                    // Start the audio file
                    mp.start();

                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    mp.setOnCompletionListener(mOnCompletionListener);
                }
            }
        });
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();

    }

    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mp != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mp.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mp = null;

            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }

}