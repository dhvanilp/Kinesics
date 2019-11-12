package com.example.voicetosign.fragmentScreens.voice_to_sign;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.voicetosign.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

import static android.app.Activity.RESULT_OK;

public class VoiceToSignFragment extends Fragment {

    private final int REQ_CODE_SPEECH_INPUT = 100;
    private VoiceToSignViewModel voiceToSignViewModel;
    private TextView txtSpeechInput;
    private ImageButton btnSpeak;
    private ImageView signImageView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        voiceToSignViewModel =
                ViewModelProviders.of(this).get(VoiceToSignViewModel.class);
        View root = inflater.inflate(R.layout.fragment_voice_to_sign, container, false);
        txtSpeechInput = root.findViewById(R.id.txtSpeechInput);
        btnSpeak = root.findViewById(R.id.btnSpeak);
        signImageView = root.findViewById(R.id.sign_image);
        btnSpeak.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                promptSpeechInput();
            }
        });



        return root;
    }

    /**
     * Showing google speech input dialog
     */
    private void promptSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                getString(R.string.speech_prompt));
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {
            Toast.makeText(getActivity().getApplicationContext(),
                    getString(R.string.speech_not_supported),
                    Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Receiving speech input
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txtSpeechInput.setText(result.get(0));
                    displaySigns(result.get(0));
                }
                break;
            }

        }
    }

    protected void displaySigns(final String text) {
        final Handler handle = new Handler();
        handle.postDelayed(new Runnable() {
            int index = -1;

            @Override
            public void run() {
                Log.d("AAAAAAAAAAAAAAAA::", String.valueOf(index));
                ++index;
                if (index < text.length()) {
                    char c = text.charAt(index);
                    displayCharImage(c);
                    handle.postDelayed(this, 1000);
                }
            }
        }, 1000);

    }

    protected void displayCharImage(char c) {
        InputStream is = null;
        try {
            if (c == ' ')
                is = getResources().getAssets().open("space.png");
            else
                is = getResources().getAssets().open(c + ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Bitmap bmp = BitmapFactory.decodeStream(is);
        signImageView.setImageBitmap(bmp);
    }


}