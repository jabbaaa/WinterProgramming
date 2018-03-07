public class Bullets extends Turtle{
   private int xPos;
   private int yPos;
   private Picture pic;
   private int damage;
   
  public Bullets(int x, int y, ModelDisplay mD, Picture p, int damage){
    super(x,y,mD);
    xPos = x;
    yPos = y;
    pic = new Picture(p);
    this.damage = damage;
  }
  
  public Picture getPic(){
    return this.pic;
  }
  
  public void reset(){
    this.moveTo(xPos, yPos);
  }
  
  public int getDamage(){
    return damage;
  }
  
  public void setDamage(int newDamage){
    damage = newDamage;
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
    
     if(x1 < x2){
       if(y1 > y2){
         targetAngle = Math.toDegrees(Math.asin(aLength / cLength)) + 90;
       }
       else if(y2 > y1){
         targetAngle = Math.toDegrees(Math.acos(bLength / cLength)) + 90;
       }
       else if(y2 == y1){
         targetAngle = 90.0;  //aiming mishap caused here
       }
     }
     else if(x1 > x2){
       if(y1 > y2){
         targetAngle = Math.toDegrees(Math.acos(aLength / cLength)) + 180;
       }
       else if(y2 > y1){
         targetAngle = Math.toDegrees(Math.asin(bLength / cLength)) + 180;
       }
       else if(y2 == y1){
         targetAngle = 270.0;  //aiming mishap caused here
       }
     }
     else if(x1 == x2){
       if(y1 > y2){ targetAngle = 180.0 ; }
       else if(y1 < y2){ targetAngle = 0.0; }
     }

     return targetAngle;
  }   
  
  
  public void shoot(toySoldiers t){
 
    toySoldiers target = t;
    
   if(target.isAlive() == false){
     toySoldiers nextTarget = target.getNext();
     target = nextTarget;
     
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
}



/*
 * public class Bullets extends Turtle{
   private int xPos;
   private int yPos;
   private Picture pic;
   private int damage;
   
  public Bullets(int x, int y, ModelDisplay mD, Picture p, int damage){
    super(x,y,mD);
    xPos = x;
    yPos = y;
    pic = new Picture(p);
    this.damage = damage;
  }
  
  public Picture getPic(){
    return this.pic;
  }
  
  public void reset(){
    this.moveTo(xPos, yPos);
  }
  
  public int getDamage(){
    return damage;
  }
  
  public void setDamage(int newDamage){
    damage = newDamage;
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
        targetAngle = 90.0;  //aiming mishap caused here
     }  
     return targetAngle;
  }   
  
  
  public void shoot(toySoldiers t){
 
    toySoldiers target = t;
    
   if(target.isAlive() == false){
     toySoldiers nextTarget = target.getNext();
     target = nextTarget;
     
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
}
*/