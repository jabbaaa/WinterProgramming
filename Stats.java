
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
public class Stats {
    //Program settings section & Constants
    public static final int WINWIDTH=1024;
    public static final int WINHIEGHT=768;
    
    //Player stats section
    private String Player_name;
    private int Gold, Map_level,
            curtot_tower_1, max_tower_1s, tower_1_tier,
            curtot_tower_2, max_tower_2s, tower_2_tier,
            curtot_tower_3, max_tower_3s, tower_3_tier,
            curtot_tower_4, max_tower_4s, tower_4_tier,
            curtot_tower_5, max_tower_5s, tower_5_tier,
            curtot_tower_6, max_tower_6s, tower_6_tier;
    
    //Resource Section
    private String[] filelist = {"Map1.png", "Map2.png","Gate.png","Tree.png","Tower1.png", "Barbarian50x50.png"};
    private File temp;
    private BufferedImage Btemp;
    //private BufferedImage[] Buffed_Array;
    private ArrayList Buffed_Array_List;
    
    
    public void Statsinit() throws IOException{
        //init resources
        Buffed_Array_List = new ArrayList(); //Super important that this is initialized... lol!
        int i=0; //counter
        for (String x: filelist){
            temp=ResourceLoader.ResourceLoader(x);//returns a full path to files.
            System.out.println(i+"/"+ filelist.length + ":" + temp); //test line to check filename
            i++;//Counter for the previous line to help with design & troubleshooting.
            if(i == filelist.length){
                System.out.println(i + "/" + filelist.length + ": Files Loaded Successfuly.");
            }
            Btemp = new BufferedImage(ImageIO.read(temp).getHeight(),ImageIO.read(temp).getWidth(), BufferedImage.TYPE_INT_ARGB); //Buffered png file "ARGB"
            Btemp = ImageIO.read(temp);//read the image into the nest we made
            Buffed_Array_List.add(Btemp);//add the buffered image to an array list to be called later by Stats.getBList()
        }
    }
    public BufferedImage getBListItem(int x){
            return (BufferedImage) Buffed_Array_List.get(x);
        }
}   