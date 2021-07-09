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
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recyclerview.Model.Tasks;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;

public class MyRecyclerViewAdapter extends RealmRecyclerViewAdapter<Tasks,MyRecyclerViewAdapter.MyViewHolder> {

    OrderedRealmCollection<Tasks> data;
    private FirebaseDatabase db=FirebaseDatabase.getInstance();
    private DatabaseReference root=db.getReference();
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
        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                HashMap<String, String>userMap=new HashMap<>();
                userMap.put("Tasks", tasks.getTask_name());
                root.push().setValue(userMap);
                Toast.makeText(v.getContext(), "Data saved succesfully...",Toast.LENGTH_LONG).show();
            }
        });


    }


    @Override
    public long getItemId(int position) {
        return getItem(position).getTask_id();

    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView idTV,tasknameTV;
        Button like;
        public MyViewHolder(@NonNull  View itemView) {
            super(itemView);
            idTV=itemView.findViewById(R.id.idTV);
            tasknameTV=itemView.findViewById(R.id.tasknameTV);
            like=itemView.findViewById(R.id.like);


        }

    }
}

