package com.codingblocks.planets;

class CelestialObjects {

    private String name, distanceFromTheSun, description, url;

    CelestialObjects(String name, String distanceFromTheSun, String description, String url) {
        this.name = name;
        this.distanceFromTheSun = distanceFromTheSun;
        this.description = description;
        this.url = url;
    }

    String getName() {
        return name;
    }

    String getDistanceFromTheSun() {
        return distanceFromTheSun;
    }

    String getDescription() {
        return description;
    }

    String getUrl() {
        return url;
    }
}
