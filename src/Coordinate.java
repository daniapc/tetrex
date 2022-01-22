//Class that stores a position in 2d space
public class Coordinate {
    public int x,y; //x and y components of the position

    public Coordinate(int x,int y) {
        this.x =x;
        this.y= y;
    }

    public Coordinate SumCoordinates(Coordinate coor1, Coordinate coor2)
    {
        return new Coordinate(coor1.x+coor2.x, coor1.y+coor2.y);
    }

}
