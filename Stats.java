
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
    private int Gold, Map_level,
            curtot_tower_1, max_tower_1s, tower_1_tier,
            curtot_tower_2, max_tower_2s, tower_2_tier,
            curtot_tower_3, max_tower_3s, tower_3_tier,
            curtot_tower_4, max_tower_4s, tower_4_tier,
            curtot_tower_5, max_tower_5s, tower_5_tier,
            curtot_tower_6, max_tower_6s, tower_6_tier;
    private boolean isLoadingResources;
    
    /*Resource Section
    
    temp- used to hold a temp file
    Btemp- used to hold buffered image from temp file before it is added to the buffed array list
    Buffed_A_L- Grows with the size of the filelist, it would be more memory efficient to use a buffered image array but
                at the moment, this will cause less issues with collaboration.
    
    */
    private String[] filelist = {"Map1.png", "Map2.png",
                                "Gate.png", "Gate2.png", "Gate3.png","Tree.png","Tower1.png", 
                                "Barbarian50x50.png","Barbarian100x100.png",
                                "Light_Effect.png","Light_Effect2.png","Light_Effect3.png","Light_Effect4.png","Light_Effect5.png"
    };
    private File temp;
    private BufferedImage Btemp;
    private BufferedImage[] Buffed_Array_List; //Based on filelist.length but grows as needed.
    
    
    public void init() throws IOException{
        isLoadingResources=true;
        //init resources
        Buffed_Array_List = new BufferedImage[filelist.length]; //Super important that this is initialized... lol!
        int i=0; //counter
        for (String x: filelist){
            temp=ResourceLoader.ResourceLoader(x);//returns a full path to files.
            System.out.println(i+"/"+ filelist.length + ":" + temp); //test line to check filename
            //i++;//Counter for the previous line to help with design & troubleshooting.
            
            if(i == filelist.length){
                System.out.println(i + "/" + filelist.length + ": Files Loaded Successfuly.");
                isLoadingResources=false; //a check so that the resources are loaded prior to the game.
            }
            
            Btemp = new BufferedImage(ImageIO.read(temp).getHeight(),ImageIO.read(temp).getWidth(), BufferedImage.TYPE_INT_ARGB); //Buffered png file "ARGB"
            Btemp = ImageIO.read(temp);//read the image into the nest we made
            Buffed_Array_List[i]=Btemp;
            //Buffed_Array_List.add(Btemp);//add the buffered image to an array list to be called later by Stats.getBList()
            i++;
        }
        
        //init gold and map
        Gold = 0;
        Map_level=1;
    }
    public BufferedImage getBListItem(int x){
            return Buffed_Array_List[x];
        }
    
    public BufferedImage[] getBList(){
        return Buffed_Array_List;
    }
    
    public void addGold(int x){
        this.Gold+=x; //itself plus x
    }
    public void subGold(int x){
        this.Gold-=x;
    }
    public int getGold(){
        return this.Gold;
    }
    
    public void setMapLevel(){
     //nothing here yet.   
    }
    
    public int getMapLevel(){
        return this.Map_level;
    }
    public boolean isLoading(){
        return isLoadingResources;
    }
}   