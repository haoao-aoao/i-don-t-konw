package GameBird;

public class GameMain {
    public static void main(String[] args) {
        //创建窗体对象
        GameWindow gw = new GameWindow();
        //创建画板对象
        GamePanel gp =new GamePanel();
        //向窗体添加一块画板
        gw.add(gp);
        //显示窗体
        gw.setVisible(true);
        //启动游戏
//        gp.start();

    }
}
