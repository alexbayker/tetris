public abstract class Shape {
    public Square[] squares;
    public char symb;
    public int moved;

    public abstract boolean down();

    public abstract boolean right();

    public abstract boolean left();

    public abstract boolean move();

    public abstract int stepsToDown();

    protected void print()
    {
        System.out.println("moved = " + moved);
        for (int i = 0; i < squares.length; i++)
            System.out.println(i + ": x - " + squares[i].x  + ", y - " + squares[i].y);
    }
}
