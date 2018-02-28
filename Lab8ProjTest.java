public class Lab8ProjTest{
  
  public static void main(String[] args){
   
                        
    
    Picture map1 = new Picture(FileChooser.getMediaPath("Map1.png"));
    
    Picture gate = new Picture(FileChooser.getMediaPath("Gate.png"));
     
    Picture tower1 = new Picture(FileChooser.getMediaPath("Tower1.png"));  
    
    Picture gateBG = new Picture(FileChooser.getMediaPath("Map1.png"));
  
    gateBG.show();
    
    World earth = new World();
    earth.setPicture(map1);
    
    Towers tow = new Towers(40, 140, earth, tower1);
    tow.drop(tow.getPic()); tow.hide();
    Bullets b = new Bullets(tow.getXPos() + (tow.getPic().getWidth() / 2),( tow.getYPos() + (tow.getHeight() / 2)), earth, tower1, 5);
    b.hide();    
                                 
    Walls w = new Walls(20, 0, earth, gate);
    w.setBGPic(gateBG);
    w.drop(w.getPic());
    w.hide();
    
   
    toySoldiers t =  new toySoldiers(earth.getWidth(), (int)(w.getYPos() + (Math.random() * earth.getHeight())),earth, tower1);
    toySoldiers t2 = new toySoldiers(earth.getWidth(), (int)(w.getYPos() + (Math.random() * earth.getHeight())), earth, tower1);
    toySoldiers t3 = new toySoldiers(earth.getWidth(), (int)(w.getYPos() + (Math.random() * earth.getHeight())), earth, tower1);
    
    t.setStats(200,20,10);
    t2.setStats(100,4,10);
    t3.setStats(100,6,10);

    t.setNext(t2); 
    t2.setNext(t3);
    t3.setNext(t);
    
    int tcounter = 0;
    int t2counter = 0;
    int t3counter = 0;
                            
                  
    
    while(w.isAlive() == true){
     
    try{
     Thread.sleep(100);
      
    
      if(t.isAlive() == true){ 
        t.marchOn(w);
        t.attack(w);
      }
     else if(t.isAlive() == false){ //drone
        tcounter += 1;
        t.setAlive(true);
        t.hide();
        t = t.reset(earth);
     }
      
     if(t2.isAlive() == true){ 
        t2.marchOn(w);
        t2.attack(w);
      }
      else if(t2.isAlive() == false){ //barbarian
        t2counter += 1;
        t2.setAlive(true);
        t2.hide();
        t2 = t2.reset(earth);
      }
     
    if(t3.isAlive() == true){ 
      t3.marchOn(w);
      t3.attack(w);
      }
     else if(t3.isAlive() == false){ //bigger barbarian
        t3counter += 1;
        t3.setAlive(true);
        t3.hide();
        t3 = t3.reset(earth);
      }
      
     int pos1 = t.getXPos();
     int pos2 = t2.getXPos();
     int pos3 = t3.getXPos();

     int closest = Math.min(pos1, Math.min(pos2,pos3));
     if(pos1 == closest){b.shoot(t);}
     else if(pos2 == closest){b.shoot(t2);}
     else if(pos3 == closest){b.shoot(t3);}
      
     
    if(w.isAlive() == false){
      w.nullify(gateBG);
      w.drop(w.getBGPic());
      w.getBGPic().show();
    }
    
    System.out.println(w.getHealth());
      
      }catch(Exception e){
        System.out.println("Something went wrong here");
      }
 
    
  }

    
  }
}   