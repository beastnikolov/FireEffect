package program;

import javax.swing.*;
import java.awt.*;

public class FireEffect extends JFrame {
    private static Viewer viewer = new Viewer();

    public FireEffect() {
        this.pintarEditor();
    }

    private void pintarEditor() {
        this.setTitle("Fire Effect - Mario Nikolov");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setPreferredSize(new Dimension(1024, 768));
        this.pintarCanvas();
        this.pack();
        this.setVisible(true);
    }

    private void pintarCanvas() {
        this.add(viewer);
       // viewer.chispas();
    }

    public static void main(String[] args) throws InterruptedException {
        FireEffect fireEffect = new FireEffect();
        int cont = 0;
        while (cont < 500000) {
            Thread.sleep(100);
            viewer.repaint();

        }
    }

}


