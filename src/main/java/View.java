import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class View
{
    private ArrayList<GraphicField> fields = new ArrayList<>();
    private ArrayList<GraphicPlayer> players = new ArrayList<>();
    private double zoomLevel;
    private double cameraX, cameraY;

    private CanvasObject canvas;
    private final HUD f;
    private final Controller ctrl;

    private void parseFields(ArrayList<FieldDescription> _flds) {
        fields = new ArrayList<>();

        for(FieldDescription fd : _flds) {
            //Add pipe
            if(fd.getType() == FieldType.PIPE) {
                // Map coordinates to screen (-1, 1) to (0, width) and (0, height)
                fields.add(new GraphicPipe( fd.getName(),
                                            (int)((fd.getCoordinates().get(0) + 1) / 2 * (double)canvas.getWidth()),
                                            (int)((fd.getCoordinates().get(1) + 1) / 2 * (double)canvas.getHeight()),
                                            (int)((fd.getCoordinates().get(2) + 1) / 2 * (double)canvas.getWidth()),
                                            (int)((fd.getCoordinates().get(3) + 1) / 2 * (double)canvas.getHeight()),
                        fd.hasWater(),
                        fd.isBroken()
                ));
            }

            // Add ActiveField
            else {
                /*
                // Type is UPPERCASE! TODO:
                Image img = Toolkit.getDefaultToolkit().getImage("images/" + fd.getType().toString() + ".png");

                // Map coordinates to screen (-1, 1) to (0, width) and (0, height)
                fields.add(new GraphicField((int)((fd.getCoordinates().get(0) + 1) / 2 * (double)canvas.getWidth()),
                                            (int)((fd.getCoordinates().get(1) + 1) / 2 * (double)canvas.getHeight()),
                                            img
                ));
                */
                String path = System.getProperty("user.dir");
                //Image img = Toolkit.getDefaultToolkit().getImage(path + "\\images\\" + pd.getType().toString() + ".png");
                try {
                    BufferedImage img = ImageIO.read(new File( path + "\\images\\" + fd.getType().toString().toLowerCase() + ".png"));
                    fields.add(new GraphicField((int)((fd.getCoordinates().get(0) + 1) / 2 * (double)canvas.getWidth()) - 50,
                            (int)((fd.getCoordinates().get(1) + 1) / 2 * (double)canvas.getHeight()) - 50,
                            fd.getName(),
                            img
                    ));


                } catch (IOException ioe) {

                }
            }

        }
    }

    private void parsePlayers(ArrayList<PlayerDescription> _pls) {
        players = new ArrayList<>();
        for(PlayerDescription pd : _pls) {
            String path = System.getProperty("user.dir");
            //Image img = Toolkit.getDefaultToolkit().getImage(path + "\\images\\" + pd.getType().toString() + ".png");
            try {
                BufferedImage img = ImageIO.read(new File( path + "\\images\\" + pd.getType().toString() + ".png"));
                /*
                if (img == null)
                    System.out.println("jskfaljksd");
                 */
                GraphicField currentField = getFieldByName(pd.getStandingOnName(), fields);
                players.add(new GraphicPlayer(currentField.getX(), currentField.getY(), img));

            } catch (IOException ioe) {

            }





        }
    }

    private GraphicField getFieldByName(String name, ArrayList<GraphicField> _flds) {
        for(GraphicField field : _flds) {
            if(field.getName().equals(name))
                return field;
        }
        return null;
    }

    public View(Controller c) {
        JPanel gamePanel = new JPanel(); // this is where the game will be drawn (without the HUD)
        canvas = new CanvasObject();

        ctrl = c;

        // creating a frame
        f = new HUD(gamePanel);
        f.setTitle("Desert of Drukmakor - meno_melosok");
        f.setResizable(false);
        f.setSize(1600, 900);
        f.setVisible(true);

        // adding canvas to frame
        gamePanel.add(canvas);

        f.setPunctureButtonListener     (e -> f.setInfo(ctrl._break()       ? "Pipe punctured"  : "Puncture failed"));
        f.setPlacePipeButtonListener    (e -> f.setInfo(ctrl.placePipe()    ? "Pipe placed"     : "Pipe placement failed"));
        f.setPickUpPumpButtonListener   (e -> f.setInfo(ctrl.pickUpPump()   ? "Pump picked up"  : "Pump pickup failed"));
        f.setPlacePumpButtonListener    (e -> f.setInfo(ctrl.placePump()    ? "Pump placed"     : "Pump placement failed"));
        f.setFixPipeButtonListener      (e -> f.setInfo(ctrl.repair()       ? "Pipe fixed"      : "Pipe fixing failed"));
        f.setFixPumpButtonListener      (e -> f.setInfo(ctrl.repair()       ? "Pump fixed"      : "Pump fixing failed"));
        f.setMakeStickyButtonListener   (e -> f.setInfo(ctrl.makeSticky()   ? "Pipe made sticky": "Pipe making failed"));
        f.setPassButtonListener         (e -> f.setInfo(ctrl.pass()         ? "Turn passed"     : "Passing failed"));
    }

    public void update(ArrayList<FieldDescription> _flds, ArrayList<PlayerDescription>_pls) {
        parseFields(_flds);
        parsePlayers(_pls);
        canvas.repaint();

        f.setCurrentPlayer(ctrl.getActivePlayerName());
        f.setMechPoints(ctrl.getMechanicPoints());
        f.setSabPoints(ctrl.getSaboteurPoints());
    }

    class CanvasObject extends Canvas {
        public CanvasObject() {
            setBackground (Color.GRAY);
            setSize(1584, 809);
            addMouseListener(new MouseEvents());
        }

        // paint() method to draw inside the canvas
        public void paint(Graphics g) {
            for(int i = 0; i < fields.size(); i++) {
                fields.get(i).draw(g, this);
            }

            for(int i = 0; i < players.size(); i++) {
                players.get(i).draw(g, this);
            }
        }
    }

    class MouseEvents extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            Point click = e.getPoint();
            Point closest = new Point(99999, 99999);
            GraphicField closestField = fields.get(0);
            for(GraphicField field : fields) {
                Point fieldPoint = new Point(field.getX(), field.getY());
                if(fieldPoint.distance(click) < closest.distance(click)) {
                    closest = fieldPoint;
                    closestField = field;
                }
            }
            f.setInfo(ctrl.move(closestField.getName()) ? "Moved to " + closestField.getName() : "Move failed to " + closestField.getName());
        }
        public void mouseWheelMoved(MouseWheelEvent e) {
            throw new UnsupportedOperationException();
            // TODO: implement
        }
    }

    class KeyboardEvents extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            throw new UnsupportedOperationException();
            // TODO: implement
        }
    }
}











