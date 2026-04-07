package chapter14;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import json.*;

public class Lab3 {
    public static void main(String[] args) throws Exception {
        String outputFile = args.length > 0 ? args[0] : "chapter14/results.txt";

        ArrayList<BikeDataRecord> records = new ArrayList<>();
        ArrayList<BikeDataRecord> records1 = BikeDataReader.parse("json/day1.json");
        ArrayList<BikeDataRecord> records2 = BikeDataReader.parse("json/day2.json");
        ArrayList<BikeDataRecord> records3 = BikeDataReader.parse("json/day3.json");
        ArrayList<BikeDataRecord> records4 = BikeDataReader.parse("json/day4.json");
        records.addAll(records1);
        records.addAll(records2);
        records.addAll(records3);
        records.addAll(records4);

        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            writer.println("Total records loaded: " + records.size());

            // Question 1: top 10 highest altitude points using quick sort
            BikeDataRecord.sortCriteria = 4; // altitude
            Sorting.quickSort(records);
            writer.println();
            writer.println("Question 1: Top 10 highest altitude points");
            for (int i = records.size() - 1; i >= 0 && i >= records.size() - 10; i--) {
                writer.println(records.get(i));
            }

            // Question 2: sort by power and search for a random power value
            if (records.isEmpty()) {
                writer.println("No records available for power search.");
            } else {
                BikeDataRecord.sortCriteria = 7; // power
                Sorting.quickSort(records);

                Random random = new Random();
                int targetPower = records.get(random.nextInt(records.size())).getPow();
                ArrayList<BikeDataRecord> powerMatches = Searching.binarySearch(records, targetPower, 7);

                writer.println();
                writer.println("Question 2: Search for power = " + targetPower);
                writer.println("Found " + powerMatches.size() + " record(s) with power " + targetPower + ".");
                for (int i = 0; i < powerMatches.size(); i++) {
                    writer.println(powerMatches.get(i));
                }
            }
        }

        System.out.println("Results written to " + outputFile);
    }

    private static int getFieldValue(BikeDataRecord record, int fieldIndex) {
        switch (fieldIndex) {
            case 2:
                return record.getHeartrate();
            case 7:
                return record.getPow();
            case 8:
                return record.getCad();
            default:
                return 0;
        }
    }

    private static int countDuplicates(ArrayList<BikeDataRecord> records, int index, int fieldIndex) {
        int value = getFieldValue(records.get(index), fieldIndex);
        int count = 1;
        int i = index - 1;
        while (i >= 0 && getFieldValue(records.get(i), fieldIndex) == value) {
            count++;
            i--;
        }
        i = index + 1;
        while (i < records.size() && getFieldValue(records.get(i), fieldIndex) == value) {
            count++;
            i++;
        }
        return count;
    }
}
