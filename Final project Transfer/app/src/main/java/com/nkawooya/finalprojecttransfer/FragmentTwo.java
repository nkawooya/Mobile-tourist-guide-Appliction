package com.nkawooya.finalprojecttransfer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by nkawooya on 4/27/2016.
 */
public class FragmentTwo extends android.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.index_location,container,false);
    }
}
