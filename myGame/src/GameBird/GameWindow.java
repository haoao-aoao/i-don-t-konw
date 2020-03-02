package GameBird;

import javax.swing.*;
import java.awt.*;
/*
    窗口类
 */
public class GameWindow extends JFrame {

    public GameWindow() throws HeadlessException {
        setSize(432,644);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("飞翔的小鸟鸟 Verson 0.1");

        setIconImage(Tools.getImg("/img/bird2_0.png"));


    }
}
