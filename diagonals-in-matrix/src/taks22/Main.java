package taks22;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int rows, columns;

        //Prompt the user to enter matrix size
        do {
            System.out.print("Enter matrix rows between 1 and 12: ");
            rows = scanner.nextInt();
        } while (rows < 1 || rows > 12);

        do {
            System.out.print("Enter matrix columns between 1 and 9: ");
            columns = scanner.nextInt();
        } while (columns < 1 || columns > 9);


        int[][] matrix = new int[rows][columns];

        //Populate matrix with random integers between -12 and 22
        for (int i = 0; i < rows; i++) {
            Arrays.setAll(matrix[i], j -> random.nextInt(-12, 23));
        }

        int[] columnIntMaxLengths = new int[columns];

        //Get maximum integer text length per column
        Arrays.setAll(columnIntMaxLengths, i -> {
            int max = 0;

            for (int[] row : matrix) {

                if (i < row.length) {
                    int len = Integer.toString(row[i]).length();
                    if (len > max) {
                        max = len;
                    }
                }
            }

            return max + 1;
        });

        System.out.println("*".repeat(Arrays.stream(columnIntMaxLengths).sum()));

        for (int[] a : matrix) {

            for (int c = 0; c < a.length; c++) {
                System.out.printf("%" + columnIntMaxLengths[c] + "d", a[c]);
            }

            System.out.println();
        }

        System.out.println("*".repeat(Arrays.stream(columnIntMaxLengths).sum()));

        List<List<Integer>> diagonals =
                getCounterDiagonals(matrix)
                .stream()
                .filter(diag -> diag.stream().mapToInt(i -> i).sum() % 2 != 0)
                .toList();

        printDiagonals(diagonals);
    }

    public static List<List<Integer>> getCounterDiagonals(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        List<List<Integer>> diagonals = new ArrayList<>();

        //Add diagonals from right top corner towards right bottom corner
        for (int c = cols - 1; c >= 0; c--) {
            List<Integer> diagonal = new ArrayList<>();
            int currentCol = c;
            for (int r = 0; r < rows; r++) {

                diagonal.add(matrix[r][c]);

                if (c >= cols - 1 || r >= rows - 1) {
                    diagonals.add(diagonal);
                    c = currentCol;
                    break;
                }
                c++;
            }
        }

        //Add diagonals from left top corner towards bottom left corner
        for (int r = 1; r < rows; r++) {
            List<Integer> diagonal = new ArrayList<>();
            int currentRow = r;
            for (int c = 0; c < cols; c++) {

                diagonal.add(matrix[r][c]);

                if (c >= cols - 1 || r >= rows - 1) {
                    diagonals.add(diagonal);
                    r = currentRow;
                    break;
                }
                r++;
            }
        }

        return diagonals;
    }

    public static void printDiagonals(List<List<Integer>> diagonals) {

        for (List<Integer> diagonal : diagonals) {
            for (int i : diagonal) {
                System.out.print(i + " ");
            }
            System.out.print("= " + diagonal.stream().mapToInt(i -> i).sum() + " ");
            System.out.println();

        }
    }
}
