package com.example.namstyling20.ui.recommendation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecommendationViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RecommendationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is recommendation fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}