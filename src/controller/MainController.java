package controller;


import model.Toy;
import model.ToyComparator;
import service.Examples;
import service.WrongAgeException;
import view.Constants;
import view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MainController {
    private View view = new View();
    private RoomCreator roomCreator = new RoomCreator();
    private ArrayList<Toy> toys = new ArrayList<Toy>();
    public void go() {
        Constants constants = new Constants();
        System.out.println("Amount of toys: " + constants.getAmountOfToys());
        System.out.println("Money: " + constants.getMoney());
    }

    private void init() {
        toys = roomCreator.roomCreating();
    }


    void printAllAvailable() {
        Examples examples = new Examples();
        ArrayList<Toy> toyExp;
        toyExp = examples.init();
        double count = 0.0;
        for (Toy toy :
                toyExp) {
            view.printElement(toy.toString());
            count += toy.getPrice();
        }
        System.out.println("Count: " + Math.rint(count) + '\n');
    }

    void printAll() {
        double count = 0;
        init();
        for (Toy toy : toys) {
            view.printElement(toy.toString());
            count += toy.getPrice();
        }
        System.out.println("Count: " + count + '\n');
    }

    void sortByName() {
        init();
        Collections.sort(toys, new ToyComparator());
        for (Toy toy :
                toys) {
            view.printElement(toy.toString());
        }
    }

    void findByName() {
        init();
        System.out.print("Input name: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            str = reader.readLine();
            for (Toy toy : toys) {
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
        String str = null;
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

        for (Toy toy : toys) {
            if (elAge >= toy.getAge()) {
                view.printElement(toy.toString());
            }
        }
    }

}
