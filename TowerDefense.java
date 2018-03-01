/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Drogana
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Drogana
 */
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class TowerDefense {

    
    public static void main(String[] args) {
        
                JFrame game = new JFrame("Tower Defense");
                game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                MainPanel mainPanel = new MainPanel();
                game.setContentPane(mainPanel);
                game.pack();
                game.setVisible(true);
                try {
                    mainPanel.loadResources();
                } catch (IOException ex) {System.out.println(ex);}
            }    
    


    private static class MainPanel extends JPanel implements ActionListener {

        private Timer t = new Timer(50, this); //repaint every 50 milliseconds by thors hammer!
        private BufferedImage img, background;
        private Spawner spawn_1 = new Spawner();
        private Stats Game_Stats;
        private boolean doesSpawnerExist;
        

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(background, 0, 0, 1024, 768, null);
            
            if(doesSpawnerExist==true){
            spawn_1.draw(g);    
            }
            
        }

        public void loadResources() throws IOException {
        Stats Game_Stats = new Stats();
        Game_Stats.init(); //resource loader
        background = Game_Stats.getBListItem(0);
        spawn_1.Spawner(470, 670, 50000, Game_Stats);//
        doesSpawnerExist=true; //the booleans are very important for controlling graphic flow.
        
        this.start();//calls the start of the timer.
        }
        
        public void start() {
        t.start();  
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(1024, 768);
        }
        
    }
}