import java.awt.*;
import java.awt.image.ImageObserver;

public class GraphicField {
    private final int x;
    private final int y;
    private final String name;
    private final Image image;

    public GraphicField(int x, int y, String name, Image image) {
        this.x = x;
        this.y = y;
        this.name = name;
        this.image  = image;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public String getName() { return name; }

    public void draw(Graphics g, ImageObserver observer) {
        //g.drawImage(image, x - 25, y - 40, 100, 100, observer); TODO
        //g.drawOval(x, y, 50, 50); // Placeholder
        g.drawImage(image, x, y, observer);
    }
}
