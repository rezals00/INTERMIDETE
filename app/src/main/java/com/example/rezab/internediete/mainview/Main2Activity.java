package com.example.rezab.internediete.mainview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.rezab.internediete.R;
import com.example.rezab.internediete.adapter.ErAdapter;
import com.example.rezab.internediete.mainhome.HomePresenter;
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

public class Main2Activity extends AppCompatActivity implements InterfaceMain2 {

    private RecyclerView mRecyclerView;
    private ErAdapter mHomeAdapter;
    private Main2Interface mHomeInterface;
    private ArrayList<HomeModel> mHomeModel;
    private List<Retro> mExampleRetros;
    private static final String BASE_URL = "https://private-4e4159-qurrata.apiary-mock.com/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        setTitle("Selamat Datang "+i.getStringExtra("username"));
        mHomeInterface = new HomePresenter(this,this);
        mHomeModel = new ArrayList<>();
        mHomeInterface.showList(mHomeModel);
        mHomeInterface.getData();

    }
    public void initView(){
        mRecyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Main2Activity.this);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        mHomeAdapter = new ErAdapter(this, mHomeModel);
        mRecyclerView.setAdapter(mHomeAdapter);
    }

    @Override
    public void setinfo(String title, String body) {

    }


    @Override
    public void next(int id) {
        Intent i = new Intent(this,DetailActivity.class);
        i.putExtra("id",id);
        startActivity(i);
    }
}
