import javax.swing.*; 
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.util.Observer;
import java.util.Random;

public class Walls extends Turtle{
  
  private int boundary;
  private int health;
  private Picture pic;
  private boolean life = true;
  private World world;
  private Picture bgPic;
  private int maxHealth = 2000;
  
  public Walls(int x, int y, ModelDisplay mD, Picture p){
   super(x,y,mD);
   boundary = x + p.getWidth();
   pic = new Picture(p);
   health = maxHealth;
  }
  public int getHealth(){
    return this.health;
  }
  public void setHealth(int newHealth){
    this.health = newHealth;
  }
  public int getMaxHealth(){
    return this.maxHealth;
  }
  public void setMaxHealth(int fullHealth){
    this.maxHealth = fullHealth;
  }
  public void subtractHealth(int damage){
    this.health = (this.health - damage);
  }
  public int getBoundary(){
    return this.boundary;
  }
  public Picture getPic(){
    return this.pic;
  }
  public void setPic(Picture p){
    this.pic = new Picture(p);
  }
  public void setBGPic(Picture p){
    this.bgPic = new Picture(p);
  }
  public Picture getBGPic(){
    return this.bgPic;
  }  
  public boolean isAlive(){
    if(this.health <= 0){
      life = false; }
   return life;
  }
  
  public void nullify(Picture background){
     int x = getXPos(); int y = getYPos();  int wide = pic.getWidth();  int tall = pic.getHeight();
    Picture bg = new Picture(background);
    Picture p = new Picture(wide, tall);
    for(int i = 0; i<p.getWidth(); i++){
      for(int j = 0; j<p.getHeight(); j++){
     int value = bg.getBasicPixel(i + x,j+y);
       p.setBasicPixel(i,j,value);
     }
}
    this.drop(p);  
    System.out.println("GAME OVER");
  }
  
  public void showBehind(Picture background){
   int x = getXPos(); int y = getYPos();  int wide = pic.getWidth();  int tall = pic.getHeight();
    Picture bg = new Picture(background);
    Picture p = new Picture(wide, tall);
    for(int i = 0; i<p.getWidth(); i++){
      for(int j = 0; j<p.getHeight(); j++){
     int value = bg.getBasicPixel(i + x,j+y);
       p.setBasicPixel(i,j,value);
      }
    }
    this.drop(p);
  }
  
  public synchronized void paintComponent(Graphics g){
    Graphics2D g2 = (Graphics2D) g;
    if (this.isVisible() == true)
    {
      AffineTransform oldTransform = g2.getTransform();
      
      // rotate the turtle and translate to xPos and yPos
   //   g2.rotate(Math.toRadians(heading),xPos,yPos);

      int barwidth = this.getPic().getWidth();
      int barheight = 10;

      g2.setColor(Color.WHITE);
      g2.fillRect(this.getXPos(), this.getYPos() - 10,
                  barwidth, barheight);
      g2.setColor(Color.RED);
      double d = ((double)this.getHealth() / (double)this.getMaxHealth() * barwidth);
      g2.fillRect(this.getXPos(), this.getYPos() - 10,
                  (int)d, barheight);

      g2.setTransform(oldTransform);
    } 
    this.getPen().paintComponent(g);
  
}
}



/*
 * 
 * import javax.swing.*; 
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.util.Observer;
import java.util.Random;

public class Walls extends Turtle{
  
  private int boundary;
  private int health;
  private Picture pic;
  private boolean life = true;
  private World world;
  private Picture bgPic;
  private int maxHealth = 2000;
  
  public Walls(int x, int y, ModelDisplay mD, Picture p){
   super(x,y,mD);
   boundary = x + p.getWidth();
   pic = new Picture(p);
   health = maxHealth;
  }
  public int getHealth(){
    return this.health;
  }
  public void setHealth(int newHealth){
    this.health = newHealth;
  }
  public int getMaxHealth(){
    return this.maxHealth;
  }
  public void setMaxHealth(int fullHealth){
    this.maxHealth = fullHealth;
  }
  public void subtractHealth(int damage){
    this.health = (this.health - damage);
  }
  public int getBoundary(){
    return this.boundary;
  }
  public Picture getPic(){
    return this.pic;
  }
  public void setPic(Picture p){
    this.pic = new Picture(p);
  }
  public void setBGPic(Picture p){
    this.bgPic = new Picture(p);
  }
  public Picture getBGPic(){
    return this.bgPic;
  }  
  public boolean isAlive(){
    if(this.health <= 0){
      life = false; }
   return life;
  }
  
  public void nullify(Picture background){
     int x = getXPos(); int y = getYPos();  int wide = pic.getWidth();  int tall = pic.getHeight();
    Picture bg = new Picture(background);
    Picture p = new Picture(wide, tall);
    for(int i = 0; i<p.getWidth(); i++){
      for(int j = 0; j<p.getHeight(); j++){
     int value = bg.getBasicPixel(i + x,j+y);
       p.setBasicPixel(i,j,value);
     }
}
    this.drop(p);  
    System.out.println("GAME OVER");
  }
  
  public void showBehind(Picture background){
   int x = getXPos(); int y = getYPos();  int wide = pic.getWidth();  int tall = pic.getHeight();
    Picture bg = new Picture(background);
    Picture p = new Picture(wide, tall);
    for(int i = 0; i<p.getWidth(); i++){
      for(int j = 0; j<p.getHeight(); j++){
     int value = bg.getBasicPixel(i + x,j+y);
       p.setBasicPixel(i,j,value);
      }
    }
    this.drop(p);
  }
  
  public synchronized void paintComponent(Graphics g){
    Graphics2D g2 = (Graphics2D) g;
    if (this.isVisible() == true)
    {
      AffineTransform oldTransform = g2.getTransform();
      
      // rotate the turtle and translate to xPos and yPos
   //   g2.rotate(Math.toRadians(heading),xPos,yPos);

      int barwidth = this.getPic().getWidth();
      int barheight = 10;

      g2.setColor(Color.WHITE);
      g2.fillRect(this.getXPos(), this.getYPos() - 10,
                  barwidth, barheight);
      g2.setColor(Color.RED);
      double d = ((double)this.getHealth() / (double)this.getMaxHealth() * barwidth);
      g2.fillRect(this.getXPos(), this.getYPos() - 10,
                  (int)d, barheight);

      g2.setTransform(oldTransform);
    } 
    this.getPen().paintComponent(g);
  
}
}
*/