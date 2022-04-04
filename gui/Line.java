package gui;

import javax.swing.*;
import java.awt.*;

/**
 * https://stackoverflow.com/questions/5801734/how-to-draw-lines-in-java
 */

public class Line extends JComponent
{
    int x1, y1, x2, y2, width = 1;

    public void setParameters(int x1, int y1, int x2, int y2, int width)
    {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.width = width;
    }

    public Line (int x1, int y1, int x2, int y2, int width)
    {
        super();
        setParameters(x1, y1,x2,y2,width);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.setColor(new Color(0,0,0));
        g.drawLine(x1, y1, x2, y2);

        this.setVisible(true);

        /*int width = Math.abs( x2 - x1 );
        int height = Math.abs( y2 - y1 );

        if (width < this.width)
            width = this.width;

        if (height < this.width)
            height = this.width;

        g.fillRect(x1, y1, width, height);*/
    }
}