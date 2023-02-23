package service;

import model.Toy;

import java.util.ArrayList;

public class Examples {
    private ArrayList<Toy> toys = new ArrayList<Toy>();

    public ArrayList init() {
        toys.add(new Toy("Car", 250.6, Size.SMALL.toString(), "Plastic", 3));
        toys.add(new Toy("Car", 1500.9, Size.BIG.toString(), "Aluminium", 16));
        toys.add(new Toy("Car", 166.7, Size.MEDIUM.toString(), "Wood", 3));
        toys.add(new Toy("Rubik's cube", 25.5, Size.SMALL.toString(), "Plastic", 8));
        toys.add(new Toy("Alphabets cubs", 960.1, Size.STANDARD.toString(), "Wood", 0));
        toys.add(new Toy("Doll", 20.6, Size.SMALL.toString(), "Rubber", 0));
        toys.add(new Toy("Soccer Ball", 1250.6, Size.STANDARD.toString(), "Leather", 10));
        toys.add(new Toy("Cubs with pictures", 250.6, Size.SMALL.toString(), "Wood", 0));
        toys.add(new Toy("Cubs with dots", 550.4, Size.SMALL.toString(), "Metal", 0));
        toys.add(new Toy("Cubs with numbers", 230.6, Size.SMALL.toString(), "Wood", 3));

        return toys;
    }


}
