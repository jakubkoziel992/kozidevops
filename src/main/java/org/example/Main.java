package org.example;

public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor("Dell");
        System.out.println(monitor.getResolution());

        monitor.setLowResolution();
        System.out.println(monitor.getResolution());
    }
}