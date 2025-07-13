package com.yogesh.nipte.utils;

public class Demo {
    public static void main(String[] args) {

        Config.initialize();
        System.setProperty("browser","firefox");
        Config.initialize();
        System.out.println(Config.get("amazon.baseurl"));
    }
}
