package com.collection.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StreamMiddleMethodTest1 {

    public static void main(String[] args) {

        List<Double> scores = new ArrayList<>();
        Collections.addAll(scores,88.5, 100.0, 60.5, 99.0, 8.4, 99.4, 25.8);

        List<Student> students = new ArrayList<>();
        Student s1 = new Student("J", 29, 170.2);
        Student s2 = new Student("J", 29, 170.2);
        Student s3= new Student("L", 28, 160.6);
        Student s4 = new Student("Z", 39, 180.4);
        Student s5 = new Student("U", 32, 175.3);
        Collections.addAll(students, s1, s2, s3, s4, s5);

        System.out.println(students);

        // 1. the score greater and equal than 60 and output ascending
        scores.stream()
                .filter(s -> s >= 60)
                .sorted()
//                .sorted(((o1, o2) -> Double.compare(o2, o1)))
                .forEach(System.out::println);

        // 2. students who are older (incl.) than 23 and younger (incl.) than 30 and output them
        // descending
        students.stream()
                .filter(s -> s.getAge() >= 23 && s.getAge() <= 30)
//                .sorted() // this will not work, you have to write next line (new Comparator)
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .forEach(System.out::println);

        // 3. the three tallest students
        System.out.println("---- 3. the three tallest students ----");
        students.stream()
                .sorted((o1, o2) -> Double.compare(o2.getHeight(), o1.getHeight()))
                .limit(3)
                .forEach(System.out::println);

        // 4. the two smallest students
        System.out.println("---- 4. the two smallest students ----");
        students.stream()
                .sorted((o1, o2) -> Double.compare(o2.getHeight(), o1.getHeight()))
                .skip(students.size() - 2)
                .forEach(System.out::println);

        // 5. the name of the students whose height is greater than 168 and get rid of the
        // repeated names and output
        System.out.println(("5. the name of the students whose height is greater than 168 and get rid of the repeated" +
                " names and output"));
        students.stream()
                .filter(s -> s.getHeight() >= 168)
                .distinct()
                .forEach(s -> System.out.println(s.getName()));

    }


}
