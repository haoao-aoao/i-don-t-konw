package GameBird;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import static GameBird.Tools.getImg;

/*
    柱子类
 */
public class Column {
    //上柱子的图片
    BufferedImage img1;
    //下柱子的图片
    BufferedImage img2;
    //坐标
    int x;
    int y1;
    //宽度&高度
    int w1;
    int h1;

    int y2;
    int w2;
    int h2;

    //柱子间的间隙
    int distance;

    Random rd = new Random();

    public Column(int i){

        img1 = getImg("/img/pipe_down.png");

        //初始化柱子间距
        distance = 245;
        //获取图片的高度
        h1 = img1.getHeight();
        //获取图片的宽度
        w1 = img1.getWidth();

        x = 300 + distance*(i-1);
        //设定柱子y坐标随即值
        y1 = -rd.nextInt(180);


        img2 = getImg("/img/pipe_up.png");

        //获取图片的高度
        h2 = img2.getHeight();
        //获取图片的宽度
        w2 = img2.getWidth();

        y2 = y1 + 400;


    }

    //柱子移动
    public void move(){

        if(x <= -w1){
            x = 275 + distance;
            y1 = -rd.nextInt(180);
            y2 = y1 + 400;
        }
        x--;

    }
}
