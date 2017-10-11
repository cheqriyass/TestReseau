package com.example.yassine.testreseau;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.yassine.testreseau.models.Users;
import com.example.yassine.testreseau.models.Voiture;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RetroActivity extends AppCompatActivity implements UserAdapter.ListItemClickListener{

    private static int NUM_LIST_ITEMS = 20;
    private RecyclerView recyclerView;
    private UserAdapter userAdapter;
    private CarAdapter carAdapter;
    private Toast toast;
    private RetroActivity retroActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retro);
        retroActivity = this;
        retroFitMethod();
    }

    private void retroFitMethod() {

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://android.busin.fr/")
                .build();

        apiService service = restAdapter.create(apiService.class);


        service.getUsers(new Callback<Users>() {
            @Override
            public void success(final Users users, Response response) {
                NUM_LIST_ITEMS = users.getUsers().size();
                recyclerView = (RecyclerView) findViewById(R.id.usersRecycler);
                recyclerView.setLayoutManager(new LinearLayoutManager(retroActivity));
                recyclerView.setHasFixedSize(true);
                userAdapter = new UserAdapter(NUM_LIST_ITEMS, retroActivity, users);
                recyclerView.setAdapter(userAdapter);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(RetroActivity.this, "oups", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onListItemClick(List<Voiture> voitures) {
//        String message = "you clicked " + voitures.get(0).getName();
//        if (toast != null)
//            toast.cancel();
//        toast = Toast.makeText(this, message, Toast.LENGTH_LONG);
//        toast.show();


        carAdapter = new CarAdapter(voitures.size(), voitures);
        recyclerView.setAdapter(carAdapter);
    }
}
