public class Z extends Shape {
    private Z()
    {
        moved = 0;
        symb = 'Z';
        squares = new Square[4];
        squares[0] = new Square(5, -3);
        squares[1] = new Square(4, -2);
        squares[2] = new Square(5, -2);
        squares[3] = new Square(4, -1);
    }

    public static Z getZ()
    {
        return new Z();
    }

    @Override
    public synchronized boolean left()
    {
        synchronized (GUI.logic)
        {
            if (moved == 0)
            {
                if (squares[3].x > 0
                        && squares[3].y < 0)
                {
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x--;
                    return true;
                }
                else if (squares[3].x > 0 &&
                        squares[3].y == 0 &&
                        GUI.logic.getFromArray(squares[3].x - 1, squares[3].y) == ' ')
                {
                    GUI.logic.setInArray(squares[3].x, squares[3].y, ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x--;
                    GUI.logic.setInArray(squares[3].x, squares[3].y, symb);
                    return true;
                }
                else if (squares[3].x > 0 &&
                        squares[3].y == 1 &&
                        GUI.logic.getFromArray(squares[1].x - 1, squares[1].y) == ' ' &&
                        GUI.logic.getFromArray(squares[3].x - 1, squares[3].y) == ' ')
                {
                    GUI.logic.setInArray(squares[2].x, squares[2].y, ' ');
                    GUI.logic.setInArray(squares[3].x, squares[3].y, ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x--;
                    GUI.logic.setInArray(squares[1].x, squares[1].y, symb);
                    GUI.logic.setInArray(squares[3].x, squares[3].y, symb);
                    return true;
                }
                else if (squares[3].x > 0 &&
                        GUI.logic.getFromArray(squares[0].x - 1, squares[0].y) == ' ' &&
                        GUI.logic.getFromArray(squares[1].x - 1, squares[1].y) == ' ' &&
                        GUI.logic.getFromArray(squares[3].x - 1, squares[3].y) == ' ')
                {
                    GUI.logic.setInArray(squares[0].x, squares[0].y, ' ');
                    GUI.logic.setInArray(squares[2].x, squares[2].y, ' ');
                    GUI.logic.setInArray(squares[3].x, squares[3].y, ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x--;
                    GUI.logic.setInArray(squares[0].x, squares[0].y, symb);
                    GUI.logic.setInArray(squares[1].x, squares[1].y, symb);
                    GUI.logic.setInArray(squares[3].x, squares[3].y, symb);
                    return true;
                }
            }
            else
            {
                if (squares[3].x > 0 &&
                        GUI.logic.getFromArray(squares[3].x - 1, squares[3].y) == ' ' &&
                        GUI.logic.getFromArray(squares[2].x - 1, squares[2].y) == ' ')
                {
                    GUI.logic.setInArray(squares[0].x, squares[0].y, ' ');
                    GUI.logic.setInArray(squares[1].x, squares[1].y, ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x--;
                    GUI.logic.setInArray(squares[2].x, squares[2].y, symb);
                    GUI.logic.setInArray(squares[3].x, squares[3].y, symb);
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
                if (squares[0].x < 9 &&
                        squares[3].y < 0)
                {
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x++;
                    return true;
                }
                else if (squares[0].x < 9 &&
                        squares[3].y == 0 &&
                        GUI.logic.getFromArray(squares[3].x + 1, squares[3].y) == ' ')
                {
                    GUI.logic.setInArray(squares[3].x, squares[3].y, ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x++;
                    GUI.logic.setInArray(squares[3].x, squares[3].y, symb);
                    return true;
                }
                else if (squares[0].x < 9 &&
                        squares[3].y == 1 &&
                        GUI.logic.getFromArray(squares[3].x + 1, squares[3].y) == ' ' &&
                        GUI.logic.getFromArray(squares[2].x + 1, squares[2].y) == ' ')
                {
                    GUI.logic.setInArray(squares[1].x, squares[1].y, ' ');
                    GUI.logic.setInArray(squares[3].x, squares[3].y, ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x++;
                    GUI.logic.setInArray(squares[2].x, squares[2].y, symb);
                    GUI.logic.setInArray(squares[3].x, squares[3].y, symb);
                    return true;
                }
                else if (squares[0].x < 9 &&
                        GUI.logic.getFromArray(squares[3].x + 1, squares[3].y) == ' ' &&
                        GUI.logic.getFromArray(squares[2].x + 1, squares[2].y) == ' ' &&
                        GUI.logic.getFromArray(squares[0].x + 1, squares[0].y) == ' ')
                {
                    GUI.logic.setInArray(squares[0].x, squares[0].y, ' ');
                    GUI.logic.setInArray(squares[1].x, squares[1].y, ' ');
                    GUI.logic.setInArray(squares[3].x, squares[3].y, ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x++;
                    GUI.logic.setInArray(squares[0].x, squares[0].y, symb);
                    GUI.logic.setInArray(squares[2].x, squares[2].y, symb);
                    GUI.logic.setInArray(squares[3].x, squares[3].y, symb);
                    return true;
                }
            }
            else
            {
                if (squares[0].x < 9 &&
                        GUI.logic.getFromArray(squares[0].x + 1, squares[0].y) == ' ' &&
                        GUI.logic.getFromArray(squares[1].x + 1, squares[1].y) == ' ')
                {
                    GUI.logic.setInArray(squares[2].x, squares[2].y, ' ');
                    GUI.logic.setInArray(squares[3].x, squares[3].y, ' ');
                    for (int i = 0; i < squares.length; i++)
                        squares[i].x++;
                    GUI.logic.setInArray(squares[0].x, squares[0].y, symb);
                    GUI.logic.setInArray(squares[1].x, squares[1].y, symb);
                    return true;
                }
            }
            return false;
        }
    }

    @Override
    public synchronized boolean move()
    {
        synchronized (GUI.logic) {
            if (moved == 0)
            {
                if (squares[0].x < 9 &&
                        squares[0].y > -1 &&
                        GUI.logic.getFromArray(squares[0].x - 1, squares[0].y) == ' ' &&
                        GUI.logic.getFromArray(squares[2].x + 1, squares[0].y) == ' ')
                {
                    GUI.logic.setInArray(squares[1].x, squares[1].y, ' ');
                    GUI.logic.setInArray(squares[3].x, squares[3].y, ' ');
                    squares[1].x = squares[0].x;
                    squares[1].y = squares[0].y;
                    squares[0].y++;
                    squares[0].x++;
                    GUI.logic.setInArray(squares[0].x, squares[0].y, symb);
                    squares[3].y -= 2;
                    GUI.logic.setInArray(squares[3].x, squares[3].y, symb);
                    moved = 1;
                    return true;
                }
            }
            else
            {
                if (squares[2].y < 19 &&
                        squares[1].y > -1 &&
                        GUI.logic.getFromArray(squares[3].x, squares[3].y + 1) == ' ' &&
                        GUI.logic.getFromArray(squares[3].x, squares[3].y + 2) == ' ')
                {
                    GUI.logic.setInArray(squares[0].x, squares[0].y, ' ');
                    GUI.logic.setInArray(squares[3].x, squares[3].y, ' ');
                    squares[0].x = squares[1].x;
                    squares[0].y = squares[1].y;
                    squares[1].y++;
                    squares[1].x--;
                    GUI.logic.setInArray(squares[1].x, squares[1].y, symb);
                    squares[3].y += 2;
                    GUI.logic.setInArray(squares[3].x, squares[3].y, symb);
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
                for (int y = squares[3].y + 1, y1 = squares[2].y + 1; y < 20; y++, y1++)
                {
                    if (squares[2].y == -2)
                    {
                        boolean downIsEmpty = true;
                        Shape temp = GUI.logic.getLastShape();
                        if (temp != null) {
                            for (int i = 0; i < temp.squares.length; i++) {
                                if (temp.squares[i].x == 5 && temp.squares[i].y == -1) {
                                    downIsEmpty = false;
                                    break;
                                }
                            }
                        }
                        if (GUI.logic.getFromArray(squares[3].x, y) == ' ' && downIsEmpty)
                            count++;
                        else
                            return count;
                    }
                    else if (GUI.logic.getFromArray(squares[3].x, y) == ' ' &&
                            GUI.logic.getFromArray(squares[2].x, y1) == ' ')
                        count++;
                    else
                        return count;
                }
            }
            else
            {
                for (int y = squares[3].y + 1, y1 = squares[2].y + 1; y1 < 20; y++, y1++)
                {
                    if (GUI.logic.getFromArray(squares[3].x, y) == ' ' &&
                            GUI.logic.getFromArray(squares[2].x, y1) == ' ' &&
                            GUI.logic.getFromArray(squares[0].x, y1) == ' ')
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
            if (moved == 0) {
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
