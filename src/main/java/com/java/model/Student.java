package com.java.model;

public class Student {
      private String studentName;
      private String studentRollNumber;
      private String studentUniversity;
     public Student(String studentName,String studentRollNumber,String studentUniversity)
      {
          this.studentName=studentName;
          this.studentRollNumber=studentRollNumber;
          this.studentUniversity=studentUniversity;
      }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentRollNumber() {
        return studentRollNumber;
    }

    public String getStudentUniversity() {
        return studentUniversity;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", studentRollNumber='" + studentRollNumber + '\'' +
                ", studentUniversity='" + studentUniversity + '\'' +
                '}';
    }
}
