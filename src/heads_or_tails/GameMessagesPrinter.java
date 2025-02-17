package heads_or_tails;

import java.util.List;

import static heads_or_tails.GameMessages.*;

public class GameMessagesPrinter {
    void printStartGameMessage() {
        System.out.println(HEADER_STAR_MESSAGE);
        System.out.println(HEADER_GAME_NAME_MESSAGE);
        System.out.println(HEADER_STAR_MESSAGE);
    }

    void printTargetValue(String coinSideName) {
        System.out.println();
        System.out.printf(FLIP_COIN_MESSAGE, coinSideName);
        System.out.println();
    }

    void printWinners(List<String> winners) {
        System.out.println(WIN_MESSAGE);
        System.out.println(winners);
    }

    void printLosers(List<String> losers) {
        System.out.println(LOSE_MESSAGE);
        System.out.println(losers);
    }

    void printEnterNumberOfPlayers() {
        System.out.print(NUMBER_OF_PLAYERS_MESSAGE);
    }
}