package com.example.namstyling20.fragments;

import static android.app.Activity.RESULT_OK;

import android.app.SearchManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.namstyling20.MainActivity;
import com.example.namstyling20.databinding.FragmentRecommendationBinding;

public class RecommendationFragment extends Fragment {

    private FragmentRecommendationBinding binding;
    private static final String TAG = "RecommendationsFragment";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentRecommendationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK && result.getData() != null){
                    Intent data = result.getData();
                    binding.etGetRecommendation.setText(data.getStringArrayListExtra(
                            RecognizerIntent.EXTRA_RESULTS).get(0));
                     //the results we get are put into a list of most likely, with item at index 0
                    // being the most accurate
                }
                else{
                    Log.d(TAG, result.toString());
                }
            }
        });

        binding.ibGetRecommendation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick get-recommendation button");

//                openVoiceDialog();
                Intent speechIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
                speechIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
                speechIntent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Start Speaking");

                launcher.launch(speechIntent);

            }
        });

        // set listener to know when the enter key on the keyboard is clicked
        binding.etGetRecommendation.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER){
                    Log.i(TAG, "Enter key clicked. Processing query: " + binding.etGetRecommendation.getText().toString());
                    searchNet(binding.etGetRecommendation.getText().toString());
                    return true;
                }
                return false;
            }
        });

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    //search internet with default search app
    private void searchNet(String words) {
        try{
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, words);
            startActivity(intent);
        }catch(ActivityNotFoundException e){
            e.printStackTrace();
            Log.d(TAG, String.valueOf(e));
            searchNetCompat(words);
        }

    }

    //search intent with the browser if there's no default search app
    private void searchNetCompat(String words) {
        try {
            Uri uri = Uri.parse("https//www.google.com/#qz" + words);
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH, uri);
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            e.printStackTrace();
            Log.d(TAG, String.valueOf(e));
            searchNetCompat(words);
        }
    }
}