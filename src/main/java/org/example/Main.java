package org.example;

public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor("Dell");
        SSDDrive ssdDrive = new SSDDrive();

        Computer computer = new Computer(monitor, ssdDrive);
        
        computer.addFile(new File("file.png"));
        computer.listFiles();
    }
}