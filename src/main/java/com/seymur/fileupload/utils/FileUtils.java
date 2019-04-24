package com.seymur.fileupload.utils;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.InputStream;

public class FileUtils {

    public static boolean checkIfImage(InputStream is){

        try {
            ImageIO.read(is);
            return false;
        } catch(IOException ex) {
           return false;
        }
    }
}
