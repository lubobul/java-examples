package models;

import java.time.Year;

public class Movie {
    private String title;
    private StringBuilder actors = new StringBuilder();
    private Year year;
    private double licenseFee;

    public Movie() {
    }

    public Movie(String title, String actors, Year year, int licenseFee) {
        this.title = title;
        this.actors = new StringBuilder(actors);
        this.year = year;
        this.licenseFee = licenseFee;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.length() > Constants.TITLE_MAX_LENGTH){
            throw new IllegalArgumentException("Movie title should not exceed " + Constants.TITLE_MAX_LENGTH + " characters");
        }
        this.title = title;
    }

    public String getActors() {
        return actors.toString();
    }

    public void setActors(String actors) {
        if(actors.length() > Constants.ACTORS_MAX_LENGTH){
            throw new IllegalArgumentException("Movie actors should not exceed " + Constants.ACTORS_MAX_LENGTH + " characters");
        }
        this.actors = new StringBuilder(actors);
    }

    public void addActor(String actor) {
        if(actors.length() + ", ".length() + actor.length() > Constants.ACTORS_MAX_LENGTH){
            throw new IllegalArgumentException("Movie actors should not exceed " + Constants.ACTORS_MAX_LENGTH + " characters");
        }

        this.actors.append(!actors.isEmpty() ? ", " : "").append(actor);
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public double getLicenseFee() {
        return licenseFee;
    }

    public void setLicenseFee(double licenseFee) {
        this.licenseFee = licenseFee;
    }

    @Override
    public String toString() {
        return title + "; " + actors.toString() + "; " + year + "; " + licenseFee;
    }
}
