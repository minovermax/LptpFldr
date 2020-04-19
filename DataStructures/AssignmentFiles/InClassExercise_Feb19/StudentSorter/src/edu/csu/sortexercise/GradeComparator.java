package edu.csu.sortexercise;

import java.util.Comparator;

public class GradeComparator implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {

        return Double.compare(student1.getGrade(), student2.getGrade()) * -1;

    }
}
