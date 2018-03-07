public class toySoldiers extends Turtle{
   private int health;
   private int damage;
   private int fullHealth;
   private Picture pic;
   private ModelDisplay world;
   private boolean life = true;
   private int speed;
  
   private toySoldiers next;
   private toySoldiers current;
   
  public toySoldiers(int x, int y, ModelDisplay modelDisplayer, Picture p){
     super(x,y,modelDisplayer);
     pic = p;
  }
  
  
  public void setStats(int health, int speed, int damage){
    this.fullHealth = health;
    this.health = health;
    this.speed = speed;
    this.damage = damage;
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
  public boolean isAlive(){
    if(this.getHealth() <= 0){
      life = false;
    }
   return life;
  }
  public void setAlive(boolean b){
    life = b;
  }
  
 /* public void wageWar(Walls target){
      if(this.isAlive() == true){ 
        this.marchOn(target);
        this.attack(target);
      }
     else if(this.isAlive() == false){ //drone
        this.setAlive(true);
        this.hide();
        this = this.reset(this.getWorld());
     }
  }
  */
 ///////////////////////////////////////////////////////////////// 
  public void marchOn(Walls target){
   int x = (target.getXPos() + (target.getPic().getWidth() / 2));
   int y = (target.getYPos() + target.getPic().getHeight());
   int dist = (int)this.getDistance(x,y); 
   
    this.turnToFace(x,y); 
    if(this.isAlive() == false){
      this.reset(this.getWorld());
      next.marchOn(target);
    }
   
    if((this.isAlive() == true)){
      if(this.getXPos() > x){
        if(speed < dist){
          this.forward(speed);}
        else if(speed >= dist){
          this.forward(dist);
        }
      }
  
      }   
    }
 /////////////////////////////////////////////////////////////////       
 public void attack(Walls target){
   
   int x = (target.getXPos() + (target.getPic().getWidth() / 2) + 1);
   if((this.getXPos() <= x) && (target.getHealth() < this.getDamage())){
     target.showBehind(target.getBGPic());
     target.subtractHealth(this.damage);
   }
   else if(this.getXPos() <= x){
       target.subtractHealth(this.damage);
     }
  //   if(this.isAlive() == false){
  //     this.reset(this.getWorld()); 
  //   }
   }
 

 ///////////////////////////////////////////////////////////////// 
  public toySoldiers reset(ModelDisplay w){
     int x = w.getWidth();
     int y = (int)(Math.random()* w.getHeight());
     this.setAlive(true);
     this.hide();
     
     toySoldiers nextOne = new toySoldiers(x,y,w,this.pic);
     nextOne.setStats(this.fullHealth + 20, this.speed + 2, this.damage + 1);
  
     return nextOne;
  }
}

/*
 *public class toySoldiers extends Turtle{
   private int health;
   private int damage;
   private int fullHealth;
   private Picture pic;
   private ModelDisplay world;
   private boolean life = true;
   private int speed;
  
   private toySoldiers next;
   private toySoldiers current;
   
  public toySoldiers(int x, int y, ModelDisplay modelDisplayer, Picture p){
     super(x,y,modelDisplayer);
     pic = p;
  }
  
  
  public void setStats(int health, int speed, int damage){
    this.fullHealth = health;
    this.health = health;
    this.speed = speed;
    this.damage = damage;
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
  public boolean isAlive(){
    if(this.getHealth() <= 0){
      life = false;
    }
   return life;
  }
  public void setAlive(boolean b){
    life = b;
  }
  
 /* public void wageWar(Walls target){
      if(this.isAlive() == true){ 
        this.marchOn(target);
        this.attack(target);
      }
     else if(this.isAlive() == false){ //drone
        this.setAlive(true);
        this.hide();
        this = this.reset(this.getWorld());
     }
  }
  /////place comment here
  
  
 ///////////////////////////////////////////////////////////////// 
  public void marchOn(Walls target){
   int x = (target.getXPos() + (target.getPic().getWidth() / 2));
   int y = (target.getYPos() + target.getPic().getHeight());
   int dist = (int)this.getDistance(x,y); 
   
    this.turnToFace(x,y); 
    if(this.isAlive() == false){
      this.reset(this.getWorld());
      next.marchOn(target);
    }
   
    if((this.isAlive() == true)){
      if(this.getXPos() > x){
        if(speed < dist){
          this.forward(speed);}
        else if(speed >= dist){
          this.forward(dist);
        }
      }
  
      }   
    }
 /////////////////////////////////////////////////////////////////       
 public void attack(Walls target){
   
   int x = (target.getXPos() + (target.getPic().getWidth() / 2) + 1);
   if((this.getXPos() <= x) && (target.getHealth() < this.getDamage())){
     target.showBehind(target.getBGPic());
     target.subtractHealth(this.damage);
   }
   else if(this.getXPos() <= x){
       target.subtractHealth(this.damage);
     }
  //   if(this.isAlive() == false){
  //     this.reset(this.getWorld()); 
  //   }
   }
 

 ///////////////////////////////////////////////////////////////// 
  public toySoldiers reset(ModelDisplay w){
     int x = w.getWidth();
     int y = (int)(Math.random()* w.getHeight());
     this.setAlive(true);
     this.hide();
     
     toySoldiers nextOne = new toySoldiers(x,y,w,this.pic);
     nextOne.setStats(this.fullHealth + 20, this.speed + 2, this.damage + 1);
  
     return nextOne;
  }
}
*/
