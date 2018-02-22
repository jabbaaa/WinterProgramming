
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Drogana
 */
public class Tree {
    private int x, y, hp;
    private BufferedImage img;
    private String fileName = "\\Tree.png";
    
    public void tree(int x, int y) throws IOException{
    this.img = new BufferedImage(1024,768, BufferedImage.TYPE_INT_ARGB); //Buffered png file "ARGB"
    this.x = x;
    this.y = y;
            loadresources();
    }
    
    private void loadresources() throws IOException {
    File f = new File (fileName); //Relative path
    if (f.canRead() != true){ //If it cant read the file, try absolute path\src\*File.png*
    f = new File ( new File("src").getAbsolutePath() + fileName);
    }
img = new BufferedImage(258,311, BufferedImage.TYPE_INT_ARGB); //Buffered png file "ARGB"
img = ImageIO.read(f); //read the file into the buffer.
    }
    
    public int getX(){
        return this.x;
        
    }
    public int getY(){
        return this.y;
    }
    public BufferedImage getPic(){
        return this.img;
    }
}
