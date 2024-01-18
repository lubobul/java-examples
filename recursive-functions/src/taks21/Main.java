package taks21;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keepTestingAnswer = "";
        do {
            int n;
            double x;

            do {
                System.out.print("Enter integer between 0 and 10^6: ");
                n = scanner.nextInt();
            } while (n < 0 || n > Math.pow(10, 6));

            do {
                System.out.print("Enter a positive real number: ");
                x = scanner.nextDouble();
            } while (x < 0);

            scanner.nextLine();

            System.out.println(f(n, x));
            System.out.print("To keep testing, type Yes, to quit press return: ");
            keepTestingAnswer = scanner.nextLine();
            int a = 0;
        }while (keepTestingAnswer.equals("Yes"));

        scanner.close();

    }

    public static double f(int n, double x) {

        if (n >= 3 && Math.abs(x) >= Math.pow(10, 3)) {
            if (n % 2 == 1) {
                return f(n - 1, Math.sqrt(x)) - (5 * Math.sqrt(n));
            } else {
                return Math.sqrt(Math.abs(f(n - 1, Math.sqrt(x)) - f(n - 2, Math.sqrt(x))));
            }
        }

        return Math.sqrt(x);
    }
}
