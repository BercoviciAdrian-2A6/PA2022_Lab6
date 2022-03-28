package gui;

import com.sun.nio.sctp.PeerAddressChangeNotification;

import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;

public class Window
{
    JFrame frame;
    JPanel panel;

    public Window ()
    {
        frame = new JFrame("PA lab 6");
        panel = new JPanel();

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout( null );

        JLabel gridSizeLabel = new JLabel( "Grid size: " );
        gridSizeLabel.setBounds( 10,0, 60, 25 );
        panel.add(gridSizeLabel);

        /*JTextField gridSizeTextField = new JTextField(1);
        gridSizeTextField.setBounds(100,20, 165, 25);
        panel.add(gridSizeTextField);*/

        JSpinner xGridSize = new JSpinner();
        xGridSize.setModel( new SpinnerNumberModel(75,50,100,1) );
        xGridSize.setBounds( 75, 0,40, 25 );
        JSpinner yGridSize = new JSpinner();
        yGridSize.setModel( new SpinnerNumberModel(75,50,100,1) );
        yGridSize.setBounds( 120, 0,40, 25 );
        panel.add(xGridSize);
        panel.add(yGridSize);

        JButton createButton = new JButton("Create");
        createButton.setBounds(165, 0 , 80, 25);
        panel.add(createButton);

        JButton loadButton = new JButton("Load");
        loadButton.setBounds(250 - 5 - 80, 425 , 80, 25);
        panel.add(loadButton);

        JButton saveButton = new JButton("Save");
        saveButton.setBounds(250 + 5, 425 , 80, 25);
        panel.add(saveButton);

        frame.add(panel);
        frame.setVisible(true);
    }
}
