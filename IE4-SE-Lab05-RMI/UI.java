 

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.io.*;

/**
 * GUI or cleaning Robot app.
 * Only few of the options are included
 * @author (Divyesh Joshi)
 * @version (2.0)
 */
public class UI extends JFrame
{
    // instance variables 
    private JButton button1,button2,button3;
    private JTextArea info;
    private JPanel panel,panel1,panel2,panel3;
    private MainController command;
    /**
     * Constructor for objects of class UI
     */
    public UI()
    {
        // initialise instance variables
        button1 = new JButton("Return Home");
        button2 = new JButton("Auto Mode");
        button3 = new JButton("Pause");
        info = new JTextArea(10,50);
        info.append("Select a command:\n");
        setUpButtons();
        add(setUpPanel());
        setTitle("Cleaning Robot");
        addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent ev)
                {
                    setVisible(false);
                }
            });
        pack();

        setVisible(true);
    }

    /**
     * Sets up the actionlistener of each button

     * Creates an object of class CommandTransmittor
     * Precondition: User's clicks the desired button.
     * Postcondition: main controller object created with command.
     */
    public void setUpButtons()
    {
        button1.addActionListener(e->{
                command = new MainController("Return Home");
                info.append("\nReturn Home Mode\n");
            }
        );
        button2.addActionListener(e->{
                command = new MainController("Auto Mode");
                info.append("\nAuto Mode\n");
            }
        );
        button3.addActionListener(e->{
                command = new MainController("Pause");
                info.append("\nPause\n");
            }
        );
    }

    private Container setUpPanel()
    {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel1 = new JPanel();
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
        panel2 = new JPanel();
        panel2.add(info);
        panel.add(panel1, BorderLayout.NORTH);
        panel.add(panel2, BorderLayout.CENTER);
        return panel;
    }
}
