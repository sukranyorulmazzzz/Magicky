package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.recyclerview.Model.Tasks;
import com.example.recyclerview.Model.VariableHolder;
import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {
    public static Realm realm;
    EditText taskName;
    Button insertBtn;
    RecyclerView rv;
    TextView tvEmpty;
    Toolbar toolbar;
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

       
         
        taskName=findViewById(R.id.taskName);
        VariableHolder.setTaskName(taskName);
        insertBtn=findViewById(R.id.insertBtn);
        tvEmpty=findViewById(R.id.tv_empty);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menudelete:
                Toast.makeText(getApplicationContext(),"Delete",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
