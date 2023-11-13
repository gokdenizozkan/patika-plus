package dev.patika.plus.java.week6;

import java.io.*;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Randomali {
    // TODO:
    //  ogrencilistesi.txt dosyasını oku
    //  içindeki tüm verileri kaydet
    //  rastgele bir kişi seç
    //  => "kişi cevap verdi mi" true false
    //          cevap verdi ise "cevapverenler.txt"ye yaz
    //  rastgele bir kişi seç
    //  daha önce seçilmişse başkasına seçecek
    private static HashMap<Integer, String> list;
    private static HashMap<Integer, String> shortlisted;

    public static void main(String[] args) {
        init();
        loop();
    }

    private static void loop() {
        while(true) {
            int id = getRandomId();

            if (isShortlistedBefore(id)) {
                continue;
            }

            printNameById(id);
            if (confirm()) {
                writeList(id);
            }
        }
    }

    private static void init() {
        list = read("src/dev/patika/plus/week6/ogrencilistesi.txt");
        shortlisted = read("src/dev/patika/plus/week6/cikanlarlistesi.txt");
    }

    private static void writeList(int id) {
        File fileOfList = new File("src/dev/patika/plus/week6/cikanlarlistesi.txt");

        try {
            FileWriter fileWriter = new FileWriter(fileOfList, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String idString = String.valueOf(id);
            String name = list.get(id);

            bufferedWriter.write(idString + "\n" + name + "\n");
            bufferedWriter.flush();

            shortlisted.put(id, name);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean isShortlistedBefore(int id) {
        return shortlisted.get(id) != null;
    }

    private static boolean confirm() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Did the selected person answer?\n1 - Yes\t2 - No");
        return sc.nextInt() == 1;
    }

    private static void printNameById(int id) {
        String name = list.get(id);
        System.out.println(name);
    }

    private static int getRandomId() {
        Random dice = new Random();
        return dice.nextInt(1, list.size() + 1);
    }

    private static HashMap<Integer, String> read(String path) {
        HashMap<Integer, String> list = new HashMap<>();

        File fileOfList = new File(path);

        try {
            FileReader fileReader = new FileReader(fileOfList);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = bufferedReader.readLine();
            while (line != null) {
                int id = Integer.parseInt(line);
                String name = bufferedReader.readLine(); // line = "1";

                list.put(id, name); // 1, isim

                // while için
                line = bufferedReader.readLine(); // line = "2"
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}
