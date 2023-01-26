package org.example;

public class Main {
    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.createScreen();
        FileUtils fileUtils = new FileUtils();
        System.out.println(fileUtils.getWord());
    }
}