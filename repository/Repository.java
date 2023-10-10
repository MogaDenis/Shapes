package repository;

import exception.EmptyRepositoryException;
import exception.OverflowException;
import model.Shape;

public interface Repository 
{
    public void addShape(Shape shape) throws OverflowException;
    
    public void removeShape(Shape shape) throws EmptyRepositoryException;

    public int getNumberOfShapes();

    public Shape[] getShapes();

    public boolean containsShape(Shape shape);

    public Shape[] getShapesWithVolumeGreater(double minVolume);
}
