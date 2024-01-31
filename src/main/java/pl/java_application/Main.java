package pl.java_application;

import pl.java_application.drive.SSDDrive;
import pl.java_application.usbdevice.MemoryStick;
import pl.java_application.usbdevice.Mouse;
import pl.java_application.usbdevice.USBDevice;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor("Dell");
        SSDDrive ssdDrive = new SSDDrive();

        Computer computer = new Computer(monitor, ssdDrive);

        //computer.addFile(new File("file.png"));
        //computer.listFiles();

        Mouse mouse = new Mouse("Mysz");
        MemoryStick memoryStick = new MemoryStick("Pendrive");

        computer.addUSBDevice(mouse);
        computer.addUSBDevice(memoryStick);

        computer.removeUSBDevice(mouse);
/*
        List<USBDevice> usbDevices = computer.getUsbDevices();

        for (USBDevice device: usbDevices){
            System.out.println(device.getName());
        }
*/
        memoryStick.eject();
        computer.removeUSBDevice(memoryStick);




    }
}