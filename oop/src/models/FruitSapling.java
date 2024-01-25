package models;

public class FruitSapling extends Sapling {
    private int yearlyFruitCount;
    private double yearlyFruitWeight;
    private String details;

    public FruitSapling(){
    }

    public FruitSapling(FruitSapling newSapling) {
        this.setName(newSapling.getName());
        this.setPrice(newSapling.getPrice());
        this.setYearlyFruitCount(newSapling.getYearlyFruitCount());
        this.setYearlyFruitWeight(newSapling.getYearlyFruitWeight());
        this.setDetails(newSapling.getDetails());
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        if(details == null){
            throw new IllegalArgumentException("Details cannot be set to null.");
        }

        this.details = details;
    }

    public int getYearlyFruitCount() {
        return yearlyFruitCount;
    }

    public void setYearlyFruitCount(int yearlyFruitCount) {
        if(yearlyFruitCount <= 0){
            throw new IllegalArgumentException("Yearly Fruit Count must be greater than 0.");
        }

        this.yearlyFruitCount = yearlyFruitCount;
    }

    public double getYearlyFruitWeight() {
        return yearlyFruitWeight;
    }

    public void setYearlyFruitWeight(double yearlyFruitWeight) {
        if(yearlyFruitWeight <= 0){
            throw new IllegalArgumentException("Yearly Fruit Weight must be greater than 0.");
        }

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
