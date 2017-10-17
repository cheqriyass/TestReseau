package com.example.yassine.testreseau;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.yassine.testreseau.models.Voiture;

import java.util.List;

public class CarActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CarAdapter carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);

        Intent i = getIntent();
        List<Voiture> voitures = (List<Voiture>) i.getSerializableExtra("voitures");

        recyclerView = (RecyclerView) findViewById(R.id.carsRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        carAdapter = new CarAdapter(voitures.size(), voitures);
        recyclerView.setAdapter(carAdapter);


    }
}
