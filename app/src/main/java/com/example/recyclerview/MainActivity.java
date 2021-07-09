package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.recyclerview.Model.Tasks;
import com.example.recyclerview.Model.VariableHolder;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    OrderedRealmCollection<Tasks> data;
    public static Realm realm;
    EditText taskName;
    Button insertBtn;
    ImageView image_view;
    RecyclerView rv;
    TextView tvEmpty;
    RelativeLayout relativeLayout;

    MyRecyclerViewAdapter adapter;
    RealMHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder()
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .build();
        realm = Realm.getInstance(config);
        helper=new RealMHelper();

         image_view=findViewById(R.id.image_view);

        taskName=findViewById(R.id.taskName);
        VariableHolder.setTaskName(taskName);
        insertBtn=findViewById(R.id.insertBtn);
        tvEmpty=findViewById(R.id.tv_empty);
        relativeLayout=findViewById(R.id.relativelayout);

        rv=findViewById(R.id.rv);
        updateRV();





        insertBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {

                String task_name=taskName.getText().toString();


                helper.insertData(new Tasks(task_name));
                taskName.setText("");
                updateRV();

                Toast.makeText(MainActivity.this, "Veri kaydedildi...", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void updateRV(){
        adapter=new MyRecyclerViewAdapter((OrderedRealmCollection<Tasks>) helper.getData());
        rv.setLayoutManager(new LinearLayoutManager(this));
         rv.setAdapter(adapter);
         ItemTouchHelper helper=new ItemTouchHelper(callback);
         helper.attachToRecyclerView(rv);
            }


    final ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
        @Override
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            return false;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

        }
    };





}
