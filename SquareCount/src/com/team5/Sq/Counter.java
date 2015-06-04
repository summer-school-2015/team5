package com.team5.Sq;

import java.io.*;

/**
 * Created by User on 04/06/2015.
 */
public class Counter {
    static Fig[] fig;
    static int n = 0;

    public static void main(String[] args) {
        go(args[0]);
    }

    private static void go(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            n = Integer.parseInt(reader.readLine());
            fig = new Fig[n];
            String line;
            for (int i = 0; i < n; i++) {
                line = reader.readLine();
                if(line.contains("CIRCLE")){
                    fig[i]=new Circle(Double.parseDouble(line.substring(7)),"CIRCLE");
                }
                if(line.contains("TRIANGLE")){
                    line = line.substring(9);
                    String[] words = line.split(" +");
                    fig[i]=new Triangle(Double.parseDouble(words[0]),Double.parseDouble(words[1]),"TRIANGLE");
                }
                if(line.contains("RECT")){
                    line = line.substring(5);
                    String[] words = line.split(" +");
                    fig[i]=new Rectangle(Double.parseDouble(words[0]),Double.parseDouble(words[1]),"RECT");
                }
            }
            int i=0;
            while(i<n-1){
                if(fig[i].square()>fig[i+1].square()){
                    Fig f =fig[i+1];
                    fig[i+1]=fig[i];
                    fig[i]=f;
                    i=0;
                }
                i++;
            }
        } catch (Exception x) {
            System.err.format("Exception: %s%n", x);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (int k = 0; k < n; k++) {
                writer.write(k+1 + ") " +  fig[k].name+ " "+ fig[k].square());
                writer.newLine();
            }
        } catch (Exception x) {
            System.err.format("Exception: %s%n", x);
        }
    }
}
