package com.example.namstyling20.ui.canvas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CanvasViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public CanvasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is canvas fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}