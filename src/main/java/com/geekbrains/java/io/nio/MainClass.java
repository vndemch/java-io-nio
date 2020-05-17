package com.geekbrains.java.io.nio;

public class MainClass {
    public static void main(String[] args) {
        AppData appData = new AppData("data.csv");
        appData.printHeader();
        appData.printData();
    }
}
