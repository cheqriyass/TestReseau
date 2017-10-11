package com.example.yassine.testreseau;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yassine.testreseau.models.Voiture;

import java.util.Collections;
import java.util.List;

/**
 * Created by Yassine on 04/10/2017.
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    private Context context;
    private int mNumberItems;
    private List<Voiture> voitures = Collections.emptyList();

    public CarAdapter(int mNumberItems, List<Voiture> voitures) {
        this.mNumberItems = mNumberItems;
        this.voitures = voitures;
    }



    @Override
    public CarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        int layoutIdForItem = R.layout.car_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForItem, parent, false);
        CarViewHolder viewHolder = new CarViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CarViewHolder holder, int position) {
        holder.bind(voitures.get(position));
    }


    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    class CarViewHolder extends RecyclerView.ViewHolder {
        TextView car_nom;
        TextView car_marque;
        TextView car_couleur;

        public CarViewHolder(View itemView) {
            super(itemView);
            this.car_nom = itemView.findViewById(R.id.car_nom);
            this.car_marque = itemView.findViewById(R.id.car_marque);
            this.car_couleur = itemView.findViewById(R.id.car_couleur);
        }

        public void bind(Voiture voiture) {
            this.car_nom.setText(voiture.getName());
            this.car_marque.setText(voiture.getMarque());
            this.car_couleur.setText(String.valueOf(voiture.getCouleur()));
        }

    }

}


