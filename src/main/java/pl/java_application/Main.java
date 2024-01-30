package pl.java_application;

import pl.java_application.drive.SSDDrive;

public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor("Dell");
        SSDDrive ssdDrive = new SSDDrive();

        Computer computer = new Computer(monitor, ssdDrive);

        computer.addFile(new File("file.png"));
        computer.listFiles();
    }
}