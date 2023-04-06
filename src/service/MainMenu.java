package service;

public abstract class MainMenu {
    public static void menu() {
        System.out.println("1) Add new toy");
        System.out.println("2) Print all available toys;");
        System.out.println("3) Print toys in the room;");
        System.out.println("4) Find by age;");
        System.out.println("5) Find by name;");
        System.out.println("6) Sort toys by name;");
        System.out.println("0) Exit");
        System.out.print("Input one of the following keys> ");
    }
}
