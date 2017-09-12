import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JComponent {
    private final static JFrame frame = new JFrame();
    public static final Logic logic = Logic.getLogic();
    private static Thread logicThread;
    private final static int size = 25;
    public final static GUI gui = new GUI();
    public GUI()
    {
        frame.setTitle("Tetris, lev: 1, sc: 0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(256, 528);
        frame.setLayout(new BorderLayout(0, 0));
        frame.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent evt) {
                    switch (evt.getKeyCode()) {
                        case KeyEvent.VK_RIGHT: {
                            if (!logic.getPause())
                            {
                                logic.fallen.right();
                                gui.repaint();
                            }
                            break;
                        }
                        case KeyEvent.VK_LEFT: {
                            if (!logic.getPause())
                            {
                                logic.fallen.left();
                                gui.repaint();
                            }
                            break;
                        }
                        case KeyEvent.VK_UP: {
                            if (!logic.getPause())
                            {
                                logic.fallen.move();
                                gui.repaint();
                            }
                            break;
                        }
                        case KeyEvent.VK_DOWN: {
                            if (!logic.getPause())
                            {
                                synchronized (GUI.logic) {
                                    int count = logic.fallen.stepsToDown();
                                    for (int i = 1; i < count; i++)
                                        logic.fallen.down();
                                    gui.repaint();
                                }
                            }
                            break;
                        }
                        case KeyEvent.VK_SPACE: {
                            logic.setPause(!logic.getPause());
                            logicThread.interrupt();
                            break;
                        }
                        default:
                            break;
                    }
            }
        });
    }
    public void paintComponent(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 20; y++) {
                if (logic.getFromArray(x, y) == ' ') {
                    g2d.setPaint(Color.WHITE);
                    g2d.fillRect(x * size, y * size, size, size);
                    g2d.setPaint(Color.LIGHT_GRAY);
                    g2d.drawRect(x * size, y * size, size, size);
                }
            }
        }
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 20; y++) {
                synchronized (logic) {
                    switch (logic.getFromArray(x, y)) {
                        case 'I': {
                            g2d.setPaint(Color.CYAN);
                            g2d.fillRect(x * size, y * size, size, size);
                            g2d.setPaint(Color.BLACK);
                            g2d.drawRect(x * size, y * size, size, size);
                            break;
                        }
                        case 'O': {
                            g2d.setPaint(Color.YELLOW);
                            g2d.fillRect(x * size, y * size, size, size);
                            g2d.setPaint(Color.BLACK);
                            g2d.drawRect(x * size, y * size, size, size);
                            break;
                        }
                        case 'S': {
                            g2d.setPaint(Color.GREEN);
                            g2d.fillRect(x * size, y * size, size, size);
                            g2d.setPaint(Color.BLACK);
                            g2d.drawRect(x * size, y * size, size, size);
                            break;
                        }
                        case 'Z': {
                            g2d.setPaint(Color.RED);
                            g2d.fillRect(x * size, y * size, size, size);
                            g2d.setPaint(Color.BLACK);
                            g2d.drawRect(x * size, y * size, size, size);
                            break;
                        }
                        case 'T': {
                            g2d.setPaint(Color.MAGENTA);
                            g2d.fillRect(x * size, y * size, size, size);
                            g2d.setPaint(Color.BLACK);
                            g2d.drawRect(x * size, y * size, size, size);
                            break;
                        }
                        case 'L': {
                            g2d.setPaint(Color.ORANGE);
                            g2d.fillRect(x * size, y * size, size, size);
                            g2d.setPaint(Color.BLACK);
                            g2d.drawRect(x * size, y * size, size, size);
                            break;
                        }
                        case 'J': {
                            g2d.setPaint(Color.BLUE);
                            g2d.fillRect(x * size, y * size, size, size);
                            g2d.setPaint(Color.BLACK);
                            g2d.drawRect(x * size, y * size, size, size);
                            break;
                        }
                    }
                }
            }
        }
    }

    public static void setScoreInTitle(int score, int level) {
        synchronized (GUI.class)
        {
            if (level == -1)
                frame.setTitle("Game Over! Your score: " + score);
            else
                frame.setTitle("Tetris, lev: " + level + ", sc: " + score);
        }
    }

    public static void main(String[] args) throws Exception
    {
        frame.add(gui);
        frame.setVisible(true);
        logicThread = new Thread(logic);
        logicThread.start();
    }
}
