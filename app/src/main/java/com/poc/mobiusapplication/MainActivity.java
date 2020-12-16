package com.poc.mobiusapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.poc.mobiusapplication.APIClient;
import com.poc.mobiusapplication.APIInterface;
import com.poc.mobiusapplication.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    APIInterface apiInterface;
    ProgressDialog progressDialog;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.custom_layout);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

        APIInterface apiInterface = APIClient.getRetrofitInstance().create(APIInterface.class);

        if(checkInternetConnection(MainActivity.this)) {
            Call<List<BonusCouponModel>> call = apiInterface.getBonusCoupons();
            call.enqueue(new Callback<List<BonusCouponModel>>() {
                @Override
                public void onResponse(Call<List<BonusCouponModel>> call, Response<List<BonusCouponModel>> response) {
                    progressDialog.dismiss();
                    populateList(response.body());
                    Log.i("BONUS COUPON DATA:", response.body().toString());
                }

                @Override
                public void onFailure(Call<List<BonusCouponModel>> call, Throwable t) {
                    progressDialog.dismiss();
                    Toast.makeText(MainActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else
        {
            progressDialog.dismiss();
            Toast.makeText(MainActivity.this, "Please check your Internet Connection", Toast.LENGTH_SHORT).show();
        }
    }

    private void populateList(List<BonusCouponModel> dataModelList) {
        BounusCouponAdapter myRecyclerViewAdapter = new BounusCouponAdapter(dataModelList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(myRecyclerViewAdapter);
    }


    public boolean checkInternetConnection(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity == null) {
            return false;
        } else {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null) {
                for (int i = 0; i < info.length; i++){
                    if (info[i].getState()== NetworkInfo.State.CONNECTED){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}