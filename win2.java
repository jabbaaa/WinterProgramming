
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 *
 * @author Dragon
 */
public class win2 extends JPanel {
    
    private BufferedImage img;
    private Graphics2D g2;
    
    public static final int SCALE = 8;
    
        public void paintComponent(Graphics g){
        g.drawImage(img, 0, 0, 1024, 768, null);
        g.setColor(Color.BLUE);
        g.fillRect(450, 715, 50, 50);
        }
        
        public win2() throws IOException {
File f = new File ("C:\\Users\\Dragon\\Documents\\NetBeansProjects\\Classwork\\src\\Map1.png");
img = new BufferedImage(1024,768, BufferedImage.TYPE_INT_ARGB);
img = ImageIO.read(f);
g2 = (Graphics2D) img.getGraphics();
        }
}
