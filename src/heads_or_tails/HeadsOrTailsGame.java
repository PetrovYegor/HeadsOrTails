package heads_or_tails;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HeadsOrTailsGame {
    int numberOfPlayers = 0;
    private final List<Player> players = new ArrayList<>();
    private final List<String> winners = new ArrayList<>();
    private final List<String> losers = new ArrayList<>();
    private final GameMessagesPrinter printer = new GameMessagesPrinter();
    private final Scanner scanner = new Scanner(System.in);
    private final PlayerInputValidator validator = new PlayerInputValidator();
    private final PlayerGuessReader reader = new PlayerGuessReader(scanner, validator);
    private final Coin coin = new Coin();

    void startGameRound() {
        printer.printStartGameMessage();
        printer.printEnterNumberOfPlayers();
        numberOfPlayers = reader.inputNumberOfPlayers();
        processPlayersGuesses(numberOfPlayers, reader, players);
        CoinSide targetSide = coin.flipCoin();
        printer.printTargetValue(targetSide.getSideName());
        fillWinnersAndLosersLists(targetSide.getSideValue(), players, winners, losers);
        printer.printWinners(winners);
        System.out.println();
        printer.printLosers(losers);
        scanner.close();
    }

    private static void processPlayersGuesses(int numberOfPlayers, PlayerGuessReader reader, List<Player> players) {
        for (int playerIndex = 1; playerIndex <= numberOfPlayers; playerIndex++) {
            int playerGuess = reader.inputAndValidatePlayersGuesses(playerIndex);
            String numberedPlayer = createNumberedPlayer(playerIndex);
            players.add(new Player(numberedPlayer, playerGuess));
        }
    }

    private static String createNumberedPlayer(int playerIndex) {
        return "Игрок" + playerIndex;
    }

    private static void fillWinnersAndLosersLists(int targetValue, List<Player> players, List<String> winners, List<String> losers) {
        for (Player player : players) {
            String numberedPlayer = player.getName();
            int playerGuess = player.getGuess();
            if (isPlayerGuessedCorrectly(playerGuess, targetValue)) {
                winners.add(numberedPlayer);
            } else {
                losers.add(numberedPlayer);
            }
        }
    }

    private static boolean isPlayerGuessedCorrectly(int playerGuess, int targetValue) {
        return playerGuess == targetValue;
    }
}
