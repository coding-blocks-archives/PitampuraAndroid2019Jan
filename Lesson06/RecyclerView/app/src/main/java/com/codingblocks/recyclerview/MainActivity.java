package com.codingblocks.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<CelestialObjects> celestialObjects = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        celestialObjects.add(new CelestialObjects("Earth", "149.6 million km", "Home", "https://santamariademocrats.info/wp-content/uploads/sites/52/2017/08/tierra1.jpg"));
        celestialObjects.add(new CelestialObjects("Mercury", "57.91 million km", "Death", "https://3c1703fe8d.site.internapcdn.net/newman/gfx/news/hires/2015/whatsimporta.jpg"));
        celestialObjects.add(new CelestialObjects("Venus", "108.2 million km", "Death", "https://www.honeysucklecreek.net/images/images_DSN/venusplanet_med.jpg"));
        celestialObjects.add(new CelestialObjects("Mars", "149.6 million km", "Death", "https://s.hswstatic.com/gif/mars-a1.jpg"));
        celestialObjects.add(new CelestialObjects("Asteroid Belt", "227.9 million km", "Death", "https://www.spaceanswers.com/wp-content/uploads/2012/09/Asteroid-belt.jpg"));
        celestialObjects.add(new CelestialObjects("Earth", "149.6 million km", "Home", "https://santamariademocrats.info/wp-content/uploads/sites/52/2017/08/tierra1.jpg"));
        celestialObjects.add(new CelestialObjects("Mercury", "57.91 million km", "Death", "https://3c1703fe8d.site.internapcdn.net/newman/gfx/news/hires/2015/whatsimporta.jpg"));
        celestialObjects.add(new CelestialObjects("Venus", "108.2 million km", "Death", "https://www.honeysucklecreek.net/images/images_DSN/venusplanet_med.jpg"));
        celestialObjects.add(new CelestialObjects("Mars", "149.6 million km", "Death", "https://s.hswstatic.com/gif/mars-a1.jpg"));
        celestialObjects.add(new CelestialObjects("Asteroid Belt", "227.9 million km", "Death", "https://www.spaceanswers.com/wp-content/uploads/2012/09/Asteroid-belt.jpg"));
        celestialObjects.add(new CelestialObjects("Earth", "149.6 million km", "Home", "https://santamariademocrats.info/wp-content/uploads/sites/52/2017/08/tierra1.jpg"));
        celestialObjects.add(new CelestialObjects("Mercury", "57.91 million km", "Death", "https://3c1703fe8d.site.internapcdn.net/newman/gfx/news/hires/2015/whatsimporta.jpg"));
        celestialObjects.add(new CelestialObjects("Venus", "108.2 million km", "Death", "https://www.honeysucklecreek.net/images/images_DSN/venusplanet_med.jpg"));
        celestialObjects.add(new CelestialObjects("Mars", "149.6 million km", "Death", "https://s.hswstatic.com/gif/mars-a1.jpg"));
        celestialObjects.add(new CelestialObjects("Asteroid Belt", "227.9 million km", "Death", "https://www.spaceanswers.com/wp-content/uploads/2012/09/Asteroid-belt.jpg"));
        celestialObjects.add(new CelestialObjects("Earth", "149.6 million km", "Home", "https://santamariademocrats.info/wp-content/uploads/sites/52/2017/08/tierra1.jpg"));
        celestialObjects.add(new CelestialObjects("Mercury", "57.91 million km", "Death", "https://3c1703fe8d.site.internapcdn.net/newman/gfx/news/hires/2015/whatsimporta.jpg"));
        celestialObjects.add(new CelestialObjects("Venus", "108.2 million km", "Death", "https://www.honeysucklecreek.net/images/images_DSN/venusplanet_med.jpg"));
        celestialObjects.add(new CelestialObjects("Mars", "149.6 million km", "Death", "https://s.hswstatic.com/gif/mars-a1.jpg"));
        celestialObjects.add(new CelestialObjects("Asteroid Belt", "227.9 million km", "Death", "https://www.spaceanswers.com/wp-content/uploads/2012/09/Asteroid-belt.jpg"));
        celestialObjects.add(new CelestialObjects("Earth", "149.6 million km", "Home", "https://santamariademocrats.info/wp-content/uploads/sites/52/2017/08/tierra1.jpg"));
        celestialObjects.add(new CelestialObjects("Mercury", "57.91 million km", "Death", "https://3c1703fe8d.site.internapcdn.net/newman/gfx/news/hires/2015/whatsimporta.jpg"));
        celestialObjects.add(new CelestialObjects("Venus", "108.2 million km", "Death", "https://www.honeysucklecreek.net/images/images_DSN/venusplanet_med.jpg"));
        celestialObjects.add(new CelestialObjects("Mars", "149.6 million km", "Death", "https://s.hswstatic.com/gif/mars-a1.jpg"));
        celestialObjects.add(new CelestialObjects("Asteroid Belt", "227.9 million km", "Death", "https://www.spaceanswers.com/wp-content/uploads/2012/09/Asteroid-belt.jpg"));
        celestialObjects.add(new CelestialObjects("Earth", "149.6 million km", "Home", "https://santamariademocrats.info/wp-content/uploads/sites/52/2017/08/tierra1.jpg"));
        celestialObjects.add(new CelestialObjects("Mercury", "57.91 million km", "Death", "https://3c1703fe8d.site.internapcdn.net/newman/gfx/news/hires/2015/whatsimporta.jpg"));
        celestialObjects.add(new CelestialObjects("Venus", "108.2 million km", "Death", "https://www.honeysucklecreek.net/images/images_DSN/venusplanet_med.jpg"));
        celestialObjects.add(new CelestialObjects("Mars", "149.6 million km", "Death", "https://s.hswstatic.com/gif/mars-a1.jpg"));
        celestialObjects.add(new CelestialObjects("Asteroid Belt", "227.9 million km", "Death", "https://www.spaceanswers.com/wp-content/uploads/2012/09/Asteroid-belt.jpg"));
        celestialObjects.add(new CelestialObjects("Earth", "149.6 million km", "Home", "https://santamariademocrats.info/wp-content/uploads/sites/52/2017/08/tierra1.jpg"));
        celestialObjects.add(new CelestialObjects("Mercury", "57.91 million km", "Death", "https://3c1703fe8d.site.internapcdn.net/newman/gfx/news/hires/2015/whatsimporta.jpg"));
        celestialObjects.add(new CelestialObjects("Venus", "108.2 million km", "Death", "https://www.honeysucklecreek.net/images/images_DSN/venusplanet_med.jpg"));
        celestialObjects.add(new CelestialObjects("Mars", "149.6 million km", "Death", "https://s.hswstatic.com/gif/mars-a1.jpg"));
        celestialObjects.add(new CelestialObjects("Asteroid Belt", "227.9 million km", "Death", "https://www.spaceanswers.com/wp-content/uploads/2012/09/Asteroid-belt.jpg"));
        celestialObjects.add(new CelestialObjects("Mercury", "57.91 million km", "Death", "https://3c1703fe8d.site.internapcdn.net/newman/gfx/news/hires/2015/whatsimporta.jpg"));
        celestialObjects.add(new CelestialObjects("Venus", "108.2 million km", "Death", "https://www.honeysucklecreek.net/images/images_DSN/venusplanet_med.jpg"));
        celestialObjects.add(new CelestialObjects("Mars", "149.6 million km", "Death", "https://s.hswstatic.com/gif/mars-a1.jpg"));
        celestialObjects.add(new CelestialObjects("Asteroid Belt", "227.9 million km", "Death", "https://www.spaceanswers.com/wp-content/uploads/2012/09/Asteroid-belt.jpg"));
        celestialObjects.add(new CelestialObjects("Earth", "149.6 million km", "Home", "https://santamariademocrats.info/wp-content/uploads/sites/52/2017/08/tierra1.jpg"));
        celestialObjects.add(new CelestialObjects("Mercury", "57.91 million km", "Death", "https://3c1703fe8d.site.internapcdn.net/newman/gfx/news/hires/2015/whatsimporta.jpg"));
        celestialObjects.add(new CelestialObjects("Venus", "108.2 million km", "Death", "https://www.honeysucklecreek.net/images/images_DSN/venusplanet_med.jpg"));
        celestialObjects.add(new CelestialObjects("Mars", "149.6 million km", "Death", "https://s.hswstatic.com/gif/mars-a1.jpg"));
        celestialObjects.add(new CelestialObjects("Asteroid Belt", "227.9 million km", "Death", "https://www.spaceanswers.com/wp-content/uploads/2012/09/Asteroid-belt.jpg"));

        RecyclerView recyclerView = findViewById(R.id.rvPlanets);

        PlanetAdapter planetAdapter = new PlanetAdapter(celestialObjects);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

//        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        recyclerView.setAdapter(planetAdapter);

    }
}
