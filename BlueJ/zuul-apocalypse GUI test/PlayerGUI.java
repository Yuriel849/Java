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
    private static final int PREFERRED_WIDTH = 500;
    private static final int PREFERRED_HEIGHT = 500;
    private static final Dimension PREFERRED_SIZE =
                            new Dimension(PREFERRED_WIDTH,PREFERRED_HEIGHT);
    
    /**
     * Create the frame with an image area at the top, a text area in the middle, and an input field with button at the bottom.
     */
    public PlayerGUI()
    {
        setTitle("Zuul-Apocalypse Game User Interface");
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev)
            {
                setVisible(false);
            }
        });

        final Container contentPane = getContentPane();
//        contentPane.add(setupImageDisplay());
//        contentPane.add(setupTextArea());
        contentPane.add(setupUserInput());

        setSize(PREFERRED_SIZE);
    }
    
    public void showWindow()
    {
        setVisible(true);
    }

    public Dimension getPreferredSize()
    {
        return PREFERRED_SIZE;
    }

    /**
     * Set up the user input area with one text input field and an OK button.
     * @return The completed panel.
     */
    private Container setupUserInput()
    {
        // Set up the text input field.
        Box inputLabelArea = Box.createHorizontalBox();
        inputLabelArea.add(new JLabel("Enter command", JLabel.LEFT));
        inputLabelArea.add(Box.createGlue());
        final JTextField inputField = new JTextField(30);
        Box inputArea = Box.createVerticalBox();
        inputArea.add(inputLabelArea);
        inputArea.add(inputField);

        // Layout the entry-details fields in a panel.
        Box singleLineFields = Box.createVerticalBox();
        singleLineFields.add(inputArea);
        JPanel detailsPanel = new JPanel();
        detailsPanel.add(singleLineFields);

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

        // Layout the details area above the button area.
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(detailsPanel, BorderLayout.CENTER);
        panel.add(buttonArea, BorderLayout.SOUTH);
        return panel;
    }
}