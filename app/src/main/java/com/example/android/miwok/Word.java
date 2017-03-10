package com.example.android.miwok;

/**
 * Created by User on 08.03.2017.
 */

public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;

    public Word(String miwokTranslation, String defaultTranslation) {
        setDefaultTranslation(defaultTranslation);
        setMiwokTranslation(miwokTranslation);
    }

    public void setMiwokTranslation(String word) {
        mMiwokTranslation = word;
    }

    public void setDefaultTranslation(String word) {
        mDefaultTranslation = word;
    }

    public String getMiwokiWord() {
        return mMiwokTranslation;
    }

    public String getDefaultLangWord() {
        return mDefaultTranslation;
    }

}
