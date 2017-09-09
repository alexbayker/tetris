public class I extends Shape
{
    private I()
    {
        moved = 0;
        symb = 'I';
        squares = new Square[4];
        for (int i = 0, j = -4; i < squares.length; i++, j++)
            squares[i] = new Square(4, j);
    }

    public static I getI() {
        return new I();
    }

    @Override
    public synchronized boolean left()
    {
        synchronized (GUI.logic) {
            if (moved == 1)
            {
                if (squares[0].x > 0 &&
                        GUI.logic.getFromArray(squares[0].x - 1, squares[0].y) == ' ')
                {
                    GUI.logic.setInArray(squares[3], ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x--;
                    GUI.logic.setInArray(squares[0], symb);
                    return true;
                }
                return false;
            }
            else {
                if (squares[0].x > 0)
                {
                    if (squares[3].y == -1)
                    {
                        for (int i = 0; i < squares.length; i++)
                            squares[i].x--;
                        return true;
                    }
                    else if (squares[3].y == 0 &&
                            GUI.logic.getFromArray(squares[3].x - 1, squares[3].y) == ' ')
                    {
                        GUI.logic.setInArray(squares[3], ' ');
                        for (int i = 0; i < squares.length; i++)
                            squares[i].x--;
                        GUI.logic.setInArray(squares[3], symb);
                        return true;
                    }
                    else if (squares[3].y == 1 &&
                            GUI.logic.getFromArray(squares[2].x - 1, squares[2].y) == ' ' &&
                            GUI.logic.getFromArray(squares[3].x - 1, squares[3].y) == ' ')
                    {
                        GUI.logic.setInArray(squares[3], ' ');
                        GUI.logic.setInArray(squares[2], ' ');
                        for (int i = 0; i < squares.length; i++)
                            squares[i].x--;
                        GUI.logic.setInArray(squares[2], symb);
                        GUI.logic.setInArray(squares[3], symb);
                        return true;
                    }
                    else if (squares[3].y == 2 &&
                            GUI.logic.getFromArray(squares[1].x - 1, squares[1].y) == ' ' &&
                            GUI.logic.getFromArray(squares[2].x - 1, squares[2].y) == ' ' &&
                            GUI.logic.getFromArray(squares[3].x - 1, squares[3].y) == ' ')
                    {
                        GUI.logic.setInArray(squares[3], ' ');
                        GUI.logic.setInArray(squares[2], ' ');
                        GUI.logic.setInArray(squares[1], ' ');
                        for (int i = 0; i < squares.length; i++)
                            squares[i].x--;
                        GUI.logic.setInArray(squares[1], symb);
                        GUI.logic.setInArray(squares[2], symb);
                        GUI.logic.setInArray(squares[3], symb);
                        return true;
                    }
                    else if (GUI.logic.getFromArray(squares[0].x - 1, squares[0].y) == ' ' &&
                            GUI.logic.getFromArray(squares[1].x - 1, squares[1].y) == ' ' &&
                            GUI.logic.getFromArray(squares[2].x - 1, squares[2].y) == ' ' &&
                            GUI.logic.getFromArray(squares[3].x - 1, squares[3].y) == ' ')
                    {
                        GUI.logic.setInArray(squares[3], ' ');
                        GUI.logic.setInArray(squares[2], ' ');
                        GUI.logic.setInArray(squares[1], ' ');
                        GUI.logic.setInArray(squares[0], ' ');
                        for (int i = 0; i < squares.length; i++)
                            squares[i].x--;
                        GUI.logic.setInArray(squares[0], symb);
                        GUI.logic.setInArray(squares[1], symb);
                        GUI.logic.setInArray(squares[2], symb);
                        GUI.logic.setInArray(squares[3], symb);
                        return true;
                    }
                }
                return false;
            }
        }
    }

    @Override
    public synchronized boolean right()
    {
        synchronized (GUI.logic) {
            if (moved == 1)
            {
                if (squares[3].x < 9 &&
                        GUI.logic.getFromArray(squares[3].x + 1, squares[3].y) == ' ')
                {
                    GUI.logic.setInArray(squares[0], ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x++;
                    GUI.logic.setInArray(squares[3], symb);
                    return true;
                }
                return false;
            }
            else {
                if (squares[3].x < 9)
                {
                    if (squares[3].y == -1)
                    {
                        for (int i = 0; i < squares.length; i++)
                            squares[i].x++;
                        return true;
                    }
                    else if (squares[3].y == 0 &&
                            GUI.logic.getFromArray(squares[3].x + 1, squares[3].y) == ' ')
                    {
                        GUI.logic.setInArray(squares[3], ' ');
                        for (int i = 0; i < squares.length; i++)
                            squares[i].x++;
                        GUI.logic.setInArray(squares[3], symb);
                        return true;
                    }
                    else if (squares[3].y == 1 &&
                            GUI.logic.getFromArray(squares[2].x + 1, squares[2].y) == ' ' &&
                            GUI.logic.getFromArray(squares[3].x + 1, squares[3].y) == ' ')
                    {
                        GUI.logic.setInArray(squares[3], ' ');
                        GUI.logic.setInArray(squares[2], ' ');
                        for (int i = 0; i < squares.length; i++)
                            squares[i].x++;
                        GUI.logic.setInArray(squares[2], symb);
                        GUI.logic.setInArray(squares[3], symb);
                        return true;
                    }
                    else if (squares[3].y == 2 &&
                            GUI.logic.getFromArray(squares[1].x + 1, squares[1].y) == ' ' &&
                            GUI.logic.getFromArray(squares[2].x + 1, squares[2].y) == ' ' &&
                            GUI.logic.getFromArray(squares[3].x + 1, squares[3].y) == ' ')
                    {
                        GUI.logic.setInArray(squares[3], ' ');
                        GUI.logic.setInArray(squares[2], ' ');
                        GUI.logic.setInArray(squares[1], ' ');
                        for (int i = 0; i < squares.length; i++)
                            squares[i].x++;
                        GUI.logic.setInArray(squares[1], symb);
                        GUI.logic.setInArray(squares[2], symb);
                        GUI.logic.setInArray(squares[3], symb);
                        return true;
                    }
                    else if (GUI.logic.getFromArray(squares[0].x + 1, squares[0].y) == ' ' &&
                            GUI.logic.getFromArray(squares[1].x + 1, squares[1].y) == ' ' &&
                            GUI.logic.getFromArray(squares[2].x + 1, squares[2].y) == ' ' &&
                            GUI.logic.getFromArray(squares[3].x + 1, squares[3].y) == ' ')
                    {
                        GUI.logic.setInArray(squares[3], ' ');
                        GUI.logic.setInArray(squares[2], ' ');
                        GUI.logic.setInArray(squares[1], ' ');
                        GUI.logic.setInArray(squares[0], ' ');
                        for (int i = 0; i < squares.length; i++)
                            squares[i].x++;
                        GUI.logic.setInArray(squares[0], symb);
                        GUI.logic.setInArray(squares[1], symb);
                        GUI.logic.setInArray(squares[2], symb);
                        GUI.logic.setInArray(squares[3], symb);
                        return true;
                    }

                }
                return false;
            }
        }
    }

    @Override
    public synchronized boolean move()
    {
        synchronized (GUI.logic) {
            if (moved == 1)
            {
                if (squares[0].y - 2 > -1 &&
                        squares[0].y + 1 < 20 &&
                        GUI.logic.getFromArray(squares[1].x, squares[1].y - 2) == ' ' &&
                        GUI.logic.getFromArray(squares[1].x, squares[1].y - 1) == ' ' &&
                        GUI.logic.getFromArray(squares[1].x, squares[1].y + 1) == ' ') {
                    GUI.logic.setInArray(squares[0].x, squares[0].y, ' ');
                    squares[0].x++;
                    squares[0].y -= 2;
                    GUI.logic.setInArray(squares[0].x, squares[0].y, symb);
                    GUI.logic.setInArray(squares[2].x, squares[2].y, ' ');
                    squares[2].x--;
                    squares[2].y--;
                    GUI.logic.setInArray(squares[2].x, squares[2].y, symb);
                    GUI.logic.setInArray(squares[3].x, squares[3].y, ' ');
                    squares[3].y++;
                    squares[3].x -= 2;
                    GUI.logic.setInArray(squares[3].x, squares[3].y, symb);
                    int temp = squares[1].y;
                    squares[1].y = squares[2].y;
                    squares[2].y = temp;
                    moved = 0;
                    return true;
                }
            }
            else
            {
                if (squares[0].y > -1 &&
                        squares[2].x - 1 > -1 &&
                        squares[2].x + 2 < 10 &&
                        GUI.logic.getFromArray(squares[2].x - 1, squares[2].y) == ' ' &&
                        GUI.logic.getFromArray(squares[2].x + 1, squares[2].y) == ' ' &&
                        GUI.logic.getFromArray(squares[2].x + 2, squares[2].y) == ' ')
                {
                    GUI.logic.setInArray(squares[0].x, squares[0].y, ' ');
                    squares[0].x--;
                    squares[0].y += 2;
                    GUI.logic.setInArray(squares[0].x, squares[0].y, symb);
                    GUI.logic.setInArray(squares[1].x, squares[1].y, ' ');
                    squares[1].x++;
                    squares[1].y++;
                    GUI.logic.setInArray(squares[1].x, squares[1].y, symb);
                    GUI.logic.setInArray(squares[3].x, squares[3].y, ' ');
                    squares[3].y--;
                    squares[3].x += 2;
                    GUI.logic.setInArray(squares[3].x, squares[3].y, symb);
                    int temp = squares[1].x;
                    squares[1].x = squares[2].x;
                    squares[2].x = temp;
                    moved = 1;
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public synchronized int stepsToDown()
    {
        synchronized (GUI.logic)
        {
            if (moved == 0)
            {
                int count = 0;
                for (int y = squares[3].y + 1; y < 20; y++)
                {
                    if (GUI.logic.getFromArray(squares[0].x, y) == ' ')
                        count++;
                    else
                        return count;
                }
                return count;

            }
            else
            {
                int count = 0;
                for (int y = squares[2].y + 1; y < 20; y++)
                {
                    for (int i = 0; i < squares.length; i++)
                    {
                        if (GUI.logic.getFromArray(squares[i].x, y) != ' ')
                            return count;
                    }
                    count++;
                }
                return count;
            }
        }
    }

    @Override
    public synchronized boolean down()
    {
        synchronized (GUI.logic) {
            if (stepsToDown() == 0)
                return false;
            if (moved == 0) {
                if (squares[0].y > -1)
                    GUI.logic.setInArray(squares[0], ' ');
                for (int i = 0; i < squares.length; i++)
                    squares[i].y++;
                if (squares[3].y > -1)
                    GUI.logic.setInArray(squares[3], symb);
                return true;
            }
            else
            {
                for (int i = 0; i < squares.length; i++)
                {
                    if (squares[i].y > 0)
                        GUI.logic.setInArray(squares[i], ' ');
                    squares[i].y++;
                    if (squares[i].y > 0)
                        GUI.logic.setInArray(squares[i], symb);
                }
                return true;
            }
        }
    }
}