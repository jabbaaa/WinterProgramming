public class toySoldiers extends Turtle{
   private int health;
   private int damage;
   private final int FULL_HEALTH = 200;
   private Picture pic;
   private ModelDisplay world;
   private boolean life;
   private int speed;
  
   private toySoldiers next;
   private toySoldiers repeat;
   private Walls myTarget;
   
  public toySoldiers(int x, int y, ModelDisplay modelDisplayer, Picture p){
     super(x,y,modelDisplayer);
     health = FULL_HEALTH;
     damage = 10;
     pic = p;
     speed = 2;
  }
    
  public int getSpeed(){
    return this.speed;
  }
  public void setSpeed(int mySpeed){
    this.speed = mySpeed;
  }
  
  
  public int getHealth(){
     return this.health;
  }
  
  public void setHealth(int newHealth){
     this.health = newHealth;
  }
  
  public int getDamage(){
     return this.damage;
  }
  public void setDamage(int newDamage){
   this.damage = newDamage;
  }

  public ModelDisplay getWorld(){
    return this.world;
  }
  public Picture getPic(){
    return this.pic;
  }
  public toySoldiers getNext() {
    return this.next;
  }
  public void setNext(toySoldiers t){
    this.next = t;
  }
  
  public void marchOn(Walls target){
   int x = (target.getXPos() + (target.getPic().getWidth() / 2));
   int y = (target.getYPos() + target.getPic().getHeight());
   int dist = (int)this.getDistance(x,y); 
   
    this.turnToFace(x,y); 
    if(this.isAlive() == false){
      this.reset(this.getWorld());
      next.marchOn(target);
    }
   
    if((this.isAlive() == true)&&(target.isAlive() == true)){
      if(this.getXPos() > x){
        if(speed < dist){
          this.forward(speed);}
        else if(speed >= dist){
          this.forward(dist);
        }
      }
      if(this.getXPos() <= x){
          this.attack(target);
      }
      }   
    }
    
 
  
  
  public boolean isAlive(){
    if(this.health > 0){
      life = true;
    } else { life = false; }
   return life;
  }
  
  public void setAlive(boolean b){
    life = b;
  }
  
 public void attack(Walls target){
   myTarget = target;
    
   if(target.isAlive() == true){
   target.setHealth(target.getHealth() - this.damage);
   }
    if(this.isAlive() == false){
        this.reset(this.getWorld()); 
    }
    if(target.isAlive() == false){
      target.nullify();
    }
  
    }
 

  
  
 
  
  
  public toySoldiers reset(ModelDisplay w){
     int x = w.getWidth();
     int y = (int)(Math.random()* w.getHeight());
     this.setAlive(true);
     this.hide();
     
     next = new toySoldiers(x,y,w,this.pic);
     next.setDamage(this.getDamage() + 5);
     next.setSpeed(this.getSpeed() + 10);
     next.setHealth(this.getHealth() + 20);
     
  
     return next;
  }
}

