package com.geekbrains.java.io.nio;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class AppData {

    private String[] header;
    private int[][] data;
    private int cells = 0;
    private int rows = 0;
    private ArrayList<String> helpData = new ArrayList<>();

    public AppData(String fileName) {
        try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
            String str = in.readLine();
            header = str.split(";");
            cells = header.length;
            int i=0;
            while ((str = in.readLine()) != null) {
                helpData.addAll(Arrays.asList(str.split(";")));

                i++;
            }
            rows = i;
            data = new int[cells][rows];
            for (i=0;i<cells*rows;i++) {
                data[i%cells][i/cells] = Integer.parseInt(helpData.get(i));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void printHeader() {
        for (int i=0;i<header.length;i++) {
            System.out.print(header[i]+"  ");
        }
        System.out.println("\n");
    }

    public void printData() {
        for (int j=0;j<rows;j++) {
            for (int i=0;i<cells;i++) {
                System.out.print(data[i][j]+"      ");
            }
            System.out.println("\n");
        }
    }
}
