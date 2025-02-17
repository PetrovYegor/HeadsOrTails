package heads_or_tails;

import java.util.Scanner;

import static heads_or_tails.GameMessages.*;

public class PlayerGuessReader {
    private final Scanner scanner;
    private final PlayerInputValidator validator;
    private int maxNumberOfPlayers = 10;

    public PlayerGuessReader(Scanner scanner, PlayerInputValidator validator) {
        this.scanner = scanner;
        this.validator = validator;
    }

    int inputNumberOfPlayers() {
        while (true) {
            String input = scanner.nextLine();
            try {
                int numberOfPlayers = Integer.parseInt(input);
                if (numberOfPlayers > 0 && numberOfPlayers <= maxNumberOfPlayers) {
                    return numberOfPlayers;
                } else {
                    System.out.println(WRONG_NUMBER_OF_PLAYERS);
                }
            } catch (NumberFormatException e) {
                System.out.println(WRONG_INPUT_MESSAGE);
            }
        }
    }

    int inputAndValidatePlayersGuesses(int playerIndex) {
        while (true) {
            System.out.printf(AKS_PLAYER_TO_GUESS_MESSAGE, playerIndex);
            String guess = scanner.nextLine();
            if (validator.isInputCorrect(guess)) {
                return Integer.parseInt(guess);
            } else {
                System.out.println(WRONG_INPUT_MESSAGE);
            }
        }
    }
}
