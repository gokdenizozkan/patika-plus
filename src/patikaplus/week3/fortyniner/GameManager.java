package patikaplus.week3.fortyniner;

import java.util.Arrays;
import java.util.Scanner;

import static patikaplus.week3.fortyniner.Printer.print;
import static patikaplus.week3.fortyniner.Printer.printTitle;
import static patikaplus.week3.fortyniner.Printer.printOptions;



public class GameManager {
    // BUG: DEATHSPOTMAP GENERATOR RANDOMIZER IS BOUND TO CLOCK
    // TODO: NINER => AVOID DEEP WATERS AND SPLINTERS THAT MAKE YOU FALL INTO THE WATER
    // TODO: FORTYNINER => CLASSIC MINESWEEPER (GOLD HUNTER)
    // TODO FEATURE: MARKING DEATHSPOTS: *1-1
    static Scanner sc = new Scanner(System.in);

    static Gamemodes gamemode;
    enum Gamemodes {
        NINER, FORTYNINER, CUSTOM;

        public int[] getRatio() {
            return switch (name()) {
                case "NINER" -> new int[]{9, 9};
                case "FORTYNINER" -> new int[]{40, 9};
                default -> newRatio();
            };
        }

        public String getName() {
            return Printer.getCapitalized(toString());
        }

    }

    public static void launch() {
        printTitle("FORTYNINER");
        print("A text-based game inspired by Mine Sweeper.\n");
        printOptions("Play");

        if (sc.nextInt() == 0) {
            setup();
        }
    }

    private static void setup() {
        printTitle("SETUP");
        print("Please choose your gamemode:\n");
        printOptions(Arrays.stream(Gamemodes.values()).map(Object::toString).toArray(String[]::new)); // Converts Gamemodes[] object to String[]

        switch (sc.nextInt()) {
            case 0 -> gamemode = Gamemodes.NINER;
            case 1 -> gamemode = Gamemodes.FORTYNINER;
            case 2 -> gamemode = Gamemodes.CUSTOM;
        }

        new Board(gamemode.getRatio());

        printTitle("SETUP: Difficulty");
        print("Please enter the difficulty level you desire to play:\n");
        printOptions(Arrays.stream(Board.Difficulties.values()).map(Object::toString).toArray(String[]::new)); // Converts Difficulties[] object to String[]

        switch (sc.nextInt()) {
            case 0 -> Board.setDifficulty(Board.Difficulties.EASY);
            case 1 -> Board.setDifficulty(Board.Difficulties.NORMAL);
            case 2 -> Board.setDifficulty(Board.Difficulties.HARD);
            case 3 -> Board.setDifficulty(Board.Difficulties.EXTREME);
        }

        Board.generateDeathspots();
        Printer.printTutorial();
        print("To continue, please enter any key.");
        sc.next();
        run();
    }

    public static void run() {
        //Printer.printDeathspotMapFramed();
        GameLogic.start();
    }

    private static int[] newRatio() {
        printTitle("SETTINGS: Ratio");
        print("Please enter the number of rows the game board will generate:\n");
        int rows = sc.nextInt();
        print("Please enter the number of columns the game board will generate:\n");
        int columns = sc.nextInt();

        return new int[]{rows, columns};
    }
}
