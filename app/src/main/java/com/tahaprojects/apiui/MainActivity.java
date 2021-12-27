package com.tahaprojects.apiui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rcvw;
    private ProgressBar progressBar;
    private TextView tvcity,tv1,tv2;
    private EditText editText;
    private ImageView imgBack;
    private Button idIVSearch;

    private List<MyClass>myClassArrayList=new ArrayList<>();
    private List<MyClass.Hour>hourList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressBar=findViewById(R.id.idPBLoading);
        setContentView(R.layout.activity_main);
        rcvw=findViewById(R.id.idRvWeather);
        editText=findViewById(R.id.idEdiCity);
        tvcity=findViewById(R.id.idTVCityName);
        tv1=findViewById(R.id.idTVTemperature);
        tv2=findViewById(R.id.idTVCondition);
        imgBack=findViewById(R.id.idTVIcon);
        idIVSearch=findViewById(R.id.idIVSearch);
        //progressBar.setVisibility(View.VISIBLE);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.weatherapi.com/v1/").addConverterFactory(GsonConverterFactory.create())
                .build();
        IApi iApi=retrofit.create(IApi.class);
        Call<MyClass> call=iApi.getApi("1265a32feba940c6bcb55610210112","Hyderabad",1,"no","no");

        idIVSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit=new Retrofit.Builder()
                        .baseUrl("https://api.weatherapi.com/v1/").addConverterFactory(GsonConverterFactory.create())
                        .build();
                IApi iApi=retrofit.create(IApi.class);
                Call<MyClass> call;
                call = iApi.getApi("1265a32feba940c6bcb55610210112",editText.getText().toString(),1,"no","no");
                call.enqueue(new Callback<MyClass>() {
                    @Override
                    public void onResponse(Call<MyClass> call, Response<MyClass> response) {
                        if(!response.isSuccessful())
                        {
                            tvcity.setText(response.message());
                            return;
                        }
                        MyClass aClass=response.body();

                        tvcity.setText(aClass.getLocation().getName());
                        //double temp=aClass.getCurrent().getTemp_c();
                        tv1.setText(aClass.getCurrent().getTemp_c()+"°C");
                        tv2.setText(aClass.getCurrent().getCondition().getText());
                        String link=aClass.getCurrent().getCondition().getText();
                        Glide.with(MainActivity.this).asBitmap().load(link).into(imgBack);
                        hourList=aClass.getForecast().getForecastday().get(0).getHour();
                        ViewData viewData=new ViewData(hourList,MainActivity.this);
                        rcvw.setLayoutManager( new GridLayoutManager(MainActivity.this,3));
                        rcvw.setAdapter(viewData);
                    }

                    @Override
                    public void onFailure(Call<MyClass> call, Throwable t) {
                        tvcity.setText(t.getMessage());

                    }
                });
            }
        });

        //Call<MyClass> call=iApi.getApi("1265a32feba940c6bcb55610210112",editText.getText().toString(),1,"no","no");
        call.enqueue(new Callback<MyClass>() {
            @Override
            public void onResponse(Call<MyClass> call, Response<MyClass> response) {
                if(!response.isSuccessful())
                {
                    return;
                }
                //MyClass myClass=new MyClass(response.body().location, response.body().current, response.body().forecast, response.body().alerts);
                MyClass aClass=response.body();

                tvcity.setText(aClass.getLocation().getName());
                //double temp=aClass.getCurrent().getTemp_c();
                tv1.setText(aClass.getCurrent().getTemp_c()+"°C");
                tv2.setText(aClass.getCurrent().getCondition().getText());
                String link=aClass.getCurrent().getCondition().getText();
                Glide.with(MainActivity.this).asBitmap().load(link).into(imgBack);
                hourList=aClass.getForecast().getForecastday().get(0).getHour();
                ViewData viewData=new ViewData(hourList,MainActivity.this);
                rcvw.setLayoutManager( new GridLayoutManager(MainActivity.this,3));
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