public class Walls extends Turtle{
  
  private int boundary;
  private int health;
  private Picture pic;
  private boolean life;
  private World world;
  private Picture bgPic;
  
  public Walls(int x, int y, ModelDisplay mD, Picture p){
   super(x,y,mD);
   boundary = x + p.getWidth();
   pic = p;
   bgPic = new Picture(((World)mD).getPicture());
   health = 20;
  }

  public int getHealth(){
    return this.health;
  }
  public void setHealth(int newHealth){
    this.health = newHealth;
  }
  
  public int getBoundary(){
    return this.boundary;
  }
  
  public Picture getPic(){
    return this.pic;
  }
  
  public void nullify(){
    this.hide();
    Picture temp = this.showBehind(bgPic);
    this.drop(temp);
   
    System.out.println("GAME OVER");
  }
  
  public Picture showBehind(Picture background){
    int x = getXPos(); int y = getYPos();
    Picture p = new Picture(pic.getWidth(), pic.getHeight());
    for(int i = 0; i<p.getWidth(); i++){
      for(int j = 0; j<p.getHeight(); j++){
        int value = background.getBasicPixel(i + x,j+y);
        p.setBasicPixel(i,j,value);
      }
    }
    return p;
  }
  
  public boolean isAlive(){
    if(this.health > 0){
      life = true;
    } else { life = false; }
   return life;
  }
  
  public Picture getBGPic(){
    return this.bgPic;
  }
}
  

      