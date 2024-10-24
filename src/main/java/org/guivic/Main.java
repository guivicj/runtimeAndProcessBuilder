package org.guivic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        runtimeTest();
        System.out.println("---");
        processBuilderTest();
    }

    private static void runtimeTest() {
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("cmd /c dir");
            BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }
            bf.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void processBuilderTest() {
        try {
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir");
            Process process = pb.start();
            BufferedReader bf = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}