package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser extends SimpleGUI{

    private final JPanel pane = new JPanel();
    private final JButton browse = new JButton("Browse...");
    private final JTextArea rOnly = new JTextArea();
    private final JFileChooser chooser = new JFileChooser();

    public SimpleGUIWithFileChooser() {
        super();
        getFrame().setVisible(false);
        pane.setLayout(new BorderLayout());
        rOnly.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1, true));
        rOnly.setText(getController().getPath());
        pane.add(rOnly, BorderLayout.CENTER);
        pane.add(browse, BorderLayout.EAST);
        getMainPanel().add(pane, BorderLayout.NORTH);
        browse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            }
            
        }); {

        }
        getFrame().setVisible(true);
    }
    
    public static void main(String[] args) {
        SimpleGUIWithFileChooser s = new SimpleGUIWithFileChooser();
    }

}
