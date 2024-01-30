package org.example;

public class Monitor {
    private final String name;
    private int width = 3840;
    private int height = 1920;

    public Monitor(String name) {
        this.name = name;
    }

    public void setHightResolution(){
        width = 3840;
        height = 1920;
    }

    public void setLowResolution(){
        width = 800;
        height = 600;
    }

    public String getResolution(){
        return width + "x" + height;
    }



}
