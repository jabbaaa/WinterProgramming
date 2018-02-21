
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Dragon
 * Since this is working code, I wont change it at the moment, extends Jpanel... is an alternative to new Jpanel. It is more confusing to
 * use it like this, for someone who hasn't experience with JPanel or JFrames.
 */
public class win2 extends JPanel {
    
    private BufferedImage img;
    private Listener theListener;
    private int x, y;
    //private Graphics2D g2;
    
    public static final int SCALE = 8;
    
        public void paintComponent(Graphics g){
        g.drawImage(img, 0, 0, 1024, 768, null);
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 50, 50);
        }
        
    private class Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            x = e.getX();
            y = e.getY();
            System.out.println("x,y pos:" + x + "," + y);
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
       }
        
    }
        
    public win2() throws IOException { //win2 initializer
File f = new File ("C:\\Users\\Dragon\\Documents\\NetBeansProjects\\Classwork\\src\\Map1.png");
img = new BufferedImage(1024,768, BufferedImage.TYPE_INT_ARGB);
img = ImageIO.read(f);
//this.addMouseListener(theListener);
//g2 = (Graphics2D) img.getGraphics();
theListener = new Listener();
this.addMouseListener(theListener);
        }
}
