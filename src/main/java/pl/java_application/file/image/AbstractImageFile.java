package pl.java_application.file.image;

import pl.java_application.file.AbstractFile;
import pl.java_application.file.FileType;

public  class AbstractImageFile extends AbstractFile {


    public AbstractImageFile(String name, int size) {
        super(name,size);
    }

    @Override
    public FileType getType() {
        return FileType.IMAGE;
    }
}
