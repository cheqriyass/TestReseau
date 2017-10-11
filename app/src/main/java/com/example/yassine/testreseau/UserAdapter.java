package com.example.yassine.testreseau;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yassine.testreseau.models.User;
import com.example.yassine.testreseau.models.Users;
import com.example.yassine.testreseau.models.Voiture;

import java.util.Collections;
import java.util.List;

/**
 * Created by Yassine on 04/10/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private final ListItemClickListener listener;
    private Context context;
    private int mNumberItems;
    private List<User> users = Collections.emptyList();

    public UserAdapter(int mNumberItems, ListItemClickListener listener, Users users) {
        this.mNumberItems = mNumberItems;
        this.listener = listener;
        this.users = users.getUsers();
    }



    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        int layoutIdForItem = R.layout.user_list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutIdForItem, parent, false);
        UserViewHolder viewHolder = new UserViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final UserViewHolder holder, int position) {
        holder.bind(users.get(position));
    }


    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        List<Voiture> voitures = Collections.emptyList();
        TextView user_nom;
        TextView user_prenom;
        TextView user_age;

        public UserViewHolder(View itemView) {
            super(itemView);
            this.user_nom = itemView.findViewById(R.id.user_nom);
            this.user_prenom = itemView.findViewById(R.id.user_prenom);
            this.user_age = itemView.findViewById(R.id.user_age);
            itemView.setOnClickListener(this);
        }

        public void bind(User user) {
            this.voitures = user.getVoitures();
            this.user_nom.setText(user.getNom());
            this.user_prenom.setText(user.getPrenom());
            this.user_age.setText(String.valueOf(user.getAge()));
        }


        @Override
        public void onClick(View view) {
            listener.onListItemClick(voitures);
        }
    }

    public interface ListItemClickListener {
        void onListItemClick(List<Voiture> voitures);
    }


}


