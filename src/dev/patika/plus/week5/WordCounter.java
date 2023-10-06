package dev.patika.plus.week5;

import java.util.HashMap;

import com.gokdenizozkan.util.Input;

public class WordCounter {
    private static HashMap<String, Integer> wordCounts = new HashMap<>();
    
    public static void main(String[] args) {
        
        //String sentence = "Oh ma darling, oh-my darling, oh-my darling Clementine! You were lost and gone forever, dreadful sorrow Clementine.";
        //System.out.println(sentence);
        //System.out.println(getWordWithHighestFrequency(sentence));
        System.out.println(
                getWordWithHighestFrequency(
                        Input.getLine("Please enter a sentence:")));
    }
    
    public static String getWordWithHighestFrequency(String str) {
        String[] tokens = str.trim().strip().replace(",", "").replace(".", "").replace("!", "").toLowerCase().split(" ");
        
        int highestFreq = 0;
        String highestFreqWord = "";
        for (String t : tokens) {
            // adding
            if (wordCounts.containsKey(t)) {
                wordCounts.put(t, wordCounts.get(t) + 1);
            }
            else {
                wordCounts.put(t, 1);
            }
            
            // freq calc
            int wordFreq = wordCounts.get(t);
            if (wordFreq > highestFreq) {
                highestFreq = wordFreq;
                highestFreqWord = t;
            }
        }
        
        return highestFreqWord;
    }
}