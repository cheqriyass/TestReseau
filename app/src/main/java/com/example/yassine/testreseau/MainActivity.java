package com.example.yassine.testreseau;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.yassine.testreseau.models.Users;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        okHTTP();

    }


    public void okHTTP(){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("http://android.busin.fr/fichier_json.json")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "oups", Toast.LENGTH_SHORT).show();

                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                runOnUiThread(new Runnable() {

                    Gson gson = new Gson();
                    String json = response.body().string();
                    Users users = gson.fromJson(json, Users.class);


                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, users.getUsers().get(0).getPrenom(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
