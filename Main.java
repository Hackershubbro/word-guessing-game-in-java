import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Created and Coded By Seenu Madhavan R");
        try{
        Scanner scanner = new Scanner(System.in);

        List<Character> alphabets = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            alphabets.add(c);
        }

        System.out.print("Enter the length of your name: ");
        int user = scanner.nextInt();

        if (user == 0){
            scanner.close();
            throw new ArithmeticException("OOPS !! Word lenght cannot be zero my friend!! try again");

        }
        List<List<Character>> matrix = new ArrayList<>();
        int k = 0;

        while (k < alphabets.size()) {
            List<Character> row = new ArrayList<>();
            for (int i = 0; i < user; i++) {
                if (k < alphabets.size()) {
                    row.add(alphabets.get(k));
                    k++;
                } else {
                    row.add(' ');
                }
            }
            matrix.add(row);
        }
        // formating Output Screen
        System.out.println();
        System.out.println();

        System.out.println("Original 2D Matrix:");
        for (List<Character> row : matrix) {
            System.out.println(row);
        }

        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < user; i++){
            temp.add(i+1);
        }
        System.out.println(temp.toString());

        // formating Output Screen
        System.out.println();
        System.out.println();

        // Get user input for column indices
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < user; i++) {
            System.out.print("Enter column index as per your name's order (indexed from 1): ");
            cols.add(scanner.nextInt() - 1);
        }

        System.out.println();
        System.out.println();

        List<List<Character>> selectedColumns = new ArrayList<>();
        // Extract the specified columns from the original matrix
        for (int colIndex : cols) {
            List<Character> selectedColumn = new ArrayList<>();
            for (List<Character> row : matrix) {
                selectedColumn.add(row.get(colIndex));
            }
            selectedColumns.add(selectedColumn);
        }

        System.out.println("Selected columns:");
        for (List<Character> col : selectedColumns) {
            System.out.println(col);
        }

        temp.clear();
        for(int i = 0; i < selectedColumns.get(0).size() ; i++){
            temp.add(i+1);
        }
        System.out.println(temp.toString());

        System.out.println();
        System.out.println();

        // Get user input for another set of column indices
        cols = new ArrayList<>();
        for (int i = 0; i < user; i++) {
            System.out.print("Enter column index as per your name's order (indexed from 1): ");
            cols.add(scanner.nextInt() - 1);
        }

        System.out.println();
        System.out.println();

        List<List<Character>> rearrangedColumns = new ArrayList<>();

        // Extract the specified columns from the previous matrix
        for (int colIndex : cols) {
            List<Character> rearrangedColumn = new ArrayList<>();
            for (List<Character> col : selectedColumns) {
                rearrangedColumn.add(col.get(colIndex));
            }
            rearrangedColumns.add(rearrangedColumn);
        }

        System.out.println("Selected columns from the second matrix:");
        for (List<Character> col : rearrangedColumns) {
            System.out.println(col);
        }

        temp.clear();
        for(int i = 0; i < rearrangedColumns.size() ; i++){
            temp.add(i+1);
        }
        System.out.println(temp.toString());

        System.out.println();
        System.out.println();

        // Print the diagonal elements
        String str = "";
        for (int i = 0; i < rearrangedColumns.size(); i++) {
            str += rearrangedColumns.get(i).get(i);
        }

        System.out.println("Do You mean " + str + " ??");

        scanner.close();
    }
    catch(ArithmeticException e){
        System.out.println(e.getMessage());
    }
    catch (Exception e){
        System.out.println("OOPS!!! Something went wrong try again ");
    }
}
}
