import dialog.Dialog;
import dialog.IntegerSelectDialog;
import models.BetPool;
import models.Coin;
import models.GameResultAnalizator;
import models.players.Bot;
import models.players.Player;

import java.util.List;

import static models.Coin.Side.HEADS;
import static models.Coin.Side.TAILS;

public class Game {

    private final List<Player> players;

    private final Coin coin;

    private final BetPool betPool = new BetPool();//паттерн создатель - создаёт класс тот класс, который этот класс использует.// Мы будем использовать именно этот класс, мы создаём его тут. Остальное через конструктор

    public Game(List<Player> players, Coin coin) {
        this.players = players;
        this.coin = coin;
    }

    //должна быть передача хода от первого до последнего игрока(делать через такой же диалог, как в Main)
    //Игроки должны ставить ставки
    public void start() {
        for (Player player : players) {
            Coin.Side playerBetSide;
            if (player instanceof Bot bot){
                playerBetSide = inputBetFromBot(bot);
            } else {
                playerBetSide = inputBetFromRealPlayer(player);
            }
            betPool.put(player, playerBetSide);
        }
        Coin.Side winSide = coin.flip();
        String winSideName = toSideName(winSide);
        System.out.println("""
                Бросаем монетку
                Выпала сторона: %s
                """.formatted(winSideName));
        GameResultAnalizator gameResultAnalizator = new GameResultAnalizator(betPool, players, winSide);
        List<Player> winners = gameResultAnalizator.getWinners();
        List<Player> losers = gameResultAnalizator.getLosers();
        printGameResult(winners, losers);
    }

    private Coin.Side inputBetFromRealPlayer(Player player) {
        Coin.Side playerBetSide;
        String title = "%s, введите ваш ход (0 - орел, 1 - решка): ".formatted(player.getName());
        String error = "Ошибка ввода";
        List<Integer> keys = List.of(0, 1);//неизменяемый список

        Dialog<Integer> dialog = new IntegerSelectDialog(
                title
                , error
                , keys
        );
        var sideKey = dialog.input();
        playerBetSide = toSide(sideKey);
        return playerBetSide;
    }

    private Coin.Side inputBetFromBot(Bot player) {
        Coin.Side playerBetSide;
        String title = "%s, введите ваш ход (0 - орел, 1 - решка): ".formatted(player.getName());
        System.out.print(title);
        playerBetSide = player.getBet();
        int sideKey = toSideKey(playerBetSide);
        System.out.println(sideKey);
        return playerBetSide;
    }

    private static int toSideKey(Coin.Side side){
        return switch (side){
            case HEADS -> 0;
            case TAILS -> 1;
        };
    }

    private static Coin.Side toSide(int key) {
        return switch (key) {
            case 0 -> HEADS;
            case 1 -> TAILS;
            default -> throw new IllegalStateException("Illegal value: " + key);
        };
    }

    private static String toSideName(Coin.Side side) {
        return switch (side){
            case HEADS -> "ОРЕЛ";
            case TAILS -> "РЕШКА";
            default -> throw new IllegalStateException("Illegal value: " + side);
        };
    }

    private static void printGameResult(List<Player> winners, List<Player> losers){
        if (winners.isEmpty()){
            System.out.println("Все игроки проиграли!");
        } else if (losers.isEmpty()){
            System.out.println("Все игроки выиграли!");
        } else {
            System.out.println("Выиграли: ");
            printList(winners);
            System.out.println("Проиграли: ");
            printList(losers);
        }
    }

    private static void printList(List<Player> players){
        for (int i = 0; i < players.size(); i++) {
            System.out.print(players.get(i).getName());
            if (i != players.size() - 1){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

}