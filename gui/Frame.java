package gui;

import org.w3c.dom.html.HTMLIsIndexElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Frame extends JFrame implements ActionListener
{
    public static final int FRAME_WIDTH = 600, FRAME_HEIGHT = 600, VERTICAL_MARGIN = 25, HORIZONTAL_MARGIN = 15;

    static ArrayList<Button> buttons = new ArrayList<>();

    public Frame ()
    {
        this.setTitle("PA_Lab6");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);

        JPanel panel = new JPanel();
        this.add(panel);
        panel.setBounds(0 ,0 ,FRAME_WIDTH, FRAME_HEIGHT);
        panel.setLayout(null);

        JLabel gridSizeLabel = new JLabel( "Grid size: " );
        gridSizeLabel.setBounds( 25, 30, 60, Button.BUTTON_HEIGHT );
        panel.add(gridSizeLabel);

        JSpinner xGridSize = new JSpinner();
        xGridSize.setModel( new SpinnerNumberModel(75,50,100,1) );
        xGridSize.setBounds( 125, 30,40, Button.BUTTON_HEIGHT );

        JSpinner yGridSize = new JSpinner();
        yGridSize.setModel( new SpinnerNumberModel(75,50,100,1) );
        yGridSize.setBounds( 170, 30,40, Button.BUTTON_HEIGHT );

        CreateButton createButton = new CreateButton("Create");
        createButton.setPosition(  215, 30  );

        panel.add(xGridSize);
        panel.add(yGridSize);
        panel.add(createButton);

        SaveButton saveButton = new SaveButton("Save");
        LoadButton loadButton = new LoadButton("Load");
        saveButton.setPosition( (FRAME_WIDTH / 2 - Button.BUTTON_WIDTH - HORIZONTAL_MARGIN), (FRAME_HEIGHT - Button.BUTTON_HEIGHT * 3)  );
        loadButton.setPosition( (FRAME_WIDTH / 2 -  + HORIZONTAL_MARGIN), (FRAME_HEIGHT - Button.BUTTON_HEIGHT * 3)  );


        buttons.add(saveButton);
        buttons.add(loadButton);
        buttons.add(createButton);

        panel.add(saveButton);
        panel.add(loadButton);

        Line line = new Line(0 ,300 ,0, 600, 1);

        panel.add(line);

        int dbg = 0;

        panel.setVisible(true);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        for (Button button : buttons)
        {
            if (e.getSource() == button)
                button.useButton();
        }
    }
}
