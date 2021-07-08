package com.example.recyclerview;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerview.Model.Tasks;

import java.util.ArrayList;

import javax.annotation.meta.When;

import io.realm.OrderedRealmCollection;
import io.realm.RealmConfiguration;
import io.realm.RealmRecyclerViewAdapter;

public class MyRecyclerViewAdapter extends RealmRecyclerViewAdapter<Tasks,MyRecyclerViewAdapter.MyViewHolder> {

    OrderedRealmCollection<Tasks> data;

    public MyRecyclerViewAdapter(OrderedRealmCollection<Tasks> data) {
        super(data,true);
        this.data=data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

      View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_layout,parent,false);
      return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull  MyRecyclerViewAdapter.MyViewHolder holder, int position) {

        final Tasks tasks = getItem(position);

        holder.idTV.setText(String.valueOf(tasks.getTask_id()));
        holder.tasknameTV.setText(tasks.getTask_name());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(v.getContext(), "Please select data first", Toast.LENGTH_SHORT).show();

            }
        });
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                        RealMHelper helper=new RealMHelper();
                        helper.deleteData(data.get(position).getTask_id());

                        return;
                    }
                });


            }
        });
    }



    @Override
    public long getItemId(int position) {
        return getItem(position).getTask_id();

    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView idTV,tasknameTV;
        CheckBox checkBox;
        Button delete;
        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);
            idTV=itemView.findViewById(R.id.idTV);
            tasknameTV=itemView.findViewById(R.id.tasknameTV);
            checkBox=itemView.findViewById(R.id.checkbox);
            delete=itemView.findViewById(R.id.delete);


            }

        }
    }


