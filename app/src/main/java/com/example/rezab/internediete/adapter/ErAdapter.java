package com.example.rezab.internediete.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rezab.internediete.R;
import com.example.rezab.internediete.maininteractor.Main2Interface;
import com.example.rezab.internediete.mainview.DetailActivity;
import com.example.rezab.internediete.model.HomeModel;

import java.util.ArrayList;

/**
 * Created by rezab on 14/05/2017.
 */

public class ErAdapter extends RecyclerView.Adapter<ErAdapter.ViewHolder> {
    private ArrayList<HomeModel> mhomemodels;
    private Context mContext;

    public ErAdapter( Context mContext, ArrayList<HomeModel> mhomemodels) {
        this.mhomemodels = mhomemodels;
        this.mContext = mContext;
    }
    public ErAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.rowlayout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ErAdapter.ViewHolder holder, final int position) {
        HomeModel homeModel = mhomemodels.get(position);
        holder.textView1.setText(homeModel.getNama());
        holder.textView2.setText(homeModel.getAlamat());
        holder.textView3.setText(homeModel.getEmail());
        holder.textView4.setText(homeModel.getNo());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Clicked : "+position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("id",""+position);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mhomemodels.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView1, textView2, textView3, textView4;

        public ViewHolder(View itemView) {
            super(itemView);

            textView1 = (TextView) itemView.findViewById(R.id.tv_name);
            textView2 = (TextView) itemView.findViewById(R.id.tv_alamat);
            textView3 = (TextView) itemView.findViewById(R.id.tv_email);
            textView4 = (TextView) itemView.findViewById(R.id.tv_noTelp);

        }
    }
}
