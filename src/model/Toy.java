package model;

public class Toy {
    private String name;
    private double price;
    private String size;
    private String material;
    private int age;


    public Toy(String name, double price, String size, String material, int age) {
        this.name = name;
        this.price = price;
        this.size = size;
        this.material = material;
        this.age = age;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder();
        strB.append("\nName: ").append(name).append("\nPrice: ").append(price).append("\nSize: ")
                .append(size).append("\nMaterial: ").append(material).append("\nAge: ").append(age).append('\n');
        return strB.toString();
    }
}
