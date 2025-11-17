package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String home = System.getProperty("user.home");
    private File file;

    public Controller() {
        file = new File(home 
        + File.separator 
        + "output.txt");
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getPath() {
        return file.getPath();
    }

    public void writeString(String toWrite) throws IOException {
        try (PrintStream ps = new PrintStream(getPath(), StandardCharsets.UTF_8)) {
                    ps.print(toWrite);
        }
    }


    
}
