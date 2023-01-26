package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;


public class FileUtils {
    private final File wordsFile = new File("C:\\Users\\romni\\JavaProjects\\wordle\\src\\main\\resources\\words.txt");
    private final ArrayList<String> words = new ArrayList<>();
    public FileUtils(){
        downloadFile();
    }
    public String getWord() {
        String word = "";
        int index = (int)(Math.random() * words.size());
        word = words.get(index);
        return word;
    }
    private void downloadFile(){
        try {
            Scanner scanner = new Scanner(wordsFile);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                words.add(line.toLowerCase());
            }
        }
        catch (IOException ignored) {}
    }
}
