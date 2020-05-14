package com.nanmu.gallery;

import android.app.Application;
import android.app.DownloadManager;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by kusunoki on 2020/5/14 0014 14:49.
 */
public class GalleyViewModel extends AndroidViewModel {

    private MutableLiveData<List<PhotoItem>> photoListLive;

    public MutableLiveData<List<PhotoItem>> getPhotoListLive() {
        if (photoListLive == null){
            photoListLive = new MutableLiveData<>();
        }
        return photoListLive;
    }

    public GalleyViewModel(@NonNull Application application) {
        super(application);
    }

    void requestData(){
        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                getUrl(),
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        Pixabay pixabay = new Gson().fromJson(response, Pixabay.class);
                        photoListLive.setValue(pixabay.getPhotoItemList());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("request", error.toString());
                    }
                }
        );
        RequestQueue queue = VolleySingleton.getinstance(getApplication()).getRequestQueue();
        queue.add(stringRequest);
    }

    String getUrl(){
        Random random = new Random();
        int page = random.nextInt(25) + 1;
        return "https://pixabay.com/api/?key=16540204-1cfc2b0396aa2a7bba53c2315&q=yellow+flowers&image_type=photo&page=" + String.valueOf(page);
    }
}
