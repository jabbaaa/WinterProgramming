
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.Timer;
/**
 *
 * @author Drogana
 */
public class Enemy implements ActionListener {
private boolean spawned=false; //initial condition
private boolean isboss=false;
private BufferedImage img, img_dead;
private int imgHeight, imgWidth;
private String name;
private int cur_hp, max_hp, x, y;
private double speed;
private Timer t;
static int ENEMY_COUNT;

public void Enemy(String n, int hp, double s, BufferedImage b, boolean isb){
    ENEMY_COUNT++;
    this.max_hp=hp;
    this.cur_hp=hp;
    this.speed=s;
    this.name=""+n+"-"+ENEMY_COUNT;
    this.isboss=isb; //assumed to be true otherwise use the other constructor lol...
    this.img=b;
    this.imgHeight=b.getHeight();
    this.imgWidth=b.getWidth();
    this.img_dead=null;//need a death image
}

public void SpawnEnemy(int x, int y){
    this.spawned=true;
    this.x = x; //initial position
    this.y = y; //initial position
    t = new Timer(25, this);
    t.start();
}

public void takeDamage(int damage){
    this.cur_hp-=damage;
}

public int getX(){
    return this.x;
}

public int getY(){
    return this.y;
}
public BufferedImage getImg(){
    return this.img;
}

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(this.y > 170){this.y-=this.speed;}
        this.takeDamage(19);
        
        
        //unit is hurt
        if(this.cur_hp < this.max_hp){
            System.out.println(this.name+"; HP:"+this.cur_hp);
        }
     
        //unit died!!!
        if(this.cur_hp < 1){
            this.img = this.img_dead;
            this.spawned=false;
            this.t.stop();
        }
           }
    
public void draw(Graphics g){
    if(spawned==true){
        g.drawImage(this.img, this.x, this.y, this.imgHeight, this.imgWidth, null );
        g.drawString("HP:"+this.cur_hp, this.x+80, this.y+30);
    }
    
}

}
