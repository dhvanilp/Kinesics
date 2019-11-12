package com.example.voicetosign.fragmentScreens.choose_dialect;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ChooseDialectViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ChooseDialectViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}