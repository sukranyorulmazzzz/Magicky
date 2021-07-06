package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recyclerview.Model.Tasks;
import com.example.recyclerview.Model.VariableHolder;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;

public class MainActivity extends AppCompatActivity {

    EditText taskName;
    Button insertBtn;
    RecyclerView rv;
    CheckBox checkbox;
    MyRecyclerViewAdapter adapter;
    RealMHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(getApplicationContext());
         helper=new RealMHelper();

        taskName=findViewById(R.id.taskName);
        VariableHolder.setTaskName(taskName);
        insertBtn=findViewById(R.id.insertBtn);

        rv=findViewById(R.id.rv);
        updateRV();

        insertBtn.setOnClickListener(new View.OnClickListener() {
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
    }
}