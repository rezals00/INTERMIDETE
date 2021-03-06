package com.example.rezab.internediete.mainhome;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.rezab.internediete.R;
import com.example.rezab.internediete.adapter.ErAdapter;
import com.example.rezab.internediete.maininteractor.InterfaceMain2;
import com.example.rezab.internediete.maininteractor.Main2Interface;
import com.example.rezab.internediete.mainview.Main2Activity;
import com.example.rezab.internediete.model.HomeModel;
import com.example.rezab.internediete.model.Retro;
import com.example.rezab.internediete.service.ServiceApi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rezab on 14/05/2017.
 */

public class HomePresenter implements Main2Interface{
    private InterfaceMain2 InterfaceMain2;
    private ArrayList<HomeModel> mHomeModel;
    private List<Retro> mExampleRetros;
    private Context mContext;
    private static final String BASE_URL = "https://private-4e4159-qurrata.apiary-mock.com/";
    private String ids;
    public HomePresenter(Main2Activity interfaceMain2, Context mContext) {
        this.InterfaceMain2 = interfaceMain2;
        this.mContext = mContext;
    }

    public HomePresenter(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public void showList(ArrayList<HomeModel> homeModels) {
        mHomeModel = homeModels;
    }

    @Override
    public void getData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ServiceApi serviceApi = retrofit.create(ServiceApi.class);
        Call<List<Retro>> call = serviceApi.getData();
        call.enqueue(new Callback<List<Retro>>() {
            @Override
            public void onResponse(Call<List<Retro>> call, Response<List<Retro>> response) {
                mExampleRetros = response.body();
                for (int i = 0; i < mExampleRetros.size() ; i++) {
                    String judul = mExampleRetros.get(i).getJudul();
                    String tipe = mExampleRetros.get(i).getTentang();
                    mHomeModel.add(new HomeModel(judul,"Tipe :"+tipe,"CLICK FOR VIEW",""));
                }
                InterfaceMain2.initView();

            }

            @Override
            public void onFailure(Call<List<Retro>> call, Throwable t) {
                Toast.makeText(mContext, R.string.koneksierror, Toast.LENGTH_SHORT).show();
            }
        });
    }
    

}
