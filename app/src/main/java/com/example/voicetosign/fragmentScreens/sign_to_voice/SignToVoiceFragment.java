package com.example.voicetosign.fragmentScreens.sign_to_voice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.voicetosign.R;

public class SignToVoiceFragment extends Fragment {

    private SignToVoiceViewModel signToVoiceViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_sign_to_voice, container, false);
        // code goes here


        return root;
    }
}