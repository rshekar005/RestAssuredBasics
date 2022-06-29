package com.ObjectMapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.util.Arrays;

public class Demo2 {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode firstBookingDetails = objectMapper.createObjectNode();
        firstBookingDetails.put("firstName", "Rajashekar");
        firstBookingDetails.put("lastName", "P");
        firstBookingDetails.put("totalPrice", 1000);
        firstBookingDetails.put("bookingTable", 23);
        firstBookingDetails.put("depositPaid", true);
        firstBookingDetails.put("additionalDetails", "BreakFast");

        ObjectNode bookingDataDetails = objectMapper.createObjectNode();
        bookingDataDetails.put("checkIn", "2022-01-03");
        bookingDataDetails.put("checkOut", "2022-01-04");

        firstBookingDetails.set("bookingDates", bookingDataDetails);

        ObjectNode secondBookingDetails = objectMapper.createObjectNode();
        secondBookingDetails.put("firstName", "Narayana");
        secondBookingDetails.put("lastName", "J");
        secondBookingDetails.put("totalPrice", 3000);
        secondBookingDetails.put("bookingTable", 24);
        secondBookingDetails.put("depositPaid", false);
        secondBookingDetails.put("additionalDetails", "BreakFast");

        ObjectNode bookingDataDetails2 = objectMapper.createObjectNode();
        bookingDataDetails2.put("checkIn", "2022-01-05");
        bookingDataDetails2.put("checkOut", "2022-01-06");

        firstBookingDetails.set("bookingDates", bookingDataDetails2);

        ArrayNode parentArray = objectMapper.createArrayNode();
        parentArray.addAll(Arrays.asList(firstBookingDetails, secondBookingDetails));

        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(parentArray));

        System.out.println(" Size of an array is :" + parentArray.size());

        //Get elements based on array index
        System.out.println(parentArray.get(1));

        //removing array from a list
        System.out.println("======== After Removing first Index=========");
        parentArray.remove(1);
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(parentArray));

        //removing all array details from a list
        System.out.println("========= Removed all array elements from a list ===========");
        parentArray.removeAll();
        System.out.println(objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(parentArray));




    }
}
