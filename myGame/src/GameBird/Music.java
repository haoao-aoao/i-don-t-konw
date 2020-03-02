package GameBird;


import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class Music {
    Player player;
    InputStream is = this.getClass().getResourceAsStream("/music/yasuo - mmz-boy.mp3");

    public Music(){

    }

    public void musicPlayerOpen() {
        try {
            player = new Player(is);
            player.play();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public void musicPlayerClose() {
        player.close();
    }
}
