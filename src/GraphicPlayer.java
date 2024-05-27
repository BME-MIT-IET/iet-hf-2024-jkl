import java.awt.*;
import java.awt.image.ImageObserver;

public class GraphicPlayer {
    private final int x, y;
    private final Image image;

    public GraphicPlayer(int _x, int _y, Image _image) {
        x = _x;
        y = _y;
        image = _image;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public void draw(Graphics g, ImageObserver observer) {
        //g.drawImage(image, x, y, 50, 80, observer); TODO
        //g.drawRect(x, y, 25, 40); // Placeholder
        g.drawImage(image, x, y, observer);
    }

}
