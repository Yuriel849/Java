
package client;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import javax.imageio.*;
import java.io.*;

import common.*;

/**
 * Class GraphicUI
 *
 * @author Yuriel
 * @version 2020.06.03.
 */
public class GameUI extends JFrame implements UserInterfaceable
{
    // Size preferences for this frame.
    private static final int PREFERRED_WIDTH = 1200;
    private static final int PREFERRED_HEIGHT = 600;
    private static final Dimension PREFERRED_SIZE = new Dimension(PREFERRED_WIDTH,PREFERRED_HEIGHT);

    private JTextArea gameTextArea;
    private JTextArea userTextArea;
    private Image image;
    
    /**
     * Create the frame with an image area in the center and a text area on its right,
     * and an input field with submit and clear buttons at the bottom.
     */
    public GameUI() {
        setTitle("Zuul-Apocalypse v2 Game User Interface");

        final Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(1, 2));
        contentPane.add(setupImageDisplay());
        contentPane.add(setupIOArea());

        setSize(PREFERRED_SIZE);
    }
    
    /** Displays text in a JTextArea in the GUI.
     *
     * @param msg The text to be displayed.
     */
    @Override
    public void print(String text) {
    }
    
    /**
     * Changes the image displayed in the GUI.
     * 
     * @param fileName The name of the image file to be displayed.
     */
    @Override
    public void changeImage(String fileName) {
    }
    
    @Override
    public Command getCommand() {
        return new Command("test", "test", "test");
    }
    
    public void showWindow() {
        setVisible(true);
    }

    public Dimension getPreferredSize() {
        return PREFERRED_SIZE;
    }

    /**
     * Set up the image display area.
     * @return The completed panel.
     */
    private Container setupImageDisplay() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        
        label.setSize(800, 590);
        
        try {
            image = ImageIO.read(new File("./images/room.jpg")); // File name is static for this test project
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Image scaledImage = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(scaledImage);
        label = new JLabel(imageIcon);
        panel.add(label);
        
        return panel;
    }
    
    private Container setupIOArea() {
        JPanel panel = new JPanel();
        
        panel.setLayout(new BorderLayout());
        gameTextArea = initTextArea(gameTextArea);
        userTextArea = initTextArea(userTextArea);
        panel.add(setupTextArea(gameTextArea), BorderLayout.NORTH);
        panel.add(setupTextArea(userTextArea), BorderLayout.CENTER);
        panel.add(setupUserInput(), BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JTextArea initTextArea(JTextArea textArea) {
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setFont(textArea.getFont().deriveFont(18f));
        return textArea;
    }
    
    /**
     * Set up the text area.
     * @return The completed panel.
     */
    private Container setupTextArea(JTextArea textArea) {
        // Set up the area where text will be displayed.
        JScrollPane scrollArea =
                new JScrollPane(textArea,
                                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollArea, BorderLayout.CENTER);
        return panel;
    }
    
    /**
     * Set up the user input area with one text input field and an OK button.
     * @return The completed panel.
     */
    private Container setupUserInput() {
        // Set up the label and text input field.
        Box inputLabelArea = Box.createHorizontalBox();
        inputLabelArea.add(new JLabel("  Enter command  ", JLabel.LEFT));
        inputLabelArea.add(Box.createGlue());
        final JTextField inputField = new JTextField(1000);
        inputField.setFont(inputField.getFont().deriveFont(18f));
        Box inputArea = Box.createHorizontalBox();
        inputArea.add(inputLabelArea);
        inputArea.add(inputField);

        // Set up the buttons.
        JPanel buttonArea = new JPanel();
        JButton submit = new JButton("OK");
        JButton clear = new JButton("Clear");

        // Take the necessary action to add the new details.
        submit.addActionListener(e -> {
                userTextArea.append(inputField.getText() + "\n");
                inputField.setText("");
            }
        );

        // Clear the data-entry areas.
        clear.addActionListener(e -> {
                inputField.setText("");
            }
        );
        buttonArea.add(submit);
        buttonArea.add(clear);
        inputArea.add(buttonArea);
        
        getRootPane().setDefaultButton(submit);
        
        // Layout the details area above the button area.
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(inputArea, BorderLayout.CENTER);
        return panel;
    }
}