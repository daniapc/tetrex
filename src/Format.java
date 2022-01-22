//class that stores information about the formats and rotations of a piece of Tetris
public class Format {
    private int[][][] formats; //stores formats of every single rotation --> [rotationId][heightId][widthId]
    private Coordinate middle;//midle of the format on a 2d matrix
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

    public void ChangeColor(char colorId)
    {
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
}
