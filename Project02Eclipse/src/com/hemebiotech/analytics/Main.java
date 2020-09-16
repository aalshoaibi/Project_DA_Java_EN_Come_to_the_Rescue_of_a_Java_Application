package com.hemebiotech.analytics;

import java.util.List;


public class Main {
    public static void main(String[] args){

        AnalyticsCounter count = new AnalyticsCounter();
        List<String> read = count.readfile("symptoms.txt");
        count.symptomsFromReader(read);
        String result = "result.out";
        count.write(result);
        System.out.println("Analysis is done!\n Check result file.");


    }
}