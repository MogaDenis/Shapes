package repository;

import model.Shape;
import exception.EmptyRepositoryException;
import exception.OverflowException;

public class InMemoryRepository implements Repository 
{
    private int capacity;
    private int size;
    private Shape[] shapes;

    InMemoryRepository()
    {
        this.capacity = 100;
        this.size = 0;
        this.shapes = new Shape[this.capacity];
    }

    InMemoryRepository(int capacity)
    {
        this.capacity = capacity;
        this.size = 0;
        this.shapes = new Shape[this.capacity];
    }

    @Override
    public void addShape(Shape shape) throws OverflowException
    {
        if (this.size == this.capacity)
            throw new OverflowException("Full repository!");

        this.shapes[this.size++] = shape;
    }
    
    @Override
    public void removeShape(Shape shape) throws EmptyRepositoryException
    {
        if (this.size == 0)
            throw new EmptyRepositoryException("Empty repository!");

        for (int i = 0; i < this.size; i++)
        {
            if (shape.equals(this.shapes[i]))
            {
                this.shapes[i] = this.shapes[--this.size];
                break;
            }
        }
    }

    @Override
    public Shape[] getShapes()
    {
        return this.shapes;
    }

    @Override
    public int getNumberOfShapes()
    {
        return this.size;
    }

    @Override
    public boolean containsShape(Shape shape)
    {
        for (Shape currentShape : this.shapes)
            if (currentShape.equals(shape))
                return true;

        return false;
    }

    @Override
    public Shape[] getShapesWithVolumeGreater(double minVolume)
    {
        int count = 0;

        for (Shape currentShape : this.shapes)
            if (currentShape.getVolume() > minVolume)
                count++;

        Shape[] filteredShapes = new Shape[count];

        int index = 0;

        for (Shape currentShape : this.shapes)
            if (currentShape.getVolume() > minVolume)
                filteredShapes[index++] = currentShape;

        return filteredShapes;
    }
}
