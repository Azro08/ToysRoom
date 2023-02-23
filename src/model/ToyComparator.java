package model;

import java.util.Comparator;

public class ToyComparator implements Comparator<Toy> {
    public int compare(Toy firstToy, Toy secondToy) {
        return firstToy.getName().compareTo(secondToy.getName());
    }
}
