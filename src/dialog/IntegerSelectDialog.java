package dialog;

import java.util.List;
import java.util.Scanner;

public class IntegerSelectDialog implements Dialog<Integer> {
    private final String title;
    private final String error;
    private final List<Integer> values;

    public IntegerSelectDialog(String title, String error, List<Integer> values) {
        this.title = title;
        this.error = error;
        this.values = values;
    }

    public Integer input(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(title);
            String input = scanner.nextLine();
            System.out.println();
            if (isInteger(input)){
                var result = Integer.parseInt(input);

                if (values.contains(result)){
                    return result;
                }
            }
            System.out.println(error);
        }
    }

    private static boolean isInteger(String s){
        try {
            Integer.parseInt(s);
            return true;
        } catch(NumberFormatException e) {
            return false;
        }
    }
}