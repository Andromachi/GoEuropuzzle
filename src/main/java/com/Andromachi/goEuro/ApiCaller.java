package com.Andromachi.goEuro;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

/**
 * Class implements a simple client. A city name is provided as input.
 * The client requests the information from GoEuro.
 * The output is the server response in json format.
 */
public class ApiCaller {
    //Calling the api
    public static String parameter(String cityName)
    {
        String URL = "http://api.goeuro.com/api/v2/position/suggest/en/" + cityName;
        System.out.println("The url to be called" +" "+ URL);
        ClientConfig clientConfig = new DefaultClientConfig();
        Client client = Client.create(clientConfig);
        WebResource webResource = client
                .resource(URL);
        ClientResponse response = webResource.accept("application/json")
                .type("application/json").get(ClientResponse.class);
        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        String output = response.getEntity(String.class);
        return (output);

    }
}
