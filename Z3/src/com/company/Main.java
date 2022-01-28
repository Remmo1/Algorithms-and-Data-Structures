package com.company;

import com.company.Z1.IQueue;
import com.company.Z2.EmptyStackException;
import com.company.Z4.MyAnalyzer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static String Load(String path) {
        String line = null;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
                line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return line;
    }

    public static void main(String[] args) {

        String input = Load("C:\\Users\\remig\\OneDrive - Politechnika Wroclawska\\Semestr2\\LaboUBiele\\Z3\\dane.txt");
        System.out.println("Postać infiksowa: " + input);

        MyAnalyzer myAnalyzer = new MyAnalyzer();
        IQueue<Object> queue = myAnalyzer.analize(input);
        String show = myAnalyzer.toRPNString(queue);

        System.out.println("Postać postfiksowa: " + show);

        try {
            System.out.println("Wynik: " + myAnalyzer.result(show));
        } catch (EmptyStackException e) {
            e.printStackTrace();
        }
    }
}
