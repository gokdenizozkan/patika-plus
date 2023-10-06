package patikaplus.week6;

import com.gokdenizozkan.util.Input;
import com.gokdenizozkan.util.Print;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Consolepad {
    public static void main(String[] args) {
        Print.line("- CONSOLEPAD -\n");

        switch (Input.ask("Choose action:", new String[]{"write", "read"})) {
            case "write" -> {
                Print.line("To exit the write mode, type and enter -1\n");
                write();
            }
            case "read" -> read();
        }
    }

    private static void read() {
        FileReader inFile = null;
        try {
            inFile = new FileReader("src/patikaplus/week6/pages.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        BufferedReader bufferedReader = new BufferedReader(inFile);
        try {
            for (String st = bufferedReader.readLine(); st != null; st = bufferedReader.readLine()) {
                Print.nline(st);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void write() {
        // WRITE
        FileWriter outFile = null;
        try {
            outFile = new FileWriter("src/patikaplus/week6/pages.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String in;
        while (true) {
            in = Input.getLineEmptySafe();
            if (in.equals("-1")) break;
            try {
                outFile.write(in + "\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        try {
            outFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
