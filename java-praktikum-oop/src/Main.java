import controllers.MovieLibraryController;
import models.MovieLibrary;
import view.View;

import java.time.Year;
import java.util.*;
;

/**
 * Пловдивски университет – 1 юни 2011 г., вариант 2
 * I. ЗАДАЧА
 * Напишете програма за информационно обслужване на филмотека, чиито филми
 * не надхвърлят 10 000.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Задача.2 , Задача.3
//        List<MovieLibrary> libraries0 = new ArrayList<>();
//        createMovieLibrary(libraries0, scanner);
//
//        MovieLibraryController libController = new MovieLibraryController(libraries0);
//
//        for (MovieLibrary movieLib : libraries0) {
//            printGenericMovieInfo(libController, movieLib.getLibraryName());
//        }

        //Задача.4
        List<MovieLibrary> libraries1 = new ArrayList<>();
        MovieLibraryController libController1 = new MovieLibraryController(libraries1);

        for (int i = 1; i <= 3; i++) {

            System.out.println("Creating movie library - " + i);
            View.addMovieLibrary(libraries1, scanner);
        }

        for (MovieLibrary movieLib : libraries1) {
            View.printGenericMovieInfo(libController1, movieLib.getLibraryName());
        }

        System.out.println("Average license fee for all movies from all libraries for year 2010 is: ");
        System.out.println(libController1.getAverageLicenseFeeFromAllLibrariesOfYear(Year.of(2010)));

        System.out.println("Highest average license fee for movies from all libraries for year 2010 is: ");
        System.out.println(libController1.getHighestAverageLicenseFeeFromAllLibrariesOfYear(Year.of(2010)));

        scanner.close();
    }

}