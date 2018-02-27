
public class Bullets extends Turtle{
   private int xPos;
   private int yPos;
 //  private double heading;
   private Picture pic;
   private int damage;
   
  public Bullets(int x, int y, ModelDisplay mD, Picture p){
    super(x,y,mD);
    xPos = x;
    yPos = y;
    pic = p;
    damage = 5;
  }
  
  public Picture getPic(){
    return this.pic;
  }
  
  public void reset(){
    this.moveTo(xPos, yPos);
  }
  
  public double calcHeading(int x, int y){
    double targetAngle = 0;
    int x1 = this.getXPos();
    int y1 = this.getYPos();
     int x2 = x;
     int y2 = y;
     double aLength = (y2 - y1);
     double bLength = (x2 - x1);
     double cLength = Math.sqrt((aLength * aLength) + (bLength * bLength));
     if(y1 > y2){
        targetAngle = Math.toDegrees(Math.asin(aLength / cLength)) + 90;
     }
     else if(y2 > y1){
        targetAngle = Math.toDegrees(Math.acos(bLength / cLength)) + 90;
     }
     else if(y2 == y1){
        targetAngle = 90.0;
     }  
     return targetAngle;
  }   
  
  
  public void shoot(toySoldiers t){
 
    
    toySoldiers target = t;
    
   if(target.isAlive() == false){
      target.reset(target.getWorld());
    //  target.nullify();
     toySoldiers nextTarget = target.getNext();
     this.shoot(nextTarget);
   } else if(target.isAlive() == true){ 
    
    this.setHeading(this.calcHeading(target.getXPos(),target.getYPos()));
    double distance = (int)this.getDistance(target.getXPos(), target.getYPos());
    this.forward((int)(distance));
    this.clearPath();
    this.turn(180);
     
    this.forward((int)(distance));
    try{ Thread.sleep(20);
      }catch(Exception e){
      System.out.println(e.getMessage());
    }
    this.turn(180);
    target.setHealth(target.getHealth() - this.damage); 
    
    this.clearPath();
  
    }
   }
  

public static void main(String[] args){
    
    
    World earth = new World();
   
    toySoldiers t = new toySoldiers(earth.getWidth(), (int)(Math.random() * earth.getHeight()),
                                                      earth, new Picture(FileChooser.getMediaPath("...blastoise.png")));
    Bullets b = new Bullets(50, 100, earth, new Picture(FileChooser.getMediaPath("...machamp.png")));
    
    
    Walls w = new Walls(20, 200, earth, new Picture(FileChooser.getMediaPath("...diglett.png")));;
   
    t.setDamage(20);
    int counter = 0;
    
    while(w.isAlive() == true){
     
      try{
        Thread.sleep(50);
      
      if(t.isAlive() == true){ 
        t.marchOn(w);
        b.shoot(t); }
      if(t.isAlive() == false){ 
        counter += 4;
        t.setAlive(true);
        t.hide();
        t = t.reset(earth); //new toySoldiers(earth.getWidth(), (int)(Math.random() * earth.getHeight()), earth, t.getPic());
        t.setSpeed(t.getSpeed() + counter);
      }
      }catch(Exception e){
        System.out.println("here");
      }
    
    
  }
  }
}      
        
              

  