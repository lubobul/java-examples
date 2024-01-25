package models;

public abstract class Sapling implements Comparable<Sapling> {
    protected String name;
    protected double price;

    public Sapling(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()){
            throw new IllegalArgumentException("Name cannot be empty.");
        }

        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException("Price must be greater than 0");
        }

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
