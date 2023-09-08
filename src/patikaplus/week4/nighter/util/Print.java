package patikaplus.week4.nighter.util;

public class Print {
    // Bundled methods
    public static void question(String question, String... options) {
        textln(question);
        options(options);
    }

    // Plain methods
    public static void title(String text) {
        //
    }

    public static void titleWithSubtitle(String title, String subtitle) {
        //
    }

    public static void text(String text) {
        System.out.print(text);
    }

    public static void textln(String text) {
        System.out.println(text);
    }

    public static void options(String... options) {
        //
    }

    // Misc
    private static void ln(int... amount) {
        if (amount.length > 0) {
            amount[0] -= 1;
            if (amount[0] > 0) {
                ln(amount[0] - 1);
            }
        }
        System.out.println();
    }

    private static void space(int... amount) {
        if (amount.length > 0) {
            amount[0] -= 1;
            if (amount[0] > 0) {
                space(amount[0] - 1);
            }
        }
        System.out.print(" ");
    }

    // Game-specific

    public static class Nighter {
        public static class Ui {
            public static void combat() {
                //
            }

            public static void trade() {
                //
            }

            public static void safehouse() {
                //
            }

            public static void wander() {

            }
        }
    }


}
