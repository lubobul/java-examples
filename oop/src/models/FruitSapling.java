package models;

public class FruitSapling extends Sapling {
    private int yearlyFruitCount;
    private double yearlyFruitWeight;
    private String details;

    public FruitSapling(){
        super();
    }

    public FruitSapling(String name, double price, int yearlyFruitCount, double yearlyFruitWeight, String details) {
        super(name, price);
        this.yearlyFruitCount = yearlyFruitCount;
        this.yearlyFruitWeight = yearlyFruitWeight;
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getYearlyFruitCount() {
        return yearlyFruitCount;
    }

    public void setYearlyFruitCount(int yearlyFruitCount) {
        this.yearlyFruitCount = yearlyFruitCount;
    }

    public double getYearlyFruitWeight() {
        return yearlyFruitWeight;
    }

    public void setYearlyFruitWeight(double yearlyFruitWeight) {
        this.yearlyFruitWeight = yearlyFruitWeight;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("Yearly grown tree fruit count: %s \n", this.yearlyFruitCount) +
                String.format("Yearly grown tree fruit weight: %,.2f\n", this.yearlyFruitWeight) +
                String.format("Details: %s\n", this.details);
    }
}
