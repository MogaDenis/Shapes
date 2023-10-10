package model;

public class Sphere implements Shape 
{
    private int radius;

    public Sphere()
    {
        this.radius = 0;
    }

    public Sphere(int radius)
    {
        this.radius = radius;
    }

    public int getRadius()
    {
        return this.radius;
    }

    @Override
    public boolean equals(Object object)
    {
        if (this == object)
            return true;

        if (!(object instanceof Sphere))
            return false;

        Sphere sphere = (Sphere) object;

        return this.radius == sphere.radius;
    }

    @Override
    public double getVolume()
    {
        return PI * radius * radius * radius;
    }

    @Override
    public String toString()
    {
        return "Sphere - radius: " + String.valueOf(this.radius) + " - volume: " + String.valueOf(this.getVolume());
    }
}
