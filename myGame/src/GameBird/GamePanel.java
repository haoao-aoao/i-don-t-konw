package GameBird;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

/*
    画板类
 */
public class GamePanel extends JPanel {
    //声明一个存放背景图片的变量
    BufferedImage bg;
    //声明一个用于存放地面的变量
    Ground land;
    //声明第一处柱子
    Column column1;
    //声明第二处柱子
    Column column2;
    //声明鸟对象
    Bird bird;
    //游戏准备状态
    boolean start;
    //游戏结束状态
    boolean gameover;
    //分数
    int score;

    Music music;



    //构造器
    public GamePanel(){
        //设置背景颜色
        setBackground(Color.red);
        //设置背景图片
        bg = Tools.getImg("/img/bg_night.png");
        //初始化地面对象
        land = new Ground();
        //初始化柱子对象
        column1 =new Column(1);
        column2 =new Column(2);
        //初始化鸟对象
        bird = new Bird();
        //初始化游戏状态
        start = false;
        //初始化游戏结束状态
        gameover = false;
        //初始化分数
        score = 0;

        music = new Music();



        //初始化鼠标监听器
        MouseAdapter ma = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if(start == false){
                    if(e.getX() <=100 && e.getY()<=100){
                        start = true;
                        start();
                    }

                }else if(gameover == true){
                    start = false;
                    gameover = false;
                    //初始化地面对象
                    land = new Ground();
                    //初始化柱子对象
                    column1 =new Column(1);
                    column2 =new Column(2);
                    //初始化鸟对象
                    bird = new Bird();
                    //初始化分数
                    score = 0;
                    //music.musicPlayerClose();
                    repaint();
                }else{
                    bird.moveUp();
                }
            }


        };

        this.addMouseListener(ma);
        ActionListener al = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };

    }

    //游戏开始的方法
    public void start(){
        System.out.println("启动游戏");
//        MyThread2 mt2 = new MyThread2();
//        Thread thread2 = new Thread(mt2);
//        thread2.start();
        //创建线程对象
        MyThread mt = new MyThread();
        Thread thread = new Thread(mt);
        thread.start();

    }

    //重写paint方法，用来向画板绘制内容，g相当与画笔
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //绘制背景图片（需要绘制的图片，x坐标，y坐标，null）
        g.drawImage(bg,0,0,432,644,null);
        //柱子的图片
        g.drawImage(column1.img1,column1.x,column1.y1,null);
        g.drawImage(column1.img2,column1.x,column1.y2,null);

        g.drawImage(column2.img1,column2.x,column2.y1,null);
        g.drawImage(column2.img2,column2.x,column2.y2,null);

        //绘制地面图片
        g.drawImage(land.img,land.x,land.y,500,land.h,null);

        //绘制鸟
        g.drawImage(bird.img,bird.x,bird.y,null);
        //准备状态图片
        if(start == false){
            g.drawImage(Tools.getImg("/img/title.png"),120,170,null);
            g.drawImage(Tools.getImg("/img/tutorial.png"),150,260,null);
        }
        //结束状态的图片
        if(gameover == true){
            g.drawImage(Tools.getImg("/img/text_game_over.png"),120,180,null);
            g.drawImage(Tools.getImg("/img/button_play.png"),155,270,null);
        }
        Font f = new Font("微软雅黑",Font.BOLD,20);
        g.setFont(f);
        g.setColor(Color.DARK_GRAY);
        g.drawString("score:" + score,20,30);

    }

    //游戏运行线程
    class MyThread implements Runnable{
        //游戏线程要执行的
        @Override
        public void run() {
            while(true){
                //调用地面移动方法
                land.move();
                //柱子移动
                column1.move();
                column2.move();
                //小鸟飞方法
                bird.fly();
                //小鸟落体运动
                bird.move();
                //检测小鸟是否与顶底部发生碰撞
                boolean hit1 = bird.hit();
                //检测小鸟是否与柱子1发生碰撞
                boolean hit2 = bird.hit(column1);
                //检测小鸟是否与柱子1发生碰撞
                boolean hit3 = bird.hit(column2);
                //若发生碰撞则游戏状态
                if(hit1 == true || hit2 == true || hit3 == true){
                    gameover = true;
                    //窗口对象停止
                    return;//结束当前方法
                }else{
                    gameover = false;
                }
                //计算分数
                if(bird.x == column1.x +column1.w1 || bird.x == column2.x +column2.w2){
                    score++;
                }
                //延时
                try {
                    Thread.sleep(25);
                    //刷新画面
                    repaint();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    class MyThread2 implements Runnable{

        @Override
        public void run() {
            music.musicPlayerOpen();
        }
    }


}
