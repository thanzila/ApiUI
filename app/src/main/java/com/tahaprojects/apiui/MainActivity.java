package com.tahaprojects.apiui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvw;
    private List<MyClass>myClassArrayList=new ArrayList<>();
    private List<MyClass.Hour>hourList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvw=findViewById(R.id.idRvWeather);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.weatherapi.com/v1/").addConverterFactory(GsonConverterFactory.create())
                .build();
        IApi iApi=retrofit.create(IApi.class);
        Call<MyClass> call=iApi.getApi("1265a32feba940c6bcb55610210112","Hyderabad",1,"yes","yes");
        call.enqueue(new Callback<MyClass>() {
            @Override
            public void onResponse(Call<MyClass> call, Response<MyClass> response) {
                if(!response.isSuccessful())
                {
                    return;
                }
                MyClass aClass=response.body();
                hourList=aClass.getForecast().getForecastday().get(0).getHour();
                ViewData viewData=new ViewData(hourList,MainActivity.this);
                rcvw.setLayoutManager( new GridLayoutManager(MainActivity.this,4));
                rcvw.setAdapter(viewData);
            }

            @Override
            public void onFailure(Call<MyClass> call, Throwable t) {
                t.getMessage();
                return;
            }
        });

    }
}