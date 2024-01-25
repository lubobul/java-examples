package taks2;

import models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Sapling> saplings = new ArrayList<Sapling>();

        System.out.print("Enter number of saplings: ");
        int saplingsNumber = scanner.nextInt();

        for (int i = 1; i <= saplingsNumber; i++) {
            saplings.add(createSapling(i));
        }

        Collections.sort(saplings, Collections.reverseOrder());

        for (Sapling s : saplings) {
            System.out.println(s.toString());
        }

        scanner.close();
    }

    public static Sapling createSapling(int saplingNumber) {
        Scanner scanner = new Scanner(System.in);
        int userChoice;

        while (true) {

            System.out.printf("Choose a sapling type for sapling: %d \n", saplingNumber);
            System.out.println("1 - Fruit tree sapling");
            System.out.println("2 - Decorative tree sapling");

            System.out.print("Choice: ");
            userChoice = scanner.nextInt();
            scanner.nextLine();
            System.out.println();
            switch (userChoice) {
                case 1:
                    try {
                        FruitSapling sapling = new FruitSapling();
                        System.out.println("Creating a fruit tree sapling");
                        System.out.println("-----------------------------");
                        System.out.print("Name: ");
                        sapling.setName(scanner.nextLine());
                        System.out.print("Price: ");
                        sapling.setPrice(scanner.nextDouble());
                        System.out.print("Yearly fruit count: ");
                        sapling.setYearlyFruitCount(scanner.nextInt());
                        System.out.print("Yearly fruit weight: ");
                        sapling.setYearlyFruitWeight(scanner.nextDouble());
                        scanner.nextLine();
                        System.out.print("Details: ");
                        sapling.setDetails(scanner.nextLine());
                        System.out.println();
                        return sapling;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                case 2:
                    try {
                        DecorativeSapling sapling2 = new DecorativeSapling();
                        System.out.println("Creating a decorative tree sapling");
                        System.out.println("----------------------------------");
                        System.out.print("Name: ");
                        sapling2.setName(scanner.nextLine());
                        System.out.print("Price: ");
                        sapling2.setPrice(scanner.nextDouble());
                        System.out.print("Spacing between saplings: ");
                        sapling2.setSpacing(scanner.nextDouble());
                        System.out.print("Grown tree maximum height: ");
                        sapling2.setMaxHeight(scanner.nextDouble());
                        scanner.nextLine();
                        System.out.println();
                        return sapling2;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 2");
                    break;
            }
            scanner.close();
        }
    }
}
