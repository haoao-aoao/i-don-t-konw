package GameBird;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Tools {

    public static BufferedImage getImg(String path){
        BufferedImage img = null;
        try {
            img = ImageIO.read(Tools.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return img;
    }

}
