package repository;

import model.Shape;

import java.util.Arrays;

import exception.EmptyRepositoryException;
import exception.OverflowException;

public class InMemoryRepository implements Repository 
{
    private int capacity;
    private int size;
    private Shape[] shapes;

    public InMemoryRepository()
    {
        this.capacity = 100;
        this.size = 0;
        this.shapes = new Shape[this.capacity];
    }

    public InMemoryRepository(int capacity)
    {
        this.capacity = capacity;
        this.size = 0;
        this.shapes = new Shape[this.capacity];
    }

    @Override
    public void addShape(Shape shape) throws OverflowException
    {
        if (this.size == this.capacity)
            throw new OverflowException("\nFull repository!\n");

        if (shape == null)
            return;

        this.shapes[this.size++] = shape;
    }
    
    @Override
    public void removeShape(Shape shape) throws EmptyRepositoryException
    {
        if (this.size == 0)
            throw new EmptyRepositoryException("\nEmpty repository!\n");

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
        return Arrays.copyOfRange(this.shapes, 0, this.size);
    }

    @Override
    public int getNumberOfShapes()
    {
        return this.size;
    }

    @Override
    public boolean containsShape(Shape shape)
    {
        for (int i = 0; i < this.size; i++)
            if (shape.equals(this.shapes[i]))
                return true;

        return false;
    }

    @Override
    public Shape[] getShapesWithVolumeGreater(double minVolume)
    {
        int count = 0;

        for (int i = 0; i < this.size; i++)
            if (this.shapes[i].getVolume() > minVolume)
                count++;

        Shape[] filteredShapes = new Shape[count];

        int index = 0;

        for (int i = 0; i < this.size; i++)
            if (this.shapes[i].getVolume() > minVolume)
                filteredShapes[index++] = this.shapes[i];

        return filteredShapes;
    }
}
