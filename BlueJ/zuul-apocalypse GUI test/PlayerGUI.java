import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/**
 * Class PlayerGUI.
 *
 * @author Yuriel
 * @version 2020.05.30
 */
public class PlayerGUI extends JFrame
{
    // Size preferences for this frame.
    private static final int PREFERRED_WIDTH = 1200;
    private static final int PREFERRED_HEIGHT = 600;
    private static final Dimension PREFERRED_SIZE = new Dimension(PREFERRED_WIDTH,PREFERRED_HEIGHT);
    
    /**
     * Create the frame with an image area in the center and a text area on its right,
     * and an input field with submit and clear buttons at the bottom.
     */
    public PlayerGUI() {
        setTitle("Zuul-Apocalypse Game User Interface");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev)
            {
                setVisible(false);
            }
        });

        final Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(new JButton("north"), BorderLayout.CENTER);
        contentPane.add(setupTextArea(), BorderLayout.EAST);
        contentPane.add(setupUserInput(), BorderLayout.SOUTH);

        setSize(PREFERRED_SIZE);
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
        // Set up the area where text will be displayed.
        final JTextArea textArea = new JTextArea(10, 50);
        textArea.setEditable(false);
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
     * Set up the text area.
     * @return The completed panel.
     */
    private Container setupTextArea() {
        // Set up the area where text will be displayed.
        final JTextArea textArea = new JTextArea(10, 50);
        textArea.setEditable(false);
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
        inputLabelArea.add(new JLabel("Enter command  ", JLabel.LEFT));
        inputLabelArea.add(Box.createGlue());
        final JTextField inputField = new JTextField(30);
        Box inputArea = Box.createHorizontalBox();
        inputArea.add(inputLabelArea);
        inputArea.add(inputField);

        // Set up the buttons.
        JPanel buttonArea = new JPanel();
        JButton submit = new JButton("OK");
        JButton clear = new JButton("Clear");

        // Take the necessary action to add the new details.
        submit.addActionListener(e -> {});

        // Clear the data-entry areas.
        clear.addActionListener(e -> {
                inputField.setText("");
            }
        );
        buttonArea.add(submit);
        buttonArea.add(clear);
        inputArea.add(buttonArea);
        
        // Layout the details area above the button area.
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(inputArea, BorderLayout.CENTER);
        return panel;
    }
}