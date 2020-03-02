package GameBird;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
/*
    地板类
 */
public class Ground {
    //x坐标
    int x;
    //y坐标
    int y;
    //地面的宽度
    int w;
    //地面的高度
    int h;
    //地面的图片
    BufferedImage img;

    //地面的构造器用来构造地面对象
    public Ground() {
        //先初始化地面图片

        img = Tools.getImg("/img/land.png");

        //获取图片的高度
        h = img.getHeight();
        //获取图片的宽度
        w = img.getWidth();
        //初始化x
        x = 0;
        //初始化y
        y = 644 - h;
    }

    //地面移动的方法
    public void move() {

        if(x <= 432-500){
            x = 0;
        }
        x--;
    }

}
