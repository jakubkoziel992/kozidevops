package pl.java_application;

public class Monitor {
    private final String name;
    private int width;
    private int height;

    public Monitor(String name) {
        this.name = name;
        setHightResolution();
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
