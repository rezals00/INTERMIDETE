package com.example.rezab.internediete.mainview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rezab.internediete.R;
import com.example.rezab.internediete.mainhome.DetailPresenter;
import com.example.rezab.internediete.mainhome.HomePresenter;
import com.example.rezab.internediete.maininteractor.InterfaceDetail;
import com.example.rezab.internediete.maininteractor.InterfaceMain2;
import com.example.rezab.internediete.maininteractor.Main2Interface;
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

public class DetailActivity extends AppCompatActivity implements InterfaceMain2{
    private List<Retro> mExampleRetros;
    private InterfaceDetail mHomeInterface;
    private static final String BASE_URL = "https://private-4e4159-qurrata.apiary-mock.com/";
    private TextView isi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle(R.string.loading);
        Intent intent = getIntent();
        String i = intent.getStringExtra("id");
        mHomeInterface = new DetailPresenter(this,this);
        mHomeInterface.getDataInfo(i);
    }

    @Override
    public void next(int id) {

    }

    @Override
    public void initView() {

    }

    @Override
    public void setinfo(String title, String body) {
        setTitle(title);
        isi = (TextView) findViewById(R.id.textView);
        isi.setText(body);
    }
}
