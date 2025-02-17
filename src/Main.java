import java.util.*;

public class Main {
    private static final String HEADER_STAR_MESSAGE = "************";
    private static final String HEADER_GAME_NAME_MESSAGE = "Орел и решка";
    private static final String NUMBER_OF_PLAYERS_MESSAGE = "Введите количество игроков: ";
    private static final String AKS_PLAYER_TO_GUESS_MESSAGE = "Игрок%d, введите ваш ход (0 - орел, 1 - решка): ";
    private static final String WIN_MESSAGE = "Выиграл:";
    private static final String LOSE_MESSAGE = "Проиграл:";
    private static final String WRONG_INPUT_MESSAGE = "Ошибка ввода";
    private static final String FLIP_COIN_MESSAGE = "Бросаем монетку \r\nВыпала сторона: %s\r\n";
    private static final String EAGLE = "ОРЕЛ";
    private static final String TAILS = "РЕШКА";
    private static final String PLAYER_INDEX_MESSAGE = "Игрок%d ";
    private static final int EAGLE_VALUE = 0;
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Map<String, Integer> GUESSES_BY_PLAYERS = new TreeMap<>();
    private static final List<String> WINNERS = new ArrayList<>();
    private static final List<String> LOSERS = new ArrayList<>();

    public static void main(String[] args) {
        startGameRound();
        SCANNER.close();
    }

    private static void startGameRound() {
        printStartGameMessage();
        System.out.print(NUMBER_OF_PLAYERS_MESSAGE);
        int numberOfPlayers = inputNumberOfPlayers();
        processPlayersGuesses(numberOfPlayers);
        int targetValue = getZeroOrOne();
        printTargetValue(targetValue);
        fillWinnersAndLosersLists(targetValue);
        printWinners();
        System.out.println();
        printLosers();
    }

    private static int inputNumberOfPlayers() {
        while (true) {
            String input = SCANNER.nextLine();
            try {
                int numberOfPlayers = Integer.parseInt(input);
                if (numberOfPlayers > 0) {
                    return numberOfPlayers;
                } else {
                    System.out.println("Количество игроков должно быть больше 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println(WRONG_INPUT_MESSAGE);
            }
        }
    }

    private static void processPlayersGuesses(int numberOfPlayers) {
        for (int playerIndex = 1; playerIndex <= numberOfPlayers; playerIndex++) {
            int playerGuess = inputAndValidatePlayersGuesses(playerIndex);
            String numberedPlayer = createNumberedPlayer(playerIndex);
            GUESSES_BY_PLAYERS.put(numberedPlayer, playerGuess);
        }
    }

    private static String createNumberedPlayer(int playerIndex) {
        return "Игрок" + playerIndex;
    }

    private static int inputAndValidatePlayersGuesses(int playerIndex) {
        while (true) {
            System.out.printf(AKS_PLAYER_TO_GUESS_MESSAGE, playerIndex);
            String guess = SCANNER.nextLine();
            if (isInputCorrect(guess)) {
                return Integer.parseInt(guess);
            } else {
                System.out.println(WRONG_INPUT_MESSAGE);
            }
        }
    }

    private static int getZeroOrOne() {
        return new Random().nextInt(2);
    }

    private static void printTargetValue(int targetValue) {
        System.out.println();
        System.out.printf(FLIP_COIN_MESSAGE, getCoinSideName(targetValue));
        System.out.println();
    }

    private static void printLosers() {
        System.out.println(LOSE_MESSAGE);
        System.out.println(LOSERS);
    }

    private static void printWinners() {
        System.out.println(WIN_MESSAGE);
        System.out.println(WINNERS);
    }

    private static void fillWinnersAndLosersLists(int targetValue) {
        for (Map.Entry<String, Integer> guessesByPlayers : GUESSES_BY_PLAYERS.entrySet()) {
            String numberedPlayer = guessesByPlayers.getKey();
            int playerGuess = guessesByPlayers.getValue();
            if (isPlayerGuessedCorrectly(playerGuess, targetValue)) {
                WINNERS.add(numberedPlayer);
            } else {
                LOSERS.add(numberedPlayer);
            }
        }
    }

    private static boolean isPlayerGuessedCorrectly(int playerGuess, int targetValue) {
        return playerGuess == targetValue;
    }

    private static void printStartGameMessage() {
        System.out.println(HEADER_STAR_MESSAGE);
        System.out.println(HEADER_GAME_NAME_MESSAGE);
        System.out.println(HEADER_STAR_MESSAGE);
    }

    private static boolean isInputCorrect(String source) {
        if (isNullOrEmpty(source)) {
            return false;
        }
        if (!isOneSymbolLength(source)) {
            return false;
        }
        if (!isDigit(source)) {
            return false;
        }
        return isOneOrZero(source);
    }

    private static boolean isNullOrEmpty(String source) {
        return (source == null || source.trim().isEmpty());
    }

    private static boolean isOneSymbolLength(String source) {
        return source.length() == 1;
    }

    private static boolean isDigit(String source) {
        return Character.isDigit(source.charAt(0));
    }

    private static boolean isOneOrZero(String source) {
        int value = Integer.parseInt(source);
        return value == 0 || value == 1;
    }

    private static String getCoinSideName(int value) {
        return value == EAGLE_VALUE ? EAGLE : TAILS;
    }
}