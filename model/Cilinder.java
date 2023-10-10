package model;

public class Cilinder implements Shape 
{
    private int baseRadius;
    private int height;

    public Cilinder()
    {
        this.baseRadius = 0;
        this.height = 0;
    }

    public Cilinder(int baseRadius, int height)
    {
        this.baseRadius = baseRadius;
        this.height = height;
    }

    public int getBaseRadius()
    {
        return this.baseRadius;
    }

    public int getHeight()
    {
        return this.height;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
            return true;

        if (!(object instanceof Cilinder))
            return false;

        Cilinder cilinder = (Cilinder) object;

        return this.baseRadius == cilinder.baseRadius && this.height == cilinder.height;
    }

    @Override
    public double getVolume()
    {
        return PI * this.baseRadius * this.baseRadius * this.height;
    }

    @Override
    public String toString()
    {
        return "Cilinder - base radius: " + String.valueOf(this.baseRadius) + " - volume: " + String.valueOf(this.getVolume());
    }
}

