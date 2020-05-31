import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import javax.imageio.*;
import java.io.*;

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
    private JTextArea textArea;
    
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
        contentPane.add(setupImageDisplay(), BorderLayout.CENTER);
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
        JPanel panel = new JPanel();
        JLabel label = new JLabel();
        Image image = null;
        
        label.setSize(800, 590);
        
        try {
            image = ImageIO.read(new File("./DSC02883.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Image scaledImage = image.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon imageIcon = new ImageIcon(scaledImage);
        label = new JLabel(imageIcon);
        panel.add(label);
        
        return panel;
    }
    
    /**
     * Set up the text area.
     * @return The completed panel.
     */
    private Container setupTextArea() {
        // Set up the area where text will be displayed.
        textArea = new JTextArea(10, 50);
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
        inputLabelArea.add(new JLabel("  Enter command  ", JLabel.LEFT));
        inputLabelArea.add(Box.createGlue());
        final JTextField inputField = new JTextField(1000);
        inputField.setFont(inputField.getFont().deriveFont(10f));
        Box inputArea = Box.createHorizontalBox();
        inputArea.add(inputLabelArea);
        inputArea.add(inputField);

        // Set up the buttons.
        JPanel buttonArea = new JPanel();
        JButton submit = new JButton("OK");
        JButton clear = new JButton("Clear");

        // Take the necessary action to add the new details.
        submit.addActionListener(e -> {
                textArea.append(inputField.getText() + "\n");
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
        
        // Layout the details area above the button area.
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(inputArea, BorderLayout.CENTER);
        return panel;
    }
}