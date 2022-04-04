package gui;

import javax.swing.*;

public abstract class Button extends JButton
{
    public static final int BUTTON_WIDTH = 80, BUTTON_HEIGHT = 25;

    public Button (String buttonName)
    {
        super(buttonName);
    }

    public abstract void useButton();

    public void setPosition(int positionX, int positionY)
    {
        this.setBounds(positionX, positionY, BUTTON_WIDTH, BUTTON_HEIGHT);
    }
}
