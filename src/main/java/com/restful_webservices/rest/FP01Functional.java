package com.restful_webservices.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FP01Functional {
    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        List<String> courses = Arrays.asList("Spring", "Spring Boot", "API", "Microservices", "AWS", "PCF", "Azure", "Docker", "Kubernetes");
//        printAllNumbersInListFunctional(list);
        printEvenNumbersInListFunctional(list);
        System.out.println("------------------------------------------------------------------");
        coursesContainingSpring(courses);
        System.out.println("------------------------------------------------------------------");
        coursesContainingFourWords(courses);
        System.out.println("------------------------------------------------------------------");
        printEvenNumbersInListFunctional(list);
        System.out.println("------------------------------------------------------------------");
        cubesOfOddNumbers(list);
        System.out.println("------------------------------------------------------------------");
        characterLengthOfWords(courses);
    }
    public static void print(Integer number){
        System.out.println(number);
    }
    private static void printAllNumbersInListFunctional(List<Integer> numbers){
        numbers.forEach(FP01Functional::print);
    }

    private static void printEvenNumbersInListFunctional(List<Integer> numbers){
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(FP01Functional::print);
    }

    private static void coursesContainingSpring(List<String> courses){

        List<String> spring = courses.stream()
                .filter(course -> course.contains("Spring"))
                .toList();

        spring.forEach(System.out::println);
    }

    private static void coursesContainingFourWords(List<String> courses){
        courses.stream()
                .filter(course -> course.length() >= 5)
                .forEach(System.out::println);
    }

    private static void cubesOfOddNumbers(List<Integer> numbers){
        numbers.stream()
                .map(number -> number % 2 == 0? number : number*number*number)
                .forEach(System.out::println);
    }

    private static void characterLengthOfWords(List<String> courses){
        courses.stream()
                .map(course -> course + ' ' + course.length())
                .forEach(System.out::println);
    }
}
