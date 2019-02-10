package com.codingblocks.planets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<CelestialObjects> celestialObjects = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        setContentView(R.layout.activity_main);

        PlanetAdapter planetAdapter = new PlanetAdapter(celestialObjects, this);

        ListView listView = findViewById(R.id.listView);

        listView.setAdapter(planetAdapter);

    }
}