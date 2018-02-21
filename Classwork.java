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
        Classwork n = new Classwork(); //custom class... this class!
        try{n.Classwork();}catch (IOException e){} //had to use a try-catch due to it being in main.
    }
    
    public void Classwork() throws IOException {

        JFrame world = new JFrame("World"); //New Java frame named world
        win2 background = new win2(); //(Extends JPanel which makes it viable to go into JFrame.add();
        world.setResizable(false); //No RESIZES!
        world.setLocationRelativeTo(null); //Dont recall now...
        world.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Never forget this.. soo good.
        world.setBounds(0, 0, 1024, 768); //top left position + width, height
        world.add(background);//add the Jpanel object to the JFrame.
        world.setVisible(true); //show the JFrame
    }
    
}
