package service;

public abstract class MainMenu {
    public static void menu() {
        System.out.println("1) Print all available toys;");
        System.out.println("2) Print toys in the room;");
        System.out.println("3) Find by age;");
        System.out.println("4) Find by name;");
        System.out.println("5) Sort toys by name;");
        System.out.println("0) Exit");
        System.out.print("Input one of the following keys> ");
    }
}
