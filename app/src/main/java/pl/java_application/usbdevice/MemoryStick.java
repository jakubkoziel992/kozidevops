package pl.java_application.usbdevice;

public class MemoryStick implements USBDevice{
    private final String name;
    private boolean ejected = false;

    public MemoryStick(String name) {
        this.name = name;
    }

    @Override
    public boolean connect() {
        System.out.println("Memory Stick connected");
        return true;
    }

    @Override
    public boolean disconnect() {
        if (ejected){
            System.out.println("Memory Stick disconnected");
            return true;
        } else {
            System.out.println("Please Memory Stick disconnect first!");
            return false;
        }
    }

    @Override
    public String getName() {
        return name;
    }

    public void eject(){
        System.out.println("Ejected Memory Stick");
        ejected = true;
    }
}
