import java.util.concurrent.CopyOnWriteArrayList;
import java.util.Random;
public class Logic implements Runnable {

    public volatile Shape fallen;

    private volatile long timing;
    private volatile boolean pause = false;
    private volatile int score;
    private volatile boolean lose = false;
    private volatile char[][] array;
    private volatile Random random = new Random();
    private volatile CopyOnWriteArrayList<Shape> shapes;
    private volatile int level = 1;
    private Logic()
    {
        timing = 800;
        score = 0;
        array = new char[10][20];
        shapes = new CopyOnWriteArrayList<Shape>();
        fallen = generateNewFigure();
        shapes.add(fallen);
    }

    public static Logic getLogic()
    {
        return new Logic();
    }

    public synchronized void print()
    {
        for (int x = 0; x < 20; x++)
        {
            for (int y = 0; y < 10; y++)
                System.out.print("'" + array[y][x] + "' ");
            System.out.println();
        }
        System.out.println("Done!");
    }

    public synchronized Shape getLastShape()
    {
        if (shapes.size() == 1)
            return null;
        else
            return shapes.get(shapes.size() - 2);
    }

    public synchronized char getFromArray(int x, int y)
    {
        return array[x][y];
    }

    public synchronized void setInArray(int x, int y, char symb)
    {
        array[x][y] = symb;
    }

    public synchronized void setInArray(Square s, char symb)
    {
        array[s.x][s.y] = symb;
    }

    public synchronized boolean getPause()
    {
        return pause;
    }

    public synchronized void setPause(boolean pause)
    {
        this.pause = pause;
    }

    public void run()
    {
        try
        {
            boolean del;
            Shape temp;
            while (!lose)
            {
                do {
                    while (pause) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {

                        }
                    }
                    synchronized (this)
                    {
                        for (int x = 0; x < 10; x++)
                            for (int y = 0; y < 20; y++)
                                array[x][y] = ' ';
                        for (int i = 0; i < shapes.size(); i++) {
                            temp = shapes.get(i);
                            del = true;
                            for (int j = 0; j < temp.squares.length; j++) {
                                if ((temp.squares[j].x < 10) && (temp.squares[j].y < 20) && (temp.squares[j].x > -1) && (temp.squares[j].y > -1)) {
                                    del = false;
                                    array[temp.squares[j].x][temp.squares[j].y] = temp.symb;
                                }
                            }
                            if (del && (!temp.equals(fallen))) {
                                shapes.remove(temp);
                                i--;
                            }
                        }
                    }
                    try
                    {
                        Thread.sleep(timing);
                    } catch (InterruptedException e) {

                    }
                    GUI.gui.repaint();
                }
                while (fallen.down());
                synchronized (this) {
                    checkFullLine();
                    fallen = generateNewFigure();
                    shapes.add(fallen);
                    if (fallen.stepsToDown() == 0)
                    {
                        GUI.setScoreInTitle(score, -1);
                        lose = true;
                    }
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private synchronized Shape generateNewFigure()
    {
        switch (random.nextInt(7))
        {
            case (0) :
                return I.getI();
            case (1) :
                return O.getO();
            case (2) :
                return S.getS();
            case (3) :
                return Z.getZ();
            case (4) :
                return T.getT();
            case (5) :
                return J.getJ();
            default :
                return L.getL();
        }
    }

    private synchronized void checkFullLine()
    {
        int count = 0;
        boolean oneline;
        for (int y = 19; y > -1; y--)
        {
            oneline = true;
            for (int x = 0; x < 10; x++)
                if (array[x][y] == ' ')
                {
                    oneline = false;
                    break;
                }
            if (oneline)
                count++;
            if (!oneline && count > 0)
            {
                for (int y1 = y + count; count <= y1; y1--)
                    for (int x1 = 0; x1 < 10; x1++)
                        array[x1][y1] = array[x1][y1 - count];
                for (int y1 = y + count, i = 0; i < count; y1--, i++)
                    for (int x = 0; x < 10; x++)
                        for (Shape s : shapes)
                            for (Square sq : s.squares)
                                if (sq.x == x && sq.y == y1)
                                    sq.y = 100;
                for (int y1 = y; y1 > -1; y1--)
                    for (int x = 0; x < 10; x++)
                        for (Shape s : shapes)
                            for (Square sq : s.squares)
                                if (sq.x == x && sq.y == y1)
                                    sq.y = sq.y + count;
                for (int c = 0; c < count; c++)
                    for (int x = 0; x < 10; x++)
                        array[x][c] = ' ';
                y += count;
                score += count * 100;
                score++;
                if ((score > 1000 && level == 1)
                || (score > 2000 && level == 2)
                || (score > 3000 && level == 3)
                || (score > 4000 && level == 4)
                || (score > 5000 && level == 5)
                || (score > 6000 && level == 6)
                || (score > 7000 && level == 7)
                || (score > 8000 && level == 8)
                || (score > 9000 && level == 9)
                || (score > 10000 && level == 10)
                || (score > 11000 && level == 11)
                || (score > 12000 && level == 12)
                || (score > 13000 && level == 13)
                || (score > 14000 && level == 14))
                {
                    level++;
                    timing -= 50;
                }
                score--;
                GUI.setScoreInTitle(score, level);
                count = 0;
            }
        }
    }
}
