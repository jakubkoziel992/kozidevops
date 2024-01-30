package org.example;

public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor("Dell");
        HDDDrive hddDrive = new HDDDrive();

        Computer computer = new Computer(monitor, hddDrive);
        hddDrive.addFile(new File("photo.jpg"));
        hddDrive.listFiles();
    }
}