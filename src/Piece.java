public class Piece {
    private Coordinate position; //position of the piece
    private Format format; //format and color of the piece

    public Piece(Coordinate position, Format format) {
        this.position = position;
        this.format = format;
        this.format.ZeroRotation();
    }
    
    // moves piece to postion, without testing it
    public void MoveTo(Coordinate position)
    {
        this.position = position;
    }
    public Format GetFormat(){ return format; }
    //sets new format and zero its current rotation
    public void SetFormat(Format format){
        this.format = format;
        this.format.ZeroRotation();
    }
    public Coordinate GetPosition(){ return position; }

    /*
    //tests if it is possible to move to a certain area, then moves piece to there, returns true if succeeded
    public boolean TryMoveBy(Coordinate movementVector, Camp camp)
    {
        if(camp.ValidPosition(this, Coordinate.SumCoordinates(position, movementVector), 0))
        {
            MoveTo(Coordinate.SumCoordinates(position, movementVector));
            return true;
        }
        return false;
    }
    */

    //tests if it is possible to rotate in this position, then rotates if possible, returns true if succeeded
    public boolean TryRotation(Camp camp)
    {
        if(camp.ValidPosition(this, position, 1))
        {
            format.IncrementRotation();
            return true;
        }
        return false;
    }
}
