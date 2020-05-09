package edu.sabanciuniv.operatingsystemslibrary;

import android.graphics.Bitmap;

import java.io.Serializable;

public class OperatingSystem implements Serializable {

    private int id;
    private String name;
    private String history;
    private String imagePath;



    public OperatingSystem() {
    }

    public OperatingSystem(int id, String name, String history, String imagePath) {
        this.id = id;
        this.name = name;
        this.history = history;
        this.imagePath = imagePath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }


}
