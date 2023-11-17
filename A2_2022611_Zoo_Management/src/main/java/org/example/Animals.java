package org.example;
import java.util.*;
public class Animals extends Admin{
    private String name;
    private String noise;

    public Animals() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNoise() {
        return noise;
    }

    public void setNoise(String noise) {
        this.noise = noise;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    private String type;
    private String about;
    Animals(String name, String type, String noise, String about){
        this.name= name;
        this.type=type;
        this.noise=noise;
        this.about = about;

    }
    @Override
    public String toString() {
        return "Animals" + '\n' +
                "name: " + name + '\n' +
                "noise: " + noise + '\n' +
                "type: " + type + '\n' +
                "about: " + about;
    }
}
