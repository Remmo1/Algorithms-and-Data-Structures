package com.company.Z4;

import java.io.*;


public class Zadanie4 {

    public String ONP(String path) {
        String[] tokens;
        String line;
        StringBuilder inputStr = null;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while((line = bufferedReader.readLine()) != null) {
                tokens = line.split(" ");
                for (String s:
                        tokens) {
                    inputStr.append(s);
                }

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return inputStr.toString();
    }


}
