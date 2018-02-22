
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
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
 * 
 * Important: Update File paths.
 */
public class window extends JPanel {
    
    private BufferedImage img, img2;
    private Listener theListener;
    private int x, y;
    private boolean selected = false;

//private Graphics2D g2;
    
    
    public static final int SCALE = 8;
    
        public void paintComponent(Graphics g){ //Everything that is drawn to the screen is done here
        g.drawImage(img, 0, 0, 1024, 768, null);
            g.drawImage(img2, x, y, null);
        g.setColor(Color.BLUE);
        //g.fillRect(x, y, 50, 50);
        //goal.getX();
        }
        
    public window() throws IOException { //win2 initializer
        /*
    //going to move all of this to a resource loader class
    File f = new File ("\\Map1.png"); //Relative path
    if (f.canRead() != true){ //If it cant read the file, try absolute path\src\*File.png*
    f = new File ( new File("src").getAbsolutePath() + "\\Map1.png");
    }
System.out.println(f); //test line to check filename
img = new BufferedImage(1024,768, BufferedImage.TYPE_INT_ARGB); //Buffered png file "ARGB"
img = ImageIO.read(f); //read the file into the buffer.
Tree goal = new Tree();
goal.tree(500, 50);

treeX = goal.getX();
treeY = goal.getY();
img2=goal.getPic();

*/
        Stats Game_Stats = new Stats();
        Game_Stats.Statsinit(); //made a new stat object
        img = Game_Stats.getBListItem(0);
        img2 = Game_Stats.getBListItem(2);
theListener = new Listener(); //create new private mouse listener
this.addMouseListener(theListener); //add mouse listener to jpanel.
        }
    private class Listener implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent mouse) {
            int Mx = mouse.getX();
            int My = mouse.getY();
            if(Mx <= x+50 && Mx >= x-50 && My <= y+50 && My >= y-50){
                System.out.println("meow");
            }
            if(selected = false){
                selected = true;
                
            }else {
                selected = false;
            }
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
        public void mouseEntered(MouseEvent mouse) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
       }
        
    }
}
