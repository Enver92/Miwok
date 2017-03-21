package com.example.android.miwok;

/**
 * Created by User on 08.03.2017.
 */

public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageSource = NO_IMAGE_PROVIDED;
    private int mAudioSource;
    private static final int NO_IMAGE_PROVIDED = -1;


    public Word(String miwokTranslation, String defaultTranslation, int imageSource, int audioSource) {
        setDefaultTranslation(defaultTranslation);
        setMiwokTranslation(miwokTranslation);
        setImageSource(imageSource);
        setAudioSource(audioSource);
    }

    public Word(String miwokTranslation, String defaultTranslation, int audioSource) {
        setDefaultTranslation(defaultTranslation);
        setMiwokTranslation(miwokTranslation);
        setAudioSource(audioSource);
    }

    public void setMiwokTranslation(String word) {
        mMiwokTranslation = word;
    }

    public void setDefaultTranslation(String word) {
        mDefaultTranslation = word;
    }

    public void setImageSource(int source) {
        mImageSource = source;
    }

    public int getImageSource() {
        return mImageSource;
    }

    public String getMiwokiWord() {
        return mMiwokTranslation;
    }

    public String getDefaultLangWord() {
        return mDefaultTranslation;
    }

    public boolean hasImage() {
        return mImageSource != NO_IMAGE_PROVIDED;
    }

    public void setAudioSource(int audioSource) {
        mAudioSource = audioSource;
    }

    public int getAudioSource() {
        return mAudioSource;
    }
}
