package models;

public class DecorativeSapling extends Sapling {
    private double spacing;
    private double maxHeight;

    public DecorativeSapling(){
        super();
    }

    public DecorativeSapling(String name, double price, double spacing, double maxHeight) {
        super(name, price);
        this.spacing = spacing;
        this.maxHeight = maxHeight;
    }

    public double getSpacing() {
        return spacing;
    }

    public void setSpacing(double spacing) {
        this.spacing = spacing;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("Spacing between saplings: %,.2f \n", this.spacing) +
                String.format("Grown tree maximum height: %,.2f\n", this.maxHeight);
    }
}
