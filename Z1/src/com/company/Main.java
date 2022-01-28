package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    static List<Student> students = new ArrayList<>();

    public static List <Student> Load(String path) {                        // metoda 1

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String wiersz;
            String[] wartosci;

            wiersz = bufferedReader.readLine();
            while( (wiersz = bufferedReader.readLine()) != null ) {
                wartosci = wiersz.split(" ");
                Student s1 = new Student(Integer.parseInt(wartosci[0]), wartosci[1], wartosci[2], Double.parseDouble(wartosci[3]));
                students.add(s1);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void Show() {                                             // metoda 2
        for (Student s :
                students) {
            System.out.println(s);
        }
        System.out.println();
    }

    public static void ChangeMark(String name, String surN, double mark) {      // metoda 3
        Iterator <Student> iterator = students.iterator();

        while(iterator.hasNext()) {
            Student s1 = iterator.next();
            if (s1.getName().equals(name) && s1.getSurN().equals(surN)) {
                s1.setMark(mark);
            }
        }
    }

    public static double AvrFromGoodMarks() {                                   // metoda 4
        double w = 0, size = students.size();
        Iterator <Student> iterator = students.iterator();

        while(iterator.hasNext()) {
            Student s1 = iterator.next();
            if (s1.getMark() < 3)
                size--;
            else
                w += s1.getMark();
        }
        return w/size;
    }

    public static void ShowStudentsWithBadMarks() {                         // metoda 5
        Iterator <Student> iterator = students.iterator();

        while(iterator.hasNext()) {
            Student s1 = iterator.next();
            if (s1.getMark() < 3)
                System.out.println(s1);
        }
    }

    public static void Save(String path) {                                  // metoda 6
        String s = "numer_indeksu imię nazwisko ocena";
        Iterator<Student> iterator = students.iterator();

        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.write(s + "\n");

            while (iterator.hasNext()) {
                Student s1 = iterator.next();
                bufferedWriter.write(s1.toString() + "\n");

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        students = Load("studenci.txt");

        Show();

        ChangeMark("Remigiusz", "Pisarski", 4.5);
        Show();

        System.out.println("średnia z ocen pozytywnych: " + AvrFromGoodMarks());
        System.out.println();

        System.out.println("Studenci którzy nie zdali: ");
        ShowStudentsWithBadMarks();

        Save("studenciPoZmianach.txt");
    }
}
