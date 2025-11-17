package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String HOME = System.getProperty("user.home");
    private File file;

    /**
     * empy constructor that initialize the default path.
     */
    public Controller() {
        file = new File(HOME 
        + File.separator 
        + "output.txt");
    }

    /**
     * file getter.
     * 
     * @return the File you're working on
     */
    public File getFile() {
        return file;
    }

    /**
     * set the File to a new file.
     * 
     * @param file you want to work on
     */
    public void setFile(final File file) {
        this.file = file;
    }

    /**
     * path getter.
     * 
     * @return the path of the file of the controller
     */
    public String getPath() {
        return file.getPath();
    }

    /**
     * write a string on the file selected.
     * 
     * @param toWrite the String to write
     * 
     * @throws IOException if there's a problem writing the file
     */
    public void writeString(final String toWrite) throws IOException {
        try (PrintStream ps = new PrintStream(getPath(), StandardCharsets.UTF_8)) {
                    ps.print(toWrite);
        }
    }

}
