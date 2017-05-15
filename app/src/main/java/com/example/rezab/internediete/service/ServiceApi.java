package com.example.rezab.internediete.service;

import com.example.rezab.internediete.model.Retro;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by rezab on 15/05/2017.
 */

public interface ServiceApi {
    String END_POINT = "questions";

    @GET("questions")
    Call<List<Retro>>getData();
}
