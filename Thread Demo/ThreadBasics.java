import java.io.*;
import java.util.*;

class LogicOperations {
    // Method to count total number of words
    static int count(ArrayList<String> words) {
        return words.size();
    }

    // Method to find the longest word
    static String longest(ArrayList<String> words) {
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }

    // Method to calculate average word length
    static double average(ArrayList<String> words) {
        int sum = 0;
        for (String word : words) {
            sum += word.length();
        }
        return (double) sum / words.size();
    }
}

class FileOperations {
    // Method to read file and return list of words
    public static ArrayList<String> readFile() throws IOException {
        ArrayList<String> words = new ArrayList<>();
        File file = new File("sample.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, " ");
                while (st.hasMoreTokens()) {
                    words.add(st.nextToken());
                }
            }
        }

        return words;
    }
}

class CountWords implements Runnable {
    public void run() {
        try {
            ArrayList<String> words = FileOperations.readFile();
            int wordCount = LogicOperations.count(words);
            System.out.println("Total Word Count = " + wordCount);
        } catch (IOException e) {
            System.out.println("Error reading file in CountWords: " + e.getMessage());
        }
    }
}

class LongestWords implements Runnable {
    public void run() {
        try {
            ArrayList<String> words = FileOperations.readFile();
            String longestWord = LogicOperations.longest(words);
            System.out.println("Longest Word = " + longestWord);
        } catch (IOException e) {
            System.out.println("Error reading file in LongestWords: " + e.getMessage());
        }
    }
}

class Average implements Runnable {
    public void run() {
        try {
            ArrayList<String> words = FileOperations.readFile();
            double averageLength = LogicOperations.average(words);
            System.out.printf("Average Word Length = %.2f%n", averageLength);
        } catch (IOException e) {
            System.out.println("Error reading file in Average: " + e.getMessage());
        }
    }
}

public class ThreadBasics {
    public static void main(String[] args) {
        CountWords countWords = new CountWords();
        LongestWords longestWords = new LongestWords();
        Average average = new Average();

        Thread t1 = new Thread(countWords);
        Thread t2 = new Thread(longestWords);
        Thread t3 = new Thread(average);

        t1.start();
        t2.start();
        t3.start();
    }
}
