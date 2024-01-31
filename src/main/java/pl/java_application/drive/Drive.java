package pl.java_application.drive;

import pl.java_application.file.File;

public interface Drive {
    void addFile(File file);
    void listFiles();
    File findFile(String fileName);

}
