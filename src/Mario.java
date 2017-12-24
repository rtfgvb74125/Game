import javax.swing.*;
import java.awt.image.BufferedImage;

public class Mario {
    private int x;
    private int y;
    private int moveX,moveY;
    private String action;
    private BufferedImage actionImage;
    private boolean cBig = false;

    public Mario(int x,int y){
        this.x = x;
        this.y = y;

        this.action = "right";
    }

    public void leftMove(){
        moveX = -5;

    }
    public void RightMove(){

    }
    public void leftStop(){

    }
    public void RightStop(){

    }
    public void jump(){

    }
}
