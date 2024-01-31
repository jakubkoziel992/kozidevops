package pl.java_application.file.image;

import pl.java_application.file.File;
import pl.java_application.file.FileType;

public class JPGImageFile implements File {
    private final String name;
    private final int size;
    private final int compression;


    public JPGImageFile(String name, int size, int compression) {
        this.name = name;
        this.size = size;
        this.compression = compression;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public FileType getType() {
        return FileType.IMAGE;
    }

    public int getCompression() {
        return compression;
    }

    public void showImage(){
        System.out.println("Showing image");
    }
}
