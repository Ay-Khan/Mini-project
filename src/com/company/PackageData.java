package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private ArrayList<Students> students;
    private Students student;

    public PackageData() {
    }

    public PackageData(String operationType, ArrayList<Students> students, Students student) {
        this.operationType = operationType;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Students getStudent() {
        return student;
    }

    public void setStudent(Students student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "PackageData{" +
                "operationType='" + operationType + '\'' +
                ", students=" + students +
                ", student=" + student +
                '}';
    }

    public ArrayList<Students> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Students> students) {
        this.students = students;
    }
}
