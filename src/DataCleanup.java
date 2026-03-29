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


        try {
            fileScanner = new Scanner(new File("E:\\downloads\\FileIOmusicianpay.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error: Input file 'FileIOmusicianpay.txt' not found. Please check the file path.");
            System.exit(1);
        }


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


        System.out.println("\n===== Valid Musician Records =====");
        for (Pay p : musicians) {
            System.out.println(p); // uses overloaded toString()
        }


        try {
            PrintWriter writer = new PrintWriter(new FileWriter("FileIOmusicianpay_corrected.txt"));
            for (Pay p : musicians) {

                writer.println(p.getName() + " " + p.getHourlyPay() + " " + p.getInstrument());
            }
            writer.close();
            System.out.println("\nCorrected data written to 'FileIOmusicianpay_corrected.txt'.");
        } catch (IOException e) {
            System.out.println("Error writing output file: " + e.getMessage());
        }
    }
}