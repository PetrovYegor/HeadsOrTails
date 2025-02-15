import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.print("Игрок1, введите ваш ход (0 - орел, 1 - решка): ");
        int playerGuess = Integer.parseInt(scanner.nextLine());
        int targetValue = random.nextInt(2);
        if (playerGuess == targetValue){
            System.out.println("Выиграл:");
            System.out.println("Игрок1");
        } else {
            System.out.println("Проиграл:");
            System.out.println("Игрок1");
        }
    }
}