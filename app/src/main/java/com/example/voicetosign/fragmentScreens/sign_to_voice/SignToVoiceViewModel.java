package com.example.voicetosign.fragmentScreens.sign_to_voice;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SignToVoiceViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SignToVoiceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}