package it.unibo.mvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private String toPrint;
    private final List<String> history = new ArrayList<>();

    @Override
    public String getString() {
        if (toPrint == null) {
            throw new IllegalStateException("Set a String before calling this method");
        }
        return this.toPrint;
    }

    @Override
    public void setString(final String s) {
        Objects.requireNonNull(s);
        toPrint = s;
    }

    @Override
    public void printString() {
        Objects.requireNonNull(toPrint);
        history.add(toPrint);
        System.out.println(toPrint); // NOPMD : required by the exercise
    }

    @Override
    public List<String> getHistory() {
        return Collections.unmodifiableList(history);
    }

}
