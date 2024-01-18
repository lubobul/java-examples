package models;

public abstract class Sapling implements Comparable<Sapling> {
    protected String name;
    protected double price;

    public Sapling(){

    }

    public Sapling(String name, double price) {
        this.name = name;
        this.price = price;
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

    @Override
    public String toString() {
        return super.toString() + "\n" +
                String.format("Name: %s \n", this.name) +
                String.format("Price: %,.2f\n", this.price);
    }

    @Override
    public int compareTo(Sapling other) {
        return this.name.compareToIgnoreCase(other.getName());
    }
}
