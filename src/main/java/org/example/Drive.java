package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Drive {
    List<File> hddFiles = new ArrayList<>();
    Map<String,File> ssdFiles = new HashMap<>();
    private final String type;

    public Drive(String type) {
        this.type = type;
    }

    public void addFile(File file){
        if (type.equals("HDD")){
            hddFiles.add(file);
        } else if (type.equals("SSD")){
            ssdFiles.put(file.toString(),file);
        }
    }

    
}
