package controller;


import model.Toy;
import model.ToyComparator;
import service.Size;
import service.WrongAgeException;
import view.Constants;
import view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MainController {
    private final Scanner input = new Scanner(System.in);
    private final View view = new View();
    private final RoomCreator roomCreator = new RoomCreator();

    public ArrayList<Toy> toysList = new ArrayList<>();
    public ArrayList<Toy> roomCreatorToysList = new ArrayList<>();

    public ArrayList<Toy> initToys() {
        if (toysList.isEmpty()){
            toysList.add(new Toy("Car", 250.6, Size.SMALL.toString(), "Plastic", 3));
            toysList.add(new Toy("Car", 1500.9, Size.BIG.toString(), "Aluminium", 16));
            toysList.add(new Toy("Car", 166.7, Size.MEDIUM.toString(), "Wood", 3));
            toysList.add(new Toy("Rubik's cube", 25.5, Size.SMALL.toString(), "Plastic", 8));
            toysList.add(new Toy("Alphabets cubs", 960.1, Size.STANDARD.toString(), "Wood", 0));
            toysList.add(new Toy("Doll", 20.6, Size.SMALL.toString(), "Rubber", 0));
            toysList.add(new Toy("Soccer Ball", 1250.6, Size.STANDARD.toString(), "Leather", 10));
            toysList.add(new Toy("Cubs with pictures", 250.6, Size.SMALL.toString(), "Wood", 0));
            toysList.add(new Toy("Cubs with dots", 550.4, Size.SMALL.toString(), "Metal", 0));
            toysList.add(new Toy("Cubs with numbers", 230.6, Size.SMALL.toString(), "Wood", 3));
        }
        return toysList;
    }

    public void go() {
        Constants constants = new Constants();
        System.out.println("Amount of toysList: " + constants.getAmountOfToys());
        System.out.println("Money: " + constants.getMoney());
    }

    private void init() {
        roomCreatorToysList = roomCreator.roomCreating();
    }

    void addNewToy() {
        if (toysList.isEmpty()) toysList = initToys();
        String name, material, size;
        int age;
        double price;
        System.out.println("Name: ");
        name = input.nextLine();
        System.out.println("Price: ");
        price = input.nextDouble();
        System.out.println("Size(STANDARD, SMALL, MEDIUM, BIG): ");
        size = input.next().toUpperCase();
        System.out.println("Material: ");
        material = input.next();
        System.out.println("Age: ");
        age = input.nextInt();
        input.nextLine();
        Toy newToy = new Toy(name, price, size, material, age);
        toysList.add(newToy);
        System.out.println("Done.");
    }

    void printAllAvailable() {
        double count = 0.0;
        if (toysList.isEmpty()){
            toysList = initToys();
        }
        for (Toy toy : toysList) {
            view.printElement(toy.toString());
            count += toy.getPrice();
        }
        System.out.println("Count: " + Math.rint(count) + '\n');
    }

    void printAll() {
        double count = 0;
        init();
        if (toysList.isEmpty()){
            toysList = initToys();
        }
        for (Toy toy : toysList) {
            view.printElement(toy.toString());
            count += toy.getPrice();
        }
        System.out.println("Count: " + count + '\n');
    }

    void sortByName() {
        init();
        toysList.sort(new ToyComparator());
        for (Toy toy : toysList) {
            view.printElement(toy.toString());
        }
    }

    void findByName() {
        init();
        System.out.print("Input name: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        try {
            str = reader.readLine();
            for (Toy toy : toysList) {
                if (str.equals(toy.getName())) {
                    view.printElement(toy.toString());
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    void findByAge() {
        init();
        int elAge = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        do {
            System.out.print("Input age: ");
            try {
                str = reader.readLine();
                elAge = Integer.parseInt(str);
                if (elAge < 0) System.out.println(new WrongAgeException().getMessage());
            } catch (WrongAgeException ex) {
                ex.getMessage();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } while (elAge < 0);

        for (Toy toy : toysList) {
            if (elAge >= toy.getAge()) {
                view.printElement(toy.toString());
            }
        }
    }

}
