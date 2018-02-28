public class Towers extends Turtle{
   private Picture pic;
   private int xPos;
   private int yPos;
 //  private int health;
  
  public Towers(int x, int y, ModelDisplay mD, Picture p){
    super(x,y,mD);
    pic = p;
    //health = 1000;
  }
  
  public Picture getPic(){
    return this.pic;
  }
  
  public void defendAgainst(toySoldiers t){
   Bullets bullet = new Bullets(xPos,yPos,t.getWorld(), 
                                  new Picture(FileChooser.getMediaPath("tinyBullet.png")), 5);
    while(t.getHealth() > 0 ){
       try{
     int x = t.getXPos();
     int y = t.getYPos();
     bullet.setHeading(bullet.calcHeading(x,y));
     int distance = (int)this.getDistance(x,y);
     
     for(int i=0; i<5; i++){
     Thread.sleep(10);
     bullet.forward(distance/5);
     }
     t.setHealth(t.getHealth() - 1);
     bullet.reset();
     
     Thread.sleep(100);
       
       } catch (Exception e){
          System.out.println("here");
       }
     }
  } 
}