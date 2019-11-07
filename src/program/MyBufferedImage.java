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
    private int[][] array_temp;
    private Random random = new Random();
    private ColorPalette colorPalette = new ColorPalette();

    public MyBufferedImage(BufferedImage bi) {
        super(
                bi.getColorModel(), bi.getRaster(), bi.getColorModel().isAlphaPremultiplied(), null

        );
        altura = bi.getHeight();
        ancho = bi.getWidth();
        colorPalette.fillPalette();
        array_bytes = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
        array_temp = new int[altura][ancho];
        poblarArrayTemperaturas();
        copia = new byte[array_bytes.length];
        System.arraycopy(array_bytes, 0, copia, 0,array_bytes.length);
    }

    public void Fuego() {
        for (int y = altura - 1; y >= altura / 4; y--) {
            for (int x = ancho - 1; x > 0; x--) {
                setPixel(y,x,array_temp[y][x]);
            }
        }

    }

    public void Loop_Fuego() {
        poblarArrayTemperaturas();
        Fuego();
    }

    public Color conseguirRgb(int y, int x) {
        int i = (y*ancho*3) + (x*3);
        Color color = new Color(Byte.toUnsignedInt(copia[i+2]), Byte.toUnsignedInt(copia[i+1]), Byte.toUnsignedInt(copia[i]));
        return color;
    }



    public void  setPixel(int y, int x, int Temp) {
        Color color = colorPalette.colorArray.get(Temp);
        int i = (y*ancho*3) + (x*3);
        array_bytes[i] = (byte) color.getBlue();
        array_bytes[i+1] = (byte) color.getGreen();
        array_bytes[i+2] = (byte) color.getRed();
    }

    public void poblarArrayTemperaturas() {
        for (int y = altura-1; y >= altura-1; y--) {
            for (int x = ancho - 1; x > 0; x--) {
                if (random.nextInt(2) == 1) {
                    array_temp[y][x] = 254;
                    //System.out.println("Array - POS Y: " + y + " | POS X: " + x + " | = " + array_temp[y][x]);
                } else {
                    array_temp[y][x] = 0;
                   // System.out.println("Array - POS Y: " + y + " | POS X: " + x + " | = " + array_temp[y][x]);
                }
            }
        }

        for (int y = altura -2; y > 0; y--) {
            for (int x = ancho - 2; x > 1; x--) {
                array_temp[y][x] = (int) ((array_temp[y][x-1] + array_temp[y][x+1] +array_temp[y+1][x-1] + array_temp[y+1][x] + array_temp[y+1][x+1]) / 5.02);
                if (array_temp[y][x] > 254) {
                    array_temp[y][x] = 254;
                }
               // System.out.println(array_temp[y][x]);
            }
        }
    }



}
