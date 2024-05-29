import java.awt.*;
import java.awt.image.ImageObserver;


public class GraphicPipe extends GraphicField {
    private final int x1, y1, x2, y2;
    private boolean hasWater;

    private boolean isBroken;

    public GraphicPipe(String name, int _x1, int _y1, int _x2, int _y2, boolean _hasWater, boolean _isbroken) {
        super(_x1, _y1, name, null);
        x1 = _x1; y1 = _y1;
        x2 = _x2; y2 = _y2;
        hasWater = _hasWater;
        isBroken = _isbroken;
    }

    @Override
    public int getX() {
        return ((x1 + x2) / 2 - 50);
    }

    @Override
    public int getY() {
        return ((y1 + y2) / 2 - 50);
    }

    @Override
    public void draw(Graphics g, ImageObserver observer) {
        Graphics2D g2d = (Graphics2D) g;
        if (hasWater)
            g2d.setColor(Color.BLUE);
        else if (isBroken)
            g2d.setColor(Color.RED);
        else
            g2d.setColor(Color.DARK_GRAY);
        g2d.setStroke(new BasicStroke(16));
        g2d.drawLine(x1, y1, x2, y2);
    }
}
