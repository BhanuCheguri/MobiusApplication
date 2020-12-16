package com.poc.mobiusapplication;

import com.poc.mobiusapplication.BonusCouponModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface APIInterface {


    @GET("/v3/4c663239-03af-49b5-bcb3-0b0c41565bd2")
    Call<List<BonusCouponModel>> getBonusCoupons();
}
