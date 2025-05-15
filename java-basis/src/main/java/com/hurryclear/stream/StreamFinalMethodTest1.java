package com.hurryclear.stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamFinalMethodTest1 {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        Student s1 = new Student("J", 29, 170.2);
        Student s2 = new Student("J", 29, 170.2);
        Student s3= new Student("L", 28, 160.6);
        Student s4 = new Student("Z", 39, 180.4);
        Student s5 = new Student("U", 32, 175.3);
        Collections.addAll(students, s1, s2, s3, s4, s5);

        System.out.println(students);

        // 1. count how many students' height s taller than 168cm and output
        long size = students.stream().filter(s -> s.getHeight() > 168).count();
        System.out.println(size);

        // 2. find the tallest student and output
        Student tallestStudent = students.stream()
                .max((o1, o2) -> Double.compare(o1.getHeight(), o2.getHeight()))
                .get();
        System.out.println(tallestStudent);

        // 3. find the smallest student and output
        Student smallestStudent = students.stream()
                .min((o1, o2) -> Double.compare(o1.getHeight(), o2.getHeight()))
                .get();
        System.out.println(smallestStudent);

        // 4. put the students whose height is taller than 170 into a new collection
        // List
        List<Student> s1List = students.stream()
                .filter(s -> s.getHeight() > 170)
                .collect(Collectors.toList());
        System.out.println(s1List);
        // Set: you will find that set has different result with list, because set will take the
        // repeated result out
        Set<Student> s2Set = students.stream()
                .filter(s -> s.getHeight() > 170)
                .collect(Collectors.toSet());
        System.out.println(s2Set);

        // 5. find the students whose height is taller than 170 and put their name and height
        // into a map
        Map<String, Double> sMap = students.stream()
                .filter(s -> s.getHeight() > 170)
                .distinct()
                .collect(Collectors.toMap(a -> a.getName(), a -> a.getHeight()));
        System.out.println(sMap);

    }
}
