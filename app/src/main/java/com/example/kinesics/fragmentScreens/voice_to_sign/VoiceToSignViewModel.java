package com.example.kinesics.fragmentScreens.voice_to_sign;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class VoiceToSignViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public VoiceToSignViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}