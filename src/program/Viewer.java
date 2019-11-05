package program;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Viewer extends Canvas {
    private String imagePath = "C:\\Users\\Alumnat\\Downloads\\negro.jpg";
    private BufferedImage image;
    private MyBufferedImage myImage;

    public Viewer() {
        try {
            image = ImageIO.read(new File(imagePath));
            myImage = new MyBufferedImage(image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void paint(Graphics g) {
        g.drawImage(image,0, 0, this.getWidth(), this.getHeight(),null);
    }

    public void chispas() {
        this.myImage.Chispas();
    }


}
