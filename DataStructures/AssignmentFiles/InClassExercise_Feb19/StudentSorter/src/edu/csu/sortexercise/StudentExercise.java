package edu.csu.sortexercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class StudentExercise {

    public static void main(String[] args) {

        // creating a class with 20 students
        ArrayList<Student> newStudentClass = createStudentClass();

        // default class (student id ascending)
        System.out.println("Student ID Ascending: ");
        System.out.println(newStudentClass);
        System.out.println(" ");

        // sorting by grades (highest grades first)
        System.out.println("Grade Descending: ");
        Collections.sort(newStudentClass, new GradeComparator());
        System.out.println(newStudentClass);
        System.out.println(" ");

        // sorting by first name (lexicographical)
        System.out.println("First Name Ascending: ");
        Collections.sort(newStudentClass, new FirstNameComparator());
        System.out.println(newStudentClass);
        System.out.println(" ");

        // sorting by first name, then last name (if last name equal, higher grade first)
        System.out.println("Last Name Descending, then Grade Descending: ");
        Comparator<Student> compareByLastNameThenGrade = new LastNameComparator().thenComparing(new GradeComparator());
        Collections.sort(newStudentClass, compareByLastNameThenGrade);
        System.out.println(newStudentClass);

    }


    // create a class of 20 students
    private static ArrayList<Student> createStudentClass() {
        String[] firstNames = {"James", "Thomas", "John", "Robert", "Michael", "William", "David", "Richard", "Joseph", "Charles", "Christopher", "Daniel", "Matthew", "Anthony", "Donald", "Mark", "Paul", "Steven", "Andrew", "Emma"};
        String[] lastNames = {"Smith", "Williams", "Johnson", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Jackson", "White", "Harris", "Martin", "Garcia", "Martinez", "Robinson", "Clark", "Lee"};
        double[] grades = {4.0, 4.0, 3.8, 3.8, 3.8, 3.5, 3.5, 3.5, 3.5, 3.5, 3.3, 3.3, 3.3, 3.3, 3.0, 3.0, 3.0, 2.8, 2.75, 2.5};

        Random rand = new Random();


        ArrayList<Student> studentClass = new ArrayList<Student>();

        for (int i = 0; i < 20; i++) {
            Student<String> someStudent = new Student<String>(i, firstNames[rand.nextInt(20)], lastNames[rand.nextInt(20)], grades[rand.nextInt(20)]);
            studentClass.add(someStudent);
        }
        return studentClass;
    }
}
