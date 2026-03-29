/*
Duy Nguyen
n186@umbc.edu
IS247
3-29-26

Information:
-Reads musician pay data from txt file
-validates each record
-store data into ArrayList
-catch corrupted data
-prints out the valid records
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DataCleanup {
    public static void main(String[] args) {

        ArrayList<Pay> musicians = new ArrayList<Pay>();
        Scanner fileScanner = null;

        //opening the file
        try {
            fileScanner = new Scanner(new File("E:\\downloads\\FileIOmusicianpay.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file 'FileIOmusicianpay.txt' not found. Please check the file path.");
            System.exit(1);
        }

        //file loop
        while (fileScanner.hasNext()) {
            String name = "";
            double hourlyPay = 0.0;
            String instrument = "";

            try {

                name = fileScanner.next();
                String payToken = fileScanner.next();
                instrument = fileScanner.next();


                hourlyPay = Double.parseDouble(payToken);


                musicians.add(new Pay(name, hourlyPay, instrument));

            } catch (NumberFormatException e) {

                System.out.println("Corrupted data detected: '" + name + "' record skipped — " +
                        "hourly pay field is not a valid number.");
            }
        }

        fileScanner.close();


        System.out.println("\n-----Valid Musician Records-----");
        for (Pay p : musicians) {
            System.out.println(p);
        }

        //Writing output file
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("FileIOmusicianpay_corrected.txt"));
            for (Pay p : musicians) {

                writer.println(p.getName() + " " + String.format("%.2f", p.getHourlyPay()) + " " + p.getInstrument());
            }
            writer.close();
            System.out.println("\nCorrected data written to 'FileIOmusicianpay_corrected.txt'.");
        } catch (IOException e) {
            System.out.println("Error writing output file: " + e.getMessage());
        }
    }
}