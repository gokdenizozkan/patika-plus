package patikaplus.week3.fortyniner;

public class Radar {
    static int[][] directions = { // No dictionary required, for Radar only cares about deathspot counts, not where the deathspot is.
            { 1, 0 },   // North
            { -1, 0 },  // South
            { 0, 1 },   // East
            { 0, -1 },  // West
            { 1, 1 },   // Northeast
            { 1, -1 },  // Northwest
            { -1, 1 },  // Southeast
            { -1, -1 }  // Southwest
    };

    // Counts deathspots surrounding the tile at the given coordinates (origin).
    public static int countNeighbouringDeathspots(Tile origin) {
        Tile[] neighbourTiles = getNeighbourTiles(origin);
        int deathspotCount = 0;

        for (Tile tile : neighbourTiles) {
            if (tile == null) { continue; } // Null check
            if (tile.isDeathspot()) { deathspotCount++; }
        }

        return deathspotCount;
    }

    private static Tile[] getNeighbourTiles(Tile origin) {
        int[][] neighbourCoordinates = new int[8][2];

        for (int i = 0; i < 8; i++) {
            neighbourCoordinates[i] = new int[]{
                    origin.getRow() + getCoordRow(directions[i]),
                    origin.getColumn() + getCoordColumn(directions[i])};
        }

        return Board.getTilesInBulk(neighbourCoordinates);
    }

    // Checks if the given coords located on the board.
    public static boolean isOnBoard(int coordRow, int coordColumn) {
        return coordRow >= 0 && coordRow < Board.getRowCount() && coordColumn >= 0 && coordColumn < Board.getColumnCount();
    }

    public static boolean isOnBoard(int[] coords) {
        return isOnBoard(
                getCoordRow(coords), getCoordColumn(coords));
    }

    // Returns coordinates in an array of integers.
    public static int[] toCoordinates(int coordRow, int coordColumn) {
        return new int[]{ coordRow, coordColumn };
    }

    // Retrieves row or column coordinates from an array of integers holding coordinates of ONE tile.
    public static int getCoordRow(int[] array) {
        return array[0];
    }

    public static int getCoordColumn(int[] array) {
        return array[1];
    }
}
