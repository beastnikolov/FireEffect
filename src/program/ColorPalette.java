package program;

import java.awt.*;
import java.util.ArrayList;

public class ColorPalette {

    public ArrayList<Color> colorArray = new ArrayList<>();

    public ColorPalette() {
        System.out.println("Generating color palette");
    }

    public void fillPalette() {
        Color rojo = new Color(255,0,0,175);
        Color amarillo = new Color(255,255,0,255);
        Color negro = new Color(0,0,0,0);
        Color blanco = new Color(78, 78, 78, 255);
        int incrementoR,incrementoG,incrementoB,incrementoA,newRojo,newVerde,newAzul,newAlpha;
        newRojo = 0;
        newVerde = 0;
        newAzul = 0;
        newAlpha = 0;


        for (int i = 0; i < 255; i++) {
            colorArray.add(i,negro);
        }

        colorArray.set(85, rojo);
        colorArray.set(170,amarillo);
        colorArray.set(254,blanco);

        incrementoA = calcularIncremento("Alpha",0,85);
        incrementoR = calcularIncremento("Red",0,85);
        incrementoG = calcularIncremento("Green",0,85);
        incrementoB = calcularIncremento("Blue",0,85);


        for (int color0 = 0; color0 < 86; color0++) {
            newRojo = newRojo + incrementoR;
            newRojo = NormalizarRGB(newRojo);
            newVerde = newVerde + incrementoG;
            newVerde = NormalizarRGB(newVerde);
            newAzul = newAzul + incrementoB;
            newAzul = NormalizarRGB(newAzul);
            newAlpha = newAlpha + incrementoA;
            newAlpha = NormalizarRGB(newAlpha);
            Color color = new Color(newRojo,newVerde,newAzul,newAlpha);
            colorArray.set(color0,color);
        }

        incrementoA = calcularIncremento("Alpha",85,170);
        incrementoR = calcularIncremento("Red",85,170);
        incrementoG = calcularIncremento("Green",85,170);
        incrementoB = calcularIncremento("Blue",85,170);


        for (int color1 = 85; color1 < 170; color1++) {
            newRojo = newRojo + incrementoR;
            newRojo = NormalizarRGB(newRojo);
            newVerde = newVerde + incrementoG;
            newVerde = NormalizarRGB(newVerde);
            newAzul = newAzul + incrementoB;
            newAzul = NormalizarRGB(newAzul);
            newAlpha = newAlpha + incrementoA;
            newAlpha = NormalizarRGB(newAlpha);
            Color color = new Color(newRojo,newVerde,newAzul,newAlpha);
            colorArray.set(color1,color);
        }

        incrementoA = calcularIncremento("Alpha",170,254);
        incrementoR = calcularIncremento("Red",170,254);
        incrementoG = calcularIncremento("Green",170,254);
        incrementoB = calcularIncremento("Blue",170,254);

        for (int color2 = 170; color2 < 255; color2++) {
            newRojo = newRojo + incrementoR;
            newRojo = NormalizarRGB(newRojo);
            newVerde = newVerde + incrementoG;
            newVerde = NormalizarRGB(newVerde);
            newAzul = newAzul + incrementoB;
            newAzul = NormalizarRGB(newAzul);
            newAlpha = newAlpha + incrementoA;
            newAlpha = NormalizarRGB(newAlpha);
            Color color = new Color(newRojo,newVerde,newAzul,newAlpha);
            colorArray.set(color2,color);
        }
        

    }


    public int calcularIncremento(String tipoColor,int puntoBajo,int puntoAlto) {
        int incremento = 0;
        if (tipoColor.equals("Red")) {
            incremento = (colorArray.get(puntoAlto).getRed() - colorArray.get(puntoBajo).getRed()) / 85;
        } else if (tipoColor.equals("Green")) {
            incremento = (colorArray.get(puntoAlto).getGreen() - colorArray.get(puntoBajo).getGreen()) / 85;
        } else if (tipoColor.equals("Blue")) {
            incremento = (colorArray.get(puntoAlto).getBlue() - colorArray.get(puntoBajo).getBlue()) / 85;
        } else {
            incremento = (colorArray.get(puntoAlto).getAlpha() - colorArray.get(puntoBajo).getAlpha()) / 85;
        }
        return incremento;
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
