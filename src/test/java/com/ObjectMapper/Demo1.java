package com.ObjectMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * ObjectMapper is a class in jackson API. So need to add Jackson databind dependency.
 * With the help of createObjectNode() we can create a map object and it returns ObjectNode(Map Objects).
 *
 * If we want to handle array of request/response then we need to use createArrayNode() instead of createObjectNode()
 * . It returns ArrayNode(List<Map>)
 *
 * If you want to print created Java Object as String then writeValueAsString which comes from ObjectMapper class
 */
public class Demo1 {
    public static void main(String[] args) throws JsonProcessingException , IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode bookingDetails = objectMapper.createObjectNode();

        bookingDetails.put("firstName", "Rajashekar");
        bookingDetails.put("lastName", "Pillalamarri");
        bookingDetails.put("totalPrice", 1000);
        bookingDetails.put("bookingTable", 23);
        bookingDetails.put("depositPaid", true);
        bookingDetails.put("additionalDetails", "BreakFast");

        ObjectNode bookingDataDetails = objectMapper.createObjectNode();
        bookingDataDetails.put("checkIn", "2022-01-03");
        bookingDataDetails.put("checkOut", "2022-01-04");

        bookingDetails.set("bookingDates",bookingDataDetails);

        // forming NestedJson Object
        String request = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookingDetails);
        System.out.println("Request forming using objectMapper :" + request);

        // To get fieldValues
        String firstName= bookingDetails.get("firstName").asText();
        boolean depositPaid=bookingDetails.get("depositPaid").asBoolean();
        int bookingTable=bookingDetails.get("bookingTable").asInt();
        String checkInDate= bookingDetails.get("bookingDates").get("checkIn").asText();

        System.out.println("firstName is :"+ firstName+ "\n"+"is deposit paid :"+depositPaid +"\n" + "Table number " +
                "is :"+bookingTable+ "\n" + "checkIn date is :"+checkInDate);

        System.out.println("==========Retrieving all field keys=========");
        // To retrieve all fieldNames
        Iterator<String> itr = bookingDetails.fieldNames();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }

        System.out.println("=======Retrieving all field values==========");
        Iterator<JsonNode> itr2=bookingDetails.elements();
        while(itr2.hasNext()){
            System.out.println(itr2.next());
        }

        // Remove keys from JsonNodes
        System.out.println("===== Removing fields from JSON =========");
        bookingDetails.remove("firstName").asText();
        System.out.println("After removing firstName then json Object will be :\n"+objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookingDetails));

        // Remove keys from JsonNodes
        System.out.println("===== Adding fields to JSON =========");
        bookingDetails.put("firstName","Raja");
        System.out.println("After adding firstName then json Object will be :\n"+objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(bookingDetails));

        // Write Json value to file
        File filePath= new File("src/test/resources/objectMapperRequest.json");
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(filePath,bookingDetails);



    }

}
