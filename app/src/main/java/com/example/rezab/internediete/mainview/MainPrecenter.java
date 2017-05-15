package com.example.rezab.internediete.mainview;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;

import com.example.rezab.internediete.R;
import com.example.rezab.internediete.maininteractor.InterfacePresenter;
import com.example.rezab.internediete.maininteractor.InterfaceMain;
/**
 * Created by rezab on 13/05/2017.
 */

public class MainPrecenter implements InterfacePresenter{
    private InterfaceMain mInterface;
    public MainPrecenter(MainActivity mainActivity) {
            this.mInterface = mainActivity;
    }

    @Override
    public void login(String username,String password){
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            mInterface.messageempty();
        } else {
            if(username.equals("reza1234")&& password.equals("reza1234")) {
                mInterface.loginsukses(username);
            } else {
                mInterface.messageinvalid();
            }
        }
    }
}
