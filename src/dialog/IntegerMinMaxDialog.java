package dialog;

import java.util.Scanner;

public class IntegerMinMaxDialog implements Dialog<Integer> {
    private final String title;
    private final String error;
    private final int min;
    private final int max;

    //на всё это сделать конструктор
    public IntegerMinMaxDialog(String title, String error, int min, int max) {
        this.title = title;
        this.error = error;
        this.min = min;
        this.max = max;
    }

    //надо принимать ввод, поэтому сканнер
    public Integer input(){
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print(title);//выводим сообщение
            String input = scanner.nextLine();//далее считываем ввод
            System.out.println();
            if (isInteger(input)){
                var result = Integer.parseInt(input);

                if (result >= min && result <= max){
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