package pl.java_application;

import pl.java_application.drive.Drive;
import pl.java_application.drive.HDDDrive;
import pl.java_application.drive.SSDDrive;
import pl.java_application.file.File;
import pl.java_application.file.image.GIFImageFile;
import pl.java_application.file.image.JPGImageFile;
import pl.java_application.file.music.MP3File;
import pl.java_application.usbdevice.MemoryStick;
import pl.java_application.usbdevice.Mouse;
import pl.java_application.usbdevice.USBDevice;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Monitor monitor = new Monitor("Dell");
        Drive ssdDrive = new HDDDrive();

        Computer computer = new Computer(monitor, ssdDrive);

        MP3File mp3File = new MP3File("audio.mp3", 4000,
                "Rammstein", "Sonne", 100);

        GIFImageFile gifImageFile = new GIFImageFile("funnydig.git", 150);
        JPGImageFile jpgImageFile = new JPGImageFile("photo.jpg", 400, 80);

        computer.addFile(mp3File);
        computer.addFile(gifImageFile);
        computer.addFile(jpgImageFile);

        computer.listFiles();
        File file = computer.findFile("audio.mp3");
        System.out.println(file.getName());
        System.out.println(file);

        //computer.addFile(new File("file.png"));
        //computer.listFiles();

       // Mouse mouse = new Mouse("Mysz");
       // MemoryStick memoryStick = new MemoryStick("Pendrive");

        //computer.addUSBDevice(mouse);
        //computer.addUSBDevice(memoryStick);

       // computer.removeUSBDevice(mouse);
/*
        List<USBDevice> usbDevices = computer.getUsbDevices();

        for (USBDevice device: usbDevices){
            System.out.println(device.getName());
        }
*/
       // memoryStick.eject();
       // computer.removeUSBDevice(memoryStick);




    }
}