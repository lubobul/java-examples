package view;

import controllers.MovieLibraryController;
import models.Movie;
import models.MovieLibrary;

import java.time.Year;
import java.util.List;
import java.util.Scanner;

import static models.Constants.ROBERT_DI_NIRO;

public class View {
    /**
     * Prints generic movie info from a list of libraries
     * @param libraryController - Library controller holding a list of libraries
     * @param libraryName - library name for which to print generic info
     */
    public static void printGenericMovieInfo(MovieLibraryController libraryController, String libraryName) {
        System.out.println("Sorted movies: ");
        for (Movie movie : libraryController.getMoviesSortedByTitleFromLibrary(libraryName)) {
            System.out.println(movie);
        }

        System.out.println("Robert De Niro movies: ");
        for (Movie movie : libraryController.getMoviesByActorSortedFromLibrary(libraryName, ROBERT_DI_NIRO)) {
            System.out.println(movie);
        }
    }

    /**
     * Adds a new MovieLibrary to a list of libraries
     * @param libraries list of libraries
     * @param scanner scanner used to read user console input
     */
    public static void addMovieLibrary(List<MovieLibrary> libraries, Scanner scanner) {
        MovieLibrary movieLibrary;
        int numberOfMovies = 0;
        String libraryName = "";
        do {
            System.out.print("Enter unique library name: ");
            movieLibrary = new MovieLibrary(scanner.nextLine());

            libraryName = movieLibrary.getLibraryName();

        } while (hasLibraryWithSameName(libraries, libraryName));

        libraries.add(movieLibrary);

        do {
            System.out.print("Enter number of movies less than 10000: ");
            numberOfMovies = scanner.nextInt();
            scanner.nextLine();
        } while (numberOfMovies > 10000);

        for (int i = 1; i <= numberOfMovies; i++) {
            movieLibrary.addMovie(createMovie(i, scanner));
        }
    }

    /**
     * Checks whether there is an existing library with the same library name in a list of libraries
     * @param libraries - list of libraries
     * @param libraryName - library name
     * @return boolean
     */
    private static boolean hasLibraryWithSameName(List<MovieLibrary> libraries, String libraryName) {
        return libraries
                .stream()
                .anyMatch(lib -> lib.getLibraryName().toLowerCase().contains(String.valueOf(libraryName).toLowerCase()));
    }

    /**
     * Creates a new Movie reading input from the user
     * @param movieNumber the movie index
     * @param scanner  scanner used to read user console input
     * @return new Movie
     */
    private static Movie createMovie(int movieNumber, Scanner scanner) {
        Movie movie = new Movie();
        while (true) {
            try {
                System.out.println("Creating movie - " + movieNumber);
                System.out.println("--------------------------------");
                System.out.print("Title: ");
                movie.setTitle(scanner.nextLine());
                enterActors(movie, scanner);
                System.out.print("Year of production: ");
                movie.setYear(Year.of(scanner.nextInt()));
                scanner.nextLine();
                System.out.print("License fee: ");
                movie.setLicenseFee(scanner.nextDouble());
                scanner.nextLine();
                System.out.println();
                break;
            } catch (Exception e) {
                if (e instanceof IllegalArgumentException) {
                    System.out.println(e.getMessage());
                    continue;
                } else {
                    break;
                }
            }
        }

        return movie;
    }

    /**
     * Enters actors in an existing movie
     * @param movie - Movie for which to enter actors
     * @param scanner - scanner used to read user console input
     */
    private static void enterActors(Movie movie, Scanner scanner) {
        System.out.println("Enter each actor. Type 'done' to finish.");

        while (true) {
            System.out.print(">");
            String actorInput = scanner.nextLine();
            if (actorInput.equalsIgnoreCase("done")) break;
            try {
                movie.addActor(actorInput);
            } catch (Exception e) {
                if (e instanceof IllegalArgumentException) {
                    System.out.println(e.getMessage());
                    continue;
                } else {
                    break;
                }
            }
        }
    }
}
