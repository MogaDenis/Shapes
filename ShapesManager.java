import controller.Controller;
import repository.*;
import view.ConsoleView;

// 7. Se da o colectie de mai multe obiecte
// avand forme de cuburi, sfere si cilindrii.
// Sa se afiseze obiectele avand volumul mai mare
// decat 25cm3.

public class ShapesManager 
{
    public static void main(String[] args)
    {
        Repository repository = new InMemoryRepository(6);
        Controller controller = new Controller(repository);
        ConsoleView consoleView = new ConsoleView(controller);

        consoleView.run();
    }
}
