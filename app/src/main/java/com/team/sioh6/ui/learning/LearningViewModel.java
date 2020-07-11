package com.team.sioh6.ui.learning;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LearningViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public LearningViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Learning fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}