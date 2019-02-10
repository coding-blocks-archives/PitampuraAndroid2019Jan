package com.codingblocks.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.PixelCopy;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlanetAdapter extends RecyclerView.Adapter<PlanetAdapter.PlanetHolder> {

    private ArrayList<CelestialObjects> objectsArrayList = new ArrayList<>();

    public PlanetAdapter(ArrayList<CelestialObjects> celestialObjects) {
        this.objectsArrayList = celestialObjects;
    }

    //This is called for the number of times during which there is no view available for reuse
    @NonNull
    @Override
    public PlanetHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.item_row, viewGroup, false);
        return new PlanetHolder(view);
    }

    //This is always called for every row
    @Override
    public void onBindViewHolder(@NonNull PlanetHolder planetHolder, int position) {

        CelestialObjects currentObject = objectsArrayList.get(position);

        planetHolder.name.setText(currentObject.getName());
        planetHolder.desc.setText(currentObject.getDescription());
        planetHolder.distance.setText(currentObject.getDescription());

        Picasso.get()
                .load(currentObject.getUrl())
                .placeholder(R.drawable.loading)
                .error(R.drawable.loading_failed)
                .into(planetHolder.image);

    }

    @Override
    public int getItemCount() {
        return objectsArrayList.size();
    }

    public class PlanetHolder extends RecyclerView.ViewHolder {

        TextView name, desc, distance;
        ImageView image;

        public PlanetHolder(@NonNull View itemView) {
            super(itemView);

            this.name = itemView.findViewById(R.id.tvName);
            this.desc = itemView.findViewById(R.id.tvDesc);
            this.distance = itemView.findViewById(R.id.tvDistance);
            this.image = itemView.findViewById(R.id.ivImage);

        }
    }

}
