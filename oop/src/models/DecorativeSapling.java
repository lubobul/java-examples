package models;

public class DecorativeSapling extends Sapling {
    private double spacing;
    private double maxHeight;

    public DecorativeSapling(){
    }

    public DecorativeSapling(DecorativeSapling newSapling) {
        this.setName(newSapling.getName());
        this.setPrice(newSapling.getPrice());
        this.setSpacing(newSapling.getSpacing());
        this.setMaxHeight(newSapling.getMaxHeight());
    }

    public double getSpacing() {
        return spacing;
    }

    public void setSpacing(double spacing) {
        if(spacing <= 0){
            throw new IllegalArgumentException("Spacing must be greater than 0.");
        }

        this.spacing = spacing;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(double maxHeight) {
        if(maxHeight <= 0){
            throw new IllegalArgumentException("Max Height must be greater than 0.");
        }

        this.maxHeight = maxHeight;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("Spacing between saplings: %,.2f \n", this.spacing) +
                String.format("Grown tree maximum height: %,.2f\n", this.maxHeight);
    }
}
