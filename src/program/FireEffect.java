package program;

import javax.swing.*;
import java.awt.*;
import java.nio.DoubleBuffer;

public class FireEffect extends JFrame {
    private static Viewer viewer = new Viewer();

    public FireEffect() {
        this.pintarEditor();
    }

    private void pintarEditor() {
        this.setTitle("Fire Effect - Mario Nikolov");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(650, 650));
        this.pintarCanvas();
        this.pack();
        this.setVisible(true);
    }

    private void pintarCanvas() {
        this.add(viewer);
    }

    public static void main(String[] args) throws InterruptedException {
        FireEffect fireEffect = new FireEffect();
        viewer.createBufferStrategy(2);
        int cont = 0;
        System.out.println();
        while (cont < 500000) {
            Thread.sleep(40);
            viewer.repaint();
           // System.out.println("(" + MouseInfo.getPointerInfo().getLocation().x +
                 //   ", " +
                  //  MouseInfo.getPointerInfo().getLocation().y + ")");
        }
    }

}


