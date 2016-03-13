package com.Andromachi.goEuro;

import java.io.IOException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.DeserializationConfig;


/**
 * The requested application receives a name of a city as an arguement.
 *
 */
public class App
{

    public static void main( String[] args )
    {
        String inputCity;
        //There must be exactly one arguement. For cities that have spaces in their names
        //such as "Rio de Janeiro", the spaces are removed
        if (args.length > 0) {
            inputCity = args[0].replaceAll("[\\s]","");
        }
        else throw new IllegalArgumentException("Please provide only one city name enclosed in"+ "\"\""); {
        }
        try {
            //Calling the api
            String output = ApiCaller.parameter(inputCity);
            System.out.println("Server response .... \n");
            System.out.println(output+"\n");

            //mapping to json
            ObjectMapper mapper = new ObjectMapper();
            //In case properties we do not need cannot be deserialized
            mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            Position[] positions = mapper.readValue(output, Position[].class);

            //Writing to csv file
            String filename = inputCity + ".csv";
            CsvWriter.write(positions, filename);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (NullPointerException ex) {
            ex.printStackTrace();
        }
    }
}
