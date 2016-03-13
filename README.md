# GoEuroPuzzle
GoEuroPuzzle Application

This application solves the GoEuro puzzle. It queries the GoEuro Location JSON API and writes the returned results into a csv file.
## Application structure
The classes GeoPosition and Position were created using http://www.jsonschema2pojo.org/, that can generate Plain Old Java Objects from JSON-Schema.
They are used to model the json data that the API returns to java objects.

The ApiCaller class uses Jersey to implement a simple client that is used to fetch the data from the Location API.

The App class implements the application. 
It receives a city name as input from the user and calls ApiCaller to fetch the data for that city.

Jackson is used to consume the data and map the json objects to the desired java objects.

CsvWriter is a class that is called to write the data to a csv file. If the file already exists it is overwriten

The following technologies were used:
- java 8
- maven 3
- Apache commons-lang 2.2
- Jackson 2.7 for deserializing the json response
- Jersey 1.9 for creating a client that requests the data from the Location JSON API


**The jar file can be found under releases**

As requested the application can be run from the command line: java -jar GoEuroTest.jar "CITY_NAME"
