package it.unibo.mvc;

import java.util.List;

/**
 * this interface models a controller that operates in the I/O using standard output. 
 */
public interface Controller {

    /**
     * @return the String you can print by calling printString().
     */
    String getString();

    /**
     * Set the String that can be further printed through printString().
     * 
     * @param s the String you wanty to print
     */
    void setString(String s);

    /**
     * prints the current String on the standard output.
     */
    void printString();

    /**
     * @return all the printed Strings.
     */
    List<String> getHistory();

}
