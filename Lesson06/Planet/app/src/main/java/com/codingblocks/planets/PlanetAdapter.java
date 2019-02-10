package com.codingblocks.planets;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PlanetAdapter extends BaseAdapter {

    private ArrayList<CelestialObjects> celestialObjects;
    private Context context;

    public PlanetAdapter(ArrayList<CelestialObjects> celestialObjects, Context context) {
        this.celestialObjects = celestialObjects;
        this.context = context;
    }

    @Override
    public int getCount() {
        return celestialObjects.size();
    }

    @Override
    public CelestialObjects getItem(int position) {
        return celestialObjects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

//    private ArrayList<ViewHolder> viewsArrayList = new ArrayList<>();

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //ConvertView is null for those scenarios where no view is available for recycling/conversion
        Log.e("TAG", "getView: " + convertView);

        View inflatedView;

        //Global wrapper for storing all of the Views inside the Inflated View's tag
        ViewHolder currentView;

        //Solving for space complexity
        if (convertView == null) {

            inflatedView = layoutInflater.inflate(R.layout.item_row, parent, false);
            currentView = new ViewHolder(inflatedView);

            //Solving for time complexity
            inflatedView.setTag(currentView);

        } else {
            inflatedView = convertView;
            currentView = (ViewHolder) inflatedView.getTag();
        }

        CelestialObjects currentObject = getItem(position);

        currentView.name.setText(currentObject.getName());
        currentView.distance.setText(currentObject.getDistanceFromTheSun());
        currentView.desc.setText(currentObject.getDescription());

        Picasso.get()
                .load(currentObject.getUrl())
                .placeholder(R.drawable.loading)
                .error(R.drawable.loading_failed)
                .into(currentView.image);

        return inflatedView;
    }

    //ViewHolder pattern to solve for time complexity
    class ViewHolder {

        TextView name, desc, distance;
        ImageView image;
        View rowView;

        public ViewHolder(View view) {
            rowView = view;
            this.name = view.findViewById(R.id.tvName);
            this.desc = view.findViewById(R.id.tvDesc);
            this.distance = view.findViewById(R.id.tvDistance);
            this.image = view.findViewById(R.id.ivImage);
        }
    }

}
