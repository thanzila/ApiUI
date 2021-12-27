package com.tahaprojects.apiui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ViewData extends RecyclerView.Adapter<ViewData.VH> {

    List<MyClass.Hour> myClassList=new ArrayList<>();
    Context context;

    public ViewData(List<MyClass.Hour> myClassList, Context context) {
        this.myClassList = myClassList;
        this.context = context;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.rc_vw_item,parent.findViewById(R.id.idRvWeather),false);

        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.cdtv1.setText(myClassList.get(position).getTime());
        holder.cdtv2.setText(myClassList.get(position).getCondition().getText());
        holder.cdtv3.setText(myClassList.get(position).getTemp_c()+"°C");
        holder.cdtv4.setText(myClassList.get(position).getTemp_f()+"°F");


        String url = myClassList.get(position).getCondition().getIcon();

        Glide.with(context).load(url).into(holder.cdiv);
    }

    @Override
    public int getItemCount() {
        return myClassList.size();
    }

    public class VH extends RecyclerView.ViewHolder{
        private TextView cdtv1,cdtv2,cdtv3,cdtv4;
        private ImageView cdiv;
        public VH(@NonNull View itemView) {
            super(itemView);
            cdtv1=itemView.findViewById(R.id.cdtv1);
            cdtv2=itemView.findViewById(R.id.cdtv2);
            cdtv3=itemView.findViewById(R.id.cdtv3);
            cdtv4=itemView.findViewById(R.id.cdtv4);
            cdiv=itemView.findViewById(R.id.cdiv1);
        }
    }
}
