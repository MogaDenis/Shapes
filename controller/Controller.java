package controller;

import exception.EmptyRepositoryException;
import exception.OverflowException;
import model.Shape;
import repository.Repository;

public class Controller 
{
    private Repository repository;

    public Controller(Repository repository)
    {
        this.repository = repository;
    }

    public void addShape(Shape shape) throws OverflowException
    {
        this.repository.addShape(shape);
    }
    
    public void removeShape(Shape shape) throws EmptyRepositoryException
    {
        this.repository.removeShape(shape);
    }

    public int getNumberOfShapes()
    {
        return this.repository.getNumberOfShapes();
    }

    public Shape[] getShapes()
    {
        return this.repository.getShapes();
    }

    public boolean containsShape(Shape shape)
    {
        return this.repository.containsShape(shape);
    }

    public Shape[] getShapesWithVolumeGreater(double minVolume)
    {
        return this.repository.getShapesWithVolumeGreater(minVolume);
    }
}
