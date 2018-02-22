import java.io.File;

/*
* @author Drogana
* The intent of this file is to store some static resource loading classes.
 */
public class ResourceLoader {
    
    public static File ResourceLoader(String x){ //this will be called in stats to load level resources.
    File f = new File ("\\" + x); //Relative path
    if (f.canRead() != true){ //If it cant read the file, try absolute path\src\*File.png*
    f = new File ( new File("src").getAbsolutePath() + "\\" + x);
    }
        return f;
    }
}
