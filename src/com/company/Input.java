package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Input {
    public static String getInput(String value)
    {
        BufferedReader buffer = new BufferedReader(new InputStreamReader((System.in)));
        System.out.println(value);
        System.out.flush();
        try {
            return buffer.readLine();

        }catch (Exception e)
        {
            return "Error";
        }
    }
    public static String getString(String value) throws NumberFormatException{
        String in = getInput(value);
        return in;
    }
}
