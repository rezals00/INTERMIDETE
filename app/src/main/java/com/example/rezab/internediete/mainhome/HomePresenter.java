package com.example.rezab.internediete.mainhome;

import android.content.Context;

import com.example.rezab.internediete.maininteractor.Main2Interface;
import com.example.rezab.internediete.model.HomeModel;

import java.util.ArrayList;

/**
 * Created by rezab on 14/05/2017.
 */

public class HomePresenter implements Main2Interface{
    private Context mContext;
    private ArrayList<HomeModel> mHomeModel;

    public HomePresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void showList(ArrayList<HomeModel> homeModels) {
        mHomeModel = homeModels;
    }

}
