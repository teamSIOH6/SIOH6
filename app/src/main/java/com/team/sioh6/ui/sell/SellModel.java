package com.team.sioh6.ui.sell;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SellModel extends ViewModel {

    private MutableLiveData<String> mText;

    public SellModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Selling fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}