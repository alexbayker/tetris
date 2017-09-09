public class O extends Shape
{
    private O()
    {
        squares = new Square[4];
        symb = 'O';
        squares[0] = new Square(4, -2);
        squares[1] = new Square(5, -2);
        squares[2] = new Square(4, -1);
        squares[3] = new Square(5, -1);
    }

    public static O getO()
    {
        return new O();
    }

    @Override
    public synchronized boolean left()
    {
        synchronized (GUI.logic) {
            if (squares[0].x > 0)
            {
                if (squares[0].y == -2 &&
                        squares[2].x > 0)
                {
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x--;
                    return true;
                }
                else if (squares[0].y == -1 &&
                        squares[2].x > 0 &&
                        GUI.logic.getFromArray(squares[0].x - 1, squares[2].y) == ' ')
                {
                    GUI.logic.setInArray(squares[3], ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x--;
                    GUI.logic.setInArray(squares[2], symb);
                    return true;
                }
                else if (squares[0].y > -1 &&
                        squares[2].y > -1 &&
                        squares[2].x > 0 &&
                        GUI.logic.getFromArray(squares[0].x - 1, squares[0].y) == ' ' &&
                        GUI.logic.getFromArray(squares[2].x - 1, squares[2].y) == ' ')
                {
                    GUI.logic.setInArray(squares[1], ' ');
                    GUI.logic.setInArray(squares[3], ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x--;
                    GUI.logic.setInArray(squares[0], symb);
                    GUI.logic.setInArray(squares[2], symb);
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public synchronized boolean right()
    {
        synchronized (GUI.logic) {
            if (squares[1].x < 9)
            {
                if (squares[1].y == -2 &&
                        squares[3].x < 9)
                {
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x++;
                    return true;
                }
                else if (squares[1].y == -1 &&
                        squares[1].x < 9 &&
                        GUI.logic.getFromArray(squares[1].x + 1, squares[3].y) == ' ')
                {
                    GUI.logic.setInArray(squares[2], ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x++;
                    GUI.logic.setInArray(squares[3], symb);
                    return true;
                }
                else if (squares[1].y > -1 &&
                        squares[3].y > -1 &&
                        squares[3].x < 9 &&
                        GUI.logic.getFromArray(squares[1].x + 1, squares[1].y) == ' ' &&
                        GUI.logic.getFromArray(squares[3].x + 1, squares[3].y) == ' ')
                {
                    GUI.logic.setInArray(squares[0], ' ');
                    GUI.logic.setInArray(squares[2], ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x++;
                    GUI.logic.setInArray(squares[1], symb);
                    GUI.logic.setInArray(squares[3], symb);
                    return true;
                }
            }

            return false;
        }
    }

    @Override
    public synchronized boolean move()
    {
        return true;
    }

    @Override
    public synchronized int stepsToDown()
    {
        synchronized (GUI.logic)
        {
            int count = 0;
            for (int y = squares[2].y + 1; y < 20; y++)
            {
                for (int i = 0; i < 2; i++)
                    if (GUI.logic.getFromArray(squares[2 + i].x, y) != ' ')
                        return count;
                count++;
            }
            return count;
        }
    }

    @Override
    public synchronized boolean down()
    {
        synchronized (GUI.logic) {
            if (stepsToDown() == 0)
                return false;
            if (squares[0].y > -1)
                GUI.logic.setInArray(squares[0], ' ');
            if (squares[1].y > -1)
                GUI.logic.setInArray(squares[1], ' ');
            for (int i = 0; i < squares.length; i++)
                squares[i].y++;
            if (squares[2].y > -1)
                GUI.logic.setInArray(squares[2], symb);
            if (squares[3].y > -1)
                GUI.logic.setInArray(squares[3], symb);
            return true;
        }
    }
}