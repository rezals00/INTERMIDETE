package com.example.rezab.internediete.mainhome;

import android.content.Context;
import android.widget.Toast;

import com.example.rezab.internediete.R;
import com.example.rezab.internediete.maininteractor.InterfaceDetail;
import com.example.rezab.internediete.maininteractor.InterfaceMain2;
import com.example.rezab.internediete.maininteractor.Main2Interface;
import com.example.rezab.internediete.mainview.DetailActivity;
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
 * Created by rezab on 15/05/2017.
 */

public class DetailPresenter implements InterfaceDetail {
    private com.example.rezab.internediete.maininteractor.InterfaceMain2 InterfaceMain2;
    private ArrayList<HomeModel> mHomeModel;
    private List<Retro> mExampleRetros;
    private Context mContext;
    private static final String BASE_URL = "https://private-4e4159-qurrata.apiary-mock.com/";
    private String ids;

    public DetailPresenter(DetailActivity interfaceMain2, Context mContext) {
        InterfaceMain2 = interfaceMain2;
        this.mContext = mContext;
    }
    @Override
    public void getDataInfo(String id) {
        final String ids = id;
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
                String judul = mExampleRetros.get(Integer.parseInt(ids)).getJudul();
                String tipe = mExampleRetros.get(Integer.parseInt(ids)).getTentang();
                String isia = mExampleRetros.get(Integer.parseInt(ids)).getIsi();
                InterfaceMain2.setinfo(judul,"\n Tipe : "+tipe+" \n Isi : "+isia);

            }

            @Override
            public void onFailure(Call<List<Retro>> call, Throwable t) {
                Toast.makeText(mContext, R.string.koneksierror, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
