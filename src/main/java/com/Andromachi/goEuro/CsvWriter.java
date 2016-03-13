package com.Andromachi.goEuro;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Class implements method that takes as input an Array of Positions
 * and the name of the desired city as filename. The output is the
 * requested csv file with fields "_id,name,type,longitude,latitude" of Position instances
 */
public class CsvWriter {
    //Define delimiters to achieve csv format and the csv header
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "_id,name,type,longitude,latitude";

    public static void write(Position[] positions, String filename) throws IOException {
        //Create csv
        FileWriter fileWriter = null;
        fileWriter = new FileWriter(filename);
        try {
            //Write the header of to the csv file
            fileWriter.append(FILE_HEADER.toString());
            fileWriter.append(NEW_LINE_SEPARATOR);
            //Write the data to the csv file
            for (Position position : positions) {
                fileWriter.append(String.valueOf(position.getId()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(position.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(position.getType());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(position.getGeoPosition().getLongitude().toString());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(position.getGeoPosition().getLatitude().toString());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println(filename+" " + "creation successful");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter");
                e.printStackTrace();
            }
        }
    }
}