
package proxy;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String[] img_extensions = {"bmp", "png", "jpeg", "jpg", "gif"};
    
    public static void main(String[] args) throws IOException {
        ArrayList<ProxyImage> photos = new ArrayList();
        
        File dir = new File("./img");
        File[] files = dir.listFiles((File f) -> {
            String filename = f.getName();
            int ext_index = filename.lastIndexOf('.');
            if(f.isFile() && ext_index != -1) {
                String extension = filename
                        .substring(ext_index + 1)
                        .toLowerCase();
                return Arrays.asList(img_extensions).contains(extension);
            }
            else return false;
        });
        
        for (File f : files)
            photos.add(new ProxyImage(f.getCanonicalPath()));
        for (Image i : photos) 
            i.showData();
        for (Image i : photos) 
            i.displayImage();
    }
}
