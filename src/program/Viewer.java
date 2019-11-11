package program;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Viewer extends Canvas {
    private String pathBackground = "C:\\Users\\Alumnat\\Downloads\\test.jpg";
    private BufferedImage bg;
    private MyBufferedImage myImage;

    public Viewer() {

        try {
            bg = ImageIO.read(new File(pathBackground));
            myImage = new MyBufferedImage(bg.getHeight(),bg.getWidth());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint() {
        BufferStrategy bs;

        bs = this.getBufferStrategy();
        if (bs == null) {
            System.out.println("NULL");
            return;
        }

        Graphics graphics = bs.getDrawGraphics();
        graphics.drawImage(bg,0,0,this.getWidth(),this.getHeight(),null);
        graphics.drawImage(myImage,0,0,this.getWidth(),this.getHeight(),null);

        bs.show();
        graphics.dispose();

    }


    public void repaint() {

        myImage.Loop_Fuego();
        this.paint();

    }



}
