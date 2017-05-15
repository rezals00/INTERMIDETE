package com.example.rezab.internediete.mainview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rezab.internediete.R;
import com.example.rezab.internediete.model.HomeModel;
import com.example.rezab.internediete.model.Retro;
import com.example.rezab.internediete.service.ServiceApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {
    private List<Retro> mExampleRetros;
    private static final String BASE_URL = "https://private-4e4159-qurrata.apiary-mock.com/";
    private TextView isi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle(R.string.loading);
        getData();
    }
    public void getData(){
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
                Intent intent = getIntent();
                String i = intent.getStringExtra("id");
                    String judul = mExampleRetros.get(Integer.parseInt(i)).getJudul();
                    String tipe = mExampleRetros.get(Integer.parseInt(i)).getTentang();
                    String isia = mExampleRetros.get(Integer.parseInt(i)).getIsi();
                isi = (TextView) findViewById(R.id.textView);
                setTitle(judul);
                isi.setText("\nTipe : "+tipe+"\nIsi : "+isia);

            }

            @Override
            public void onFailure(Call<List<Retro>> call, Throwable t) {
                Toast.makeText(DetailActivity.this, R.string.koneksierror, Toast.LENGTH_SHORT).show();
            }
        });


    }
}
