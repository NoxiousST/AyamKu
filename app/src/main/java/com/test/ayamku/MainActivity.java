package com.test.ayamku;

import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import android.content.BroadcastReceiver;
import java.util.ArrayList;
import android.content.IntentFilter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<RecyclerData> recyclerDataArrayList;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.idCourseRV);
        total = findViewById(R.id.total);

        recyclerDataArrayList = new ArrayList<>();
        recyclerDataArrayList.add(new RecyclerData("Ayam 1", "20000", R.drawable.img));
        recyclerDataArrayList.add(new RecyclerData("Ayam 2", "12000", R.drawable.img2));
        recyclerDataArrayList.add(new RecyclerData("Ayam 3", "18000", R.drawable.img3));
        recyclerDataArrayList.add(new RecyclerData("Ayam 4", "15000", R.drawable.img4));
        recyclerDataArrayList.add(new RecyclerData("Ayam 5", "30000", R.drawable.img5));
        recyclerDataArrayList.add(new RecyclerData("Ayam 6", "25000", R.drawable.img6));

        RecyclerViewAdapter adapter = new RecyclerViewAdapter(recyclerDataArrayList, this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("custom-message"));

    }
    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String s = intent.getStringExtra("Rhrg");
            total.setText("Total = " + s);
        }
    };


}