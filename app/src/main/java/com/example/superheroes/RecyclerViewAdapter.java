package com.example.superheroes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    ArrayList<SuperHeroModel> superHeroesList;

    public RecyclerViewAdapter(Context context, ArrayList<SuperHeroModel> superHeroesList,
                               RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.superHeroesList = superHeroesList;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.textViewName.setText(superHeroesList.get(position).getName());
        holder.textViewDetails.setText(superHeroesList.get(position).getDetails());
        holder.imageView.setImageResource(superHeroesList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return superHeroesList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textViewName, textViewDetails;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            imageView = itemView.findViewById(R.id.SuperHeroImage);
            textViewName = itemView.findViewById(R.id.SuperHeroName);
            textViewDetails = itemView.findViewById(R.id.SuperHeroDetails);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
