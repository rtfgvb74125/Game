import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ActionImage {
    public static List<BufferedImage> marioImage = new ArrayList<BufferedImage>();
    public static String imagePath = System.getProperty("user.dir")+"/Image/";
public static void init(){
    for(int i = 1;i<=10;i++){
        try {
            marioImage.add(ImageIO.read(new File(imagePath+i+".png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }

}
