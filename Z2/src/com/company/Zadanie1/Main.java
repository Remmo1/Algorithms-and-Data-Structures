package com.company.Zadanie1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Main {

    public static final int amountOfStudents = 5;
    public static final Student[] students = new Student[amountOfStudents];

    public static void Load(String path) {
        String line;
        String[] tokens;
        int i = 0;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            line = bufferedReader.readLine(); // pominięcie wiersza tytułowego
            while ( (line = bufferedReader.readLine()) != null ) {
                tokens = line.split(";");
                Student st = new Student(Integer.parseInt(tokens[0]), tokens[1], tokens[2], Float.parseFloat(tokens[3]));
                students[i] = st;
                i++;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static <T> void Show(Iterator<T> iterator) {                                     // 1
        while(iterator.hasNext()) {
            Student st = (Student) iterator.next();
            if (st != null)
                System.out.println(st.toString());
        }
    }

    public static <T> void ChangeMark(Iterator<T> iterator, int nr, float mark) {           // 2
        while(iterator.hasNext()) {
            Student st = (Student) iterator.next();
            if (st != null && st.getNrI() == nr)
                st.setMark(mark);
        }
    }

    public static <T> float ShowAVR(Iterator<T> iterator) {                                  // 3
        float w = 0;
        int size = 0;

        while(iterator.hasNext()) {
            Student st = (Student) iterator.next();
            if (st != null) {
                w += st.getMark();
                size++;
            }

        }
        return (w/size);
    }

    public static <T> Student[] Copy(Iterator <T> iterator, int size) {
        Student[] students1 = new Student[size];
        int i = 0;

        while(iterator.hasNext()) {
            Student s1 = (Student) iterator.next();
            if (s1 != null) {
                students1[i] = s1;
                i++;
            }

        }
        return students1;
    }

    public static void main(String[] args) {

        System.out.println("============1==============");
        Load("C:\\Users\\remig\\OneDrive - Politechnika Wroclawska\\Semestr2\\LaboUBiele\\Z2\\studenci.txt");
        Show(new IteratorA<>(students));
        System.out.println();

        System.out.println("============2==============");
        ChangeMark(new IteratorA<>(students), 5, 3.0f);
        Show(new IteratorA<>(students));
        System.out.println();

        System.out.println("============3==============");
        System.out.println(ShowAVR(new FilterIterator<>(
                new IteratorA<>(students),
                student -> student.getMark()>=3
        )));
        System.out.println();

        System.out.println("============4==============");
        Show(new FilterIterator<>(
                new IteratorA<>(students),
                student -> student.getMark()<3
                ));
        System.out.println();

        System.out.println("============5==============");
        Student[] goodStudents = Copy(new FilterIterator<>(
                new IteratorA<>(students),
                student -> student.getMark() >= 3
                ), 4);
        Show(new IteratorA<>(goodStudents));
        System.out.println();

        Student[] badStudents = Copy(new FilterIterator<>(
                new IteratorA<>(students),
                student -> student.getMark() < 3
        ), 1);
        Show(new IteratorA<>(badStudents));
        System.out.println();

    }
}
