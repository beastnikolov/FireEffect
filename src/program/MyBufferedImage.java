package program;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.Random;

public class MyBufferedImage extends BufferedImage {
    private byte[] copia;
    private byte[]array_bytes;
    private int altura;
    private int ancho;

    public MyBufferedImage(BufferedImage bi) {
        super(
                bi.getColorModel(), bi.getRaster(), bi.getColorModel().isAlphaPremultiplied(), null

        );

        altura = bi.getHeight();
        ancho = bi.getWidth();
        array_bytes = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
        copia = new byte[array_bytes.length];
        System.arraycopy(array_bytes, 0, copia, 0,array_bytes.length);
    }

    public void Chispas() {
        int r;
        int g;
        int b;
        Color c;


        for (int y = altura - 1; y > altura-2; y--) {
            for (int x = ancho - 1; x > 0; x--) {
                r = g = b = 0;
                c = conseguirRgb(y,x);
                Random random = new Random();
                Color color = new Color(random.nextInt(255),random.nextInt(255),random.nextInt(255));
                setPixel(y,x,color);

            }
        }

    }

    public Color conseguirRgb(int y, int x) {
        int i = (y*ancho*3) + (x*3);
        Color color = new Color(Byte.toUnsignedInt(copia[i+2]), Byte.toUnsignedInt(copia[i+1]), Byte.toUnsignedInt(copia[i]));
        return color;
    }

    public void  setPixel(int y, int x, Color color) {
        int i = (y*ancho*3) + (x*3);
        array_bytes[i] = (byte) color.getBlue();
        array_bytes[i+1] = (byte) color.getGreen();
        array_bytes[i+2] = (byte) color.getRed();
    }

}
