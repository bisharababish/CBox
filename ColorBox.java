package Random;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ColorBox extends Frame {
    public ColorBox(int pause, int grid) {
        setTitle("ColorBoxes");
        setLayout(new GridLayout(grid, grid));
        for (int i = 0; i < grid * grid; i++)
            add(new CBox(pause));
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        int pause = 5000;
        int grid = 10;
        if (args.length > 0)
            pause = Integer.parseInt(args[0]);
        if (args.length > 1)
            grid = Integer.parseInt(args[1]);
        Frame f = new ColorBox(pause, grid);
        f.setSize(250, 250);
        f.setVisible(true);
    }
}
