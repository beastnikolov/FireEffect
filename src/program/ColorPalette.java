package program;

import java.awt.*;
import java.util.ArrayList;

public class ColorPalette {

    public ArrayList<Color> colorArray = new ArrayList<>();

    public ColorPalette() {
        System.out.println("Generating color palette");
    }

    public void fillPalette() {
        int newRojo = 0;
        int newVerde = 0;
        int newAzul = 0;


        for (int i = 0; i < 255; i++) {
            colorArray.add(i,Color.black);
        }

        colorArray.set(85, Color.RED.darker());
        colorArray.set(170,Color.YELLOW);
        colorArray.set(254,Color.white);

        for (int color0 = 0; color0 < 86; color0++) {
            newRojo = newRojo + Calculo(color0, 85, "Red", 85);
            newRojo = NormalizarRGB(newRojo);
            newVerde = newVerde +  Calculo(color0, 85, "Green", 85);
            newVerde = NormalizarRGB(newVerde);
            newAzul = newAzul + Calculo(color0,85,"Blue", 85);
            newAzul = NormalizarRGB(newAzul);
            Color color = new Color(newRojo,newVerde,newAzul);
            colorArray.set(color0,color);
        }




        for (int color1 = 85; color1 < 170; color1++) {
            newRojo = newRojo + Calculo(color1, 170, "Red", 85);
            newRojo = NormalizarRGB(newRojo);
            newVerde = newVerde +  Calculo(color1, 170, "Green", 85);
            newVerde = NormalizarRGB(newVerde);
            newAzul = newAzul + Calculo(color1,170,"Blue", 85);
            newAzul = NormalizarRGB(newAzul);
            Color color = new Color(newRojo,newVerde,newAzul);
            colorArray.set(color1,color);
        }

        for (int color2 = 170; color2 < 255; color2++) {
            newRojo = newRojo + Calculo(color2, 254, "Red", 85);
            newRojo = NormalizarRGB(newRojo);
            newVerde = newVerde +  Calculo(color2, 254, "Green", 85);
            newVerde = NormalizarRGB(newVerde);
            newAzul = newAzul + Calculo(color2,254,"Blue", 85);
            newAzul = NormalizarRGB(newAzul);
            Color color = new Color(newRojo,newVerde,newAzul);
            colorArray.set(color2,color);
        }

    }

    public int Calculo(int index, int divisor, String color, int diferencia) {
        int result = 0;
        if (color.equals("Red")) {
            result = (colorArray.get(divisor).getRed() - colorArray.get(index).getRed()) / diferencia;
        } else if (color.equals("Green")) {
            result = (colorArray.get(divisor).getGreen() - colorArray.get(index).getGreen()) / diferencia;
        } else {
            result = (colorArray.get(divisor).getBlue() - colorArray.get(index).getBlue()) / diferencia;
        }
        return result;
    }

    public int NormalizarRGB(int valor) {
        if (valor > 255) {
            valor = 255;
        }
        if (valor < 0) {
            valor = 0;
        }
        return valor;
    }



}
