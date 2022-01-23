//class that stores information about the formats and rotations of a piece of Tetris
public class Format {
    private int[][][] formats; //stores formats of every single rotation --> [rotationId][heightId][widthId]
    private Coordinate middle;//middle of the format on a 2d matrix
    private int dimension, currentRotation=0, maxRotation; //dimension of the 2d square matrix, current rotationId and max Rotation Id
    

    public Format(int[][][] formats, Coordinate middle, int dimension,int maxRotation) {
        this.formats = formats;
        this.middle = middle;
        this.dimension = ( dimension>0 ? dimension : 1);
        this.maxRotation = (maxRotation>0 ? maxRotation : 1);
    }

    //returns middle of the format in a 2d matrix
    public Coordinate GetMiddle() { return middle; }
    //returns 2d matrix of the current rotation of the format
    public int[][] GetCurrentRotationFormat() { return formats[currentRotation]; }
    //returns 2d matrix of the next rotation of the format
    public int[][] GetNextRotationFormat(){ return formats[(currentRotation+1)%maxRotation]; }
    //returns dimension of the 2d matrix
    public int GetDimension() { return dimension; }
    //increments currentRotation
    public void IncrementRotation() { currentRotation=(currentRotation+1) % maxRotation; }
    //Zero currentRotation
    public void ZeroRotation(){ currentRotation = 0; }

    // changes color of the format
    public void ChangeColor(int colorId)
    {
        if(colorId == 0)
            return;
        
        for(int i=0;i<maxRotation;i++)
        {
            for(int j=0;j<dimension;j++)
            {
                for(int k =0 ; k<dimension;j++)
                {
                    if(formats[i][j][k]!=0)
                        formats[i][j][k]=colorId;
                }
            }
        }
    }
    /** Stores the possible Formats of the game */
    private static int possibleFormats = 7;
    private static Format[] formatArray = {Cube(),Line(),T(),L(),Inverse_L(),S(),Z()};
    //creates an instance of the cube format
    private static Format Cube()
    {
        Coordinate mid = new Coordinate(0, 0);
        int[][][] formats = {{{1,1},{1,1}}};
        return new Format(formats, mid, 2, 1);
    }
    private static Format Line()
    {
        Coordinate mid = new Coordinate(1, 1);
        int[][][] formats = {{{0,0,0,0},{1,1,1,1},{0,0,0,0},{0,0,0,0}},{{0,1,0,0},{0,1,0,0},{0,1,0,0},{0,1,0,0}}};
        Format format = new Format(formats, mid, 4, 2);
        format.ChangeColor(2);
        return format;
    }
    private static Format T()
    {
        Coordinate mid = new Coordinate(1, 1);
        int[][][] formats = {{{0,0,0},{1,1,1},{0,1,0}},{{0,1,0},{0,1,1},{0,1,0}},{{0,1,0},{1,1,1},{0,0,0}},{{0,1,0},{1,1,0},{0,1,0}}};
        Format format = new Format(formats, mid, 3, 4);
        format.ChangeColor(3);
        return format;
    }
    private static Format L()
    {
        Coordinate mid = new Coordinate(1, 1);
        int[][][] formats = {{{0,0,0},{1,1,1},{1,0,0}},{{0,1,0},{0,1,0},{0,1,1}},{{0,0,1},{1,1,1},{0,0,0}},{{1,1,0},{0,1,0},{0,1,0}}};
        Format format = new Format(formats, mid, 3, 4);
        format.ChangeColor(4);
        return format;
    }
    private static Format Inverse_L()
    {
        Coordinate mid = new Coordinate(1, 1);
        int[][][] formats = {{{0,0,0},{1,1,1},{0,0,1}},{{0,1,1},{0,1,0},{0,1,0}},{{1,0,0},{1,1,1},{0,0,0}},{{0,1,0},{0,1,0},{1,1,0}}};
        Format format =new Format(formats, mid, 3, 4); 
        format.ChangeColor(5);
        return format;
    }
    private static Format S()
    {
        Coordinate mid = new Coordinate(1, 1);
        int[][][] formats = {{{0,0,0},{0,1,1},{1,1,0}},{{0,1,0},{0,1,1},{0,0,1}},{{0,1,1},{1,1,0},{0,0,0}},{{1,0,0},{1,1,0},{0,1,0}}};
        Format format = new Format(formats, mid, 3, 4);
        format.ChangeColor(6);
        return format;
    }
    private static Format Z()
    {
        Coordinate mid = new Coordinate(1, 1);
        int[][][] formats = {{{0,0,0},{1,1,0},{0,1,1}},{{0,0,1},{0,1,1},{0,1,0}},{{1,1,0},{0,1,1},{0,0,0}},{{0,1,0},{1,1,0},{1,0,0}}};
        Format format =new Format(formats, mid, 3, 4);
        format.ChangeColor(7);
        return format;
    }
    public static Format GetFormat(int randomNumber)
    {
        return formatArray[randomNumber%possibleFormats];
    }
}
