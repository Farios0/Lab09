package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser extends SimpleGUI {

    private final JPanel pane = new JPanel();
    private final JButton browse = new JButton("Browse...");
    private final JTextArea rOnly = new JTextArea();
    private final JFileChooser chooser = new JFileChooser(getController().getPath());

    /**
     * empty constructor that extends the work of the superclass by adding new
     * textfield and button.
     */
    public SimpleGUIWithFileChooser() {
        super();
        getFrame().setVisible(false);
        pane.setLayout(new BorderLayout());
        rOnly.setEditable(false);
        rOnly.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        rOnly.setText(getController().getPath());
        pane.add(rOnly, BorderLayout.CENTER);
        pane.add(browse, BorderLayout.EAST);
        getMainPanel().add(pane, BorderLayout.NORTH);
        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                final int risultato = chooser.showOpenDialog(null);
                if (risultato == JFileChooser.APPROVE_OPTION) {
                    final File fileSelezionato = chooser.getSelectedFile();
                    getController().setFile(fileSelezionato);
                    rOnly.setText(fileSelezionato.getPath());
                }
            }

        }); 

        getFrame().setVisible(true);
    }

    /**
     * instantiate a new object of the class, whic is already visible and ready.
     * 
     * @param args here are useless
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser();
    }

}
