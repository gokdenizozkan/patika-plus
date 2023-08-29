package patikaplus.week3.fortyniner;

public class Tile {
    private final int row;
    private final int column;
    private boolean deathspot;
    private boolean revealed;
    private char visual;

    Tile(int row, int column) {
        this.row = row;
        this.column = column;
        this.visual = '-';
    }

    public void reveal() {
        updateVisual();
        GameLogic.checkEnd(deathspot);
    }

    public void revealPlainTileChain() {
        // TODO
    }

    private void updateVisual() {
        char c;

        if (deathspot) { c = '*'; }
        else { c = Character.forDigit(getNeighbouringDeathspots(), 10); }

        visual = (c == '0') ? ' ' : c;
    }

    // Getters and Setters

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getNeighbouringDeathspots() {
        return Radar.countNeighbouringDeathspots(this);
    }

    public boolean isDeathspot() {
        return deathspot;
    }

    public void setDeathspot(boolean deathspot) {
        this.deathspot = deathspot;
    }

    public char getVisual() {
        return visual;
    }
}