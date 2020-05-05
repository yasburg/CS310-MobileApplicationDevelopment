package edu.sabanciuniv.planetsapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.sabanciuniv.planetsapp.R;

/**
 * Created by atanaltay on 01/04/2017.
 */

public class Planet implements Serializable {

    private String name;
    private int img;
    private String description;


    public Planet() {
    }

    public Planet(String name, int img, String description) {
        this.name = name;
        this.img = img;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public static List<Planet> getAllPlanets(){

        Planet p1 = new Planet("Mercury", R.drawable.mercury,"First planet is Solar System.");
        Planet p2 = new Planet("Venus",R.drawable.venus,"Second planet is Solar System.");
        Planet p3 = new Planet("Earth",R.drawable.earth,"Our home planet.");
        Planet p4 = new Planet("Mars",R.drawable.mars,"Fourth planet is Solar System, or the red planet");
        Planet p5 = new Planet("Jupiter",R.drawable.jupiter,"Fifth planet is Solar System. A very long description text added to this planet. Fifth planet is Solar System. A very long description text added to this planet. Fifth planet is Solar System. A very long description text added to this planet. Fifth planet is Solar System. A very long description text added to this planet. Fifth planet is Solar System. A very long description text added to this planet. Fifth planet is Solar System. A very long description text added to this planet. Fifth planet is Solar System. A very long description text added to this planet. Fifth planet is Solar System. A very long description text added to this planet. Fifth planet is Solar System. A very long description text added to this planet. Fifth planet is Solar System. A very long description text added to this planet. Fifth planet is Solar System. A very long description text added to this planet.");
        Planet p6 = new Planet("Saturn",R.drawable.saturn,"Sixth planet is Solar System.");
        Planet p7 = new Planet("Uranus",R.drawable.uranus,"Seventh planet description.");
        Planet p8 = new Planet("Neptune",R.drawable.neptune,"Eighth planet is Solar System.");
        Planet p9 = new Planet("Pluton",R.drawable.pluto,"Nineth planet, is it even a planet??");

        List<Planet> planets = new ArrayList<>();
        planets.add(p1);
        planets.add(p2);
        planets.add(p3);
        planets.add(p4);
        planets.add(p5);
        planets.add(p6);
        planets.add(p7);
        planets.add(p8);
        planets.add(p9);

        return planets;

    }


}
