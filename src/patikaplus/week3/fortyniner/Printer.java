package patikaplus.week3.fortyniner;

public class Printer {
    public static void update() {
        printBoardFramed();
    }

    public static void print(String message) {
        System.out.print(message);
        System.out.flush();
    }

    public static void printOptions(String... options) {
        for (int i = 0; i < options.length; i++) {
            System.out.printf("%d: %s\n", i, options[i]);
        }
        printNewLine();
        System.out.flush();
    }

    public static void printTitle(String title) {
        for (int i = 0; i < (title.length() * 3); i++) {
            System.out.print("#");
        }

        printNewLine();
        printNewLine();
        printSpace((int) (title.length() * 1.5f + 1));
        System.out.print(title.toUpperCase());
        printNewLine();
        printNewLine();

        for (int i = 0; i < (title.length() * 3); i++) {
            System.out.print("#");
        }
        printNewLine();
    }

    public static void printBoardFramed() {
        int row = Board.getRowCount();
        int column = Board.getColumnCount();

        printFrameColumns(column);

        for (int r = 0; r < row; r++) {
            System.out.print(r + 1); // Prints frame of Rows for user
            printSpace();

            for (int c = 0; c < column; c++) {
                printSpace();
                // Additional space to preserve the shape of the board
                System.out.print(Board.getTileAt(r, c).getVisual());
            }
            printNewLine();
        }
    }

    public static void printDeathspotMapFramed() {
        int row = Board.getDeathspotMap().length;
        int column = Board.getDeathspotMap()[0].length;

        printFrameColumns(column);

        for (int r = 0; r < row; r++) {
            System.out.print(r + 1); // Prints frame of Rows for user
            printSpace();

            for (int c = 0; c < column; c++) {
                printSpace();
                // Additional space to preserve the shape of the board
                System.out.print(Board.getDeathspotMap()[r][c]);
            }
            printNewLine();
        }
    }

    public static void printTutorial() {
        printTitle("TUTORIAL");
        print("To open a tile, type its coordinates with a hyphen, like: 2-3\nIf you enter 2-3, it will open the tile at 2nd row and 3rd column.\n");
        printTitle("HAVE FUN!");
    }

    public static String getCapitalized(String text) {
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }

    private static void printFrameColumns(int columnCount) {
        printSpace(2);

        for (int c = 0; c < columnCount; c++) {
            printSpace();
            System.out.print(c + 1);
        }
        printNewLine();
    }

    private static void printNewLine() {
        System.out.println();
    }

    private static void printSpace(int... amount) {
        if (amount.length > 0) {
            amount[0] -= 1;
            if (amount[0] > 0) {
                printSpace(amount[0] - 1);
            }
        }
        System.out.print(" ");
    }
}