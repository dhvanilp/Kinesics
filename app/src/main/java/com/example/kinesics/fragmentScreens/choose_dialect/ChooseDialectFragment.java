package com.example.kinesics.fragmentScreens.choose_dialect;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.kinesics.R;

public class ChooseDialectFragment extends Fragment {

    private ChooseDialectViewModel chooseDialectViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_choose_dialect, container, false);
        //code goes here
        return root;
    }
}