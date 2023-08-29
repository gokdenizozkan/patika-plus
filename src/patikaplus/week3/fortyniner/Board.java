package patikaplus.week3.fortyniner;

import java.util.Random;

public class Board {
    private static Tile[][] board;
    private static int rowCount;
    private static int columnCount;
    private static int tileCount;
    private static int revealedTileCount;
    private static int deathspotCount;
    private static boolean[][] deathspotMap;

    public enum Difficulties {
        EASY, NORMAL, HARD, EXTREME;
        private static final int BASE_ORDINAL = 5;

        public int getValue() {
            return BASE_ORDINAL - ordinal();
        }

        public String getName() {
            return Printer.getCapitalized(toString());
        }
    }

    private static Difficulties difficulty;


    public Board(int[] ratio, boolean initializeWithDeathspots, Difficulties difficulty) {
        reset();
        Board.rowCount = ratio[0];
        Board.columnCount = ratio[1];
        Board.tileCount = rowCount * columnCount;
        Board.difficulty = difficulty;

        generateBoard(initializeWithDeathspots);
    }

    public Board(int[] ratio, boolean initializeWithDeathspots) {
        new Board(ratio, initializeWithDeathspots, Difficulties.NORMAL);
    }

    public Board(int[] ratio) {
        new Board(ratio, false, Difficulties.NORMAL);
    }

    private static void reset() {
        board = null;
        deathspotMap = null;
    }

    // Management and tracking methods
    public static boolean isBoardCleared() {
        return (tileCount - deathspotCount) == revealedTileCount;
    }

    public static void incrementRevealedTileCount() {
        revealedTileCount++;
    }

    // Generation methods
    public static void generateBoard(boolean initializeWithDeathspots) {
        initializeBoard();
        initializeTiles();

        if (initializeWithDeathspots) {
            generateDeathspotMap();
            placeDeathspots();
        }
    }

    public static void generateDeathspots() {
        generateDeathspotMap();
        placeDeathspots();
    }

    private static void initializeBoard() {
        board = new Tile[rowCount][columnCount];
    }

    private static void initializeTiles() {
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < columnCount; c++) {
                getBoard()[r][c] = new Tile(r, c);
            }
        }
    }

    private static void generateDeathspotMap() {
        boolean[][] deathspotMap = new boolean[rowCount][columnCount];
        int deathspotLimitPerRow = (int) (rowCount * 0.75f);
        int deathspotsInRow, deathspotsPlaced = 0;
        Random dice = new Random();

        calculateDeathspotCount();

        while (deathspotsPlaced < deathspotCount) {
            for (int r = 0; r < deathspotMap.length; r++) {
                for (int c = 0; c < deathspotMap[0].length; c++) {
                    // If all deathspots are placed, break
                    if (deathspotsPlaced == deathspotCount) {
                        break;
                    }

                    // If deathspot limit per row is exceeded, break
                    deathspotsInRow = countDeathspotsInARow(deathspotMap[r]);
                    if (deathspotsInRow >= deathspotLimitPerRow) {
                        break;
                    }

                    // If it is a deathspot, continue
                    if (deathspotMap[r][c]) {
                        continue;
                    }

                    // Roll the dice and see if it is true
                    if (dice.nextBoolean()) {
                        deathspotMap[r][c] = true;
                        deathspotsPlaced++;
                    }
                }
            }
        }
        Board.deathspotMap = deathspotMap;
    }

    private static void calculateDeathspotCount() {
        deathspotCount = tileCount / difficulty.getValue();

        // TODO: Better difficulty
    }

    private static int countDeathspotsInARow(boolean[] row) {
        int deathspots = 0;

        for (boolean c : row) {
            if (c) {
                deathspots++;
            }
        }

        return deathspots;
    }

    private static void placeDeathspots() {
        for (int r = 0; r < rowCount; r++) {
            for (int c = 0; c < columnCount; c++) {
                board[r][c].setDeathspot(
                        deathspotMap[r][c]);
            }
        }
    }

    // Access methods

    public static Tile getTileAt(int row, int column) {
        return board[row][column];
    }

    public static Tile getTileAt(int[] coords) {
        return getTileAt(
                Radar.getCoordRow(coords), Radar.getCoordColumn(coords));
    }

    public static Tile[] getTilesInBulk(int[][] coords) {
        Tile[] tiles = new Tile[coords.length];

        for (int i = 0; i < coords.length; i++) {
            if (!Radar.isOnBoard(coords[i])) {
                continue;
            }
            tiles[i] = getTileAt(coords[i]);
        }

        return tiles;
    }

    // Getters and Setters

    public static Tile[][] getBoard() {
        return board;
    }

    public static int getRowCount() {
        return rowCount;
    }

    public static int getColumnCount() {
        return columnCount;
    }

    public static void setDifficulty(Difficulties difficulty) {
        Board.difficulty = difficulty;
    }

    public static boolean[][] getDeathspotMap() {
        return deathspotMap;
    }
}