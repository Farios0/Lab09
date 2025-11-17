package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public class SimpleGUI {
    private final static int PROPORTION = 3;
    private final Controller controller = new Controller();
    private final JFrame frame = new JFrame("Write on a file");
    private final JPanel canvas = new JPanel();
    private final JTextArea text = new JTextArea();
    private final JButton save = new JButton("save");

    public SimpleGUI() {
        canvas.setLayout(new BorderLayout());
        canvas.add(text, BorderLayout.CENTER);
        canvas.add(save, BorderLayout.SOUTH);
        save.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.writeString(text.getText());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        frame.add(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display();
    }

    protected void display() {
        /*
         * Make the frame one third the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected. In order to deal coherently with multimonitor
         * setups, other facilities exist (see the Java documentation about this
         * issue). It is MUCH better than manually specify the size of a window
         * in pixel: it takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
    }

    protected JPanel getMainPanel() {
        return this.canvas;
    }

    protected Controller getController() {
        return this.controller;
    }

    protected JFrame getFrame() {
        return this.frame;
    }

        public static void main(String[] args) {
        SimpleGUI s = new SimpleGUI();
    }

}
