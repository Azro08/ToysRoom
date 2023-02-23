import controller.MainController;
import view.View;

public class Main {
    public static void main(String[] args) {
        new MainController().go();
        new View().init();

    }
}
