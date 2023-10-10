package model;

public class Cube implements Shape 
{
    private int width; 

    public Cube()
    {
        this.width = 0;
    }

    public Cube(int width)
    {
        this.width = width;
    }

    public int getWidth()
    {
        return this.width;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
            return true;

        if (!(object instanceof Cube))
            return false;

        Cube cube = (Cube) object;

        return this.width == cube.width;
    }
    
    @Override
    public double getVolume() 
    {
        return width * width * width;
    }

    @Override
    public String toString()
    {
        return "Cube - width: " + String.valueOf(this.width) + " - volume: " + String.valueOf(this.getVolume());
    }
}
