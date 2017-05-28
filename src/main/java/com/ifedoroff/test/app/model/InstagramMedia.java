package com.ifedoroff.test.app.model;

import com.ifedoroff.test.app.social.instagram.Instagram;

/**
 * Created by Rostik on 28.05.2017.
 */
public class InstagramMedia {
    private String minId;

    private String maxId;

    private int iterator;

    private String name;

    private Instagram instagram;

    public Instagram getInstagram() {
        return instagram;
    }

    public void setInstagram(Instagram instagram) {
        this.instagram = instagram;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setIterator(int iterator) {
        this.iterator = iterator;
    }

    public int getIterator() {
        return iterator;
    }

    public void setMaxId(String maxId) {
        this.maxId = maxId;
    }

    public String getMaxId() {
        return maxId;
    }

    public void setMinId(String minId) {
        this.minId = minId;
    }

    public String getMinId() {
        return minId;
    }
}
