public class Lab8ProjTest{
  
  public static void main(String[] args){
   
                        
    
    Picture map1 = new Picture(FileChooser.getMediaPath("Map1.png"));
    Picture tree = new Picture(FileChooser.getMediaPath("Barbarian50x50.png"));
    Picture gate = new Picture(FileChooser.getMediaPath("Gate.png"));
    Picture gate2 = new Picture(FileChooser.getMediaPath("Gate2.png"));
    Picture gate3 = new Picture(FileChooser.getMediaPath("Gate3.png"));
     
    Picture tower1 = new Picture(FileChooser.getMediaPath("Tower1.png"));  
    
    Picture gateBG = new Picture(FileChooser.getMediaPath("Map1.png"));
  
    
    World earth = new World(map1.getWidth(), map1.getHeight());
    earth.setPicture(map1);
    
      
                                 

    
    Walls goal = new Walls(10, 10 ,earth,tree);
    goal.setMaxHealth(1000);
    goal.setHealth(1000);
    goal.setBGPic(gateBG);
    goal.showBehind(gateBG);
    goal.drop(goal.getPic());
    
    Walls w = new Walls(100, 100, earth, gate);
    w.setBGPic(gateBG);
    w.showBehind(gateBG);
    w.drop(w.getPic());
    
    Towers tow = new Towers(earth.getWidth() / 2, earth.getHeight() / 2, earth, tower1);
    tow.drop(tow.getPic()); tow.hide();
   // tow.setAmmo();
   // Bullets b = tow.getAmmo();
    Bullets b = new Bullets(tow.getXPos() + (tow.getPic().getWidth() / 2),( tow.getYPos() + (tow.getHeight() / 2)), earth, tower1, 5);
    b.hide(); 
    
    
    toySoldiers t =  new toySoldiers(earth.getWidth(), (int)(w.getYPos() + (Math.random() * earth.getHeight())),earth, tower1);
    toySoldiers t2 = new toySoldiers(earth.getWidth(), (int)(w.getYPos() + (Math.random() * earth.getHeight())), earth, tower1);
    toySoldiers t3 = new toySoldiers(earth.getWidth(), (int)(w.getYPos() + (Math.random() * earth.getHeight())), earth, tower1);
    
    t.setStats(200,20,10);
    t2.setStats(100,4,10);
    t3.setStats(100,6,10);

    t.setNext(t2); 
    t2.setNext(t3);
    t3.setNext(t);
    

    int picCounter = 0;
    
    while(goal.isAlive() == true){               
    
    while(w.isAlive() == true){
     
   
      
     if((w.getHealth() < (w.getMaxHealth() / 3)) && (picCounter == 2)){
       w.showBehind(gateBG);
       w.drop(gate3);
       tow.drop(tow.getPic());
       picCounter += 1;
     }
     else if((w.getHealth() < (2 * w.getMaxHealth() / 3)) && (picCounter == 1)){
       w.showBehind(gateBG);
       w.drop(gate2);
       tow.drop(tow.getPic());
       picCounter += 1;
     }
     else if((w.getHealth() == w.getMaxHealth()) && (picCounter == 0)){
       w.showBehind(gateBG);
       w.drop(gate);
       picCounter += 1;
       goal.showBehind(gateBG);
       goal.drop(tree);
     }
      
     try{
     Thread.sleep(100);
     
     
     if(t.isAlive() == true){ 
        t.marchOn(w);
        t.attack(w);
      }
     else if(t.isAlive() == false){ //drone
        t.setAlive(true);
        t.hide();
        t = t.reset(earth);
     }
     if(t2.isAlive() == true){ 
        t2.marchOn(w);
        t2.attack(w);
      }
     else if(t2.isAlive() == false){ //barbarian
        t2.setAlive(true);
        t2.hide();
        t2 = t2.reset(earth);
      }
     if(t3.isAlive() == true){ 
      t3.marchOn(w);
      t3.attack(w);
      }
     else if(t3.isAlive() == false){ //bigger barbarian
        t3.setAlive(true);
        t3.hide();
        t3 = t3.reset(earth);
      }
      /*
     t.wageWar(w);
     t2.wageWar(w);
     t3.wageWar(w);
     */
     
     int pos1 = t.getXPos();
     int pos2 = t2.getXPos();
     int pos3 = t3.getXPos();

     int closest = Math.min(pos1, Math.min(pos2,pos3));
     if(pos1 == closest){b.shoot(t);}
     else if(pos2 == closest){b.shoot(t2);}
     else if(pos3 == closest){b.shoot(t3);}
      

    System.out.println("wall health: " + w.getHealth());
      
      }catch(Exception e){
        System.out.println("Something went wrong here");
      }
  }
    w.hide();
    
    try{
      Thread.sleep(100);
      if(t.isAlive() == true){ 
        t.marchOn(goal);
        t.attack(goal);
      }
     else if(t.isAlive() == false){ //drone
        t.setAlive(true);
        t.hide();
        t = t.reset(earth);
     }
      
     if(t2.isAlive() == true){ 
        t2.marchOn(goal);
        t2.attack(goal);
      }
      else if(t2.isAlive() == false){ //barbarian
        t2.setAlive(true);
        t2.hide();
        t2 = t2.reset(earth);
      }
     
    if(t3.isAlive() == true){ 
      t3.marchOn(goal);
      t3.attack(goal);
      }
     else if(t3.isAlive() == false){ //bigger barbarian
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
      
     System.out.println("Goal Health: " + goal.getHealth());
     if(goal.getHealth() < 10){
       goal.showBehind(gateBG);
     }
    }catch (Exception e) {
      System.out.println(e.getMessage());
    }
    }
    goal.hide();
    goal.nullify(gateBG);
  }  
}

/*
 * 
 * public class Lab8ProjTest{
  
  public static void main(String[] args){
   
                        
    
    Picture map1 = new Picture(FileChooser.getMediaPath("Map1.png"));
    Picture tree = new Picture(FileChooser.getMediaPath("Barbarian50x50.png"));
    Picture gate = new Picture(FileChooser.getMediaPath("Gate.png"));
    Picture gate2 = new Picture(FileChooser.getMediaPath("Gate2.png"));
    Picture gate3 = new Picture(FileChooser.getMediaPath("Gate3.png"));
     
    Picture tower1 = new Picture(FileChooser.getMediaPath("Tower1.png"));  
    
    Picture gateBG = new Picture(FileChooser.getMediaPath("Map1.png"));
  
    
    World earth = new World(map1.getWidth(), map1.getHeight());
    earth.setPicture(map1);
    
      
                                 
    Walls w = new Walls(100, 100, earth, gate);
    w.setBGPic(gateBG);
    w.showBehind(gateBG);
    w.drop(w.getPic());
    
    Walls goal = new Walls(10, 10 ,earth,tree);
    goal.setMaxHealth(1000);
    goal.setHealth(1000);
    goal.setBGPic(gateBG);
    goal.showBehind(gateBG);
    goal.drop(goal.getPic());
  
    
    Towers tow = new Towers(700, 140, earth, tower1);
    tow.drop(tow.getPic()); tow.hide();
   // tow.setAmmo();
   // Bullets b = tow.getAmmo();
    Bullets b = new Bullets(tow.getXPos() + (tow.getPic().getWidth() / 2),( tow.getYPos() + (tow.getHeight() / 2)), earth, tower1, 5);
    b.hide(); 
    
    
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
    int picCounter = 0;
    
    while(goal.isAlive() == true){               
    
    while(w.isAlive() == true){
     
   
      
     if((w.getHealth() < (w.getMaxHealth() / 3)) && (picCounter == 2)){
       w.showBehind(gateBG);
       w.drop(gate3);
       tow.drop(tow.getPic());
       picCounter += 1;
     }
     else if((w.getHealth() < (2 * w.getMaxHealth() / 3)) && (picCounter == 1)){
       w.showBehind(gateBG);
       w.drop(gate2);
       tow.drop(tow.getPic());
       picCounter += 1;
     }
     else if((w.getHealth() == w.getMaxHealth()) && (picCounter == 0)){
       w.showBehind(gateBG);
       w.drop(gate);
       picCounter += 1;
       goal.showBehind(gateBG);
       goal.drop(tree);
     }
      
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
      /*
     t.wageWar(w);
     t2.wageWar(w);
     t3.wageWar(w);
     // place a comment here
     
     int pos1 = t.getXPos();
     int pos2 = t2.getXPos();
     int pos3 = t3.getXPos();

     int closest = Math.min(pos1, Math.min(pos2,pos3));
     if(pos1 == closest){b.shoot(t);}
     else if(pos2 == closest){b.shoot(t2);}
     else if(pos3 == closest){b.shoot(t3);}
      

    System.out.println("wall health: " + w.getHealth());
      
      }catch(Exception e){
        System.out.println("Something went wrong here");
      }
  }
    w.hide();
    
    try{
      Thread.sleep(100);
      if(t.isAlive() == true){ 
        t.marchOn(goal);
        t.attack(goal);
      }
     else if(t.isAlive() == false){ //drone
        tcounter += 1;
        t.setAlive(true);
        t.hide();
        t = t.reset(earth);
     }
      
     if(t2.isAlive() == true){ 
        t2.marchOn(goal);
        t2.attack(goal);
      }
      else if(t2.isAlive() == false){ //barbarian
        t2counter += 1;
        t2.setAlive(true);
        t2.hide();
        t2 = t2.reset(earth);
      }
     
    if(t3.isAlive() == true){ 
      t3.marchOn(goal);
      t3.attack(goal);
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
      
     System.out.println("Goal Health: " + goal.getHealth());
     if(goal.getHealth() < 10){
       goal.showBehind(gateBG);
     }
    }catch (Exception e) {
      System.out.println(e.getMessage());
    }
    }
    goal.hide();
    goal.nullify(gateBG);
  }  
}
*/