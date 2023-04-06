package controller;

import model.Toy;
import view.Constants;

import java.util.ArrayList;

public class RoomCreator {

    public ArrayList<Toy> roomCreating() {
        ArrayList<Toy> available = new ArrayList<>();
        Constants constants = new Constants();
        MainController mainController = new MainController();

        ArrayList<Toy> toys = mainController.toysList;
        if (toys.isEmpty()) toys = mainController.initToys();
        int countOfToys = 0;
        double cash = 0;
        for (Toy toy : toys) {
            if (countOfToys < constants.getAmountOfToys()) {
                cash += toy.getPrice();
                if (cash > constants.getMoney()) {
                    cash -= toy.getPrice();
                    continue;
                }
                countOfToys++;
                available.add(toy);
            } else {
                break;
            }
        }
        return available;
    }
}
