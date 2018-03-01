
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Drogana
 */
public class Spawner implements ActionListener {
    private int x, y, num_spawns; //location of the spawner
    private BufferedImage img;
    private Enemy[] Enemy_Array;
    private Timer t;
    private int counter;
    
    //private Stats Game_stats; //need to pull the images -.-
    
    public void Spawner(int x, int y, int n, Stats sr){
        this.x = x;
        this.y = y;
        this.num_spawns = n;
        this.counter = n;
        this.img = sr.getBListItem(13);
        this.Enemy_Array = new Enemy[n];
        for(int i =0; i<this.Enemy_Array.length;i++){
            this.Enemy_Array[i] = new Enemy();
            this.Enemy_Array[i].Enemy("Warrior", 1000, 1.0, sr.getBListItem(7), false);
        }
    t = new Timer(550, this); //set the spawn rate here!
    t.start();
                }
    
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public Enemy[] getEnemyList(){
        return this.Enemy_Array;
    }
    public void draw(Graphics g){
        g.drawImage(this.img, this.x, this.y, null);
        for(Enemy s: this.Enemy_Array){
            s.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        this.counter--;
        this.Enemy_Array[this.counter].SpawnEnemy(this.x, this.y);
        if(this.counter<1){t.stop();}
    }
}
