package controllers;

import models.Movie;
import models.MovieLibrary;

import java.time.Year;
import java.util.Comparator;
import java.util.List;

import static models.Constants.ROBERT_DI_NIRO;

public class MovieLibraryController {
    private List<MovieLibrary> movieLibraries;

    public MovieLibraryController(List<MovieLibrary> movieLibraries) {
        this.movieLibraries = movieLibraries;
    }

    public List<MovieLibrary> getMovieLibraries() {
        return movieLibraries;
    }

    /**
     * Returns a list of all movies sorted by title ASC
     *
     * @return List<Movie>
     */
    public List<Movie> getMoviesSortedByTitleFromLibrary(String libraryName) {
        return movieLibraries
                .stream()
                .filter(movieLibrary -> movieLibrary.getLibraryName().toLowerCase().contains(libraryName.toLowerCase()))
                .findFirst()
                .get()
                .getMovies()
                .stream()
                .sorted(Comparator.comparing(Movie::getTitle, String.CASE_INSENSITIVE_ORDER))
                .toList();
    }

    /**
     * Returns a list of all movies for which one of main actors is Robert Di Niro
     * Sorted by Year ASC and sorted by LicenseFee DESC
     * @param libraryName - library name
     * @return List<Movie>
     */
    public List<Movie> getMoviesByActorSortedFromLibrary(String libraryName, String actorName) {
        return movieLibraries
                .stream()
                .filter(movieLibrary -> movieLibrary.getLibraryName().toLowerCase().contains(libraryName.toLowerCase()))
                .findFirst()
                .get()
                .getMovies()
                .stream()
                .filter(film -> film.getActors().toLowerCase().contains(actorName.toLowerCase()))
                .sorted(Comparator.comparing(Movie::getYear)
                        .reversed()
                        .thenComparing(Movie::getLicenseFee))
                .toList();

    }

    /**
     * Returns average license fee for all movies from particular production year
     * across all libraries
     * @param year - movie production year
     * @return double
     */
    public double getAverageLicenseFeeFromAllLibrariesOfYear(Year year) {
        return movieLibraries
                .stream()
                .flatMap(movieLibrary -> movieLibrary.getMovies().stream())
                .filter(movie -> movie.getYear().equals(year))
                .mapToDouble(Movie::getLicenseFee)
                .average()
                .orElse(0.0);
    }

    /**
     * Returns the average license fee for a library with highest license fee
     * for a particular year
     * @param year - movie production year
     * @return double
     */
    public double getHighestAverageLicenseFeeFromAllLibrariesOfYear(Year year) {
        return movieLibraries
                .stream()
                .mapToDouble(movieLibrary -> movieLibrary
                        .getMovies()
                        .stream()
                        .filter(movie -> movie.getYear().equals(year))
                        .mapToDouble(Movie::getLicenseFee)
                        .average()
                        .orElse(0.0))
                .max()
                .orElse(0.0);
    }

    /**
     * Returns average license fee for all movies from particular production year
     * for a particular library
     * @param year - movie production year
     * @return double
     */
    public double getAverageLicenseFeeFromLibraryOfYear(Year year, String libraryName) {
        return movieLibraries
                .stream()
                .filter(movieLibrary -> movieLibrary.getLibraryName().toLowerCase().contains(libraryName.toLowerCase()))
                .flatMap(movieLibrary -> movieLibrary.getMovies().stream().filter(movie -> movie.getYear().equals(year)))
                .mapToDouble(Movie::getLicenseFee)
                .average()
                .orElse(0.0);
    }
}
