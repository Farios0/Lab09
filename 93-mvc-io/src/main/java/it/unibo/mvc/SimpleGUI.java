package it.unibo.mvc;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private static final int PROPORTION = 3;
    private final Controller controller = new SimpleController();
    private final JFrame frame = new JFrame("I/O");
    private final JPanel canvas = new JPanel();
    private final JPanel pane = new JPanel();
    private final JTextField textToPrint = new JTextField();
    private final JTextArea textToShow = new JTextArea();
    private final JButton print = new JButton("Print");
    private final JButton showHistory = new JButton("Show history");

    public SimpleGUI(){
        frame.add(canvas);
        canvas.setLayout(new BorderLayout());
        pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
        canvas.add(textToPrint, BorderLayout.NORTH);
        canvas.add(textToShow, BorderLayout.CENTER);
        pane.add(print);
        pane.add(showHistory);
        canvas.add(pane, BorderLayout.SOUTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        print.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                controller.setString(textToPrint.getText());
                controller.printString();
            }
            
        });
        showHistory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                textToShow.setText(controller.getHistory().toString());
            }
            
        });
        display();
    }

        private void display() {

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

    public static void main(final String[] args) {
        new SimpleGUI();
    }

}
