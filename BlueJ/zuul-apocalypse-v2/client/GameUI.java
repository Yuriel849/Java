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
 * @version 2020.06.04.
 */
public class GameUI extends JFrame implements UserInterfaceable
{
    // Size preferences for this frame.
    private static final int PREFERRED_WIDTH = 1200;
    private static final int PREFERRED_HEIGHT = 600;
    private static final Dimension PREFERRED_SIZE = new Dimension(PREFERRED_WIDTH,PREFERRED_HEIGHT);
    private static final int IMG_PREFERRED_WIDTH = 800;
    private static final int IMG_PREFERRED_HEIGHT = 600;
    private static final Dimension IMAGE_PREFERRED_SIZE = new Dimension(IMG_PREFERRED_WIDTH,IMG_PREFERRED_HEIGHT);

    private JTextArea upperTextArea;
    private JTextArea lowerTextArea;
    private JLabel imageLabel = new JLabel();
    
    // Input text field
    private JTextField inputField;
    private LinkedList<Command> outstandingCommands;

    /**
     * Create the frame with an image area in the center and a text area on its right,
     * and an input field with submit and clear buttons at the bottom.
     */
    public GameUI() {
        outstandingCommands = new LinkedList<Command>();
        
        setTitle("Zuul-Apocalypse v2 Game User Interface");

        final Container contentPane = getContentPane();
        contentPane.setLayout(new GridLayout(1, 2));
        contentPane.add(setupImageDisplay());
        contentPane.add(setupIOArea());

        setSize(PREFERRED_SIZE);
    }
    
    /**
     * Displays text about the game in the upper JTextArea in the GUI.
     *
     * @param msg The text to be displayed.
     */
    @Override
    public void printUpper(String text) {
        upperTextArea.append(text);
        upperTextArea.append("\n");
    }
    
    /**
     * Displays text about the game in the lower JTextArea in the GUI.
     *
     * @param msg The text to be displayed.
     */
    @Override
    public void printLower(String text) {
        lowerTextArea.append(text);
    }
    
    /**
     * Changes the image displayed in the GUI.
     * 
     * @param newImage The new Image object to be displayed.
     */
    @Override
    public void changeImage(Image newImage) {
        imageLabel.setIcon(new ImageIcon(newImage.getScaledInstance(IMG_PREFERRED_WIDTH, IMG_PREFERRED_HEIGHT, Image.SCALE_SMOOTH)));
    }
    
    /**
     * Returns the first three words of the user input to the game engine.
     * Resets the three Strings commandFirst, commandSecond, commandThird to empty Strings ("").
     * 
     * @return Command object containing the first three words of the user input.
     */
    @Override
    public Command getCommand() {
        if(outstandingCommands.isEmpty()) {
            return new Command(null, null, null);
        }
        else
            return outstandingCommands.poll();
    }
    
    public void enable() {
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
        Image image = null;
        
        try {
            image = ImageIO.read(new File("./images/room.jpg")); // When starting the GUI for the first time, loads this image as the initial image
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(IMG_PREFERRED_WIDTH, IMG_PREFERRED_HEIGHT, Image.SCALE_SMOOTH));
        imageLabel.setIcon(imageIcon);
        
        return imageLabel;
    }
    
    private Container setupIOArea() {
        JPanel panel = new JPanel();
        
        panel.setLayout(new BorderLayout());
        upperTextArea = initTextArea(upperTextArea);
        lowerTextArea = initTextArea(lowerTextArea);
        panel.add(setupTextArea(upperTextArea), BorderLayout.NORTH);
        panel.add(setupTextArea(lowerTextArea), BorderLayout.CENTER);
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
        // Set up the text input field.
        inputField = new JTextField(1000);
        inputField.setFont(inputField.getFont().deriveFont(18f));
        Box inputArea = Box.createHorizontalBox();
        inputArea.add(inputField);

        // Set up the buttons.
        JPanel buttonArea = new JPanel();
        JButton submit = new JButton("OK");
        JButton clear = new JButton("Clear");

        // Take the first three words of the user input and put them into the three Strings, commandFirst, commandSecond, commandThird.
        submit.addActionListener(e -> {
            String inputLine;   // will hold the full input line
            String word1 = null;
            String word2 = null;
            String word3 = null;
    
            inputLine = inputField.getText().trim();
    
            // Find up to two words on the line.
            Scanner tokenizer = new Scanner(inputLine);
            if(tokenizer.hasNext()) {
                word1 = tokenizer.next();      // get first word
                if(tokenizer.hasNext()) {
                    word2 = tokenizer.next();      // get second word
                    if(tokenizer.hasNext()) {
                    word3 = tokenizer.next();      // get second word
                    // note: we just ignore the rest of the input line.
                    } 
                }
            }
            Command returnCommand = new Command(word1, word2, word3);
            // Setting text field to empty string after processing command
            inputField.setText("");
            
            // Now check whether this word is known. If so, create a command
            // with it. If not, create a "null" command (for unknown command).
            if(returnCommand.isCommand()) {
                outstandingCommands.add(returnCommand);
            }
            else {
                outstandingCommands.add(new Command(null, word2, word3));
            }
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