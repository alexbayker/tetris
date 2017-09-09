public class T extends Shape {
    private T()
    {
        moved = 0;
        symb = 'T';
        squares = new Square[4];
        squares[0] = new Square(5, -3);
        squares[1] = new Square(4, -2);
        squares[2] = new Square(5, -2);
        squares[3] = new Square(5, -1);
    }

    public static T getT()
    {
        return new T();
    }

    @Override
    public synchronized boolean left()
    {
        synchronized (GUI.logic)
        {
            if (moved == 0)
            {
                if (squares[3].y < 0 &&
                        squares[1].x > 0)
                {
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x--;
                    return true;
                }
                else if (squares[3].y == 0 &&
                        squares[1].x > 0 &&
                        GUI.logic.getFromArray(squares[3].x - 1, squares[3].y) == ' ')
                {
                    GUI.logic.setInArray(squares[3], ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x--;
                    GUI.logic.setInArray(squares[3], symb);
                    return true;
                }
                else if (squares[3].y == 1 &&
                        squares[1].x > 0 &&
                        GUI.logic.getFromArray(squares[1].x - 1, squares[1].y) == ' ' &&
                        GUI.logic.getFromArray(squares[3].x - 1, squares[3].y) == ' ')
                {
                    GUI.logic.setInArray(squares[2], ' ');
                    GUI.logic.setInArray(squares[3], ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x--;
                    GUI.logic.setInArray(squares[1], symb);
                    GUI.logic.setInArray(squares[3], symb);
                    return true;
                }
                else if (squares[1].x > 0 &&
                        GUI.logic.getFromArray(squares[0].x - 1, squares[0].y) == ' ' &&
                        GUI.logic.getFromArray(squares[1].x - 1, squares[1].y) == ' ' &&
                        GUI.logic.getFromArray(squares[3].x - 1, squares[3].y) == ' ')
                {
                    GUI.logic.setInArray(squares[0], ' ');
                    GUI.logic.setInArray(squares[2], ' ');
                    GUI.logic.setInArray(squares[3], ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x--;
                    GUI.logic.setInArray(squares[0], symb);
                    GUI.logic.setInArray(squares[1], symb);
                    GUI.logic.setInArray(squares[3], symb);
                    return true;
                }
            }
            else if (moved == 1)
            {
                if (squares[0].x > 0 &&
                        GUI.logic.getFromArray(squares[0].x - 1, squares[0].y) == ' ' &&
                        GUI.logic.getFromArray(squares[1].x - 1, squares[1].y) == ' ')
                {
                    GUI.logic.setInArray(squares[3], ' ');
                    GUI.logic.setInArray(squares[1], ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x--;
                    GUI.logic.setInArray(squares[0], symb);
                    GUI.logic.setInArray(squares[1], symb);
                    return true;
                }
            }
            else if (moved == 2)
            {
                if (squares[3].x > 0 &&
                        GUI.logic.getFromArray(squares[0].x - 1, squares[0].y) == ' ' &&
                        GUI.logic.getFromArray(squares[2].x - 1, squares[2].y) == ' ' &&
                        GUI.logic.getFromArray(squares[3].x - 1, squares[3].y) == ' ')
                {
                    GUI.logic.setInArray(squares[0], ' ');
                    GUI.logic.setInArray(squares[1], ' ');
                    GUI.logic.setInArray(squares[3], ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x--;
                    GUI.logic.setInArray(squares[0], symb);
                    GUI.logic.setInArray(squares[2], symb);
                    GUI.logic.setInArray(squares[3], symb);
                    return true;
                }
            }
            else
            {
                if (squares[3].x > 0 &&
                        GUI.logic.getFromArray(squares[3].x - 1, squares[3].y) == ' ' &&
                        GUI.logic.getFromArray(squares[1].x - 1, squares[1].y) == ' ')
                {
                    GUI.logic.setInArray(squares[0], ' ');
                    GUI.logic.setInArray(squares[1], ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x--;
                    GUI.logic.setInArray(squares[1], symb);
                    GUI.logic.setInArray(squares[3], symb);
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public synchronized boolean right()
    {
        synchronized (GUI.logic)
        {
            if (moved == 0)
            {
                if (squares[3].y < 0 &&
                        squares[0].x < 9)
                {
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x++;
                    return true;
                }
                else if (squares[1].y == -1 &&
                        squares[0].x < 9 &&
                        GUI.logic.getFromArray(squares[3].x + 1, squares[3].y) == ' ')
                {
                    GUI.logic.setInArray(squares[3], ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x++;
                    GUI.logic.setInArray(squares[3], symb);
                    return true;
                }
                else if (squares[0].y == -1 &&
                        squares[0].x < 9 &&
                        GUI.logic.getFromArray(squares[2].x + 1, squares[2].y) == ' ' &&
                        GUI.logic.getFromArray(squares[3].x + 1, squares[3].y) == ' ')
                {
                    GUI.logic.setInArray(squares[1], ' ');
                    GUI.logic.setInArray(squares[3], ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x++;
                    GUI.logic.setInArray(squares[2], symb);
                    GUI.logic.setInArray(squares[3], symb);
                    return true;
                }
                else if (squares[0].x < 9 &&
                        GUI.logic.getFromArray(squares[0].x + 1, squares[0].y) == ' ' &&
                        GUI.logic.getFromArray(squares[2].x + 1, squares[2].y) == ' ' &&
                        GUI.logic.getFromArray(squares[3].x + 1, squares[3].y) == ' ')
                {
                    GUI.logic.setInArray(squares[0], ' ');
                    GUI.logic.setInArray(squares[1], ' ');
                    GUI.logic.setInArray(squares[3], ' ');
                    for (int i = 0 ; i < squares.length; i++)
                        squares[i].x++;
                    GUI.logic.setInArray(squares[0], symb);
                    GUI.logic.setInArray(squares[2], symb);
                    GUI.logic.setInArray(squares[3], symb);
                    return true;
                }
            }
            else if (moved == 1)
            {
                if (squares[3].x < 9 &&
                        GUI.logic.getFromArray(squares[3].x + 1, squares[3].y) == ' ' &&
                        GUI.logic.getFromArray(squares[1].x + 1, squares[1].y) == ' ')
                {
                    GUI.logic.setInArray(squares[0], ' ');
                    GUI.logic.setInArray(squares[1], ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x++;
                    GUI.logic.setInArray(squares[1], symb);
                    GUI.logic.setInArray(squares[3], symb);
                    return true;
                }
            }
            else if (moved == 2)
            {
                if (squares[1].x < 9 &&
                        GUI.logic.getFromArray(squares[0].x + 1, squares[0].y) == ' ' &&
                        GUI.logic.getFromArray(squares[1].x + 1, squares[1].y) == ' ' &&
                        GUI.logic.getFromArray(squares[3].x + 1, squares[3].y) == ' ')
                {
                    GUI.logic.setInArray(squares[0], ' ');
                    GUI.logic.setInArray(squares[2], ' ');
                    GUI.logic.setInArray(squares[3], ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x++;
                    GUI.logic.setInArray(squares[0], symb);
                    GUI.logic.setInArray(squares[1], symb);
                    GUI.logic.setInArray(squares[3], symb);
                    return true;
                }
            }
            else
            {
                if (squares[0].x < 9 &&
                        GUI.logic.getFromArray(squares[0].x + 1, squares[0].y) == ' ' &&
                        GUI.logic.getFromArray(squares[1].x + 1, squares[1].y) == ' ')
                {
                    GUI.logic.setInArray(squares[3], ' ');
                    GUI.logic.setInArray(squares[1], ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x++;
                    GUI.logic.setInArray(squares[0], symb);
                    GUI.logic.setInArray(squares[1], symb);
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public synchronized boolean move()
    {
        synchronized (GUI.logic)
        {
            if (moved == 0)
            {
                if (squares[0].y > -1 &&
                        squares[0].x < 9 &&
                        GUI.logic.getFromArray(squares[2].x + 1, squares[2].y) == ' ')
                {
                    GUI.logic.setInArray(squares[0], ' ');
                    squares[0].x = squares[1].x;
                    squares[0].y = squares[1].y;
                    squares[1].x = squares[3].x;
                    squares[1].y = squares[3].y;
                    squares[3].x = squares[2].x + 1;
                    squares[3].y = squares[2].y;
                    GUI.logic.setInArray(squares[3], symb);
                    moved = 1;
                    return true;
                }
            }
            else if (moved == 1)
            {
                if (squares[0].y > 0 &&
                        GUI.logic.getFromArray(squares[2].x, squares[2].y - 1) == ' ')
                {
                    GUI.logic.setInArray(squares[0], ' ');
                    squares[0].x = squares[1].x;
                    squares[0].y = squares[1].y;
                    squares[1].x = squares[3].x;
                    squares[1].y = squares[3].y;
                    squares[3].x = squares[2].x;
                    squares[3].y = squares[2].y - 1;
                    GUI.logic.setInArray(squares[3], symb);
                    moved = 2;
                    return true;
                }
            }
            else if (moved == 2)
            {
                if (squares[0].x > 0 &&
                        GUI.logic.getFromArray(squares[2].x - 1, squares[2].y) == ' ')
                {
                    GUI.logic.setInArray(squares[0], ' ');
                    squares[0].x = squares[1].x;
                    squares[0].y = squares[1].y;
                    squares[1].x = squares[3].x;
                    squares[1].y = squares[3].y;
                    squares[3].x = squares[2].x - 1;
                    squares[3].y = squares[2].y;
                    GUI.logic.setInArray(squares[3], symb);
                    moved = 3;
                    return true;
                }
            }
            else
            {
                if (squares[2].y < 19 &&
                        GUI.logic.getFromArray(squares[2].x, squares[2].y + 1) == ' ')
                {
                    GUI.logic.setInArray(squares[0], ' ');
                    squares[0].x = squares[1].x;
                    squares[0].y = squares[1].y;
                    squares[1].x = squares[3].x;
                    squares[1].y = squares[3].y;
                    squares[3].x = squares[2].x;
                    squares[3].y = squares[2].y + 1;
                    GUI.logic.setInArray(squares[3], symb);
                    moved = 0;
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
            int count = 0;
            if (moved == 0)
            {
                for (int y = squares[1].y + 1, y1 = squares[3].y + 1; y1 < 20; y++, y1++)
                {
                    if (squares[1].y == -2)
                    {
                        boolean downIsEmpty = true;
                        Shape temp = GUI.logic.getLastShape();
                        if (temp != null)
                        {
                            for (int i = 0; i < temp.squares.length; i++)
                            {
                                if (temp.squares[i].x == 4 && temp.squares[i].y == -1)
                                {
                                    downIsEmpty = false;
                                    break;
                                }
                            }
                        }
                        if (GUI.logic.getFromArray(squares[3].x, y1) == ' ' && downIsEmpty)
                            count++;
                        else
                            return count;
                    }
                    else if (GUI.logic.getFromArray(squares[1].x, y) == ' ' &&
                                    GUI.logic.getFromArray(squares[3].x, y1) == ' ')
                        count++;
                    else
                        return count;
                }
            }
            else if (moved == 1)
            {
                for (int y = squares[0].y + 1, y1 = squares[1].y + 1; y1 < 20; y++, y1++)
                {
                    if (GUI.logic.getFromArray(squares[0].x, y) == ' ' &&
                            GUI.logic.getFromArray(squares[1].x, y1) == ' ' &&
                            GUI.logic.getFromArray(squares[3].x, y) == ' ')
                        count++;
                    else
                        return count;
                }
            }
            else if (moved == 2)
            {
                for (int y = squares[0].y + 1, y1 = squares[1].y + 1; y < 20; y++, y1++)
                {
                    if (GUI.logic.getFromArray(squares[0].x, y) == ' ' &&
                            GUI.logic.getFromArray(squares[1].x, y1) == ' ')
                        count++;
                    else
                        return count;
                }
            }
            else
            {
                for (int y = squares[2].y + 1; y < 20; y++)
                {
                    if (GUI.logic.getFromArray(squares[0].x, y) == ' ' &&
                            GUI.logic.getFromArray(squares[2].x, y) == ' ' &&
                            GUI.logic.getFromArray(squares[3].x, y) == ' ')
                        count++;
                    else
                        return count;
                }
            }
            return count;
        }
    }

    @Override
    public synchronized boolean down() {
        synchronized (GUI.logic) {
            if (stepsToDown() == 0)
                return false;
            if (moved == 0)
            {
                if (squares[0].y > -1)
                    GUI.logic.setInArray(squares[0], ' ');
                if (squares[1].y > -1)
                    GUI.logic.setInArray(squares[1], ' ');
                for (int i = 0; i < squares.length; i++)
                    squares[i].y++;
                if (squares[1].y > -1)
                    GUI.logic.setInArray(squares[1], symb);
                if (squares[3].y > -1)
                    GUI.logic.setInArray(squares[3], symb);
                return true;
            }
            else if (moved == 1)
            {
                for (int i = 0; i < squares.length; i++)
                {
                    if (i != 1 && squares[i].y > -1)
                        GUI.logic.setInArray(squares[i], ' ');
                    squares[i].y++;
                    if (i != 2 && squares[i].y > -1)
                        GUI.logic.setInArray(squares[i], symb);
                }
                return true;
            }
            else if (moved == 2)
            {
                if (squares[1].y > -1)
                    GUI.logic.setInArray(squares[1], ' ');
                if (squares[3].y > -1)
                    GUI.logic.setInArray(squares[3], ' ');
                for (int i = 0; i < squares.length; i++)
                    squares[i].y++;
                if (squares[1].y > -1)
                    GUI.logic.setInArray(squares[1], symb);
                if (squares[0].y > -1)
                    GUI.logic.setInArray(squares[0], symb);
                return true;
            }
            else
            {
                for (int i = 0; i < squares.length; i++)
                {
                    if (i != 2 && squares[i].y > -1)
                        GUI.logic.setInArray(squares[i], ' ');
                    squares[i].y++;
                    if (i != 1 && squares[i].y > -1)
                        GUI.logic.setInArray(squares[i], symb);
                }
                return true;
            }
        }
    }
}
