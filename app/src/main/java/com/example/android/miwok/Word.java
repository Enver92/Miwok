package com.example.android.miwok;

/**
 * Created by User on 08.03.2017.
 */

public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImageSource;

    public Word(String miwokTranslation, String defaultTranslation) {
        setDefaultTranslation(defaultTranslation);
        setMiwokTranslation(miwokTranslation);
    }

    public Word(String miwokTranslation, String defaultTranslation, int imageSource) {
        setDefaultTranslation(defaultTranslation);
        setMiwokTranslation(miwokTranslation);
        setImageSource(imageSource);
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

}
