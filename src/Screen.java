import java.util.ArrayList;

import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Screen extends JPanel{
    public Screen() {
        super();
    }

    /**
     * Paints this Screen.
     * @param g
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        ArrayList<Wall> walls = new ArrayList<Wall>();
        for (int i = 0; i < 50; ++i) {
            walls.add(new Wall(i * 20, 0, 20, 20));
            g2d.setColor(walls.get(i).getColour());
            g2d.draw(walls.get(i));
        }
    }
}
