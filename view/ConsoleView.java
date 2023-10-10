package view;

import java.util.Scanner;
import controller.Controller;
import exception.EmptyRepositoryException;
import exception.OverflowException;
import model.Cilinder;
import model.Cube;
import model.Sphere;
import model.Shape;

public class ConsoleView 
{
    private Controller controller;
    private final String[] validOptions = {"0", "1", "2", "3", "4"};
    private final String[] validShapeOptions = {"0", "1", "2", "3"};
    private Scanner scanner;

    private final int CUBE = 1;
    private final int SPHERE = 2;
    private final int CILINDER = 3;

    public ConsoleView(Controller controller)
    {
        this.controller = controller;
        this.scanner = new Scanner(System.in);
    }

    private void showMenu()
    {
        System.out.println("\n\t~ Main menu ~\n");

        System.out.println("1 - Add a shape.");
        System.out.println("2 - Remove a shape");
        System.out.println("3 - Show all shapes.");
        System.out.println("4 - Show all shapes having volume greater than 25.");
        System.out.println("0 - Close the application.\n");
    }

    private boolean checkOption(String userOption, String[] validOptions)
    {
        for (String option : validOptions)
            if (option.equals(userOption))
                return true;

        return false;
    }

    private int readOption() throws Exception
    {
        this.showMenu();

        System.out.print(">> ");

        String option = scanner.nextLine();

        if (!this.checkOption(option, this.validOptions))
            throw new Exception("\nInvalid option!");

        return Integer.parseInt(option);
    }

    private void showShapesArray(Shape[] shapes)
    {
        if (shapes.length == 0)
        {
            System.out.println("\nEmpty!");
            return;
        }

        System.out.println();

        for (Shape shape : shapes)
            System.out.println(shape);

        System.out.println();
    }

    private void showAllShapes()
    {
        Shape[] allShapes = this.controller.getShapes();

        this.showShapesArray(allShapes);
    }

    private void showShapesWithVolumeGreater()
    {
        Shape[] shapes = this.controller.getShapesWithVolumeGreater(25);

        this.showShapesArray(shapes);
    }

    private Cube readCubeData()
    {
        System.out.print("\nWidth: ");
        int width = this.scanner.nextInt();

        return new Cube(width);
    }

    private Sphere readSphereData()
    {
        System.out.print("\nRadius: ");
        int radius = this.scanner.nextInt();

        return new Sphere(radius);
    }

    private Cilinder readCilinderData()
    {
        System.out.print("\nBase radius: ");
        int baseRadius = this.scanner.nextInt();

        System.out.print("\nHeight: ");
        int height = this.scanner.nextInt();

        return new Cilinder(baseRadius, height);
    }

    private Shape readShapeData(int shapeType)
    {
        if (shapeType == CUBE)
            return this.readCubeData();

        if (shapeType == SPHERE)
            return this.readSphereData();

        if (shapeType == CILINDER)
            return this.readCilinderData();

        return null;
    }

    private void addShape() throws Exception
    {
        System.out.println("\nChoose the type of shape:\n");
        System.out.println("1 - Cube");
        System.out.println("2 - Sphere");
        System.out.println("3 - Cilinder");
        System.out.println("0 - Cancel\n");

        System.out.print(">> ");

        String shapeOption = scanner.nextLine();

        if (!this.checkOption(shapeOption, this.validShapeOptions))
            throw new Exception("\nInvalid option!");

        Shape newShape = this.readShapeData(Integer.parseInt(shapeOption));

        if (newShape != null)
            this.scanner.nextLine();

        try
        {
            this.controller.addShape(newShape);
        }
        catch (OverflowException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private void removeShape() throws Exception
    {
        System.out.println("\nChoose the type of shape:\n");
        System.out.println("1 - Cube");
        System.out.println("2 - Sphere");
        System.out.println("3 - Cilinder");
        System.out.println("0 - Cancel\n");

        System.out.print(">> ");

        String shapeOption = scanner.nextLine();

        if (!this.checkOption(shapeOption, this.validShapeOptions))
            throw new Exception("\nInvalid option!");

        Shape newShape = this.readShapeData(Integer.parseInt(shapeOption));

        if (newShape != null)
            this.scanner.nextLine();

        try
        {
            this.controller.removeShape(newShape);
        }
        catch (EmptyRepositoryException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void run()
    {
        Shape cube1 = new Cube(5);
        Shape cube2 = new Cube(4);
        Shape sphere1 = new Sphere(3);
        Shape cilinder1 = new Cilinder(1, 5);

        try 
        {
            this.controller.addShape(cube1);
            this.controller.addShape(cube2);
            this.controller.addShape(sphere1);
            this.controller.addShape(cilinder1);
        } 
        catch (Exception e) 
        {
            // Do nothing.
        }

        while (true)
        {
            try
            {
                int userOption = this.readOption();

                if (userOption == 0)
                    break;

                if (userOption == 1)
                {
                    // Add.
                    this.addShape();
                }
                else if (userOption == 2)
                {
                    // Remove. 
                    this.removeShape();
                }
                else if (userOption == 3)
                {
                    // Show all.
                    this.showAllShapes();
                }
                else if (userOption == 4)
                {
                    // Show shapes with volume greater than 25.
                    this.showShapesWithVolumeGreater();
                }
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
            }
        }

        this.scanner.close();
    }
}
