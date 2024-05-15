package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MovieLibrary {

    private List<Movie> movies = new ArrayList<>();
    private String libraryName;

    public MovieLibrary(){
    }

    public MovieLibrary(String name){
        this.libraryName = name;
    }

    public String getLibraryName(){
        return libraryName;
    }

    public void setLibraryName(String libraryName){
        this.libraryName = libraryName;
    }

    public void addMovie(Movie movie) {
        if (movies.size() <= 10000) {
            movies.add(movie);
        } else {
            throw new IndexOutOfBoundsException("The library cannot hold more than 10000 movies");
        }
    }

    public List<Movie> getMovies() {
        return movies;
    }
}
