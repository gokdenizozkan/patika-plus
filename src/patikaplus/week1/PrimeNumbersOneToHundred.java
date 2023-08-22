package patikaplus.week1;

public class PrimeNumbersOneToHundred {
    public static void run() {
        boolean prime;

        for (int i = 2; i < 100; i++) {
            prime = true;
            for (int j = 2; j < 10; j++) {
                if (i % j == 0) {
                    if (i > 10) {
                        prime = false;
                        break;
                    }
                    if (i != j) {
                        prime = false;
                        break;
                    }
                }
            }
            if (prime) System.out.print(i + " ");
        }
    }
}
