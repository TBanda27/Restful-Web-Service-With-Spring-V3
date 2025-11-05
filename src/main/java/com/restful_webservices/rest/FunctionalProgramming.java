package com.restful_webservices.rest;

import java.util.List;

public class FunctionalProgramming {
    public static void main(String[] args) {
        printAllNumbersInListStructured(List.of(1,2,31,4,15, 2,3,28));
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        for(Integer number : numbers){
            System.out.println(number);
        }
    }
}
