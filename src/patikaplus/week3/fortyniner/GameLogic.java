package patikaplus.week3.fortyniner;

import java.util.Scanner;

public class GameLogic {
    // TODO FEATURE: FIRST TILE OPENING IS DEATHSPOT-FREE

    static Scanner sc = new Scanner(System.in);

    public static void getInput() {
        String input = sc.nextLine();
        parseInput(input);
    }

    private static void parseInput(String input) {
        if (input.length() > 1) {
            String[] coordsInStr = input.split("-");
            int[] coordsInInt = new int[coordsInStr.length];

            for (int i = 0; i < coordsInStr.length; i++) {
                coordsInInt[i] = Integer.parseInt(coordsInStr[i]) - 1;
            }

            openTileAt(coordsInInt);
        }

        // TODO: OTHER POSSIBILITIES
    }

    public static void openTileAt(int[] coords) {
        Tile tile = Board.getTileAt(
                Radar.getCoordRow(coords),
                Radar.getCoordColumn(coords));

        tile.reveal();
    }

    public static void checkEnd(boolean gameOver) {
        if (gameOver) { end(false); }
        else if (Board.isBoardCleared()) { end(true); }
        else { proceed(); }
    }

    private static void proceed() {
        Board.incrementRevealedTileCount();
        Printer.update();
        getInput();
    }

    public static void start() {
        Printer.update();
        getInput();
    }

    private static void end(boolean won ) {
        Printer.update();

        String message;
        if (won) { message = "Board cleared, you win."; }
        else { message = "Could not see the end."; }

        System.out.println(message);
    }
}