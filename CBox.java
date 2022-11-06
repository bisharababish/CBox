package Random;

//: ColorBoxes.java
// Using the Runnable interface
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

class CBox extends Canvas implements Runnable {
    private Thread t;
    private int pause;
    private static final Color[] colors = {
            new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)),
            new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)),
            new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)),
            new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)),
            new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)),
            new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)),
            new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)),
            new Color((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255)) };
    private Color cColor = newColor();

    private static final Color newColor() {

        return colors[(int) (Math.random() * colors.length)];
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(cColor);
        Dimension s = getSize();
        g.fillRect(0, 0, s.width, s.height);
    }

    public CBox(int pause) {
        this.pause = pause;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            cColor = newColor();
            repaint();
            try {
                t.sleep(pause);
            } catch (InterruptedException e) {
            }
        }
    }
}
