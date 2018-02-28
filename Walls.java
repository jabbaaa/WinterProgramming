public class Walls extends Turtle{
  
  private int boundary;
  private int health;
  private Picture pic;
  private boolean life = true;
  private World world;
  private Picture bgPic;
  
  public Walls(int x, int y, ModelDisplay mD, Picture p){
   super(x,y,mD);
   boundary = x + p.getWidth();
   pic = new Picture(p);
   health = 2000;
  }
  public int getHealth(){
    return this.health;
  }
  public void setHealth(int newHealth){
    this.health = newHealth;
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
   
  }

  

}