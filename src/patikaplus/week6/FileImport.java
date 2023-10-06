package patikaplus.week6;

import java.io.*;

public class FileImport {
    File file;
    BufferedReader bufferedReader;

    public FileImport() throws FileNotFoundException {
        file = new File("src/patikaplus/week6/nums.txt");
        bufferedReader = new BufferedReader(new FileReader(file));
    }

    private void run() throws IOException {
        int sum = 0;
        for (String st = bufferedReader.readLine(); st != null; st = bufferedReader.readLine()) {
            sum += Integer.parseInt(st);
        }
        System.out.println(sum);
    }
    public static void main(String[] args) throws IOException {
        new FileImport().run();
    }
}
