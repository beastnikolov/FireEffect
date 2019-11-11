package program;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.util.Random;
import java.util.Timer;

public class MyBufferedImage extends BufferedImage {
    private byte[] copia;
    private byte[]array_bytes;
    private int altura;
    private int ancho;
    private int[][] array_temp;
    private Random random = new Random();
    private ColorPalette colorPalette = new ColorPalette();

    public MyBufferedImage(int Width, int Height) {
        super(
                Width,Height, BufferedImage.TYPE_4BYTE_ABGR

        );
        //altura = Height;
        altura = 521;
        ancho = Width;
        colorPalette.fillPalette();
        array_bytes = ((DataBufferByte) this.getRaster().getDataBuffer()).getData();
        array_temp = new int[altura][ancho];
        poblarArrayTemperaturas();
        copia = new byte[array_bytes.length];
        System.arraycopy(array_bytes, 0, copia, 0,array_bytes.length);
        System.out.println("Array length: " + array_bytes.length + " " + this.getColorModel().hasAlpha());
    }

    public void Fuego() {
        // x = ancho - 2 , x > 0
        for (int y = altura - 3; y >= 0; y--) {
            for (int x = 553 - 1; x > 275; x--) {
                setPixel(y,x,array_temp[y][x]);
            }
        }

    }

    public void Loop_Fuego() {
        poblarArrayTemperaturas();
        Fuego();

    }




    public void  setPixel(int y, int x, int Temp) {
        Color color = colorPalette.colorArray.get(Temp);
        int i = (y*ancho*4) + (x*4) ;
        array_bytes[i] = (byte) color.getAlpha();
        array_bytes[i+1] = (byte) color.getBlue();
        array_bytes[i+2] = (byte) color.getGreen();
        array_bytes[i+3] = (byte) color.getRed();
    }

    public void poblarArrayTemperaturas() {
        for (int y = altura-1; y >= altura-1; y--) {
            // x = ancho - 1 | x > 0
            for (int x = 560 - 1; x > 272; x--) {
                if (random.nextInt(2) == 1) {
                    array_temp[y][x] = 254;
                } else {
                    array_temp[y][x] = 0;
                }
            }
        }

        for (int y = altura -2; y > 0; y--) {
            for (int x = ancho - 2; x > 1; x--) {
                array_temp[y][x] = (int) ((array_temp[y][x-1] + array_temp[y][x+1] +array_temp[y+1][x-1] + array_temp[y+1][x] + array_temp[y+1][x+1])/ 5.02);
                if (array_temp[y][x] > 254) {
                    array_temp[y][x] = 254;
                }
               // System.out.println(array_temp[y][x]);
            }
        }
    }



}
