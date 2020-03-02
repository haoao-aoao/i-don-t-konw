package GameBird;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/*
    小鸟类
 */
public class Bird {
    //鸟的图片
    BufferedImage img;
    BufferedImage img1;
    BufferedImage img2;
    BufferedImage img3;

    int x;
    int y;

    int h;
    int w;

    //用集合装鸟的图片
    List<BufferedImage> list;

    //初速度
    double v0;
    //时间间隔（往上移的时间）
    double t;
    //距离
    double s;
    //重力
    double g;

    //构造器
    public Bird() {
        //获取图片
        img = Tools.getImg("/img/bird0_0.png");
        img1 = Tools.getImg("/img/bird0_0.png");
        img2 = Tools.getImg("/img/bird0_1.png");
        img3 = Tools.getImg("/img/bird0_2.png");

        x = 100;
        y = 200;

        h = img.getHeight();
        w = img.getWidth();

        list = new ArrayList<>();
        list.add(img1);
        list.add(img2);
        list.add(img3);
        list.add(Tools.getImg("/img/bird1_0.png"));
        list.add(Tools.getImg("/img/bird1_1.png"));
        list.add(Tools.getImg("/img/bird1_2.png"));

        //初始化初速度
        v0 = 3;
        //时间
        t = 0.2;
        //距离
        s = 0;
        //重力
        g = 5;
    }
    //鸟动的方法
    int index = 0;
    public void fly() {
        img = list.get(index);
        index++;

        if (index >= 5){
            index = 0;
        }
    }
    //小鸟落体运动
    public void move(){
        //计算小鸟上抛的距离
        s = v0*t;
        //得到小鸟上抛最高点时的y坐标
        y = (int)(y - s);
        //计算出小鸟到达最高点的速度
        double v2 = v0 -g*t;
        //最高点的速度就是小鸟下落时的初速度
        v0 = v2;
    }

    //小鸟上抛运动
    public void moveUp() {
        v0 = 17;
    }

    //小鸟与顶底部碰撞检测
    public boolean hit(){
        if(y <= 0 || y >= 644-112-h){
            return true;
        }else{
            return false;
        }
    }

    //小鸟与柱子的碰撞
    public boolean hit(Column column){
        if(x >= column.x-w+10 && x <=column.x + column.w1-10){
            if(y >= column.y1+column.h1-10 && y <= column.y2-40){
                return false;
            }
            return true;
        }


        return false;
    }

}
