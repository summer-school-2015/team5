package com.team5.count;

import java.io.*;

class StringsCount {
    static int strCounter = 0;
    static int chrCounter = 0;
    static int wrdCounter = 0;

    public static void main(String[] args) {
        if (args[0].contains("if=")) {
            String fileName = args[0].substring(3);
            readFile(fileName);
        } else {
            readConsole();
            if (args[0].contains("of=")) {
                String fileName = args[0].substring(3);
                writeFile(fileName);
            }
        }
        if (args.length > 1) {
            if (args[1].contains("of=")) {
                String fileName = args[1].substring(3);
                writeFile(fileName);
            }
        } else {
            writeConsole();
        }
    }

    private static void readFile(String fileName) {
        String line = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null) {
                strCounter++;
                chrCounter = chrCounter + line.length();
                String[] words = line.split(" +");
                wrdCounter = wrdCounter + words.length;
            }
            System.out.println("Count of strings: " + strCounter);
            System.out.println("Count of words: " + wrdCounter);
            System.out.println("Count of chars: " + chrCounter);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    private static void writeFile(String fileName) {
        String line = null;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Count of strings:" + strCounter);
            writer.newLine();
            writer.write("Count of words:" + wrdCounter);
            writer.newLine();
            writer.write("Count of chars:" + chrCounter);
            writer.newLine();
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    private static void readConsole() {
        String line = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (!((line = reader.readLine()).equals(""))) {
                strCounter++;
                chrCounter = chrCounter + line.length();
                String[] words = line.split(" +");
                wrdCounter = wrdCounter + words.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        chrCounter = chrCounter + line.length();
        String[] words = line.split(" +");
        wrdCounter = wrdCounter + words.length;
    }

    private static void writeConsole() {
        System.out.println("Count of strings: " + strCounter);
        System.out.println("Count of words: " + wrdCounter);
        System.out.println("Count of chars: " + chrCounter);
    }
}
