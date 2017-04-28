package com.example.akshay.quickdeal.Utils;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.akshay.quickdeal.Activities.MainActivity;
import com.example.akshay.quickdeal.Activities.RecyclerItem;
import com.example.akshay.quickdeal.Activities.details;
import com.example.akshay.quickdeal.R;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Akshay on 20/04/2017.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private List<RecyclerItem> listItmes;
    public Context context;

    public MyAdapter(List<RecyclerItem> listItmes, Context context){
        this.listItmes = listItmes;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final RecyclerItem itemList = listItmes.get(position);
        holder.txtTitle.setText(itemList.getTitle());
        holder.txtDesc.setText(itemList.getDescription());

    }

    @Override
    public int getItemCount() {
        return listItmes.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView txtTitle;
        public TextView txtDesc;
        public TextView textTime;
        public TextView option;
        public ViewHolder(View itemView) {
            super(itemView);


            txtTitle = (TextView) itemView.findViewById(R.id.recycler_textview_title);
            txtDesc = (TextView) itemView.findViewById(R.id.recycler_textview_desc);
            textTime = (TextView) itemView.findViewById(R.id.post_time);
            option = (TextView) itemView.findViewById(R.id.option_menu);
           itemView.setOnClickListener(this);

        }

         @Override
         public void onClick(View v) {
            Intent intent = new Intent(context,details.class);
             String text1 = txtTitle.getText().toString();
             String text2 = txtDesc.getText().toString();
             intent.putExtra("title",text1);
             intent.putExtra("desc",text2);
             context.startActivity(intent);
         }


     }
}
