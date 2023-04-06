package view;

import controller.MenuController;

public class View {
    private final MenuController menuController = new MenuController();
    public void init() {
        menuController.printMenu();
    }

    public void printElement(String str) {
        System.out.println(str);
    }
}
