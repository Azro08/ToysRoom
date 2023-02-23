package controller;

import service.MainMenu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuController {
    public void printMenu() {
        MainController mainController = new MainController();
        char key = '0';
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        while (true) {
            MainMenu.menu();
            try {
                key = reader.readLine().charAt(0);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            switch (key) {
                case '0':
                    System.exit(0);
                case '1':
                    mainController.printAllAvailable();
                    break;
                case '2':
                    mainController.printAll();
                    break;
                case '3':
                    mainController.findByAge();
                    break;
                case '4':
                    mainController.findByName();
                    break;
                case '5':
                    mainController.sortByName();
                    break;
                default:
                    System.out.println("Try again");
                    break;
            }
        }
    }
}
