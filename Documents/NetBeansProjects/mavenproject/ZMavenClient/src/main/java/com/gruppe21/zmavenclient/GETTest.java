/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.gruppe21.zmavenclient;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
/**
 *
 * @author Martin
 */
public class GETTest {
    public static void main(String[] args) {
        while(true){
            try {
                
                Client client = Client.create();
                
                WebResource webResource = client
                        .resource("http://localhost:8080/zoomoutgame/webapi/generic");
                
                ClientResponse response = webResource.accept("application/json")
                .get(ClientResponse.class);
                
         //       ClientResponse response = webResource.accept("text/plain")
           //             .get(ClientResponse.class);
                
                if (response.getStatus() != 200) {
                    throw new RuntimeException("Failed : HTTP error code : "
                            + response.getStatus());
                }
                
                String output = response.getEntity(String.class);
                
                System.out.println("Output from Server .... \n");
                System.out.println(output);
                
            } catch (Exception e) {
                
                e.printStackTrace();
                
            }
        }
    }
}
