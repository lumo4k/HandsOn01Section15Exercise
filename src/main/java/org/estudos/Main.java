package org.estudos;


import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String filePath = sc.nextLine();
        String pathCSV = "./Items.csv";

        File path = new File(filePath);

        if (!path.exists()) {
            System.out.println("Error: File not found at " + path.getAbsolutePath());
            return;
        }

        try (
                BufferedWriter bw = new BufferedWriter(new FileWriter(pathCSV));
                BufferedReader br = new BufferedReader(new FileReader(path))
        ) {
            String x = br.readLine();

            while (x != null) {
                String[] splitted = x.split(",");

                bw.write(splitted[0] + ";" + (Double.parseDouble(splitted[1]) * Integer.parseInt(splitted[2])));

                bw.newLine();
                x = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}