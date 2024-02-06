package pl.java_application.usbdevice;

public interface USBDevice {
    boolean connect();
    boolean disconnect();
    String getName();
}
