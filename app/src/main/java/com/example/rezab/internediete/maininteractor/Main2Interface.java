package com.example.rezab.internediete.maininteractor;

import android.view.View;

import com.example.rezab.internediete.mainview.Main2Activity;
import com.example.rezab.internediete.model.HomeModel;

import java.util.ArrayList;

/**
 * Created by rezab on 15/05/2017.
 */

public interface Main2Interface {
    void showList(ArrayList<HomeModel> homeModels);
    void getData();
}
