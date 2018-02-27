public class CombatRunner{
  

  
  public static void main(String[] args){
   
 /*   Picture barb1 = new Picture(FileChooser.getMediaPath("Barbarian50x50.png"));
    Picture barb2 = new Picture(FileChooser.getMediaPath("Barbarian100x100.png"));
    Picture tower1 = new Picture(FileChooser.getMediaPath("Tower1.png"));
    Picture map1 = new Picture(FileChooser.getMediaPath("Map1.png"));
    Picture map2 = new Picture(FileChooser.getMediaPath("Map2.png"));
    Picture drone = new Picture(FileChooser.getMediaPath("Drone50x50.png"));
   */                            
    System.out.println("map");
    Picture map1 = new Picture(FileChooser.pickAFile());
    System.out.println("gate");
    Picture gate = new Picture(FileChooser.pickAFile());
     System.out.println("tower");
    Picture tower1 = new Picture(FileChooser.pickAFile());
   
    
 //   Picture barb1 = new Picture(FileChooser.pickAFile());
 //   System.out.println("small barb");
 //   Picture barb2 = new Picture(FileChooser.pickAFile());
 //   System.out.println("big barb");
 //   Picture drone = new Picture(FileChooser.pickAFile());
 //   System.out.println("drone");
                       
    
    
    World earth = new World();
    earth.setPicture(map1);
    
    Towers tow = new Towers(40, 140, earth, tower1);
    tow.drop(tow.getPic()); tow.hide();
    Bullets b = new Bullets(tow.getXPos() + (tow.getPic().getWidth() / 2),( tow.getYPos() + (tow.getHeight() / 2)),
                          earth, tower1);
    b.hide();       
   Walls w = new Walls(20, 0, earth, gate);
   w.drop(w.getPic());
   w.hide();
    
   
    toySoldiers t = new toySoldiers(earth.getWidth(), 
                                    (int)(w.getYPos() + (Math.random() * (earth.getHeight() - w.getYPos()))),
                                    earth, tower1);
    t.setSpeed(20);  t.setDamage(10); t.setHealth(25);
    toySoldiers t2 = new toySoldiers(earth.getWidth(),  
                                     (int)(w.getYPos() + (Math.random() * (earth.getHeight() - w.getYPos()))),
                                     earth, tower1);
    t2.setSpeed(20);  t2.setDamage(15);  t2.setHealth(100);
    toySoldiers t3 = new toySoldiers(earth.getWidth(), 
                                     (int)(w.getYPos() + (Math.random() * (earth.getHeight() - w.getYPos()))),
                                     earth, tower1);
    t3.setSpeed(20); t3.setDamage(45); t2.setHealth(200);
    
    t.setNext(t2); 
    t2.setNext(t3);
    t3.setNext(t);
    
    

   
 
    
   
    
    int tcounter = 0;
    int t2counter = 0;
    int t3counter = 0;
                            
                         
    
    while(w.isAlive() == true){
     
    try{
     Thread.sleep(50);
      
    
      if(t.isAlive() == true){ 
        t.marchOn(w);
      }
     else if(t.isAlive() == false){ //drone
        tcounter += 1;
        t.setAlive(true);
        t.hide();
       t = new toySoldiers(earth.getWidth(), (int)(Math.random() * earth.getHeight()), earth, t.getPic());
        t.setSpeed(t.getSpeed() + tcounter * 3);
    
     
     }
      
     if(t2.isAlive() == true){ 
        t2.marchOn(w);
      }
      else if(t2.isAlive() == false){ //barbarian
        t2counter += 1;
        t2.setAlive(true);
        t2.hide();
        t2 = new toySoldiers(earth.getWidth(), (int)(Math.random() * earth.getHeight()), earth, t.getPic());
        t2.setHealth(t2.getHealth() + (t2counter * 2)); t2.setSpeed(t2.getSpeed() + t2counter*2);
      }
      
      
    if(t3.isAlive() == true){ 
      t3.marchOn(w);
      }
     else if(t3.isAlive() == false){ //bigger barbarian
        t3counter += 1;
        t3.setAlive(true);
        t3.hide();
        t3 = new toySoldiers(earth.getWidth(), (int)(Math.random() * earth.getHeight()), earth, t.getPic());
        t3.setDamage(t3.getDamage() + (t3counter * 3)); t3.setSpeed(t3.getSpeed() + t3counter * 2);
      }
      
     int pos1 = t.getXPos();
     int pos2 = t2.getXPos();
     int pos3 = t3.getXPos();
          
     int closest = Math.min(pos1, Math.min(pos2,pos3));
     if(pos1 == closest){b.shoot(t);}
     else if(pos2 == closest){b.shoot(t2);}
     else if(pos3 == closest){b.shoot(t3);}
      
      
      }catch(Exception e){
        System.out.println(e.getMessage());
      }
    
    
  }
  }
}      
        
