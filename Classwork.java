/**
 *
 * @author Dragon
 */
import java.io.IOException;
import javax.swing.JFrame;
public class Classwork {
    /**
     * Driver Class
     */
    public static void main(String[] args) {
        //SoundNode meow = new SoundNode();
        //toySoldiers.main();       
        //mew.window();}
        Classwork n = new Classwork();
        try{n.Classwork();}catch (IOException e){}
    }
    
    public void Classwork() throws IOException {

        JFrame world = new JFrame("World");
        win2 background = new win2();
        world.setResizable(false);
        world.setLocationRelativeTo(null);
        world.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        world.setBounds(0, 0, 1024, 768);
        world.add(background);
        world.setVisible(true);
    }
    
}
